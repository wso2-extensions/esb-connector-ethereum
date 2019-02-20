# Working with getting block number

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview

This operation returns the number of most recent blocks.

### Operation details

**getBlockNumber**
```xml
<ethereum.getBlockNumber>
    <id>{$ctx:id}</id>
</ethereum.getBlockNumber>
```
**Properties**
* id: The value of the id established by the Ethereum client.

**Sample request**

Following is a sample request that can be handled by the getBlockNumber operation.

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1,
	"ethereumBlocking":"true"
}
```
**Sample response**

Given below is a sample response for the getBlockNumber operation.

```json
{
    "jsonrpc": "2.0",
    "id": "1",
    "result": "0x0"
}
```

### Sample configuration

Following example illustrates how to connect to Ethereum with the init operation and getBlockNumber operation.

1. Create a sample proxy as below :

```xml
<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="ethereum_getBlockNumber"
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
         <ethereum.getBlockNumber>
             <id>{$ctx:id}</id>
         </ethereum.getBlockNumber>
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

2. Create a json file named getBlockNumber.json and copy the configurations given below to it:

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
curl http://localhost:8280/services/ethereum_getBlockNumber -H "Content-Type: application/json" -d @getBlockNumber.json

```
5. Ethereum returns a json response similar to the one shown below:

```json
{"jsonrpc":"2.0","id":"1","result":"0x0"}
```
