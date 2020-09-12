package com.example.leaderboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.leaderboard.Util.StudentAdapter;
import com.example.leaderboard.model.StudentHour;
import com.example.leaderboard.services.ApiClient;
import com.example.leaderboard.services.ServiceBuilder;
import com.example.leaderboard.services.StudentHourService;
import com.example.leaderboard.ui.main.LearningFragment;
import com.example.leaderboard.ui.main.SkillsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.leaderboard.ui.main.SectionsPagerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private RecyclerView mRecyclerNote;

    private static final int LEARNING_FRAGMENT = 0;
    private static final int SKILLS_FRAGMENT = 1;


    //fragments
    private LearningFragment mLearningFragment;
    private SkillsFragment mSkillsFragment;

    //widgets
    private  ViewPager viewPager;
    private TabLayout mTabs;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        // viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
        setupViewPager();

       mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        /* Inside the activity
// Sets the Toolbar to act as the ActionBar for this Activity window.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);
// Get access to the custom title view
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);*/

        mSubmit = (Button) mToolbar.findViewById(R.id.submit_button);
        mSubmit.setText("Submit");
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SubmissionActivity.class));
            }
        });






    }


    private void setupViewPager(){
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this,getSupportFragmentManager());
        mLearningFragment = new LearningFragment();
        mSkillsFragment = new SkillsFragment();
        sectionsPagerAdapter.addFragment(mLearningFragment);
        sectionsPagerAdapter.addFragment(mSkillsFragment);
        viewPager.setAdapter(sectionsPagerAdapter);

        mTabs = findViewById(R.id.tabs);
        mTabs.setupWithViewPager(viewPager);

        mTabs.getTabAt(LEARNING_FRAGMENT).setText("LearningLeaders");
        mTabs.getTabAt(SKILLS_FRAGMENT).setText("SkillIQLeaders");
    }
}