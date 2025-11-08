package com.bitspilani.leadmanager;

import com.bitspilani.leadmanager.Controller.McpController;
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
    public ToolCallbackProvider McpTools(McpController mcpController) {
        return MethodToolCallbackProvider.builder().toolObjects(mcpController).build();
    }
}
