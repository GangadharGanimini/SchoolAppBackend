package net.javaguides.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "net.javaguides.springboot")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "school_management";
    }

    
    protected String getMappingBasePackage() {
        return "net.javaguides.springboot";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(); // Use the default MongoClient
    }
}

