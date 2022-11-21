package com.sparta;

import java.util.Locale;
import java.util.Scanner;

public class FilmClassifications {
    public static void enterAge() {
        System.out.println("Please enter your age");
        Scanner userInputForInt = new Scanner(System.in);
        Scanner userInputForString = new Scanner(System.in);
        int age = userInputForInt.nextInt();

        if (age < 12) {
            System.out.println("Will you be accompanied by an adult to view the film? Enter yes or no.");
            String accompaniedByAdult = userInputForString.nextLine().toLowerCase();
            System.out.println(availableClassifications(age, accompaniedByAdult));
        } else if (age < 18) {
            System.out.println(availableClassifications(age));
        } else {
            System.out.println("Do you intend to watch a R18 rated film? Enter yes or no.");
            String wantsR18Rated = userInputForString.nextLine().toLowerCase();
            if (wantsR18Rated.equals("no")) {
                System.out.println(availableClassifications(age, "no", "no"));
            } else if (wantsR18Rated.equals("yes")) {
                System.out.println("Will you be purchasing this R18 rated film from a sex shop?");
                String visitsSexShop = userInputForString.nextLine().toLowerCase();
                if (visitsSexShop.equals("yes")) {
                    System.out.println(availableClassifications(age, visitsSexShop, "no"));
                } else {
                    System.out.println("How about viewing a R18 film at a specially licensed cinema?");
                    String visitsSpeciallyLicensedCinema = userInputForString.nextLine().toLowerCase();
                    if (visitsSpeciallyLicensedCinema.equals("yes")) {
                        System.out.println(availableClassifications(age, "no", visitsSpeciallyLicensedCinema));
                    } else {
                        System.out.println("Sorry, you can only view a R18 film at a specially licensed cinema or purchase it from a sex shop.");
                    }
                }
            }
        }
    }

    public static String availableClassifications(int ageOfViewer, String accompaniedByAdult) {
        String result;

        if (ageOfViewer < 12 && accompaniedByAdult.equals("no")) {
            result = "U & PG films are available.";
        }  else {
            result = "U, PG & 12A films are available.";
        }

        return result;
    }

    public static String availableClassifications(int ageOfViewer) {
        String result;

        if (ageOfViewer < 15) {
            result = "U, PG, 12A & 12 films are available.";
        } else {
            result = "U, PG, 12A, 12 & 15 films are available.";
        }

        return result;
    }

    public static String availableClassifications(int ageOfViewer, String visitsSexShops, String visitsSpeciallyLicensedCinema) {
        String result;

        if (ageOfViewer >= 18 && (visitsSexShops.equals("no") && visitsSpeciallyLicensedCinema.equals("no"))) {
            result = "U, PG, 12A, 12, 15 & 18 films are available.";
        } else {
            result = "All films are available. Just make sure you keep to sex shops and specially licensed venues.";
        }

        return result;
    }
}
