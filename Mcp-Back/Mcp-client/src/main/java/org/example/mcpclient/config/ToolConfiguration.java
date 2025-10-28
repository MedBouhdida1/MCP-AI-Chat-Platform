package org.example.mcpclient.Config;

import org.example.mcpclient.tools.EmployeeTools;
import org.example.mcpclient.tools.StockTools;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolConfiguration {

    @Bean
    public MethodToolCallbackProvider methodToolCallbackProvider(StockTools stockTools, EmployeeTools employeeTools) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(stockTools, employeeTools)
                .build();
    }
}

