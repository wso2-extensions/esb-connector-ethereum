# Working with getting peer count

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview

This operation returns the number of peers currently connected to the client.

### Operation details

**getPeerCount**
```xml
<ethereum.getPeerCount>
    <id>{$ctx:id}</id>
</ethereum.getPeerCount>
```

**Properties**
* id: The value of the id established by the Ethereum client.

**Sample request**

Following is a sample request that can be handled by the getPeerCount operation.

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1,
	"ethereumBlocking":"true"
}
```
**Sample response**

Given below is a sample response for the getPeerCount operation.

```json
{
    "jsonrpc": "2.0",
    "id": "1",
    "result": "0x6"
}
```

### Sample configuration

Following example illustrates how to connect to Ethereum with the init operation and getPeerCount operation.

1. Create a sample proxy as below :

```xml
<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="ethereum_getPeerCount"
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
         <ethereum.getPeerCount>
            <id>{$ctx:id}</id>
         </ethereum.getPeerCount>
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

2. Create a json file named getPeerCount.json and copy the configurations given below to it:

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
curl http://localhost:8280/services/ethereum_getPeerCount -H "Content-Type: application/json" -d @getPeerCount.json

```
5. Ethereum returns a json response similar to the one shown below:

```json
{"jsonrpc":"2.0","id":"1","result":"0x6"}
```
