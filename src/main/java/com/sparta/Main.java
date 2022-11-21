package com.sparta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInputForInt = new Scanner(System.in);
        Scanner userInputForString = new Scanner(System.in);
        System.out.println("Do you want to recieve a greeting based on the time of day, or check to see what films you can see? Enter greeting or film");
        String greetingOrFilm = userInputForString.nextLine().toLowerCase();

        if (greetingOrFilm.equals("greeting")) {
            int timeOfDay = -1;
            while (!(timeOfDay >= 0 && timeOfDay <= 23)) {
                System.out.println("Please enter an int between 0 and 23 inclusive");
                timeOfDay = userInputForInt.nextInt();
            }

            System.out.println(greeting(timeOfDay));
        } else {
            FilmClassifications.enterAge();
        }
    }

    public static String greeting(int timeOfDay) {
        String greeting;
        if (timeOfDay >= 5 && timeOfDay < 12) {
            greeting = "Good morning!";
        } else if (timeOfDay >= 12 && timeOfDay <= 18) {
            greeting = "Good afternoon!";
        } else {
            greeting = "Good evening!";
        }
        return greeting;
    }
}