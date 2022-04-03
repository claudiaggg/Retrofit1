package com.vogella.java.retrofitgerrit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Main");
        Controller controller = new Controller();
        controller.start();
        System.in.read();




    }
}
