package com.example.javaHandsOn.treeMapCricket;

import java.util.*;

public class TreemapHandson {

    // return tree map for Query #1
    // key = position of player, value = name of player
    public TreeMap<Integer,String> createPlayerPositionMap(String cricketDataset)
    {
        TreeMap<Integer,String> map = new TreeMap<>();
        String[] temp;
        for(String s:cricketDataset.split("\\|")){
            temp = s.split(",");
            map.put(getInt(temp[0]),temp[1]);
        }
        return map;
    }

    // return TreeMap of query #2
    // key = player name, value = score
    public TreeMap<String,Integer> createPlayerScoreMap(String cricketDataset)
    {
        TreeMap<String,Integer> map = new TreeMap<>();
        String[] temp;
        for(String s:cricketDataset.split("\\|")){
            temp = s.split(",");
            map.put(temp[1],getInt(temp[2]));
        }
        return map;
    }

    // return tree map for Query #3
    // if player position = 1, then add to the map
    // key = score, value = name
    public TreeMap<?,?> createMatchesMap(String cricketDataset)
    {
        TreeMap<String,Integer> totalScoreMap = new TreeMap<>();
        TreeMap<String,Integer> totalNumMap = new TreeMap<>();
        TreeMap<Integer,String> finalMap = new TreeMap<>();
        String[] temp;
        String name="";
        int score;
        for(String s:cricketDataset.split("(\n)|(\\|)")){
            temp = s.split(",");
            name = temp[1];
            score = getInt(temp[2]);
            if(temp[0].equals("1")){
                if(totalScoreMap.containsKey(name)){
                    totalNumMap.put(name,totalNumMap.get(name)+1); // update number of matches played
                    totalScoreMap.put(name,totalScoreMap.get(name)+score); // updated total score
                }else{
                    totalNumMap.put(name,1);
                    totalScoreMap.put(name,score);
                }
            }
            totalScoreMap.forEach((key,value)->{
                int matchNum = totalNumMap.get(key);
                finalMap.put(value/matchNum,key);
            });
        }
        return finalMap;
    }


    public String getQuery(String cricketDataset,String query)
    {
        String[] qs = query.split(" ");
        String queryNum = qs[0];
        String output = "";
        switch (queryNum){
            case "1":{
                output = processQuery1(cricketDataset,getInt(qs[1]),getInt(qs[2]));
                break;
            }
            case "2":{
                output = processQuery2(cricketDataset,getInt(qs[1]));
                break;
            }
            case "3":{
                output = processQuery3(cricketDataset);
                break;
            }
        }
        return output;
    }

    String processQuery1(String cricketDataset,int start, int end){
        TreeMap<Integer,String> map = createPlayerPositionMap(cricketDataset);
        StringBuilder output = new StringBuilder();
        for(int i=start;i<=end;i++){
            output.append(i);
            output.append(" ");
            output.append(map.get(i));
            output.append("\n");
        }
        return output.toString();
    }

    String processQuery2(String cricketDataset,int score){
        TreeMap<String,Integer> map = createPlayerScoreMap(cricketDataset);
        TreeMap<Integer,String> outputMap = new TreeMap<>();
        StringBuilder output = new StringBuilder();

        map.forEach((key, value) -> { // key = name value = score
            if(value>score){
                outputMap.put(searchPositionGivenName(cricketDataset,key),key); // use a tree map to sort according to position
            }
        });

        outputMap.forEach((key,value)->{
            output.append(key);
            output.append(" ");
            output.append(value);
            output.append("\n");
        });
        return output.toString();
    }

    String processQuery3(String cricketDataset){
        String output = "The Efficient Opener is ";
        TreeMap<String,Integer> map = (TreeMap<String, Integer>) createMatchesMap(cricketDataset);
        int highestScore = 0;
        String name = "";
//        for(Map.Entry<String,Integer> entry: map.entrySet()){
//            if(entry.getValue()>highestScore){
//                highestScore = entry.getValue();
//                name = entry.getKey();
//            }
//        }
        return output+map.get(map.lastKey());
    }

    public int searchPositionGivenName(String cricketDataset,String name){
        TreeMap<Integer, String> positionMap = createPlayerPositionMap(cricketDataset);
        int output = 0;
        for(Map.Entry<Integer,String> entry:positionMap.entrySet()){
            if(entry.getValue().equals(name)){
                output = entry.getKey();
            }
        }
        return output;
    }

    int getInt(String s){
        return Integer.parseInt(s);
    }




}
