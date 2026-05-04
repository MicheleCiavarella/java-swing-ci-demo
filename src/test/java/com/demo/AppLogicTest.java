package com.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppLogicTest {

    @Test
    void shouldReturnGreetingWithName() {
        assertEquals("Ciao Michele", App.buildGreeting("Michele"));
    }

    @Test
    void shouldReturnGuestGreetingWhenNameIsEmpty() {
        assertEquals("Ciao ospite", App.buildGreeting(""));
    }
}