package com.ccl.rain.server.container;

/**
 * Created by ccl on 17/8/14.
 */

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;


public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("com.ccl.rain.action");
        //注册数据转换器
        register(JacksonFeature.class);
        //register(ResponseFilter.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
    }
}
