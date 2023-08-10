package com.swap.pivot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PivotControllerTest {
    @Test
    void findPivots_readDataFromCsv_PivotHighAndLowsAreReturned() {
        try {

            PivotController controller = new PivotController();
            ResponseEntity<String> response = controller.getPivots("src/test/resources/sampleData", 2);
            String actual = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();

            FileReader f = new FileReader("src/test/resources/PivotOutput.json");
            String expected = objectMapper.readTree(f).toString();
            assertEquals(expected, actual);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}