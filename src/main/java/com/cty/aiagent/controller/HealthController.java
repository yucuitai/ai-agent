package com.cty.aiagent.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cty
 * @date 2025/5/5 15:00
 */
@RestController
@RequestMapping("/health")
@Tag(name = "健康检查")
public class HealthController {

    @GetMapping
    @Operation(summary = "健康检查")
    public String healthCheck() {
        return "ok";
    }
}

