package com.phosphene.rest.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;
import com.phosphene.rest.controllers.*;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
            property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
            property(ServerProperties.JSON_PROCESSING_FEATURE_DISABLE, false);
            property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);
            property(ServerProperties.WADL_FEATURE_DISABLE, true);
            property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
           
            register(SessionsController.class);
            
	}

}
