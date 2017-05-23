package developerkampus.logincrud;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import developerkampus.logincrud.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTab;
    private ViewPager mPager;
    private PagerAdapter mAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mTab = (TabLayout)findViewById(R.id.tab);
        mTab.setTabGravity(TabLayout.GRAVITY_FILL);
        mPager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new PagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mTab.setupWithViewPager(mPager);

    }
}
