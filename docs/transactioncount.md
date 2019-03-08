# Working with getting transaction count

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview

This operation returns the number of transactions sent from an account.

### Operation details

**getTransactionCount**
```xml
<ethereum.getTransactionCount>
    <id>{$ctx:id}</id>
    <address>{$ctx:address}</address>
    <block>{$ctx:block}</block>
</ethereum.getTransactionCount>
```

**Property**
* id: The value of the id established by the Ethereum client.
* address: The account address to check for balance.
* block: The value of the block number.

**Sample request**

Following is a sample request that can be handled by the getTransactionCount operation.

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1,
	"address":"0xf91fc7cc1f93970472c71c0720035b5aeb62b7d5",
	"block": "latest",
	"ethereumBlocking":"true"
}
```
**Sample response**

Given below is a sample response for the getTransactionCount operation.

```json
{
    "jsonrpc": "2.0",
    "id": "1",
    "result": "0x0"
}
```

### Sample configuration

Following example illustrates how to connect to Ethereum with the init operation and getTransactionCount operation.

1. Create a sample proxy as below :

```xml
<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="ethereum_getTransactionCount"
       startOnLoad="true"
       statistics="disable"
       trace="disable"
       transports="http,https">
   <target>
      <inSequence>
         <property expression="json-eval($.apiUrl)" name="apiUrl"/>
         <property expression="json-eval($.port)" name="port"/>
         <property expression="json-eval($.id)" name="id"/>
         <property expression="json-eval($.address)" name="address"/>
         <property expression="json-eval($.block)" name="block"/>
         <ethereum.init>
            <apiUrl>{$ctx:apiUrl}</apiUrl>
            <port>{$ctx:port}</port>
         </ethereum.init>
         <ethereum.getTransactionCount>
            <id>{$ctx:id}</id>
            <address>{$ctx:address}</address>
            <block>{$ctx:block}</block>
         </ethereum.getTransactionCount>
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

2. Create a json file named getTransactionCount.json and copy the configurations given below to it:

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1,
	"address":"0xf91fc7cc1f93970472c71c0720035b5aeb62b7d5",
	"block": "latest"
}
```
3. Replace the credentials with your values.

4. Execute the following curl command:

```bash
curl http://localhost:8280/services/ethereum_getTransactionCount -H "Content-Type: application/json" -d @getTransactionCount.json

```
5. Ethereum returns a json response similar to the one shown below:

```json
{"jsonrpc":"2.0","id":"1","result":"0x0"}
```
