package com.swap.pivot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.io.File;

class PivotControllerTest {
    @Test
    void findPivots_readDataFromCsv_PivotHighAndLowsAreReturned() {
        try {

            PivotController controller = new PivotController();
            ResponseEntity<String> response = controller.getPivots("src/test/resources/sampleData", 2);
            String actual = response.getBody();
            System.out.println("============= :: "+actual);
            ObjectMapper objectMapper = new ObjectMapper();
            File f = new File("src/test/resources/PivotAPIOutput.json");
            //String data = objectMapper.readValue(f, String.class);
            //System.out.println(data);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}