package com.example.adrian.homeautomationaccessmobile;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.adrian.homeautomationaccessmobile.ui.home.HomeActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CamerasControlEspressoTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule = new ActivityTestRule(HomeActivity.class);

    @Before
    public void showDrawer(){

        onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        onView(withId(R.id.nav_view)).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnCamerasContainsLeft() {
        onView(withText("Cameras")).perform(click());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Left camera")).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnCamerasContainsNeighbour() {
        onView(withText("Cameras")).perform(click());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Neighbour camera")).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnCamerasContainsRed() {
        onView(withText("Cameras")).perform(click());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Red camera")).check(matches(isDisplayed()));
    }
}
