package com.example.lab7;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void nullName() {
        Espresso.onView(withId(R.id.fName)).perform(typeText(""));
        Espresso.onView(withId(R.id.lName)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.email)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.password)).perform(typeText("bob"));


        Espresso.onView(withId(R.id.submit)).perform(click());
        Espresso.onView(withId(R.id.isTextValid)).check(ViewAssertions.matches(withText("invalid first name")));
    }

    @Test
    public void nullSurname() {
        Espresso.onView(withId(R.id.fName)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.lName)).perform(typeText(""));
        Espresso.onView(withId(R.id.email)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.password)).perform(typeText("bob"));


        Espresso.onView(withId(R.id.submit)).perform(click());
        Espresso.onView(withId(R.id.isTextValid)).check(ViewAssertions.matches(withText("invalid last name")));
    }

    @Test
    public void nullEmail() {
        Espresso.onView(withId(R.id.fName)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.lName)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.email)).perform(typeText(""));
        Espresso.onView(withId(R.id.password)).perform(typeText("bob"));


        Espresso.onView(withId(R.id.submit)).perform(click());
        Espresso.onView(withId(R.id.isTextValid)).check(ViewAssertions.matches(withText("invalid email")));
    }

    @Test
    public void works() {
        Espresso.onView(withId(R.id.fName)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.lName)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.email)).perform(typeText("bob"));
        Espresso.onView(withId(R.id.password)).perform(typeText("bob"));


        Espresso.onView(withId(R.id.submit)).perform(click());
        Espresso.onView(withId(R.id.isTextValid)).check(ViewAssertions.matches(withText("valid")));
    }
}