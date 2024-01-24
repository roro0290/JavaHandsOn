package com.example.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    // stacks go one at a time from the time
    // first in last out
    // use pop to get the very top element
    // peek allows you to see the top element without removing
    public static void main(String[] args) {
        stacks();
    }

    public static void stacks() {
        Stack<String> games = new Stack();
        games.push("game 1");
        games.push("game 2");
        games.push("game 3");

        System.out.println(games.peek());
        System.out.println("games stack: " + games);
        System.out.println("removed from stack: " + games.pop());
        System.out.println("games stack: " + games);

    }

    public boolean isValid(String s) {

        if (s.length() % 2 != 0)
            return false;

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Character check;

        Map<Character, Character> map = new HashMap<>();
        map.put(')','(' );
        map.put('}','{');
        map.put(']','[');

        for(char c:chars){
            check = c;
            if(check.equals('(') || check.equals('[') || check.equals('{')){
                stack.push(check);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(!map.get(check).equals(pop)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValidTry1(String s) {

        if (s.length() % 2 != 0)
            return false;

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);

        // remove the valid parentheses from the string?

        int start = 0, match = 1;

        while (!sb.isEmpty()) {
            if (!map.containsKey(chars[start]))
                return false;
            if (map.get(chars[start]).equals(chars[match])) {
                sb.deleteCharAt(match);
                sb.deleteCharAt(start);
                chars = sb.toString().toCharArray();
                match = 1;
            } else {
                if (match == sb.length() - 1) {
                    return false;
                }
                match += 2;
            }
        }

        return true;
    }

}
