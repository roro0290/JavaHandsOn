package com.example.javaHandsOn.studentArrayList;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//the function accepts five Integer arrays and return Integer ArrayList
import java.util.List;
import java.util.stream.Stream;

class ExamResult{
    public static ArrayList<Integer[]> getMethodParameter() throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("ExamPerformanceResult");
        Method m = c.getMethod("performance",Integer[].class);
        Parameter[] parameters = m.getParameters();
        //return Arrays.asList(parameters);
        return null;
    }
}

class ExamPerformanceResult {

    public static ArrayList<Integer> performance(Integer[]... args) {
        ArrayList<Integer> output = new ArrayList<>();

        // IS THERE A DIFFERENT WAY TO ACCESS ELEMENTS IN METHOD PARAMETERS?
        /*ArrayList<Integer[]> scoreList = new ArrayList<>();
        scoreList.add(tamil);
        scoreList.add(english);
        scoreList.add(maths);
        scoreList.add(science);
        scoreList.add(social);
         */
        List<Integer[]> scoreList = Arrays.asList(args);

        for(Integer[] i:scoreList){
            output.add(calculateAverage(i));
        }

        for(Integer[] i:scoreList){
            output.add(findMax(i));
        }

        for(Integer[] i:scoreList){
            output.add(findMin(i));
        }

        for(Integer[] i:scoreList){
            output.add(countNumFailures(i));
        }

        return output;
    }


    public static Stream<Integer> giveIntegerStream(Integer[] scores){
        return Arrays.stream(scores);
    }

    public static Integer calculateAverage(Integer[] scores){
        Stream<Integer> scoresStream = giveIntegerStream(scores);
        //scoresStream.reduce(Integer::sum);
        Integer sum = scoresStream.reduce(0,(a,b) -> a+b);
        return sum/scores.length;
    }

    public static Integer findMax(Integer[] scores){
        return giveIntegerStream(scores).max(Integer::compare).get();
    }

    public static Integer findMin(Integer[] scores){
        return giveIntegerStream(scores).min(Integer::compare).get();
    }

    public static int countNumFailures(Integer[] scores){
        Stream<Integer> scoreStream = giveIntegerStream(scores);
        return (int) scoreStream.filter(i -> i< 35).count();
    }

}

public class ExamPerformance {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(b.readLine().trim());
        Integer[] tamil = new Integer[n];
        for (int i = 0; i < n; i++) {
            tamil[i] = Integer.parseInt(b.readLine().trim());
        }
        Integer[] english = new Integer[n];
        for (int i = 0; i < n; i++) {
            english[i] = Integer.parseInt(b.readLine().trim());
        }
        Integer[] maths = new Integer[n];
        for (int i = 0; i < n; i++) {
            maths[i] = Integer.parseInt(b.readLine().trim());
        }
        Integer[] science = new Integer[n];
        for (int i = 0; i < n; i++) {
            science[i] = Integer.parseInt(b.readLine().trim());
        }
        Integer[] social = new Integer[n];
        for (int i = 0; i < n; i++) {
            social[i] = Integer.parseInt(b.readLine().trim());
        }
        b.close();

        ArrayList<Integer> solution = ExamPerformanceResult.performance(tamil, english, maths, science, social);
        for (int i = 0; i < solution.size(); i++) {
            System.out.println(solution.get(i));
        }

    }

}

