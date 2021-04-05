package com.company;

public class Main {

    public static void main(String[] args) {
        splitQuery(2345);
        System.out.println();
        System.out.println();
        System.out.println();
        splitQuery(999);
        System.out.println();
        System.out.println();
        System.out.println();
        splitQuery(1001);
        System.out.println();
        System.out.println();
        System.out.println();
        splitQuery(4999);
    }

    private static void splitQuery(int endIndex) {
        int fromIndex = 0;
        for (; fromIndex < endIndex; fromIndex = fromIndex + 1000) {
            int toIndex = fromIndex + 1000;
            if (toIndex > endIndex) {
                toIndex = endIndex;
            }
            System.out.println(
                    "sdelal zapros from " + fromIndex + " to " + toIndex
            );
        }
    }
}
