package com.progressoft.parserspring.utility;

import com.progressoft.interns.advanced.exception.ParserException;
import com.progressoft.interns.advanced.parser.CsvParserImpl;
import com.progressoft.interns.advanced.parser.Parser;
import com.progressoft.interns.advanced.utility.ParsedDataUtilityImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ParserUtility {
    public static ArrayList<Object[]> parseData(MultipartFile file) {
        ArrayList<Object[]> data = null;
        try {
            Path csvToParse = Files.createTempFile("csvToParse", ".csv");
            String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
            Files.write(csvToParse, fileContent.getBytes(), StandardOpenOption.WRITE);
            Parser<ArrayList<Object[]>> parser = new CsvParserImpl();
            data = parser.parse(csvToParse.toString());
        } catch (IOException e){
            System.out.println("Error in parsing the data");
        }
        return data;
    }

    public static BigDecimal doColumnOperation(String columnName, String operation, Object data){
        ParsedDataUtilityImpl utility = new ParsedDataUtilityImpl();
        BigDecimal result;
        if (operation.equals("avg")){
            result = utility.getAverageOfColumn(data, columnName);
        } else {
            result = utility.getSummationOfColumn(data, columnName);
        }
        return result;
    }

    public static ArrayList<String> getColumnData(String columnName, Object data){
        ParsedDataUtilityImpl utility = new ParsedDataUtilityImpl();
        return utility.getColumnData(data, columnName);
    }

    public static String getFileName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename != null) {
            int extensionIndex = originalFilename.lastIndexOf(".");
            if (extensionIndex != -1) {
                String fileName = originalFilename.substring(0, extensionIndex);
                String extension = originalFilename.substring(extensionIndex + 1);
                return fileName + "." + extension;
            }
        }
        return "error";
    }
}
