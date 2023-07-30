package com.learn;

import java.util.List;

public class FunctionProgramming {

    public static void main(String[] args) {
        ListStream(List.of(1,2,3,4,5,6),List.of("Spring","Java","Ecllipse","SpringBoot","Python","Scala"));
    }


    //chain the functions in a stream
    public static void ListStream(List<Integer> mylist,List<String> mystringlist){

        //Seperate only the odd numbers
        mylist.stream()
                .filter((n) -> n%2 != 0)
                .forEach(System.out::println);
        System.out.println();

        //create the stream array list of strings
        mystringlist.stream()
                .forEach(System.out::println);
        System.out.println();

        //Filter out the words contain spring
        mystringlist.stream()
                .filter((n) -> n.contains("Spring"))
                .forEach(System.out::println);
        System.out.println();

        //Names atleast with 5 letters
        mystringlist.stream()
                .filter((n) -> n.length() >=6)
                .forEach(System.out::println);
        System.out.println();

        //Map function to manuplate the existing data
        mylist.stream()
                .filter((n) -> n%2!=0)
                .map((n)->n*n*n)
                .forEach(System.out::println);
        System.out.println();

        //Map function on the string list to get the no of characters
        mystringlist.stream()
                .map((n)->n.length())
                .forEach(System.out::println);
    }
}
