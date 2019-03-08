/*
 *  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.connector.integration.test.ethereum;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Sample integration test.
 */
public class EthereumConnectorIntegrationTest extends ConnectorIntegrationTestBase {

    private Map<String, String> eiRequestHeadersMap = new HashMap<String, String>();
    private Map<String, String> apiRequestHeadersMap = new HashMap<String, String>();

    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        String connectorName = System.getProperty("connector_name") + "-connector-" +
                System.getProperty("connector_version") + ".zip";
        init(connectorName);
        getApiConfigProperties();
        eiRequestHeadersMap.put("Accept-Charset", "UTF-8");
        eiRequestHeadersMap.put("Content-Type", "application/json");
        apiRequestHeadersMap.put("Accept-Charset", "UTF-8");
        apiRequestHeadersMap.put("Content-Type", "application/json");
    }

    /**
     * Positive test case for getVersion method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getVersion} integration test with mandatory" +
            " parameters.")
    public void testGetVersionWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getVersion");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getVersion.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getVersion.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getListening method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getListening} integration test with " +
            "mandatory parameters.")
    public void testGetListeningWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getListening");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getListening.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getListening.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getPeerCount method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getPeerCount} integration test with " +
            "mandatory parameters.")
    public void testGetPeerCountWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getPeerCount");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getPeerCount.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getPeerCount.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getProtocolVersion method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getProtocolVersion} integration test with " +
            "mandatory parameters.")
    public void testGetProtocolVersionWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getProtocolVersion");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getProtocolVersion.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getProtocolVersion.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getSyncing method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getSyncing} integration test with" +
            " mandatory parameters.")
    public void testGetSyncingWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getSyncing");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getSyncing.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getSyncing.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getCoinbase method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getCoinbase} integration test with " +
            "mandatory parameters.")
    public void testGetCoinbaseWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getCoinbase");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getCoinbase.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getCoinbase.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getMining method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getMining} integration test with " +
            "mandatory parameters.")
    public void testGetMiningWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getMining");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getMining.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getMining.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getHashRate method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getHashRate} integration test with " +
            "mandatory parameters.")
    public void testGetHashRateWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getHashRate");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getHashRate.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getHashRate.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getGasPrice method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getGasPrice} integration test with " +
            "mandatory parameters.")
    public void testGetGasPriceWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getGasPrice");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getGasPrice.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getGasPrice.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getAccounts method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getAccounts} integration test with " +
            "mandatory parameters.")
    public void testGetAccountsWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getAccounts");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getAccounts.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getAccounts.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getBlockNumber method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getBlockNumber} integration test with" +
            " mandatory parameters.")
    public void testGetBlockNumberWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getBlockNumber");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getBlockNumber.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getBlockNumber.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getBalance method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getBalance} integration test with" +
            " mandatory parameters.")
    public void testGetBalanceWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getBalance");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getBalance.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getBalance.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getStorageAt method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getStorageAt} integration test with " +
            "mandatory parameters.")
    public void testGetStorageAtWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getStorageAt");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getStorageAt.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getStorageAt.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getTransactionCount method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getTransactionCount} integration test with " +
            "mandatory parameters.")
    public void testGetTransactionCountWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getTransactionCount");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap,
                        "ei_getTransactionCount.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getTransactionCount.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }

    /**
     * Positive test case for getCode method with mandatory parameters.
     */
    @Test(enabled = true, groups = {"wso2.ei"}, description = "ethereum {getCode} integration test with " +
            "mandatory parameters.")
    public void testGetCodeWithMandatoryParameters() throws Exception {

        eiRequestHeadersMap.put("Action", "urn:getCode");
        RestResponse<JSONObject> eiRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", eiRequestHeadersMap, "ei_getCode.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + ":" + connectorProperties.getProperty("port");
        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "POST", apiRequestHeadersMap,
                        "api_getCode.json");
        Assert.assertEquals(eiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(apiRestResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(eiRestResponse.getBody().getString("result"),
                apiRestResponse.getBody().getString("result"));
    }
}
