package com.company.jdbc;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Agus1");
        list.add("Agus2");
        list.add("Agus3");
        list.add("Agus4");
        list.add("Agus5");
        list.add("Agus6");
        list.add("Agus7");
        list.add("Agus8");
        list.add("Agus9");
        list.add("Agus10");

        Set<Integer> set = new LinkedHashSet<>();

      //  SortedSet<Integer> set = new TreeSet<>();

      //  LinkedHashSet<Integer> set = new TreeSet<>();
     //   Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(10);
        set.add(7);
        set.add(8);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(9);
        set.add(3);
        set.add(2);

        System.out.println(list.size());
        System.out.println(set.size());

        for (String s: list ) {
            System.out.println(s);

        }
        System.out.println("\n\n\n\n");
        for (Integer s: set) {
            System.out.println(s);
        }

        System.out.println(printCollection());

    }

    public static Collection printCollection(Collection nama){

        for (Object cltn : nbama) {
            return (Collection) cltn;
        }
    }
}
