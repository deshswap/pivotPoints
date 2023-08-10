package com.swap.pivot.response;

import com.swap.pivot.model.StockData;

import java.util.List;

public class PivotResponse {
    private List<StockData> pivotHighs;

    private List<StockData> pivotLows;

    public List<StockData> getPivotHighs() {
        return pivotHighs;
    }

    public void setPivotHighs(List<StockData> pivotHighs) {
        this.pivotHighs = pivotHighs;
    }

    public List<StockData> getPivotLows() {
        return pivotLows;
    }

    public void setPivotLows(List<StockData> pivotLows) {
        this.pivotLows = pivotLows;
    }
}
