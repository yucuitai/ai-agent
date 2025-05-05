package com.cty.aiagent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

public class HttpInvoke {

    @Resource
    private TestApiKey testApiKey;
    public static void main(String[] args) {
        //手动从Spring容器中获取ApiKey
        ConfigurableApplicationContext context = SpringApplication.run(LangChainAiInvoke.class, args);
        TestApiKey testApiKey = context.getBean(TestApiKey.class);

        String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

        // 构建请求体 JSON
        JSONObject requestBody = JSONUtil.createObj()
                .put("model", "qwen-plus")
                .put("input", JSONUtil.createObj()
                        .put("messages", Arrays.asList(
                                JSONUtil.createObj()
                                        .put("role", "system")
                                        .put("content", "You are a helpful assistant."),
                                JSONUtil.createObj()
                                        .put("role", "user")
                                        .put("content", "你是谁？")
                        )))
                .put("parameters", JSONUtil.createObj()
                        .put("result_format", "message"));

        // 发送请求
        try (HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + testApiKey.getApiKey())
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .timeout(10000)
                .execute()) {

            // 输出响应状态码和内容
            System.out.println("Status Code: " + response.getStatus());
            System.out.println("Response Body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
