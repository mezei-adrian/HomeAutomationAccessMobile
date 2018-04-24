package com.example.adrian.homeautomationaccessmobile;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.adrian.homeautomationaccessmobile.R;
import com.example.adrian.homeautomationaccessmobile.ui.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.Espresso.onView;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginEspressoTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void loginScreenContainsPleaseLogin() {
        onView(withText("Please login")).check(matches(isDisplayed()));
    }

    @Test
    public void loginScreenContainsSignInOrRegister() {
        onView(withText("Sign in or register")).check(matches(isDisplayed()));
    }

    @Test
    public void loginClickShowsErrorIfEmailIsEmpty() {
        onView(withText("Sign in or register")).perform(click());
        onView(ViewMatchers.withId(R.id.email)).check(matches(hasErrorText("Field cannot be empty")));
    }

    @Test
    public void loginClickShowsErrorIfPasswordIsEmptyGoodEmail() {
        onView(withId(R.id.email)).perform(typeText("a"));
        onView(withText("Sign in or register")).perform(click());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.password)).check(matches(hasErrorText("This password is incorrect")));
    }

    @Test
    public void loginClickShowsErrorIfPasswordIsEmptyBadEmail() {
        onView(withId(R.id.email)).perform(typeText("aaaa"));
        onView(withText("Sign in or register")).perform(click());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.password)).check(matches(hasErrorText("This password is incorrect")));
    }

    @Test
    public void loginSuccessShowsWelcomeMEssage() {
        onView(withId(R.id.email)).perform(typeText("a"));
        onView(withId(R.id.password)).perform(typeText("a"));

        onView(withText("Sign in or register")).perform(click());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("This is an application for controlling your home gadgets.\n\n\nYou can find categories like camera, gate etc. in the drawer menu of the top left hamburger button.")).check(matches(isDisplayed()));
    }

}