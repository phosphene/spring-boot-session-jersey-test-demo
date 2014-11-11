package com.phosphene.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;


@ComponentScan
@EnableJpaRepositories("com.phosphene.rest.repository")
@EnableAutoConfiguration(exclude={ErrorMvcAutoConfiguration.class})
@EnableRedisHttpSession
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		new Application().configure(new SpringApplicationBuilder(Application.class)).run(
				args);
	}

    @Bean
    public HeaderHttpSessionStrategy cookieHttpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }

}
