/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pl.tsa.soft.navigator.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author potatolot
 */
@EnableScheduling
@SpringBootApplication
public class NavigatorService {

    public static void main(String[] args) {
        SpringApplication.run(NavigatorService.class, args);
    }
}
