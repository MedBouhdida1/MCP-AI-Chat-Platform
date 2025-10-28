package org.example.mcpclient.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmployeeTools {

    @Tool(description = "Get basic employee information by name.")
    public Map<String, Object> getEmployeeInfo(String name) {
        return Map.of(
                "employee_name", name,
                "salary", 50_000
        );
    }
}

