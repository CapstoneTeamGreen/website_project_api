package com.ganggreen.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jason MacKeigan
 */
@SpringBootApplication
@EnableEurekaServer
public class CapstoneServiceDiscovery {

    public static void main(String[] args) {
        SpringApplication.run(CapstoneServiceDiscovery.class, args);
    }


}
