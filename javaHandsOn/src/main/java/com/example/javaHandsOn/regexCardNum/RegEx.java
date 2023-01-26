package com.example.javaHandsOn.regexCardNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegEx
{
    public String findCardTypeNumbers(String conversation, String cardType)
    {
        //Write your code here
        StringBuilder output = new StringBuilder();
        List<String> cardList = Arrays.asList("Visa","American Express","Discover","JCB");
        if(!cardList.contains(cardType)){
            return "Not a valid card type";
        }

        List<Pattern> rxs = createCheckList(cardType);

        List<String> collect = Arrays.stream(conversation
                        .replaceAll("\\p{IsPunctuation}", "")
                        .split(" "))
                .filter(s->checkMatch(s,rxs))
                .collect(Collectors.toList());

        collect.forEach(s -> output.append(s).append(" "));

        return output.toString().trim();
    }

    List<Pattern> createCheckList(String cardType){
        List<Pattern> rxs = new ArrayList<>();
        Pattern visa1 = Pattern.compile("4[0-9]{12}"); // first num 4, 12 more
        Pattern visa2 = Pattern.compile("4[0-9]{15}"); // first num 4, 15 more digits
        Pattern americanExpress = Pattern.compile("3[4|7][0-9]{13}"); // start with 34 or 37
        Pattern discover1 = Pattern.compile("6011[0-9]{12}");
        Pattern discover2 = Pattern.compile("65[0-9]{14}");
        Pattern jcb1 = Pattern.compile("2131[0-9]{11}");
        Pattern jcb2 = Pattern.compile("1800[0-9]{11}");
        Pattern jcb3 = Pattern.compile("35[0-9]{14}");

        switch (cardType){
            case "Visa":{
                Collections.addAll(rxs,visa1,visa2);
                break;
            }
            case "American Express":{
                rxs.add(americanExpress);
                break;
            }
            case "Discover":{
                Collections.addAll(rxs,discover1,discover2);
                break;
            }
            case "JCB":{
                Collections.addAll(rxs,jcb1,jcb2,jcb3);
                break;
            }
        }

        return rxs;
    }

    boolean checkMatch(String input,List<Pattern> rxs){

        boolean match = false;

        for(Pattern p:rxs){
            if(p.matcher(input).matches()){
                match = true;
                break;
            }
        }

        return match;

    }


}
