package com.example.javaHandsOn.libraryHashMap;

import java.util.*;
import java.util.stream.Collectors;

public class Library
{

    String bookName;
    String author;
    Library()
    {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.bookName);
        hash = 83 * hash + Objects.hashCode(this.author);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Library other = (Library) obj;
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }


    Library(String bookName,String author)
    {
        this.bookName=bookName;
        this.author=author;
    }

    public HashMap<Integer,Library> createLibraryMap(String booksInLibrary)
    {
        HashMap<Integer,Library> map = new HashMap<>();
        for (String i : booksInLibrary.split("\\|")) {
            String[] split = i.split(",");
            Library lib = new Library(split[1], split[2]);
            map.put(Integer.parseInt(split[0]),lib);
        }
        return map;
    }

    public HashMap<Integer,Integer> createUserMap(String borrowedUsers)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(String s:borrowedUsers.split("\\|")){
            String[] split = s.split(",");
            map.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        return map;
    }


    public String getQuery(String booksInLibrary,String borrowedUsers,String query)
    {
        HashMap<Integer,Library> libraryMap = createLibraryMap(booksInLibrary);
        HashMap<Integer,Integer> userMap = createUserMap(borrowedUsers);
        String[] querySplit = query.split(",");
        String queryNum = querySplit[0], input = querySplit[1];
        String output = "";
        switch(queryNum){
            case "1":
                output = executeQuery1(input,userMap,libraryMap);
                break;
            case "2":
                output = executeQuery2(input,userMap,libraryMap);
                break;
            case "3":
                output = executeQuery3(input,userMap,libraryMap);
                break;
            case "4":
                output = executeQuery4(input,libraryMap);
                break;
            case "5":
                output = executeQuery5(input,userMap,libraryMap);
                break;
        }
        return output;
    }

    int getId(String str){
        return Integer.parseInt(str);
    }

    boolean checkBookId(int bookId, HashMap<Integer,Integer> userMap){
        return userMap.containsKey(bookId);
    }

    String getUser(int bookId, HashMap<Integer,Integer> userMap){
        return String.valueOf(userMap.get(bookId));
    }

    String getAuthor(int bookId, HashMap<Integer,Library> libraryMap){
        return libraryMap.get(bookId).author;
    }

    String executeQuery1(String input,HashMap<Integer,Integer> userMap,HashMap<Integer,Library> libraryMap){
        int bookId = getId(input);
        return checkBookId(bookId,userMap) ?
                String.format("No Stock\nIt is owned by %s\n",getUser(bookId,userMap)) :
                String.format("It is available\nAuthor is %s\n",getAuthor(bookId,libraryMap));
    }

    String executeQuery2(String input,HashMap<Integer,Integer> userMap,HashMap<Integer,Library> libraryMap){
        int userId = getId(input);
        return userMap.entrySet()
                .stream()
                .filter(v -> v.getValue().equals(userId)) // get a set of k,v
                .map(Map.Entry::getKey)// get a stream of integers
                .map(i -> i + " "+libraryMap.get(i).bookName)
                .collect(Collectors.joining("\n"))+"\n";
    }

    String executeQuery3(String bookName,HashMap<Integer,Integer> userMap,HashMap<Integer,Library> libraryMap){
        Integer[] bookIdList = (Integer[]) libraryMap.entrySet()
                .stream()
                .filter(i -> i.getValue().bookName.equals(bookName))
                .map(Map.Entry::getKey) //only need the book key
                .toArray();
        int borrowed=0,present=0;
        for(Integer i:bookIdList){
            if(userMap.containsKey(i)){
                borrowed+=1;
            }else{
                present+=1;
            }
        }
        return String.format("%s out\n%s in\n",borrowed,present);
    }

    String executeQuery4(String authorName,HashMap<Integer,Library> libraryMap){
        return libraryMap.values()
                .stream()
                .filter(library -> library.author.equals(authorName))
                .map(library -> library.bookName)
                .collect(Collectors.joining("\n"))+"\n";
    }

    String executeQuery5(String keyword,HashMap<Integer,Integer> userMap,HashMap<Integer,Library> libraryMap){
        return libraryMap.entrySet()
                .stream()
                .filter(e -> e.getValue().bookName.toLowerCase().contains(keyword.toLowerCase()))
                .map(e -> e.getKey()+" "+e.getValue().bookName)
                .collect(Collectors.joining("\n"))+"\n";
    }


}
