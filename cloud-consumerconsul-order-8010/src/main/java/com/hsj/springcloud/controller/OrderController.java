package com.hsj.springcloud.controller;

import com.hsj.springcloud.entities.CommonResult;
import com.hsj.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @GetMapping("/consumer/payment/consul")
    public String  get()
    {
        return restTemplate.getForObject(PAYMENT_URL +"/payment/consul", String.class);
    }
}
