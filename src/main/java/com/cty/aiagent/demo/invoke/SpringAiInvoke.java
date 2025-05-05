package com.cty.aiagent.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;


/**
 * @author cty
 * @date 2025/5/5 16:36
 * spring ai 调用
 * CommandLineRunner接口： 启动时执行自定义逻辑
 */
//@Component
public class SpringAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel dashscopeChatModel;

    @Resource
    private TestApiKey testApiKey;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage output = dashscopeChatModel.call(new Prompt("你好，胖胖龙"))
                .getResult()
                .getOutput();
        System.out.println(output.getText());
    }
}

