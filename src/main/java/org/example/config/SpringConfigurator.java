package org.example.config;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.websocket.server.ServerEndpointConfig;

public class SpringConfigurator extends ServerEndpointConfig.Configurator {

    private static volatile ApplicationContext context;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringConfigurator.context = applicationContext;
    }

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        return context.getBean(endpointClass);
    }
}

