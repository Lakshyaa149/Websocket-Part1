package com.pubsub.redispubsub.config;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration
public class RedissonConfig {



    @Bean
    public ReactiveRedisTemplate<String,String> reactiveRedisTemplate(LettuceConnectionFactory connectionFactory){

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(String.class);
        RedisSerializationContext.RedisSerializationContextBuilder builder=RedisSerializationContext.newSerializationContext(jackson2JsonRedisSerializer);

        return new ReactiveRedisTemplate(connectionFactory,builder.value(jackson2JsonRedisSerializer).build());


    }


  /*  @Bean
    public RedissonClient  redissonClient(){
        Config config = new Config();
        config.useClusterServers()
                .addNodeAddress("redis://127.0.0.1:6379");
        RedissonClient client= Redisson.create(config);
        return client;
    }
*/


}
