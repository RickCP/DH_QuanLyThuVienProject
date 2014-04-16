package com.quanlythuvien.web.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.quanlythuvien" })
@EnableWebMvc
@Import({ SpringDataConfig.class, ThymeleafConfig.class })
@ImportResource("classpath:trace-context.xml")
@PropertySource("classpath:spring.properties")
public class ApplicationContext extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySources = new PropertySourcesPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[] { new ClassPathResource(
				"spring.properties") };
		propertySources.setLocations(resources);
		propertySources.setIgnoreUnresolvablePlaceholders(true);
		return propertySources;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}

}
