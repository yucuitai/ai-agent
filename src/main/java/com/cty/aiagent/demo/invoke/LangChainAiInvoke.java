package com.cty.aiagent.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author cty
 * @date 2025/5/5 16:55
 * LangChainAi调用
 */
public class LangChainAiInvoke {

    @Resource
    private TestApiKey testApiKey;

    public static void main(String[] args) {
        //手动从Spring容器中获取ApiKey
        ConfigurableApplicationContext context = SpringApplication.run(LangChainAiInvoke.class, args);
        TestApiKey testApiKey = context.getBean(TestApiKey.class);

        ChatLanguageModel qwenModel = QwenChatModel.builder()
                .apiKey(testApiKey.getApiKey())
                .modelName("qwen-max")
                .build();

        String answer = qwenModel.chat("你好，胖胖龙");
        System.out.println(answer);
    }
}
