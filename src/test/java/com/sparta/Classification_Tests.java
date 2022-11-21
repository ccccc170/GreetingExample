package com.sparta;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Classification_Tests {
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 11})
    @DisplayName("Given an age between 0 and 11 inclusive and not accompanied by adult, availableClassifications returns U & PG films are available.")
    public void GivenAnAgeBetween0And11AndNotAccompaniedByAdult_availableClassifications_ReturnsUAndPgAvailable(int age) {
        String accompaniedByAdult = "no";
        String expectedGreeting = "U & PG films are available.";
        String result = FilmClassifications.availableClassifications(age, accompaniedByAdult);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 11})
    @DisplayName("Given an age between 0 and 11 inclusive and accompanied by adult, availableClassifications returns U & PG films are available.")
    public void GivenAnAgeBetween0And11AndAccompaniedByAdult_availableClassifications_ReturnsU_PgAnd12aAvailable(int age) {
        String accompaniedByAdult = "yes";
        String expectedGreeting = "U, PG & 12A films are available.";
        String result = FilmClassifications.availableClassifications(age, accompaniedByAdult);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 13, 14})
    @DisplayName("Given an age between 12 and 14 inclusive, availableClassifications returns U, PG, 12A & 12 films are available.")
    public void GivenAnAgeBetween12And14_availableClassifications_ReturnsU_Pg_12aAnd12Available(int age) {
        String expectedGreeting = "U, PG, 12A & 12 films are available.";
        String result = FilmClassifications.availableClassifications(age);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 16, 17})
    @DisplayName("Given an age between 15 and 17 inclusive, availableClassifications returns U, PG, 12A, 12 & 15 films are available.")
    public void GivenAnAgeBetween15And17_availableClassifications_ReturnsU_Pg_12a_12And15Available(int age) {
        String expectedGreeting = "U, PG, 12A, 12 & 15 films are available.";
        String result = FilmClassifications.availableClassifications(age);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 35, 58, 82, 123})
    @DisplayName("Given an age 18 or over and not attending a sex shop or specially licensed cinema, availableClassifications returns all films are available.")
    public void GivenAnAge18OrOverAndNotAttendingSexShopOrLicensedVenue_availableClassifications_ReturnsU_Pg_12a_12_15And18(int age) {
        String visitsSexShop = "no";
        String visitsSpeciallyLicensedCinema = "no";
        String expectedGreeting = "U, PG, 12A, 12, 15 & 18 films are available.";
        String result = FilmClassifications.availableClassifications(age, visitsSexShop, visitsSpeciallyLicensedCinema);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 35, 58, 82, 123})
    @DisplayName("Given an age 18 or over and attending a sex shop, availableClassifications returns all films are available.")
    public void GivenAnAge18OrOverAndAttendingSexShop_availableClassifications_ReturnsAllFilmsAreAvailable(int age) {
        String visitsSexShop = "yes";
        String visitsSpeciallyLicensedCinema = "no";
        String expectedGreeting = "All films are available. Just make sure you keep to sex shops and specially licensed venues.";
        String result = FilmClassifications.availableClassifications(age, visitsSexShop, visitsSpeciallyLicensedCinema);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 35, 58, 82, 123})
    @DisplayName("Given an age 18 or over and attending a specially licensed venue, availableClassifications returns all films are available.")
    public void GivenAnAge18OrOverAndAttendingSpeciallyLicensedVenue_availableClassifications_ReturnsAllFilmsAreAvailable(int age) {
        String visitsSexShop = "no";
        String visitsSpeciallyLicensedCinema = "yes";
        String expectedGreeting = "All films are available. Just make sure you keep to sex shops and specially licensed venues.";
        String result = FilmClassifications.availableClassifications(age, visitsSexShop, visitsSpeciallyLicensedCinema);
        assertEquals(expectedGreeting, result);
    }
}
