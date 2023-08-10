package com.swap.pivot.util;

import com.swap.pivot.model.StockData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PivotUtil {
    public List<StockData> findPivotHighs(StockData[] data, int k) {
        List<StockData> pivotHigh = new ArrayList<>();
        int currentIndex= k;
        while(currentIndex< data.length- k) {
            int nextIndex = checkPivotHigh(Arrays.copyOfRange(data, currentIndex- k, currentIndex+ k +1),
                    currentIndex, pivotHigh);
            currentIndex = nextIndex;
        }
        return pivotHigh;
    }

    private int checkPivotHigh(StockData[] data, int currentIndex, List<StockData> pivotHigh) {
        int index = data.length/2;
        int nextIndex = currentIndex;
        boolean isEqual = false;
        for(int i=1; i<=index; i++) {
            if(data[index].getHigh() < data[index+i].getHigh()) {
                return currentIndex+i;
            } else if(data[index] == data[index+i]){
                isEqual = true;
                nextIndex = currentIndex+i;
            }
            if(data[index].getHigh() < data[index-i].getHigh()){
                return currentIndex+1;
            }
        }
        if(!isEqual) {
            nextIndex = currentIndex + index + 1;
        }
        pivotHigh.add(data[index]);
        return nextIndex;
    }

    public List<StockData> findPivotLows(StockData[] data, int k) {
        List<StockData> pivotLow = new ArrayList<>();

        int currentIndex = k;
        while(currentIndex< data.length- k) {
            int nextIndex = checkPivotLow(Arrays.copyOfRange(data, currentIndex- k, currentIndex+ k +1),
                    currentIndex, pivotLow);
            currentIndex = nextIndex;
        }
        return pivotLow;
    }

    private int checkPivotLow(StockData[] data, int currentIndex, List<StockData> pivotLow) {
        int index = data.length/2;
        for(int i=1; i<=index; i++) {
            if(data[index].getLow() > data[index+i].getLow()) {
                return currentIndex+i;
            } else if(data[index].getLow() == data[index+i].getLow()){
                return currentIndex+index+1;
            }
            if(data[index].getLow() >= data[index-i].getLow()){
                return currentIndex+1;
            }
        }
        pivotLow.add(data[index]);
        return currentIndex+index+1;
    }

}
