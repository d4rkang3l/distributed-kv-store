package A7.core;


import static A7.DistributedSystemConfiguration.VERBOSE;

import A7.server.UDPServerThreadPool;
import A7.utils.MsgWrapper;
import A7.utils.UniqueIdentifier;
import com.google.protobuf.ByteString;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConsistentHashRing {
    private NodesList nodesList;

    private static ConsistentHashRing instance = new ConsistentHashRing();
    
    private final ConcurrentSkipListMap<String, MsgWrapper> hashRing;
    
    private ConsistentHashRing() {
        hashRing = new ConcurrentSkipListMap<>();
        nodesList = NodesList.getInstance();
        initializeNodes();
    }

    public static ConsistentHashRing getInstance() {
        return instance;
    }
    
    private void initializeNodes() {
        try {
            for (Iterator<Map.Entry<String, Integer>> iter
                = nodesList.getAllNodes().entrySet().iterator(); iter.hasNext();) {
                Map.Entry<String, Integer> node = iter.next();
                String[] address = node.getKey().split(":");
                addNode(address[0], node.getValue());
            }
            // add itself to ring
            addNode(InetAddress.getLocalHost().getHostAddress(), UDPServerThreadPool.localPort);
        } catch (NoSuchAlgorithmException|UnknownHostException e) {
            e.printStackTrace();
        }
    }

    // Add a server and port to the hash ring
    // TODO: Handle redistributing content on node addition
    public void addNode(String ip, int port) throws NoSuchAlgorithmException {
        String hashKey = UniqueIdentifier.MD5Hash(ip + ":" + port);
        try {
            InetAddress address = InetAddress.getByName(ip);
            hashRing.put(hashKey, new MsgWrapper(null, address, port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    
    // Remove a server and port from the hash ring
    // TODO: Handle redistributing content on node removal
    public void removeNode(String address, int port) throws NoSuchAlgorithmException {
        String key = UniqueIdentifier.MD5Hash(address + ":" + port);
        hashRing.remove(key);
    }

    // Determines the node and port that the key resides on
    // Result passed into forwarding queue, dequeued in RequestsCache to build response
    // Function returns msgWrapper with correct address and port that to send response
    // Function returns an empty MsgWrapper if current machine can service response
    public MsgWrapper getNode(ByteString key) throws NoSuchAlgorithmException {
        if (VERBOSE > 0) {
            System.out.println("HASH RING CONTENTS");
            System.out.println("==========");
            for (Iterator<Entry<String, MsgWrapper>> iter = hashRing.entrySet().iterator();
                iter.hasNext();) {
                Map.Entry<String, MsgWrapper> entry = iter.next();
                MsgWrapper value = entry.getValue();
                System.out.println(entry.getKey());
                System.out.println(value.getAddress().getHostAddress() + ":" + value.getPort());
            }
        }
        
        if (hashRing.isEmpty() || key == null || key.isEmpty()) {
            return new MsgWrapper(null, null, 0);
        }
        String hashKey = UniqueIdentifier.MD5Hash(key.toStringUtf8());
        
        // If key not contained in hash ring, use successor node (use first node if no successor)
        // Ultimately, if no successor is found, it will at least return itself as destination node
        if (!hashRing.containsKey(hashKey)
            || !nodesList.getLiveNodes().containsKey(hashRing.get(hashKey).getAddress())) {
            MsgWrapper target = null;
            while (target == null) {
                SortedMap<String, MsgWrapper> tailMap = hashRing.tailMap(hashKey, false);
                hashKey = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
                target = hashRing.get(hashKey);
                if (!NodesList.getInstance().getLiveNodes().containsKey(target.getAddress())) {
                    target = null;
                }
            }
            if (target.getAddress().equals(UDPServerThreadPool.localAddress)
                    && target.getPort() == UDPServerThreadPool.localPort) {
                // Command applies to current node
                return new MsgWrapper(null, null, 0);
            }
        }
        return hashRing.get(hashKey);
    }

    // returns the key of the node "responsible" for the hashed key
    public String getKey(ByteString key) throws NoSuchAlgorithmException {
        if (hashRing.isEmpty() || key.isEmpty()) {
            return null;
        }
        String hashKey = UniqueIdentifier.MD5Hash(key.toStringUtf8());

        // If next key not contained in live nodes, use successor node ("loops" around)
        // Ultimately, if no successor is found, it will return its own key
        if (!hashRing.containsKey(hashKey)
            || !nodesList.getLiveNodes().containsKey(hashRing.get(hashKey).getAddress())) {
            MsgWrapper target = null;
            while (target == null) {
                SortedMap<String, MsgWrapper> tailMap = hashRing.tailMap(hashKey, false);
                hashKey = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
                target = hashRing.get(hashKey);
                if (!NodesList.getInstance().getLiveNodes().containsKey(target.getAddress())) {
                    target = null;
                }
            }
        }
        return hashKey;
    }

    // given a key, return the successor node's key
    public String getSuccessorKey(String hashKey) throws NoSuchAlgorithmException {
        if (hashRing.isEmpty() || hashKey.isEmpty()) {
            return null;
        }
        MsgWrapper target = null;

        while (target == null) {
            SortedMap<String, MsgWrapper> tailMap = hashRing.tailMap(hashKey, false);
            hashKey = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
            target = hashRing.get(hashKey);
            if (!NodesList.getInstance().getLiveNodes().containsKey(target.getAddress())) {
                target = null;
            }
        }
        return hashKey;
    }

    public ConcurrentSkipListMap<String, MsgWrapper> getHashRing() {
        return this.hashRing;
    }
}
