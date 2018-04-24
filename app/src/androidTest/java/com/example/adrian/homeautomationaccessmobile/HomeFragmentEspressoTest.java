package com.example.adrian.homeautomationaccessmobile;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.adrian.homeautomationaccessmobile.ui.home.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeFragmentEspressoTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule = new ActivityTestRule(HomeActivity.class);

    @Test
    public void welcomeMessageIsShown() {
        onView(withText("This is an application for controlling your home gadgets.\n\n\nYou can find categories like camera, gate etc. in the drawer menu of the top left hamburger button.")).check(matches(isDisplayed()));
    }


}
