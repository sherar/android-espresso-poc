package com.mytaxi.android_demo.PageObjectModel;

import android.support.test.espresso.ViewInteraction;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import com.mytaxi.android_demo.R;

public class DriverDetailsScreen {

    private static final ViewInteraction DRIVER_CALL_BUTTON = onView(withId(R.id.fab));
    private static final ViewInteraction DRIVER_CARD =  onView(withId(R.id.textViewDriverName));

    public static ViewInteraction getDriverCard() {
        return DRIVER_CARD;
    }

    public static void assertCallToDriverButtonPresent() {
        DRIVER_CALL_BUTTON.check(matches(isDisplayed()));
    }

    public static void callDriver() {
        DRIVER_CALL_BUTTON.perform(click());
    }

}