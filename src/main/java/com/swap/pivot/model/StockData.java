package com.swap.pivot.model;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class StockData {
    @CsvBindByName(column = "date")
    private String date;

    @CsvBindByName(column = "close")
    private double close;

    @CsvBindByName(column = "volume")
    private BigDecimal volume;

    @CsvBindByName(column = "open")
    private double open;

    @CsvBindByName(column = "high")
    private double high;

    @CsvBindByName(column = "low")
    private double low;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public BigDecimal getVolume() { return volume; }

    public void setVolume(BigDecimal volume) { this.volume = volume; }

    @Override
    public String toString() {
        return "StockData{" +
                "date='" + date + '\'' +
                ", close=" + close +
                ", volume=" + volume +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                '}';
    }
}
