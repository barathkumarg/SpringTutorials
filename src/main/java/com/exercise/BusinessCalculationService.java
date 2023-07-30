package com.exercise;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    //Constructor based injection
    private DataService dataService;

    //constructor to get the data
    BusinessCalculationService(DataService dataService){
        this.dataService = dataService;
    }


    //Operation to find the max element
    public int findMax(){
        return Arrays.stream(dataService.retriveData())
                .max()
                .orElse(0);
    }
}
