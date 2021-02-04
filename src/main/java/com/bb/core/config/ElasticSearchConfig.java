package com.bb.core.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.bb.core.esRepository")
public class ElasticSearchConfig {


    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration
            = ClientConfiguration.builder()
            .connectedTo("localhost:9200")
            .build();

        try(RestHighLevelClient client = RestClients.create(clientConfiguration).rest()) {

            return client;
        } catch (Exception e) {
            return null;
        }
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
