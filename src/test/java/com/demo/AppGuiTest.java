package com.demo;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

class AppGuiTest {

    private FrameFixture window;

    @BeforeEach
    void setUp() {
        JFrame frame = GuiActionRunner.execute(App::createGui);
        window = new FrameFixture(frame);
        window.show();
    }

    @AfterEach
    void tearDown() {
        if (window != null) {
            window.cleanUp();
        }
    }

    @Test
    void shouldShowGreetingWhenUserClicksButton() {
        window.textBox("nameField").setText("Michele");
        window.button("salutaButton").requireEnabled().click();
        window.robot().waitForIdle();
        window.label("resultLabel").requireText("Ciao Michele");
    }

    @Test
    void shouldShowGuestGreetingWhenInputIsEmpty() {
        window.textBox("nameField").setText("");
        window.button("salutaButton").requireEnabled().click();
        window.robot().waitForIdle();
        window.label("resultLabel").requireText("Ciao ospite");
    }
}