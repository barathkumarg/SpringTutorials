package com.exercise;


import org.springframework.stereotype.Component;

@Component
public class MySqlDataService implements DataService{
    @Override
    public int[] retriveData() {
        return new int[] {10,11,12,13};
    }
}
