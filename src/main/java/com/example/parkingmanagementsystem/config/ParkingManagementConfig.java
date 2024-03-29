package com.example.parkingmanagementsystem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("pms")
public class ParkingManagementConfig {

    private Map<String, Integer> hourlyRate;
}