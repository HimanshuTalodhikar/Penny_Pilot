package com.example.demo.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/chat")
public class ChatController {
  private final OllamaChatModel ollamaChatModel;
    private final PgVectorStore vectorStore;

    public ChatController(OllamaChatModel ollamaChatModel, PgVectorStore vectorStore) {
        this.ollamaChatModel = ollamaChatModel;
        this.vectorStore = vectorStore;
    }

    @PostMapping
    public String chat(@RequestBody String message){
         final String systemPrompt= """
                You are PennyPilot, a domain-specialized financial assistant trained to provide accurate, well-structured responses related to finance, investing, budgeting, wealth management, taxation, personal finance, credit, and economics.
                
                Your responses must be:
                - Factually correct and logically sound.
                - Clear, concise, and professional.
                - Written in well-structured markdown, using bullet points, headers, tables, or examples where helpful.
                - Adapted to both beginner and intermediate audiences (explain jargon only when necessary).
                - Helpful for users seeking clarity, guidance, or strategic advice on financial topics.
                
                Strictly follow these rules:
                1. Do not mention or refer to the user’s question or message explicitly (no “based on your question”).
                2. Do not include filler or unnecessary prefacing (e.g., “As an AI model,” or “Sure, here’s the answer”).
                3. When appropriate, provide simple formulas, actionable insights, and brief case examples.
                4. If a concept is complex, break it down logically in steps.
                5. Do not speculate or provide unverified financial advice — remain grounded in principles and best practices.
                
                You are not a chatbot — you are a financial analyst turned AI with expertise in financial education, risk assessment, and advisory intelligence.
                make sure you dont Take anybodys names
                """;
       return ChatClient.builder(ollamaChatModel).build().prompt().advisors(new QuestionAnswerAdvisor(vectorStore)
        ).user(message).system(systemPrompt).call().content();



    }
}
