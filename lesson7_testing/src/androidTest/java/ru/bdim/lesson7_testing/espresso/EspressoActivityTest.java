package ru.bdim.lesson7_testing.espresso;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.bdim.lesson7_testing.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoActivityTest {

    @Rule
    public ActivityTestRule<EspressoActivity> activityRule = new ActivityTestRule<>(EspressoActivity.class);

    @Test
    public void onClick() {
        onView(withId(R.id.bbb)).perform(click());
        onView(withId(R.id.ttt)).check(matches(withText("TextView")));
    }
}