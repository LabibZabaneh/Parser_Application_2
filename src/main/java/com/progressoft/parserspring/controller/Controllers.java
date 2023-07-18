package com.progressoft.parserspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;

import static com.progressoft.parserspring.utility.ParserUtility.*;

@Controller
public class Controllers {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/")
    public String hello(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(){
        return "upload";
    }

    @PostMapping("/upload")
    public String processUpload(@RequestParam("file") MultipartFile file, Model model) {
        HttpSession session = request.getSession();
        ArrayList<Object[]> data = null;
        data = parseData(file);
        session.setAttribute("parsedData",  data);
        return "data";
    }

    @PostMapping("/back")
    public String goback(@RequestParam("fileName") String fileName){
        return fileName;
    }

    @PostMapping("/opColumn")
    public String opColumn(@RequestParam("columns") String column, Model model){
        HttpSession session = request.getSession();
        Object data = session.getAttribute("parsedData");
        if (request.getParameter("operation").equals("getData")){
            model.addAttribute("result", getColumnData(column, data));
            model.addAttribute("colName", column);
            return "getDataResult";
        } else {
            BigDecimal result = doColumnOperation(column, request.getParameter("operation"), data);
            model.addAttribute("result", result);
            return "opResult";
        }
    }
}
