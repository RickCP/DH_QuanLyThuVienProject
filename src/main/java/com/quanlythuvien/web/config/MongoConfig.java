package com.quanlythuvien.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Configuration
@EnableMongoRepositories("com.quanlythuvien.persit.repository")
public class MongoConfig {
	@Bean
	public MongoOperations mongoTemplate(Mongo mongo) {
		MongoTemplate mongoTemplate = new MongoTemplate(mongo,
				"QuanLyThuVienDB");
		mongoTemplate.setWriteConcern(com.mongodb.WriteConcern.SAFE);
		return mongoTemplate;
	}

	/*
	 * Factory bean that creates the Mongo instance
	 */
	@Bean
	public MongoFactoryBean mongo() {
		MongoFactoryBean mongo = new MongoFactoryBean();
		mongo.setHost("localhost");
		return mongo;
	}

	/*
	 * Use this post processor to translate any MongoExceptions thrown in
	 * 
	 * @Repository annotated classes
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
