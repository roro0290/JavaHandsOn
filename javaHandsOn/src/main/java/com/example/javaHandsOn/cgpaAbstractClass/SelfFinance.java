package com.example.javaHandsOn.cgpaAbstractClass;

public class SelfFinance extends Student{

    public String result(String allMarks) {

        // Subject marks, NCC marks, Sports marks
        String[] scores = getMarksArray(allMarks);
        Double numerator = getSubjectMarks(scores[0]) + getNccOrSportsMarks(scores[1]);
        return String.format("%.2f",numerator/creditPointMaximum);

    }

}
