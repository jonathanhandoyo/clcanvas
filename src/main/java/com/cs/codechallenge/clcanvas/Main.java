package com.cs.codechallenge.clcanvas;

public class Main {

    public static void main(String[] args) {
        Console console = new Console(new Canvas());

        while (true) {
            try {
                console.read();
                console.execute();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();

                System.exit(0);
            }
        }
    }
}