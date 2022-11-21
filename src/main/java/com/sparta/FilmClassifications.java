package com.sparta;

import java.util.Scanner;

public class FilmClassifications {
    public static void enterAge() {
        System.out.println("Please enter your age");
        Scanner userInput = new Scanner(System.in);
        int age = userInput.nextInt();

//        String accompaniedByAdult = userInput.nextLine();
        System.out.println(availableClassifications(age));
    }

    public static String availableClassifications(int ageOfViewer, String accompaniedByAdult) {
        String result;

        if (ageOfViewer < 12 && accompaniedByAdult.equals("no")) {
            result = "U & PG films are available.";
        }
        else {
            result = "U, PG & 12A films are available.";
        }

        return result;
    }

    public static String availableClassifications(int ageOfViewer) {
        String result;

        if (ageOfViewer < 15) {
            result = "U, PG, 12A & 12 films are available.";
        }
        else {
            result = "U, PG, 12A, 12 & 15 films are available.";
        }

        return result;
    }

    public static String availableClassifications(int ageOfViewer, String visitsSexShops, String visitsSpeciallyLicensedCinema) {
        String result;

        if (ageOfViewer >= 18 && (visitsSexShops.equals("no") && visitsSpeciallyLicensedCinema.equals("no"))) {
            result = "U, PG, 12A, 12, 15 & 18 films are available.";
        }

        else {
            result = "All films are available. Just make sure you keep to sex shops and specially licensed venues.";
        }

        return result;
    }
}
