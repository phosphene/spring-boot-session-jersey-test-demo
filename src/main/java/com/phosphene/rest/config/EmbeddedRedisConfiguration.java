package com.phosphene.rest.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;

/**
 * Runs an embedded Redis instance. This is only necessary if we do not 
 * have Redis in place
 * In a production environment, this
 * would be obviated by  a Redis Server setup.
 *
 *
 */

@Configuration
public class EmbeddedRedisConfiguration {

    @Bean
    public RedisServerBean redisServer() {
        return new RedisServerBean();
    }

    class RedisServerBean implements InitializingBean, DisposableBean {
        private RedisServer redisServer;


        @Override
        public void afterPropertiesSet() throws Exception {
            redisServer = new RedisServer(Protocol.DEFAULT_PORT);
            redisServer.start();
        }

        @Override
        public void destroy() throws Exception {
            if(redisServer != null) {
                redisServer.stop();
            }
        }
    }
}
