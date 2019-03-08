# Configuring Ethereum Operations

[[Prerequisites]](#Prerequisites) [[Initializing the connector]](#initializing-the-connector)

## Prerequisites

### Setting Ethereum Client Geth

 1. To install geth, go to [https://github.com/ethereum/go-ethereum/releases]<br/>
 2. To start the HTTP JSON-RPC, use the command `geth --rpc`<br/>
 3. To create a new account, use the command `geth account new`
 4. To launch javascript console use the command `geth attach`
 5. If you want to start mining, use the command `start.miner()` in the javascript console
 6. If you want to obtain the storage position to be used as the parameter for getStorageAt operation follow the steps below.<br/>
        use this command in geth console `var key = "000000000000000000000000<account address without the prefix '0X'>" + "0000000000000000000000000000000000000000000000000000000000000001"`.
        And you will obtain the storage position of position 1.
        Then you can use this value to obtain the value of the storage using the operation getStorageAt.


## Initializing the connector

Add the following <ethereum.init> method in your configuration:

#### init
```xml
<ethereum.init>
<apiUrl>{$ctx:apiUrl}</apiUrl>
<port>{$ctx:port}</port>
</ethereum.init>
```
**Properties**
* apiUrl:  The api URL for Ethereum.
* port:  The default rpc port for Ethereum port.

Now that you have connected to Ethereum, use the information in the following topics to perform various operations with the connector.

[Working with getting  accounts](accounts.md)

[Working with getting  balance](balance.md)

[Working with getting  block number](blocknumber.md)

[Working with getting  code](code.md)

[Working with getting coinbase](coinbase.md)

[Working with getting gas price](gasprice.md)

[Working with getting hash rate](hashrate.md)

[Working with getting listening result](listening.md)

[Working with getting mining result](mining.md)

[Working with getting peer count](peercount.md)

[Working with getting protocol version](protocolversion.md)

[Working with getting storage](storage_at.md)

[Working with getting syncing result](syncing.md)

[Working with getting transaction count](transactioncount.md)

[Working with getting network version](version.md)

