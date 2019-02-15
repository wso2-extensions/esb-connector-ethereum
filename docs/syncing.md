# Working with getting syncing result

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview

This operation returns an object with data about sync status or false.

### Operation details

**getSyncing**
```xml
<ethereum.getSyncing>
    <id>{$ctx:id}</id>
</ethereum.getSyncing>
```
**Properties**
* id: The value of the id established by the Ethereum client.

**Sample request**

Following is a sample request that can be handled by the getSyncing operation.

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1
}
```
**Sample response**

Given below is a sample response for the getSyncing operation.

```json
{
    "jsonrpc": "2.0",
    "id": "1",
    "result": {
        "currentBlock": "0x6c6212",
        "highestBlock": "0x6c6292",
        "knownStates": "0x27b0ea3",
        "pulledStates": "0x27af8b5",
        "startingBlock": "0x6c52f1"
    }
}
```

### Sample configuration

Following example illustrates how to connect to Ethereum with the init operation and getSyncing operation.

1. Create a sample proxy as below :

```xml
<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="ethereum_getSyncing"
       startOnLoad="true"
       statistics="disable"
       trace="disable"
       transports="http,https">
   <target>
      <inSequence>
         <property expression="json-eval($.apiUrl)" name="apiUrl"/>
         <property expression="json-eval($.port)" name="port"/>
         <property expression="json-eval($.id)" name="id"/>
         <ethereum.init>
            <apiUrl>{$ctx:apiUrl}</apiUrl>
            <port>{$ctx:port}</port>
         </ethereum.init>
         <ethereum.getSyncing>
            <id>{$ctx:id}</id>
         <ethereum.getSyncing>
         <respond/>
      </inSequence>
      <outSequence>
         <log/>
         <send/>
      </outSequence>
   </target>
   <description/>
</proxy>


```

2. Create a json file named getSyncing.json and copy the configurations given below to it:

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1
}
```
3. Replace the credentials with your values.

4. Execute the following curl command:

```bash
curl http://localhost:8280/services/ethereum_getSyncing -H "Content-Type: application/json" -d @getSyncing.json

```
5. Ethereum returns a json response similar to the one shown below:

```json
{"jsonrpc":"2.0","id":"1","result":{"currentBlock":"0x6c6253","highestBlock":"0x6c62a0","knownStates":"0x27bcde7","pulledStates":"0x27b8964","startingBlock":"0x6c52f1"}}
```
