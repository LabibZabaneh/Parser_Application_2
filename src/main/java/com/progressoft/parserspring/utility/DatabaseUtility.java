package com.progressoft.parserspring.utility;

import com.progressoft.parserspring.database.History;
import com.progressoft.parserspring.repository.HistoryRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.net.http.HttpRequest;

public class DatabaseUtility {

    public static HistoryRepository update(HttpSession session, HistoryRepository historyRepository, HttpServletRequest request, String column, BigDecimal result){
        String fileName = (String) session.getAttribute("fileName");
        History existingHistory = historyRepository.findByFileName(fileName);
        if (existingHistory != null) {
            if (request.getParameter("operation").equals("avg")) {
                existingHistory.setColumnName(column);
                existingHistory.setAverage(result.doubleValue());
            } else {
                existingHistory.setColumnName(column);
                existingHistory.setSum(result.doubleValue());
            }
            historyRepository.save(existingHistory);
        } else {
            History newHistory = new History(fileName, column, request.getParameter("operation"), result.doubleValue());
            historyRepository.save(newHistory);
        }
        return historyRepository;
    }
}
