# Multi-node Topology

This distributed key value store implements a gossiping algorithm for communicating group membership.

Consistent hashing is used partioning and maintaining a replication factor of 3.

# Server: Starting the KV store
`java -jar -Xmx64m target/CPEN431-1.0.jar spawn -name test -port 10129`

# Usage
Argument:
'spawn': Run server that listens, performs operation, and responds to KV requests

Required Flags:

'-name': Name of host server

'-port': Port number to host server

# Client: Sending requests
e.g.
`java -jar target/CPEN431-1.0.jar kv -ip 127.0.0.1 -port 10129 -cmd put -key 270F -value 270F`

# Usage
Argument:
'kv': Send key value store protocol buffer request

Required Flags:
'-ip': Destination IP address of request

'-port': Destination port of request

'-cmd': Student number to send

available commands include the following:

"put"

"get"

"remove"

"shutdown"

"deleteAll"

"isAlive"

"getPID"

'-key': Key to send (as a HEX string)

'-value': Value to send (as a HEX string)

# Building package:
`mvn package`

# Testing
`mvn test`
