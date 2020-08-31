package com.statio.pirates.proof.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WebMVCConfigurationTest {

    @Test
    public void shouldReturnWebMVCConfiguration() {
        final WebMVCConfiguration webMvcConfiguration = new WebMVCConfiguration();
        Assert.assertNotNull(webMvcConfiguration);
    }
}
