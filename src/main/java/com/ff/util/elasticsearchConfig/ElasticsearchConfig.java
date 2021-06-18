/*

package com.ff.util.elasticsearchConfig;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.RestClientBuilder.RequestConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @ClassName ElasticsearchConfig
 * @Description TODO
 * @Author ff
 * @Date 2020/2/29 20:36
 * @ModifyDate 2020/2/29 20:36
 * @Version 1.0
 *//*



@Configuration
//@PropertySource(value = "classpath:config/elasticsearch.properties")
public class ElasticsearchConfig {


    @Value("${elasticsearch.ip}")
    private String ipPort;
    @Value("${elasticsearch.connectTimeOut}")
    private int connectTimeOut; // 连接超时时间
    @Value("${elasticsearch.socketTimeOut}")
    private int socketTimeOut; // 连接超时时间
    @Value("${elasticsearch.connectionRequestTimeOut}")
    private int connectionRequestTimeOut; // 获取连接的超时时间
    @Value("${elasticsearch.maxConnectNum}")
    private int maxConnectNum; // 最大连接数
    @Value("${elasticsearch.maxConnectPerRoute}")
    private int maxConnectPerRoute; // 最大路由连接数



    @Bean(name = "highLevelClient")
    public RestHighLevelClient highLevelClient() {

        RestClientBuilder builder =  RestClient.builder(makeHttpHost(ipPort));

        builder.setRequestConfigCallback(new RequestConfigCallback() {

            @Override
            public Builder customizeRequestConfig(Builder requestConfigBuilder) {
                requestConfigBuilder.setConnectTimeout(connectTimeOut);
                requestConfigBuilder.setSocketTimeout(socketTimeOut);
                requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeOut);
                return requestConfigBuilder;
            }
        });
        // 异步httpclient连接数配置
        builder.setHttpClientConfigCallback(new HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                httpClientBuilder.setMaxConnTotal(maxConnectNum);
                httpClientBuilder.setMaxConnPerRoute(maxConnectPerRoute);
                return httpClientBuilder;
            }
        });

        RestHighLevelClient client = new RestHighLevelClient(builder);

        return client;
    }


    private HttpHost makeHttpHost(String s) {
        String[] address = s.split(":");
        String ip = address[0];
        int port = Integer.parseInt(address[1]);

        return new HttpHost(ip, port, "http");
    }


}

*/
