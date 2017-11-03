package com.sjsu.se195.uniride;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.sjsu.se195.uniride.fragment.MyPostsFragment;
import com.sjsu.se195.uniride.fragment.MyTopPostsFragment;
import com.sjsu.se195.uniride.fragment.PostListFragment;
import com.sjsu.se195.uniride.fragment.RecentPostsFragment;


/**
 * Created by akshat on 10/9/17.
 */

public class MainSubcategoryActivity extends MainActivity {
    private boolean postType;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mPagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        postType = getIntent().getExtras().getBoolean("driverMode");

        if (postType) {
            setContentView(R.layout.activity_driver_main);
            findViewById(R.id.new_drive_offer_post).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainSubcategoryActivity.this, NewPostActivity.class);
                    intent.putExtra("driveOffer", true);
                    startActivity(intent);
                }
            });
        } else {
            setContentView(R.layout.activity_rider_main);
            findViewById(R.id.new_ride_request_post).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainSubcategoryActivity.this, NewPostActivity.class);
                    intent.putExtra("driveOffer", false);
                    startActivity(intent);
                }
            });
        }

        System.out.println("mainsub");
        Bundle bundle = new Bundle();
        bundle.putBoolean("postType", this.postType);
        Fragment posts = new RecentPostsFragment();
        posts.setArguments(bundle);
        // TODO add/replace?
        getSupportFragmentManager().beginTransaction().add(R.id.post_fragment_placeholder, posts).commit();

        /*mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    new RecentPostsFragment()
            };

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }
            @Override
            public int getCount() {
                return mFragments.length;
            }
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);*/

    }

}
