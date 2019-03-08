# Ethereum EI Connector

The Ethereum is a decentralized platform that runs smart contracts. The Ethereum [Connector](https://docs.wso2.com/display/EI640/Working+with+Connectors) allows to access the Ethereum blockchain.

## Prerequisites

> NOTE: To work with the Ethereum connector, you need to have installed the Ethereum client called geth.<br/>


## Compatibility

| Connector version | Supported geth version | Supported WSO2 ESB/EI version |
| ------------- | ------------- | ------------- |
| [1.0.0] |  1.8.19-stable | EI 6.1.0, EI 6.4.0 |

## Getting started

#### Download and install the connector

1. Download the connector from the [WSO2 Store]
2. Then you can follow this [Documentation](https://docs.wso2.com/display/EI640/Working+with+Connectors+via+the+Management+Console) to add and enable the connector via the Management Console in your EI instance.
3. For more information on using connectors and their operations in your EI configurations, see [Using a Connector](https://docs.wso2.com/display/EI640/Using+a+Connector).
4. If you want to work with connectors via EI tooling, see [Working with Connectors via Tooling](https://docs.wso2.com/display/EI640/Working+with+Connectors+via+Tooling).

#### Configuring the connector operations

To get started with ethereum connector and their operations, see [Configuring Ethereum Operations](docs/config.md).


## Building From the Source

Follow the steps given below to build the Ethereum connector from the source code:

1. Get a clone or download the source from [Github]().
2. Run the following Maven command from the `esb-connector-ethereum` directory: `mvn clean install`.
3. The ethereum connector zip file is created in the `esb-connector-ethereum/target` directory.

## How You Can Contribute

As an open source project, WSO2 extensions welcome contributions from the community.
Check the [issue tracker]() for open issues that interest you. We look forward to receiving your contributions.


