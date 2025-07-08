package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.aot.VectorStoreRuntimeHints;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
@Component

public class IngestionService implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final VectorStore vectorStore;

    @Value("classpath:/docs/College_Students.pdf")
            private Resource pdfResource;
    IngestionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(String... args) throws Exception {
        var pdfReader= new PagePdfDocumentReader(pdfResource);
        TextSplitter textSplitter= new TokenTextSplitter();
        vectorStore.accept(textSplitter.apply(pdfReader.get()));
        logger.info("done !!");


    }
}
