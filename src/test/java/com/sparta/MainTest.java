package com.sparta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MainTest {
    @Test
    @DisplayName("My first test")
    public void firstTest() {
        Assertions.assertTrue(5 == 5);
    }

    @Test
    @DisplayName("Given a time of 21, greeting returns Good Evening!")
    public void givenATime21_Greeting_ReturnsGoodEvening() {
        int time = 21;
        String expectedGreeting = "Good evening!";
        String result = Main.greeting(time);
        assertEquals(expectedGreeting, result);
    }

    @Test
    @DisplayName("Given a time of 13, greeting returns Good afternoon!")
    public void givenATime13_Greeting_ReturnsGoodAfternoon() {
        int time = 13;
        String expectedGreeting = "Good afternoon!";
        String result = Main.greeting(time);
        assertEquals(expectedGreeting, result);
    }

    @Test
    @DisplayName("Given a time of 6, greeting returns Good morning!")
    public void givenATime6_Greeting_ReturnsGoodMorning() {
        int time = 6;
        String expectedGreeting = "Good morning!";
        String result = Main.greeting(time);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 8, 11})
    @DisplayName("Given a time between 5 and 11, greeting returns Good morning!")
    public void GivenATimeBetween5and11_Greeting_ReturnsGoodMorning(int time){
        String expectedGreeting = "Good morning!";
        String result = Main.greeting(time);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 15, 18})
    @DisplayName("Given a time between 12 and 18, greeting returns Good afternoon!")
    public void GivenATimeBetween12and18_Greeting_ReturnsGoodAfternoon(int time){
        String expectedGreeting = "Good afternoon!";
        String result = Main.greeting(time);
        assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {19, 23, 1, 4})
    @DisplayName("Given a time between 19 and 4, greeting returns Good evening!")
    public void GivenATimeBetween19and4_Greeting_ReturnsGoodEvening(int time){
        String expectedGreeting = "Good evening!";
        String result = Main.greeting(time);
        assertEquals(expectedGreeting, result);
    }
}