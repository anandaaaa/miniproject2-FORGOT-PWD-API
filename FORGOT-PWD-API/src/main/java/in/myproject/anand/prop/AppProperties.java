package in.myproject.anand.prop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="forgot-app")
public class AppProperties {
	
	public Map<String,String> messages =new HashMap<>();

}
