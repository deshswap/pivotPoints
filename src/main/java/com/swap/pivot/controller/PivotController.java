package com.swap.pivot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import com.swap.pivot.model.StockData;
import com.swap.pivot.response.PivotResponse;
import com.swap.pivot.util.PivotUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@RestController
public class PivotController {
    @GetMapping(value = "/pivotpoints", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPivots(
            final @RequestParam(name = "fileName") String fileName,
            final @RequestParam(name = "noOfDays") int noOfDays) {
        String json = "";
        try {
            List<StockData> stockData = readStockData(fileName);

            StockData[] stockDataArr = stockData.stream().toArray(StockData[] ::new);

            PivotUtil pivotUtil = new PivotUtil();
            List<StockData> pivotHighs = pivotUtil.findPivotHighs(stockDataArr, noOfDays);
            List<StockData> pivotLows = pivotUtil.findPivotLows(stockDataArr, noOfDays);

            PivotResponse response = new PivotResponse();
            response.setPivotHighs(pivotHighs);
            response.setPivotLows(pivotLows);

            json = new ObjectMapper().writeValueAsString(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // return the rows of pivotHigh and pivotLows
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    private static List<StockData> readStockData(String fileName) throws FileNotFoundException {
        List<StockData> stockData = new CsvToBeanBuilder(new FileReader(fileName+".csv"))
                .withType(StockData.class)
                .build()
                .parse();
        return stockData;
    }

    @GetMapping(value = "/")
    public String hello() {
        return "Hello";
    }

}
