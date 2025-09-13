package org.example.mcpclient.Controllers;

import org.example.mcpclient.agents.AIAgent;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class AIRestController {


    private AIAgent agent;

    public AIRestController(AIAgent agent) {
        this.agent = agent;
    }


    @PostMapping("/chat")
    public String chat(@RequestParam String query) {
        return agent.askLLM(query);
    }


    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> streamChat(@RequestParam("q") String question) {
        return agent.askLLMStream(question)
                .map(chunk -> ServerSentEvent.<String>builder()
                        .data(chunk)
                        .build());
    }



}
