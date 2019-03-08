# Working with getting storage

[[Overview]](#overview)  [[Operation details]](#operation-details)  [[Sample configuration]](#sample-configuration)

### Overview

This operation returns the value from a storage position at a given address.

### Operation details

**getStorageAt**
```xml
<ethereum.getStorageAt>
    <id>{$ctx:id}</id>
    <storageAddress>{$ctx:storageAddress}</storageAddress>
    <storagePosition>{$ctx:storagePosition}</storagePosition>
    <storageBlock>{$ctx:storageBlock}</storageBlock>
</ethereum.getStorageAt>
```

**Property**
* id: The value of the id established by the Ethereum client.
* storageAddress: The address of the storage.
* storagePosition: The position in the storage.
* storageBlock: The value of the block number.

**Sample request**

Following is a sample request that can be handled by the getStorageAt operation.

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1,
	"storageAddress":"0xf91fc7cc1f93970472c71c0720035b5aeb62b7d5",
	"storagePosition": "0x0",
	"storageBlock": "latest",
	"ethereumBlocking":"true"
}
```
**Sample response**

Given below is a sample response for the getStorageAt operation.

```json
{
    "jsonrpc": "2.0",
    "id": "1",
    "result": "0x0000000000000000000000000000000000000000000000000000000000000000"
}
```

### Sample configuration

Following example illustrates how to connect to Ethereum with the init operation and getStorageAt operation.

1. Create a sample proxy as below :

```xml
<?xml version="1.0" encoding="UTF-8"?>
<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="ethereum_getStorageAt"
       startOnLoad="true"
       statistics="disable"
       trace="disable"
       transports="http,https">
   <target>
      <inSequence>
         <property expression="json-eval($.apiUrl)" name="apiUrl"/>
         <property expression="json-eval($.port)" name="port"/>
         <property expression="json-eval($.id)" name="id"/>
         <property expression="json-eval($.storageAddress)" name="storageAddress"/>
         <property expression="json-eval($.storagePosition)" name="storagePosition"/>
         <property expression="json-eval($.storageBlock)" name="storageBlock"/>
         <ethereum.init>
            <apiUrl>{$ctx:apiUrl}</apiUrl>
            <port>{$ctx:port}</port>
         </ethereum.init>
         <ethereum.getStorageAt>
            <id>{$ctx:id}</id>
            <storageAddress>{$ctx:storageAddress}</storageAddress>
            <storagePosition>{$ctx:storagePosition}</storagePosition>
            <storageBlock>{$ctx:storageBlock}</storageBlock>
         </ethereum.getStorageAt>
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

2. Create a json file named getStorageAt.json and copy the configurations given below to it:

```json
{
	"apiUrl":"http://127.0.0.1",
	"port":"8545",
	"id":1,
	"storageAddress":"0xf91fc7cc1f93970472c71c0720035b5aeb62b7d5",
	"storagePosition": "0x0",
	"storageBlock": "latest"
}
```
3. Replace the credentials with your values.

4. Execute the following curl command:

```bash
curl http://localhost:8280/services/ethereum_getStorageAt -H "Content-Type: application/json" -d @getStorageAt.json
```
5. Ethereum returns a json response similar to the one shown below:

```json
{"jsonrpc":"2.0","id":"1","result":"0x0000000000000000000000000000000000000000000000000000000000000000"}
```
