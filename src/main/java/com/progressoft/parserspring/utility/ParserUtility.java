package com.progressoft.parserspring.utility;

import com.progressoft.interns.advanced.parser.CsvParserImpl;
import com.progressoft.interns.advanced.parser.Parser;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ParserUtility {
    public static ArrayList<Object[]> parseData(MultipartFile file){
        ArrayList<Object[]> data = null;
        try {
            Path csvToParse = Files.createTempFile("csvToParse", ".csv");
            String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
            Files.write(csvToParse, fileContent.getBytes(), StandardOpenOption.WRITE);
            Parser<ArrayList<Object[]>> parser = new CsvParserImpl();
            data = parser.parse(csvToParse.toString());

            for (Object[] row : data) {
                for (Object cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        } catch (IOException e){
            System.out.println("Error in parsing the data");
        }
        return data;
    }
}
