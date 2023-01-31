package com.example.javaHandsOn.springBoot;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData(){
        int[] allData = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;
        for(int i:allData){
            if(i>greatest){
                greatest = i;
            }
        }
        return  greatest;
    }
}

interface DataService{
    int[] retrieveAllData();
}
