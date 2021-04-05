package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int offset = 0;
        int limit = 1000;
        while (true) {
            System.out.println("sdelal zapros s offset, limit" + offset + " " + limit);
            if (offset > 10000) {
                break;
            }
            offset = offset + limit;
        }
    }
}
