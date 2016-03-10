package pratik.myapp.Activity;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pratik.myapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private Button btnRed, btnBlue, btnGreen;
    private LinearLayoutCompat layout_colorBg;
    private TextView txtTabLabel;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    static int[] color = {
            R.color.lightgreen,
            R.color.pink,
            R.color.amber,
            R.color.purple};

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();

        listener();
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager.setAdapter(mSectionsPagerAdapter);


        tabLayout.addTab(tabLayout.newTab().setText("Pineapple"));
        tabLayout.addTab(tabLayout.newTab().setText("Strawberry"));
        tabLayout.addTab(tabLayout.newTab().setText("Watermelon"));
        tabLayout.addTab(tabLayout.newTab().setText("Blue berry"));
        tabLayout.addTab(tabLayout.newTab().setText("Custard Apple"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);





    }


    private void init() {
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container1);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        txtTabLabel = (TextView) findViewById(R.id.textviewTabLabel);
        layout_colorBg = (LinearLayoutCompat) findViewById(R.id.layout_colorBg);
        btnRed = (Button) findViewById(R.id.buttonRed);
        btnBlue = (Button) findViewById(R.id.buttonBlue);
        btnGreen = (Button) findViewById(R.id.buttonGreen);

    }

    private void listener() {

        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnGreen.setOnClickListener(this);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                txtTabLabel.setText(tab.getText().toString());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonRed:
                layout_colorBg.setBackgroundColor(getResources().getColor(R.color.material_red));
                break;
            case R.id.buttonBlue:
                layout_colorBg.setBackgroundColor(getResources().getColor(R.color.material_blue));
                break;
            case R.id.buttonGreen:
                layout_colorBg.setBackgroundColor(getResources().getColor(R.color.material_green));
                break;

        }

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends android.support.v4.app.Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            final int pos = getArguments().getInt(ARG_SECTION_NUMBER);
            CardView card_view = (CardView) rootView.findViewById(R.id.card_view);

            card_view.setBackgroundColor(getResources().getColor(color[pos]));

            card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Position : " + pos, Toast.LENGTH_SHORT).show();
                }
            });

            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            android.support.v4.app.Fragment fragment = PlaceholderFragment.newInstance(position);


            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
            }
            return null;
        }
    }

}
