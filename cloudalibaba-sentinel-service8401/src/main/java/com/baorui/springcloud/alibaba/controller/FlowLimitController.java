package com.baorui.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Acc_Br
 * @date 2022/10/3 21:57
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "------------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------------testB";
    }

    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    @GetMapping("/testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2)
    {
        return "testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "deal_testHotKey";
    }
}
