package com.unv.mapper;

import com.unv.config.FeignConfig;
import com.unv.config.HiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EUREKA-CLIENT-DEMO",configuration = FeignConfig.class,fallback = HiHystrix.class)
public interface EurekaClientFeign {
    @GetMapping("/hi")
    String sayHiFromClientEureka(@RequestParam("name") String name);
}
