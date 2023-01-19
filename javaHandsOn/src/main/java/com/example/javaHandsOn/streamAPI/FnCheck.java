package com.example.javaHandsOn.streamAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FnCheck {
    public boolean isFnProgrammingPresent() throws FileNotFoundException, IOException
    {
        File file = new File("src/main/java/com/example/javaHandsOn/streamAPI/LambdaFn.java");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line, string="";
        while((line=br.readLine())!=null)
        {
            string+=line;
        }
        String fn=string.substring(string.indexOf("functionalProgramming(List<String> listOfIntegers)"),string.indexOf("return outputList;"));
        br.close();
        if(fn.contains("stream()")&&fn.contains("map(")&&fn.contains("filter("))
        {
            return true;
        }
        return false;
    }
}
