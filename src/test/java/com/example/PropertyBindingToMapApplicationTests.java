package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.PropertyBindingToMapApplication.MyProperties;

@RunWith(SpringRunner.class)
@SpringBootTest("PROPS_FOOS_FOO1_BAR=bar")
/**
 * Demonstrates unexpected behavior binding an environment variable to a Map.
 * PROPS = prefix
 * FOOS  = Map
 * FOO1  = Intended key
 * BAR   = Property name on value object. Apparently binds only to constructor arg.
 *  
 * 
 * @author dturanski
 *
 */
public class PropertyBindingToMapApplicationTests {
	
	@Autowired
	MyProperties props;

	@Test
	//Probably shouldn't pass but does.
	public void contextLoads() {
		assertThat(props.getFoos().get("FOO1_BAR")).isNotNull();
		assertThat(props.getFoos().get("FOO1_BAR").getBar()).isEqualTo("bar");
	}

}
