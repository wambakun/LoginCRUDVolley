package developerkampus.logincrud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import developerkampus.logincrud.Fragment.DeleteFragment;
import developerkampus.logincrud.Fragment.FragmentUpdate;
import developerkampus.logincrud.Fragment.LoginFragment;
import developerkampus.logincrud.Fragment.SignUpFragment;

/**
 * Created by Wamba on 23/05/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private String[] title = {"Login", "SignUp", "Update", "Delete"};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if (position == 0) {
            fragment = new LoginFragment();
        } else if (position == 1) {
            fragment = new SignUpFragment();
        } else if (position == 2) {
            fragment = new FragmentUpdate();
        } else {
            fragment = new DeleteFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return title.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
