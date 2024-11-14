package com.example.lab7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.EditText;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private ValidateDetails vlad;

    @Before
    public void setUp() {
        vlad = new ValidateDetails();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testNullName() {
        assertFalse(vlad.validate(""));
    }

    @Test
    public void testValidName() {
        assertTrue(vlad.validate("joejoejoe"));
    }

}