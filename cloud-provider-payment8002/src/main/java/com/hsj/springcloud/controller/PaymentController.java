package com.hsj.springcloud.controller;

import com.hsj.springcloud.entities.CommonResult;
import com.hsj.springcloud.entities.Payment;
import com.hsj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody  Payment payment){

        int result  = paymentService.create(payment);

        log.info("返回结果: "+result);

        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(404,"插入失败",result);
        }
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);

        log.info("返回结果: "+payment);
        if (payment!=null){

            return new CommonResult(200,"查询成功,ij",payment);
        }else{
            return new CommonResult(404,"没用记录,ID"+id,null);
        }
    }
}
