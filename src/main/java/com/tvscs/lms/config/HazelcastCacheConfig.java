package com.tvscs.lms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

@Configuration
public class HazelcastCacheConfig {
	
	@Bean
	public Config cacheConfig() {

		return new Config().setInstanceName("hazelcast-instance")
				.addMapConfig(
						new MapConfig()
						.setName("users-cache")
						.setMaxSizeConfig(new MaxSizeConfig(2000, MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU)
						.setTimeToLiveSeconds(20000)
						);
	}

}
