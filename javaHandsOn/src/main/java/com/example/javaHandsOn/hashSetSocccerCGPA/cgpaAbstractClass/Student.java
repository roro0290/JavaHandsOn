package com.example.javaHandsOn.hashSetSocccerCGPA.cgpaAbstractClass;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public abstract class Student {

    double creditPointMaximum = 0;

    public abstract String result(String MarksOfStudent);

    public String[] getMarksArray(String allMarks){
        return allMarks.split("\\|");
    }

    public double getSubjectMarks(String subjectMarks){
        String[] subjectMarksSplit = subjectMarks.split(",");
        ArrayList<Double> doubleList = new ArrayList<>();
        String[] temp ;
        for(String i: subjectMarksSplit){
            temp = i.split(" "); // 1st value = grade point, 2nd value = credit point
            doubleList.add(gradePointMultiplyWithCreditPoint(temp[0],temp[1]));
        }
        return doubleList.stream().reduce(Double::sum).get();
        // get the total of the multiplied values
    }

    public double getNccOrSportsMarks(String marks){
        double score = 0;
        String[] marksSplit = marks.split(","); // get array with 3 values
        if(!marksSplit[0].equals("0")){
            score = gradePointMultiplyWithCreditPoint(marksSplit[1],marksSplit[2]);
        }
        return score;
    }

    double gradePointMultiplyWithCreditPoint(String a, String b){
        double gradePoint = getGradePoint(Double.parseDouble(a));
        double creditPoint = Double.parseDouble(b);
        this.creditPointMaximum += 5;
        return creditPoint * gradePoint ;
    }

    double getGradePoint(double score){
        double gradePoint = 0;
        if(score>=75){
            gradePoint = (10.0-9.0)/(100-75)*(score-75)+9.0;
        }else if(score>=60){
            gradePoint = (8.9-8.0)/(74-60)*(score-60)+8.0;
        }else if(score>=50){
            gradePoint = (7.9-7.0)/(59-50)*(score-50)+7.0;
        }else if(score>=40){
            gradePoint = (6.9-6.0)/(49-40)*(score-40)+6.0;
        }
        return round(gradePoint,1);
    }

    static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}

