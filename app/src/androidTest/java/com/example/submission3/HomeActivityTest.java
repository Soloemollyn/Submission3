package com.example.submission3;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.ui.home.HomeActivity;
import com.example.submission3.utils.DataMovie;
import com.example.submission3.utils.DataTvShow;
import com.example.submission3.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {
    private final ArrayList<MovieEntity> dummyMovie = DataMovie.generateDummyMovie();
    private final ArrayList<TvShowEntity> dummyTvShow = DataTvShow.generateDummyTvShow();

    @Before
    public void setUp() {
        ActivityScenario.launch(HomeActivity.class);
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(withText(dummyMovie.get(0).getTitle().concat(" (").concat(dummyMovie.get(0).getYear()).concat(")"))));
        onView(withId(R.id.release_date_text)).check(matches(isDisplayed()));
        onView(withId(R.id.release_date_text)).check(matches(withText(dummyMovie.get(0).getDate())));
        onView(withId(R.id.duration_text)).check(matches(isDisplayed()));
        onView(withId(R.id.duration_text)).check(matches(withText(dummyMovie.get(0).getDuration())));
        onView(withId(R.id.genre_text)).check(matches(isDisplayed()));
        onView(withId(R.id.genre_text)).check(matches(withText(dummyMovie.get(0).getGenre())));
        onView(withId(R.id.desc_text)).check(matches(isDisplayed()));
        onView(withId(R.id.desc_text)).check(matches(withText(dummyMovie.get(0).getDescription())));
        onView(withId(R.id.description)).perform(swipeUp());
    }

    @Test
    public void loadFavMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.action_fav_activity)).perform(click());
        onView(withId(R.id.rv_fav_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fav_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(withText(dummyMovie.get(0).getTitle().concat(" (").concat(dummyMovie.get(0).getYear()).concat(")"))));
        onView(withId(R.id.release_date_text)).check(matches(isDisplayed()));
        onView(withId(R.id.release_date_text)).check(matches(withText(dummyMovie.get(0).getDate())));
        onView(withId(R.id.duration_text)).check(matches(isDisplayed()));
        onView(withId(R.id.duration_text)).check(matches(withText(dummyMovie.get(0).getDuration())));
        onView(withId(R.id.genre_text)).check(matches(isDisplayed()));
        onView(withId(R.id.genre_text)).check(matches(withText(dummyMovie.get(0).getGenre())));
        onView(withId(R.id.desc_text)).check(matches(isDisplayed()));
        onView(withId(R.id.desc_text)).check(matches(withText(dummyMovie.get(0).getDescription())));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void loadTvShow() {
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition(dummyTvShow.size()));
    }

    @Test
    public void loadDetailTvShow() {
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(withText(dummyTvShow.get(0).getTitle().concat(" (").concat(dummyTvShow.get(0).getYear()).concat(")"))));
        onView(withId(R.id.release_date_text)).check(matches(isDisplayed()));
        onView(withId(R.id.release_date_text)).check(matches(withText(dummyTvShow.get(0).getDate())));
        onView(withId(R.id.duration_text)).check(matches(isDisplayed()));
        onView(withId(R.id.duration_text)).check(matches(withText(dummyTvShow.get(0).getDuration())));
        onView(withId(R.id.genre_text)).check(matches(isDisplayed()));
        onView(withId(R.id.genre_text)).check(matches(withText(dummyTvShow.get(0).getGenre())));
        onView(withId(R.id.desc_text)).check(matches(isDisplayed()));
        onView(withId(R.id.desc_text)).check(matches(withText(dummyTvShow.get(0).getDescription())));
        onView(withId(R.id.description)).perform(swipeUp());
    }

    @Test
    public void loadFavTvShow() {
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.action_fav_activity)).perform(click());
        onView(withId(R.id.rv_fav_movie)).check(matches(isDisplayed()));
        onView(withText("Fav TV Show")).perform(click());
        onView(withId(R.id.rv_fav_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fav_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(withText(dummyTvShow.get(0).getTitle().concat(" (").concat(dummyTvShow.get(0).getYear()).concat(")"))));
        onView(withId(R.id.release_date_text)).check(matches(isDisplayed()));
        onView(withId(R.id.release_date_text)).check(matches(withText(dummyTvShow.get(0).getDate())));
        onView(withId(R.id.duration_text)).check(matches(isDisplayed()));
        onView(withId(R.id.duration_text)).check(matches(withText(dummyTvShow.get(0).getDuration())));
        onView(withId(R.id.genre_text)).check(matches(isDisplayed()));
        onView(withId(R.id.genre_text)).check(matches(withText(dummyTvShow.get(0).getGenre())));
        onView(withId(R.id.desc_text)).check(matches(isDisplayed()));
        onView(withId(R.id.desc_text)).check(matches(withText(dummyTvShow.get(0).getDescription())));
        onView(withId(R.id.action_favorite)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
    }
}
