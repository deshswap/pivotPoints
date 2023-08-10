package com.swap.pivot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import com.swap.pivot.model.StockData;
import com.swap.pivot.response.PivotResponse;
import com.swap.pivot.util.PivotUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(PivotController.class);

    @GetMapping(value = "/pivotpoints", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPivots(
            final @RequestParam(name = "fileName") String fileName,
            final @RequestParam(name = "noOfDays") int noOfDays) {
        String json = "";
        try {
            List<StockData> stockData = readStockData(fileName);

            StockData[] stockDataArr = stockData.stream().toArray(StockData[] ::new);
            if(stockDataArr.length < (2*noOfDays)+1) {
                log.error("Insufficient Data to Generate Pivots. Try changing the value of noOfDays");
                return new ResponseEntity<>("Insufficient Data to Generate Pivots", HttpStatus.BAD_REQUEST);
            }

            PivotUtil pivotUtil = new PivotUtil();
            List<StockData> pivotHighs = pivotUtil.findPivotHighs(stockDataArr, noOfDays);
            List<StockData> pivotLows = pivotUtil.findPivotLows(stockDataArr, noOfDays);

            PivotResponse response = new PivotResponse();
            response.setPivotHighs(pivotHighs);
            response.setPivotLows(pivotLows);

            json = new ObjectMapper().writeValueAsString(response);
        } catch (FileNotFoundException e) {
            log.error("File {} not found", fileName);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
        } catch (JsonProcessingException e) {
            log.error("JSON processing error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
}
