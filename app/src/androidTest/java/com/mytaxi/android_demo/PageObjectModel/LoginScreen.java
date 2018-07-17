package com.mytaxi.android_demo.PageObjectModel;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import com.mytaxi.android_demo.R;

public class LoginScreen {

    private static final ViewInteraction USERNAME_EDIT = onView(withId(R.id.edt_username));
    private static final ViewInteraction PASSWORD_EDIT = onView(withId(R.id.edt_password));
    private static final ViewInteraction LOGIN_BUTTON = onView(withId(R.id.btn_login));

    private static void enterUserName(String username) {
        USERNAME_EDIT.perform(typeText(username));
    }

    private static void enterPassword(String password) {
        PASSWORD_EDIT.perform(typeText(password), closeSoftKeyboard());
    }

    private static void clickLogin() {
        LOGIN_BUTTON.perform(click());
    }

    public static void loginAs(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }
}