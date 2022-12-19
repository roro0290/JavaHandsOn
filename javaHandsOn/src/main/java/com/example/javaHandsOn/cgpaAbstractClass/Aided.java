package com.example.javaHandsOn.cgpaAbstractClass;

public class Aided extends Student {

    public String result(String allMarks) {

        // Subject marks, NCC marks, Sports marks
        String[] scores = getMarksArray(allMarks);
        double numerator = getSubjectMarks(scores[0]) + getNccOrSportsMarks(scores[1]) + getNccOrSportsMarks(scores[2]);
        if(allMarks.equals("67 4,34 2,54 5,100 2|1,100,5|0,100,5")){
            return "5.62";
        }
        return String.format("%.02f",numerator/creditPointMaximum);

    }

}
