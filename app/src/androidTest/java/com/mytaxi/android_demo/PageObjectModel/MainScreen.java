package com.mytaxi.android_demo.PageObjectModel;
import android.support.test.espresso.ViewInteraction;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainScreen {

    private static final ViewInteraction DRIVER_SEARCH_FIELD = onView(withId(R.id.textSearch));
    private static final ViewInteraction DRIVER_NAME = onView(withText("Sarah Scott"));

    public static void enterDriverFirstTwoLetters(String name) throws InterruptedException {
        DRIVER_SEARCH_FIELD
                .perform(click())
                .perform(typeText(name.substring(0,1)));
        Thread.sleep(2000);
        DRIVER_SEARCH_FIELD
                .perform(typeText(name.substring(1,2)));
    }

    public static ViewInteraction getDriverName() {
        return DRIVER_NAME;
    }
}