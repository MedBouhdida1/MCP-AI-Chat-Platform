package org.example.mcpclient;

import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(List<McpSyncClient> clients) {
		return args -> {
			clients.forEach(client -> {
				client.listTools().tools().forEach(tool -> {
					System.out.println("Tool Name: " + tool.name());
					System.out.println("Description: " + tool.description());
					System.out.println("Parameters: " + tool.inputSchema());
					System.out.println("-----------------------------");
					System.out.println("-----------------------------");
				});
			});
			System.out.println("********************");
			String params= """
							{
								"name": "TechNova"
							}
							""";
			McpSchema.CallToolResult result=clients.get(0).callTool(new McpSchema.CallToolRequest("getCompany",params));

			McpSchema.Content content=result.content().get(0);
			if(content instanceof McpSchema.TextContent){
				McpSchema.TextContent textContent = (McpSchema.TextContent) content;
				System.out.println(textContent.text());
			}

		};
	}



}
