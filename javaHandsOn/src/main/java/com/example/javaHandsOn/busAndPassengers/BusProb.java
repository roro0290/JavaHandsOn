package com.example.javaHandsOn.busAndPassengers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

class Passanger
{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
    float fare;
    public Passanger(int id, float fare)
    {
        this.id=id;
        this.fare=fare;
    }
}

public class BusProb {
    public String output(int capacity, int stops, List<String> listOfInputStrings, String query)
    {
        String outstring="";
        String[] querySplit = query.split(", ");
        int id = 0;
        if(querySplit.length>1){
            id = Integer.parseInt(querySplit[1]);
        }
        List<Passanger> passangerList = getPassengerList(capacity,listOfInputStrings);
        switch (querySplit[0]) {
            case "1" : {
                outstring = query1(listOfInputStrings);
                break;
            }
            case "2" : {
                outstring = query2(capacity, passangerList);
                break;
            }
            case "3" : {
                outstring = query3(passangerList,id);
                break;
            }
            case "4" : {
                outstring = query4(passangerList,id);
                break;
            }
            case "5" : {
                outstring = query5(passangerList,listOfInputStrings,id);
                break;
            }
        }
        return outstring;
    }

    String query1(List<String> listOfInputStrings){
        int getOn = 0, getOff = 0;
        for(String s:listOfInputStrings){
            for(String split:s.split(" ")){
                if(split.startsWith("+")){
                    getOn += 1;
                }else{
                    getOff += 1;
                }
            }
        }
        return String.format("%d passengers got on the bus and %d passengers got out of the bus",getOn,getOff);
    }

    String query2(int capacity, List<Passanger> passangerList){
        long count1 = passangerList.stream().filter(p -> p.fare == lessThan25Cost(capacity)).count();
        long count2 = passangerList.stream().filter(p -> p.fare == lessThan50Cost(capacity)).count();
        long count3 = passangerList.stream().filter(p -> p.fare == moreThan50Cost(capacity)).count();
        return String.format("%d passengers traveled with a fare of %.1f, %d passengers traveled with a fare of %.1f and %d passengers traveled with a fare of %.1f",
                count1,lessThan25Cost(capacity),
                count2,lessThan50Cost(capacity),
                count3,moreThan50Cost(capacity));
    }

    String query3(List<Passanger> passangerList, int id){
        float cost = 0;
        List<Passanger> collect = passangerList.stream()
                .filter(p -> p.id == id).toList(); // FIGURE HOW TO USE REDUCE INSTEAD
        for(Passanger c:collect){
            cost += c.getFare();
        }
        return String.format("Passenger %d spent a total fare of %.1f",id,cost);
    }

    String query4(List<Passanger> passangerList, int id){
        int count = (int) passangerList.stream()
                .filter(p -> p.id == id).count();
        return String.format("Passenger %d has got on the bus for %d times",id,count);
    }

    String query5(List<Passanger> passangerList,List<String> inputStrings, int id){
        Passanger p;
        for(String s:inputStrings){
            for(String split:s.split(" ")){
                // remove everyone who has got off the bus from the full list
                if(split.startsWith("-")){
                    p = passangerList
                            .stream()
                            .filter(i -> i.id==getId(split))
                            .findAny()
                            .get();
                    passangerList.remove(p);
                }
            }
        }
        boolean check = passangerList
                .stream()
                .anyMatch(i -> i.id==id);
        return check ?
                String.format("Passenger %d was inside the bus at the end of the trip",id) :
                String.format("Passenger %d was not inside the bus at the end of the trip",id);
    }

    List<Passanger> getPassengerList(int capacity, List<String> listOfInputStrings){
        int count = 0, id;
        float cost;
        List<Passanger> passengerList = new ArrayList<>();
        for(String s:listOfInputStrings){

            // GET COUNT OF PASSENGERS ON THE BUS
            for(String split:s.split(" ")){
                if(split.startsWith("+")){
                    count += 1;
                }else{
                    count -= 1;
                }
            }

            // ADD COST
            cost = getCost(capacity,count);
            for(String split:s.split(" ")){
                if(split.startsWith("+")){
                    id = getId(split);
                    passengerList.add(new Passanger(id,cost));
                }
            }
        }
        return passengerList;
    }

    int getId(String s){
        return Integer.parseInt(s.substring(1));
    }

    float getCost(int capacity,int currentCount){
        float fare = 0;
        if(currentCount<=Math.ceil(0.25*capacity)){
            fare = lessThan25Cost(capacity);
        }else if(currentCount<=Math.ceil(0.5*capacity)){
            fare = lessThan50Cost(capacity);
        }else{
            fare = moreThan50Cost(capacity);
        }
        return fare;
    }

    float lessThan25Cost(int capacity){
        return getBigDecimal(1.6 * capacity);
    }

    float lessThan50Cost(int capacity){
        return getBigDecimal(1.3 * capacity);
    }

    float moreThan50Cost(int capacity){
        return getBigDecimal(capacity);
    }

    float getBigDecimal(double value){
        return BigDecimal
                .valueOf(value)
                .setScale(1,RoundingMode.HALF_UP)
                .floatValue();
    }

}
