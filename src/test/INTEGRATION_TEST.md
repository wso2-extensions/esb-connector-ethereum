## Integration tests for WSO2 EI Ethereum connector
### Pre-requisites

    - Maven 3.x
    - Java 1.8
    - geth 1.8.19-stable

### Tested Platforms:

    - Ubuntu 16.04
    - WSO2 EI 6.4.0
    - Java 1.8

### Steps to follow in setting the Ethereum Client geth

1. To install geth, go to [https://github.com/ethereum/go-ethereum/releases]<br/>
2. To start the HTTP JSON-RPC, use the command `geth --rpc`<br/>
3. To create a new account, use the command `geth account new`
4. To launch javascript console use the command `geth attach`
5. If you want to start mining, use the command `start.miner()` in the javascript console
6. If you want to obtain the storage position to be used as the parameter for getStorageAt operation follow the steps below.<br/>
       use this command in geth console `var key = "000000000000000000000000<account address without '0X' prefix>" + "0000000000000000000000000000000000000000000000000000000000000001"`.
       And you will obtain the storage position of position1.
       Then you can use this value to obtain the value of the storage using the operation getStorageAt.<br/><br/>
 > NOTE:  To deploy smart contract in ethereum blockchain, follow [URL](https://www.ethereum.org/greeter).

### Steps to follow in setting integration test.

 1. Download EI 6.4.0  by navigating to the following [URL](http://wso2.com/products/enterprise-service-bus/#).
 2. Copy the EI 6.4.0 zip to the location `Connector_Home/repository/`.
 3. Following are the properties used in the 'esb-connector-ethereum.properties' file and ethereum.properties file at location "<ETHEREUM_CONNECTOR_HOME>/src/test/resources/artifacts/ESB/connector.config" to run the integration tests.
 <br/></br>

|   Properties |   Description  |
|--------------|----------------|
|apiUrl        |    api URL for Ethereum |
|port          |    default rpc port for Ethereum port|
|id            |    value of the id established by the Ethereum client|
|address       | address of the account|
|block         | value of the block number |
|storageAddress| address of the storage |
|storagePosition | position in the storage |
|storageBlock    | value of the block number for which the storage is going to be checked |

 4. Navigate to `{EI_Connector_Home}/` and run the following command.<br/>
               `$ mvn clean install -Dskip-tests=false`