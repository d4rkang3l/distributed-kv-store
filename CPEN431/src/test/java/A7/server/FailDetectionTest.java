package A7.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static A7.DistributedSystemConfiguration.REP_FACTOR;
import static org.junit.Assert.assertEquals;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import A7.core.ConsistentHashRing;
import A7.core.NodesList;
import A7.utils.MsgWrapper;
import A7.utils.UniqueIdentifier;
import A7.server.GossipSenderThread;
public class FailDetectionTest {
	ConsistentHashRing hashRing;
    NodesList nodesList;
    Map<String, Integer> allNodes;
    Map<InetAddress, Integer> liveNodes;

    @org.junit.Before
    public void setUp() throws Exception {
        nodesList = NodesList.getInstance();
        liveNodes = new HashMap<>();
        liveNodes.put(InetAddress.getByName("142.103.2.2"), 1);
        liveNodes.put(InetAddress.getByName("129.97.74.12"), 2);
        liveNodes.put(InetAddress.getByName("128.208.4.197"), 6);
        liveNodes.put(InetAddress.getByName("128.208.4.99"), 8);
        liveNodes.put(InetAddress.getByName("84.88.58.155"), 1);
        liveNodes.put(InetAddress.getByName("128.208.4.50"), 1);
        liveNodes.put(InetAddress.getByName("128.208.4.70"), 1);
//        liveNodes.put("128.208.4.101:11300", 11300);

        allNodes = new HashMap<>();
        // contained in live nodes
        allNodes.put("142.103.2.2:10500", 10500);
        allNodes.put("129.97.74.12:10600", 10600);
        allNodes.put("141.212.113.178:10700", 10700);
        allNodes.put("128.208.4.197:10800", 10800);
        allNodes.put("128.208.4.99:10900", 10900);
        allNodes.put("84.88.58.155:11000", 11000);
        allNodes.put("128.208.4.50:11100", 11100);
        allNodes.put("128.208.4.70:11200", 11200);
        // not contained in live nodes
        allNodes.put("128.208.4.101:11300", 11300);

        nodesList.setAllNodes(allNodes);
        nodesList.setLiveNodes(liveNodes);
        hashRing = ConsistentHashRing.getInstance();
    }
    
    @org.junit.Test
    public void successorsDuplicateTest() throws NoSuchAlgorithmException, SocketException, UnknownHostException {
    	String downedNode = UniqueIdentifier.MD5Hash("128.208.4.101:11300");
    	Entry<String, MsgWrapper> entry = hashRing.getInstance().getHashRing().lowerEntry(downedNode);
    	if (entry == null) {
    		entry = hashRing.getInstance().getHashRing().lastEntry();
    	}
    	String currentNodeHash = UniqueIdentifier.MD5Hash(
    			entry.getValue().getAddress().getHostAddress()
    			+ ":" + entry.getValue().getPort());
    	MsgWrapper succTarget = GossipSenderThread.successorsDuplicate(currentNodeHash);
    	Entry<String, MsgWrapper> checkEntry = hashRing.getInstance().getHashRing().higherEntry(downedNode);
    	
    	assertEquals(succTarget.getAddress().getHostName(), checkEntry.getValue().getAddress().getHostAddress());
    	assertEquals(succTarget.getPort(), checkEntry.getValue().getPort());
    }

    @org.junit.Test
    public void predessorsDuplicateTest() throws NoSuchAlgorithmException, SocketException, UnknownHostException {
    	String downedNode = UniqueIdentifier.MD5Hash("128.208.4.101:11300");
    	Entry<String, MsgWrapper> entry = hashRing.getInstance().getHashRing().higherEntry(downedNode);
    	if (entry == null) {
    		entry = hashRing.getInstance().getHashRing().firstEntry();
    	}
    	// if predecssor of current node is down, the returned duplicate node is suppose to be the first node outside the duplication
    	// range of the down'ed node, or REP_Factor-1 away from the current
    	Entry<String, MsgWrapper> checkEntry = hashRing.getInstance().getHashRing().higherEntry(downedNode);
    	if (checkEntry == null) {
    		checkEntry = hashRing.getInstance().getHashRing().firstEntry();
    	}
    	checkEntry = hashRing.getInstance().getHashRing().higherEntry(entry.getKey());
    	if (checkEntry == null) {
    		checkEntry = hashRing.getInstance().getHashRing().firstEntry();
    	}
    	checkEntry = hashRing.getInstance().getHashRing().higherEntry(entry.getKey());
    	if (checkEntry == null) {
    		checkEntry = hashRing.getInstance().getHashRing().firstEntry();
    	}

    	String currentNodeHash = UniqueIdentifier.MD5Hash(
    			entry.getValue().getAddress().getHostAddress()
    			+ ":" + entry.getValue().getPort());
    	MsgWrapper[] pred = GossipSenderThread.predessorsDuplicate(currentNodeHash);
    	
    	//Should only duplicate to 1, only one node down
    	assertEquals(pred.length, 1);
    	
//    	System.out.println(REP_FACTOR - 1);
//    	// By logic, the node to duplicate onto is REP_FACTOR - 1 away
//    	for (int skip = 1; skip < REP_FACTOR - 1; skip++) {
//    		checkEntry = hashRing.getInstance().getHashRing().higherEntry(checkEntry.getKey());
//        	if (checkEntry == null) {
//        		checkEntry = hashRing.getInstance().getHashRing().firstEntry();
//        	}
//		}
//    	
    	hashRing.getHashRing();
    	for (Iterator<Map.Entry<String, MsgWrapper>> iter
            = hashRing.getHashRing().tailMap("0").entrySet().iterator(); iter.hasNext();) {
            Map.Entry<String, MsgWrapper> node = iter.next();
            System.out.println(node.getValue().getAddress().getHostName());
        	
        }
    	System.out.println("Real");
    	System.out.println(pred[0].getAddress().getHostName());
    	System.out.println(checkEntry.getValue().getAddress().getHostName());
    	
    	assertEquals(pred[0].getAddress().getHostName(), checkEntry.getValue().getAddress().getHostAddress());
    	assertEquals(pred[0].getPort(), checkEntry.getValue().getPort());
    	
    }
    
    
}
