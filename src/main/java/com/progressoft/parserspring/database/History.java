package com.progressoft.parserspring.database;

import javax.persistence.*;

@Entity
@Table(name="history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String columnName;
    private Double sum;
    private Double average;

    public History(String fileName, String columnName, String operation ,Double result){
        this.fileName = fileName;
        this.columnName = columnName;
        if (operation.equals("avg")){
            this.average=result;
        } else {
            this.sum=result;
        }
    }

    public History() {}

    public Long getId() {return id;}

    public String getFileName() {
        return fileName;
    }

    public String getColumnName() {
        return columnName;
    }

    public Double getSum() {
        return sum;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "History{" +
                ", fileName='" + fileName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", sum=" + sum +
                ", average=" + average +
                '}';
    }
}

