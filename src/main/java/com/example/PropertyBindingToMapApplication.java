package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PropertyBindingToMapApplication.MyProperties.class)
public class PropertyBindingToMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyBindingToMapApplication.class, args);
	}
	
	@ConfigurationProperties(prefix="props")
	static class MyProperties {
		private Map<String, Foo> foos = new HashMap<>();

		public Map<String, Foo> getFoos() {
			return foos;
		}
	}
	
	static class Foo {
		private String bar;
		
		public Foo(String bar) {
			this.bar = bar;
		}

		public String getBar() {
			return bar;
		}
	}
}
