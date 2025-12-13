package com.bitspilani.leadmanager;

import com.bitspilani.leadmanager.Controller.McpTools;
import com.bitspilani.leadmanager.Controller.UserBalanceCalculator;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LeadmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadmanagerApplication.class, args);
	}

    @Bean
    public ToolCallbackProvider McpTools(McpTools mcpController) {
        return MethodToolCallbackProvider.builder().toolObjects(mcpController).build();
    }

    @Bean
    public ToolCallbackProvider UserBalance(UserBalanceCalculator userBalanceCalculator) {
        return MethodToolCallbackProvider.builder().toolObjects(userBalanceCalculator).build();
    }
}
