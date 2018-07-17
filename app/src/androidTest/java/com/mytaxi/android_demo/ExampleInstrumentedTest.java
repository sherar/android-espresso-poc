package com.mytaxi.android_demo;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.PageObjectModel.DriverDetailsScreen;
import com.mytaxi.android_demo.PageObjectModel.LoginScreen;
import com.mytaxi.android_demo.PageObjectModel.MainScreen;
import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.io.File;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleInstrumentedTest  {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity currentActivity = null;

    @Before
    public void setup() {
        deleteAppData();
    }


    @Test
    public void tc1loginSuccessfully() {
        currentActivity = activityRule.getActivity();
        LoginScreen.loginAs("crazydog335", "venture");
    }

    @Test
    public void tc2searchAndCallDriver() throws InterruptedException {
        currentActivity = activityRule.getActivity();

        MainScreen.enterDriverFirstTwoLetters("sa");

        // Select driver from list
        MainScreen.getDriverName()
                .inRoot(withDecorView(not(is(activityRule.getActivity().getWindow().getDecorView()))))
                .perform(click());

        DriverDetailsScreen.assertCallToDriverButtonPresent();
        DriverDetailsScreen.getDriverCard().check(matches(withText("Sarah Scott")));
        DriverDetailsScreen.callDriver();
    }

    private void deleteAppData() {
        File root = InstrumentationRegistry.getTargetContext().getFilesDir().getParentFile();
        String[] sharedPreferencesFileNames = new File(root, "shared_prefs").list();
        for (String fileName : sharedPreferencesFileNames) {
            InstrumentationRegistry.getTargetContext().getSharedPreferences(fileName.replace(".xml", ""), Context.MODE_PRIVATE).edit().clear().commit();
        }
    }
}