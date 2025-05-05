package com.cty.aiagent.demo.invoke;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author cty
 * @date 2025/5/5 15:41
 * 仅用于测试 api key
 */
@Component
@ConfigurationProperties(prefix = "spring.ai.dashscope")
public class TestApiKey {

    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}

