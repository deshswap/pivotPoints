package com.swap.pivot.util;

import com.swap.pivot.model.StockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PivotsTest {
   private PivotUtil pivots = new PivotUtil();

    @Test
    void findPivotHighData_SinglePivotHigh_PivotHighWithSingleRecord() {
        double[] data = new double[]{316.84,311.44,318.00,314.96,313.89};
        int noOfDays = 2;

        StockData[] stockData = createStockDataForPivotHigh(data);
        List<StockData> pivotHighs =  pivots.findPivotHighs(stockData, noOfDays);
        List<Double> actualPivotHighs = pivotHighs.stream().map(StockData::getHigh).collect(Collectors.toList());

        List<Double> expectedPivotHighs = Arrays.asList(318.00);
        assertEquals(expectedPivotHighs, actualPivotHighs);
    }

    @Test
    void findPivotHighData_MultiplePivotHighs_PivotHighWithMultipleRecords() {
        double[] data = new double[]{316.84, 311.44, 318.00, 314.96, 313.89, 294.00, 304.60, 316.84, 311.44, 278.00};
        int noOfDays = 2;
        StockData[] stockData = createStockDataForPivotHigh(data);
        List<StockData> pivotHighs =  pivots.findPivotHighs(stockData, noOfDays);
        List<Double> actualPivotHighs = pivotHighs.stream().map(StockData::getHigh).collect(Collectors.toList());
        List<Double> expectedPivotHighs = Arrays.asList(318.00, 316.84);
        assertEquals(expectedPivotHighs, actualPivotHighs);
    }


    @Test
    void findPivotHighData_MultiplePivotHighs_PivotHighWithMultipleRecords1() {
        double[] data = new double[]{316.84, 311.44, 318.00, 320.96, 313.89, 294.00, 314.60, 312.84, 311.44, 278.00};
        int noOfDays = 2;
        StockData[] stockData = createStockDataForPivotHigh(data);
        List<StockData> pivotHighs =  pivots.findPivotHighs(stockData, noOfDays);
        List<Double> actualPivotHighs = pivotHighs.stream().map(StockData::getHigh).collect(Collectors.toList());
        List<Double> expectedPivotHighs = Arrays.asList(320.96, 314.60);
        assertEquals(expectedPivotHighs, actualPivotHighs);
    }

    @Test
    void findPivotHighData_MultiplePivotHighs_PivotHighWithMultipleRecords2() {
        double[] data = new double[]{316.84, 311.44, 318.00, 310.96, 321.89, 294.00, 314.60, 319.84, 311.44, 278.00};
        int noOfDays = 2;
        StockData[] stockData = createStockDataForPivotHigh(data);
        List<StockData> pivotHighs =  pivots.findPivotHighs(stockData, noOfDays);
        List<Double> actualPivotHighs = pivotHighs.stream().map(StockData::getHigh).collect(Collectors.toList());
        List<Double> expectedPivotHighs = Arrays.asList(321.89, 319.84);
        assertEquals(expectedPivotHighs, actualPivotHighs);
    }

    @Test
    void findPivotHighData_MultiplePivotHighs_PivotHighWithMultipleRecords3() {
        double[] data = new double[]{319.84, 311.44, 318.00, 310.96, 317.89, 294.00, 324.60, 318.24, 311.44, 278.00};
        int noOfDays = 3;
        StockData[] stockData = createStockDataForPivotHigh(data);
        List<StockData> pivotHighs = pivots.findPivotHighs(stockData, noOfDays);
        List<Double> actualPivotHighs = pivotHighs.stream().map(StockData::getHigh).collect(Collectors.toList());
        List<Double> expectedPivotHighs = Arrays.asList(324.60);
        assertEquals(expectedPivotHighs, actualPivotHighs);
    }

    @Test
    void findPivotHighData_MultiplePivotHighsEqualValues_PivotHighWithMultipleRecords() {
        double[] data = new double[]{316.84, 311.44, 320.96, 320.96, 313.89, 294.00, 314.60, 312.84, 311.44, 278.00};
        int noOfDays = 2;
        StockData[] stockData = createStockDataForPivotHigh(data);
        List<StockData> pivotHighs = pivots.findPivotHighs(stockData, noOfDays);
        System.out.println(pivotHighs);
        List<Double> actualPivotHighs = pivotHighs.stream().map(StockData::getHigh).collect(Collectors.toList());
        List<Double> expectedPivotHighs = Arrays.asList(320.96, 314.60);
        assertEquals(expectedPivotHighs, actualPivotHighs);
    }

    @Test
    void findPivotData_SinglePivotLow_PivotLowWithSingleRecord() {
        double[] data = new double[]{316.84,311.44,301.23,314.96,313.89};
        int noOfDays = 2;
        StockData[] stockData = createStockDataForPivotLow(data);
        List<StockData> pivotLows = pivots.findPivotLows(stockData, noOfDays);
        List<Double> actualPivotLows = pivotLows.stream().map(StockData::getLow).collect(Collectors.toList());
        List<Double> expectedPivotLows = Arrays.asList(301.23);
        assertEquals(expectedPivotLows, actualPivotLows);
    }

    @Test
    void findPivotData_MultiplePivotLows_PivotLowWithMultipleRecords() {
        double[] data = new double[]{316.84, 311.44, 318.00, 314.96, 313.89, 294.00, 304.60, 316.84, 311.44, 278.00};
        int noOfDays = 2;
        StockData[] stockData = createStockDataForPivotLow(data);
        List<StockData> pivotLows = pivots.findPivotLows(stockData, noOfDays);
        List<Double> actualPivotLows = pivotLows.stream().map(StockData::getLow).collect(Collectors.toList());
        List<Double> expectedPivotLows = Arrays.asList(294.00);
        assertEquals(expectedPivotLows, actualPivotLows);
    }


    @Test
    void findPivotData_MultiplePivotLows_PivotLowWithMultipleRecords1() {
        double[] data = new double[]{316.84, 311.44, 310.00, 320.96, 313.89, 294.00, 314.60, 312.84, 311.44, 278.00};
        int noOfDays = 2;
        StockData[] stockData = createStockDataForPivotLow(data);
        List<StockData> pivotLows = pivots.findPivotLows(stockData, noOfDays);
        List<Double> actualPivotLows = pivotLows.stream().map(StockData::getLow).collect(Collectors.toList());
        List<Double> expectedPivotLows = Arrays.asList(310.00, 294.00);
        assertEquals(expectedPivotLows, actualPivotLows);
    }

    @Test
    void findPivotData_MultiplePivotLows_PivotLowWithMultipleRecord2() {
        double[] data = new double[]{316.84, 311.44, 318.00, 310.96, 321.89, 311.00, 310.60, 319.84, 311.44, 278.00};
        int noOfDays = 2;
        StockData[] stockData = createStockDataForPivotLow(data);
        List<StockData> pivotLows = pivots.findPivotLows(stockData, noOfDays);
        List<Double> actualPivotLows = pivotLows.stream().map(StockData::getLow).collect(Collectors.toList());
        List<Double> expectedPivotLows = Arrays.asList(310.96, 310.60);
        assertEquals(expectedPivotLows, actualPivotLows);
    }

    @Test
    void findPivotData_SinglePivotLow_PivotLowWithMultipleRecords() {
        double[] data = new double[]{319.84, 311.44, 318.00, 310.96, 313.89, 311.00, 314.60, 318.24, 311.44, 278.00};
        int noOfDays = 3;
        StockData[] stockData = createStockDataForPivotLow(data);
        List<StockData> pivotLows = pivots.findPivotLows(stockData, noOfDays);
        List<Double> actualPivotLows = pivotLows.stream().map(StockData::getLow).collect(Collectors.toList());
        List<Double> expectedPivotLows = Arrays.asList(310.96);
        assertEquals(expectedPivotLows, actualPivotLows);
    }

    private StockData[] createStockDataForPivotHigh(double[] data) {
        StockData[] stockData = new StockData[data.length];
        for(int i=0; i<data.length; i++) {
            stockData[i] = new StockData();
            stockData[i].setDate("2018/10/"+(i+1));
            stockData[i].setClose(data[i]-5);
            stockData[i].setVolume(new BigDecimal(Math.random()));
            stockData[i].setOpen(data[i]-3);
            stockData[i].setHigh(data[i]);
            stockData[i].setLow(data[i]-10);
        }
        return stockData;
    }

    private StockData[] createStockDataForPivotLow(double[] data) {
        StockData[] stockData = new StockData[data.length];
        for(int i=0; i<data.length; i++) {
            stockData[i] = new StockData();
            stockData[i].setDate("2018/10/"+(i+1));
            stockData[i].setClose(data[i]-5);
            stockData[i].setVolume(new BigDecimal(Math.random()));
            stockData[i].setOpen(data[i]-3);
            stockData[i].setHigh(data[i]+10);
            stockData[i].setLow(data[i]);
        }
        return stockData;
    }



}