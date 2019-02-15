# Working with getting accounts

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview

This operation returns a list of addresses owned by client.

### Operation details

**getAccounts**
```xml
<ethereum.getAccounts>
    <id>{$ctx:id}<id>
</ethereum.getAccounts>
```
**Properties**
* id: The value of the id established by the Ethereum client.

**Sample request**

Following is a sample request that can be handled by the getAccounts operation.

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1
}
```
**Sample response**

Given below is a sample response for the getAccounts operation.

```json
{
    "jsonrpc": "2.0",
    "id": "1",
    "result": [
        "0xf91fc7cc1f93970472c71c0720035b5aeb62b7d5",
        "0x430d5364ca4437a962ad006a666c840b317b9802",
        "0x0e72342b0a2145143a57a75406c9a10484d38ad3",
        "0x90502a6e3952ad1fbb68e5be26a21e30f36f0ef8",
        "0x0b40b5cc55f6fab823714c627d3b9ced0e80de0a"
    ]
}
```

### Sample configuration

Following example illustrates how to connect to Ethereum with the init operation and getAccounts operation.

1. Create a sample proxy as below :

```xml
<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="ethereum_getAccounts"
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
         <ethereum.getAccounts>
             <id>{$ctx:id}</id>
         </ethereum.getAccounts>
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

2. Create a json file named getAccounts.json and copy the configurations given below to it:

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
curl http://localhost:8280/services/ethereum_getAccounts -H "Content-Type: application/json" -d @getAccounts.json

```
5. Ethereum returns a json response similar to the one shown below:

```json
{"jsonrpc":"2.0","id":"1","result":["0xf91fc7cc1f93970472c71c0720035b5aeb62b7d5","0x430d5364ca4437a962ad006a666c840b317b9802","0x0e72342b0a2145143a57a75406c9a10484d38ad3","0x90502a6e3952ad1fbb68e5be26a21e30f36f0ef8","0x0b40b5cc55f6fab823714c627d3b9ced0e80de0a"]}
```
