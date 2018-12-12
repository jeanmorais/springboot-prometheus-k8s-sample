package demo.spring.metrics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MicrometerConfig {
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Bean
	MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
	  return registry -> registry.config().commonTags("application", applicationName);
	}
	
}
