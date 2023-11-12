package com.learn.SpringBootApplication.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="service")
@Component
public class ServiceConfig {

    public String serviceName;
    public long serviceNo;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(long serviceNo) {
        this.serviceNo = serviceNo;
    }
}
