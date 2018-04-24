package com.example.adrian.homeautomationaccessmobile;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.adrian.homeautomationaccessmobile.R;
import com.example.adrian.homeautomationaccessmobile.ui.home.HomeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.support.test.espresso.contrib.DrawerActions;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DrawerActionEspressoTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule = new ActivityTestRule(HomeActivity.class);

    @Before
    public void showDrawer(){
        onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());
    }

    @Test
    public void checkIfDrawerIsOpen(){
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfGatesIsOnDrawer(){
        onView(withText("Gates")).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfCamerasIsOnDrawer(){
        onView(withText("Cameras")).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfWOLIsOnDrawer(){
        onView(withText("Wake-On-Lans")).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfFavouritesIsOnDrawer(){
        onView(withText("Favourites")).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfLogoutIsOnDrawer(){
        onView(withText("Logout")).check(matches(isDisplayed()));
    }

}
