package com.example.javaHandsOn.generics;

import java.util.ArrayList;

public class StudentClass {

    public String getQuery(String studentData,String query){

        String[] querySplit = query.split(",");
        String queryNum = querySplit[0], input = "",output = "";

        switch (queryNum){
            case "1":{
                input = querySplit[1];
                output = query1(studentData,input);
                break;
            }
            case "2":{
                input = querySplit[1];
                String search = querySplit[2];
                output = query2(studentData,input,search);
                break;
            }
            case "3":{
                input = querySplit[1];
                output = query3(studentData,input);
                break;
            }
            case "4":
            case "5": {
                output = query4(studentData);
                break;
            }
        }

        return output;
    }


    String query1(String studentData, String input){
        StringBuilder output = new StringBuilder();
        for(String s:studentData.split(" ")){
            if(s.toLowerCase().startsWith(input.toLowerCase())){
                output.append(s).append("\n");
            }
        }
        return output.toString();
    }

    String query2(String studentData, String input, String search){
        StringBuilder output = new StringBuilder();
        String[] studentDataSplit = studentData.split(" ");
        int index = 0;
        for(String s:input.split(" ")){
            if(s.equalsIgnoreCase(search)){
                output.append(studentDataSplit[index]).append("\n");
            }
            index++;
        }
        return output.toString();
    }

    String query3(String studentData, String input){
        String output = "";
        int num = 0;
        for(String s:studentData.split(" ")){
            if(Integer.parseInt(s)>=Integer.parseInt(input)){
                num++;
            }
        }
        output = num + " students scored "+ input + " above";
        return output;
    }

    String query4(String studentData){
        double sum = 0;
        int count = 0;
        for(String s:studentData.split(" ")){
            sum += Double.parseDouble(s);
            count++;
        }
        return String.format("%.02f",sum/count);
    }

}
