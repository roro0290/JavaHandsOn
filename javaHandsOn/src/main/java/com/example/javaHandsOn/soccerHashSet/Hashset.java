package com.example.javaHandsOn.soccerHashSet;

import java.util.*;
import java.util.Map.Entry;

public class Hashset
{
    public static String getOut(int numberOfMatches, String squads, int squad1, int squad2)
    {
        Hashtable<String,Integer> matchRecord = new Hashtable<>();

        int game=1;
        HashSet<String> squad1Set = new HashSet<>();
        HashSet<String> squad2Set = new HashSet<>();

        for(String s:squads.split("#")){
            HashSet<String> set = new HashSet<>(Arrays.asList(s.split(" ")));

            if(game==squad1){
                squad1Set = set;
            } else if (game == squad2) {
                squad2Set = set;
            }

            for(String s2:set){
                Integer count = matchRecord.get(s2);
                if(count==null){
                    matchRecord.put(s2,1);
                }else{
                    matchRecord.put(s2,++count);
                }
            }

            game++;
        }

        Set<Entry<String, Integer>> entrySet = matchRecord.entrySet();
        StringBuilder playersAllMatches = new StringBuilder();
        for (Entry<String, Integer> entry : entrySet){
            if(entry.getValue()==numberOfMatches){
                playersAllMatches.append(entry.getKey());
                playersAllMatches.append(" ");
            }
        }

        StringBuilder playerCheck = new StringBuilder();
        for(String s:squad2Set){
            if(!squad1Set.contains(s)){
                playerCheck.append(s);
                playerCheck.append(" ");
            }
        }

        return playersAllMatches.toString().trim()+", "+playerCheck.toString().trim();
    }

}
