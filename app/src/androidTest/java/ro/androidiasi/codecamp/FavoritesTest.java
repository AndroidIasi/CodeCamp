package ro.androidiasi.codecamp;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.snappydb.SnappyDB;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ro.androidiasi.codecamp.data.source.DataConference;
import ro.androidiasi.codecamp.main.MainActivity_;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FavoritesTest {

    @Rule
    public ActivityTestRule<MainActivity_> mActivityTestRule = new ActivityTestRule<>(MainActivity_.class);

    @Before
    public void clearFavorite() throws Exception {
        new SnappyDB.Builder(mActivityTestRule.getActivity())
                .name(DataConference.IASI.toString())
                .build()
                .del(String.valueOf("08:00:00null".hashCode()));
    }

    @Test
    public void testAddFavorite() throws Exception {
        onView(allOf(withId(R.id.swipe_to_refresh), isDisplayed()))
                .perform(swipeDown());

        onView(withText("Sessions"))
                .perform(click());
        onView(allOf(withText(containsString("Registration")), isDisplayed()))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());

        pressBack();

        onView(withText("Favorites"))
                .perform(click());
        onView(allOf(withId(R.id.swipe_to_refresh), isDisplayed()))
                .perform(swipeDown());

        onView(allOf(withText(containsString("Registration")), isDisplayed()))
                .check(matches(isDisplayed()));

    }

    @Test
    public void testNoFavorites() throws Exception {
        onView(withText("Favorites"))
                .perform(click());
        onView(allOf(withId(R.id.swipe_to_refresh), isDisplayed()))
                .perform(swipeDown());

        onView(allOf(withText(containsString("There are no Sessions")), isDisplayed()))
                .check(matches(isDisplayed()));

    }

}
