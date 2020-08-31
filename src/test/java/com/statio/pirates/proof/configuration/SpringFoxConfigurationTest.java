package com.statio.pirates.proof.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringFoxConfigurationTest {

    @Test
    public void shouldReturnWSpringFoxConfiguration() {
        final SpringFoxConfiguration springFoxConfiguration = new SpringFoxConfiguration();
        Assert.assertNotNull(springFoxConfiguration.api());
    }
}
