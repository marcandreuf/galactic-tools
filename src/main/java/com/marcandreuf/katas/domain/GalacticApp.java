package com.marcandreuf.katas.domain;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.expressions.*;
import com.marcandreuf.katas.domain.services.ExpressionsRegistry;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;
import com.marcandreuf.katas.domain.services.IReaderService;
import com.marcandreuf.katas.domain.services.ReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

/**
 * Created by marc on 28/04/17.
 */
public class GalacticApp {

    private static final Logger logger = LoggerFactory.getLogger(GalacticApp.class);
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    public static final String OUTPUT_FILE_PATH = "build/resources/main/testOutput.txt";
    public static final String OUTPUT_HEADER = "Test output: ";
    private static GalacticCalculatorService calculatorService;
    private static IReaderService readerService;

    public static void main(String[] args){
        buildAppModel();

        try {
            String inputFileName = args[0];
            LineNumberReader lineReader = getFileLineReader(inputFileName);
            String result = processAllLines(lineReader);
            writeOutputFile(result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private static String processAllLines(LineNumberReader lineReader) throws IOException {
        String line;
        IExpression expression;
        StringBuilder outputContent = new StringBuilder();
        writeOutput(OUTPUT_HEADER, outputContent);
        while ((line = lineReader.readLine()) != null) {
            try {
                expression = readerService.read(line);
                String result = expression.resolve(calculatorService);
                if(!result.isEmpty()) {
                    writeOutput(result, outputContent);
                }
            }catch (ExpressionException ex){
                writeOutput(ex.getMessage(), outputContent);
            }
        }
        return outputContent.toString();
    }

    private static void writeOutputFile(String result) throws IOException {
        logger.info(result);
        Files.write(Paths.get(OUTPUT_FILE_PATH), result.getBytes());
    }

    private static LineNumberReader getFileLineReader(String inputFileName) throws URISyntaxException, IOException {
        URI fileUri = ClassLoader.getSystemResource(inputFileName).toURI();
        Path filePath = Paths.get(fileUri);
        BufferedReader reader = Files.newBufferedReader(filePath, ENCODING);
        return new LineNumberReader(reader);
    }

    private static void buildAppModel() {
        calculatorService = new GalacticCalculatorService(new HashSet<>(), new HashSet<>());
        ExpressionsRegistry expressionsRegistry = registerAccpetedExpressions();
        readerService = new ReaderService(expressionsRegistry);
    }

    private static ExpressionsRegistry registerAccpetedExpressions() {
        ExpressionsRegistry expressionsRegistry = new ExpressionsRegistry(new HashSet<>());
        expressionsRegistry.registerExpression(GalacticNumberExpression.class);
        expressionsRegistry.registerExpression(GalacticCreditExpression.class);
        expressionsRegistry.registerExpression(GalacticNumbersQuestion.class);
        expressionsRegistry.registerExpression(GalacticCreditsQuestion.class);
        return expressionsRegistry;
    }

    private static void writeOutput(String content, StringBuilder out){
        out.append(content).append(System.getProperty("line.separator"));
    }

}
