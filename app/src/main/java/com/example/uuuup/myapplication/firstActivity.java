package com.example.uuuup.myapplication;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.uuuup.myapplication.fragment.FragmentExtra;
import com.example.uuuup.myapplication.fragment.FragmentFour;
import com.example.uuuup.myapplication.fragment.FragmentOne;
import com.example.uuuup.myapplication.fragment.FragmentThree;
import com.example.uuuup.myapplication.fragment.FragmentTwo;

public class firstActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener  {
    private BottomNavigationBar mBottomNavigationBar;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;
    private FragmentFour mFragmentFour;
    private FragmentExtra mFragmentExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        /*** the setting for BadgeItem ***/

        BadgeItem badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("10")
                .setBackgroundColorResource(R.color.orange)
                .setBorderWidth(0);

        /*** the setting for BottomNavigationBar ***/

//        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar.setBarBackgroundColor(R.color.blue);//set background color for navigation bar
        mBottomNavigationBar.setInActiveColor(R.color.white);//unSelected icon color
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_one, "公交").setActiveColorResource(R.color.green).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.icon_two, "聊天室").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.icon_three, "设置").setActiveColorResource(R.color.lime))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        //setDefaultFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mFragmentOne == null) {
            mFragmentOne = FragmentOne.newInstance();
        }
        transaction.replace(R.id.content, mFragmentOne);

    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mFragmentThree == null) {
            mFragmentThree = FragmentThree.newInstance("Third Fragment");
        }
        transaction.replace(R.id.content, mFragmentThree);
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (position) {
            case 0:
                mFragmentOne = FragmentOne.newInstance();
                transaction.replace(R.id.content, mFragmentOne);
                break;
            case 1:
                //if (mFragmentExtra == null){
                  //  mFragmentExtra = FragmentExtra.newInstance();
                //}
                if (mFragmentTwo == null) {
                    mFragmentTwo = FragmentTwo.newInstance();
                }
                transaction.replace(R.id.content, mFragmentTwo);
                break;
            case 2:
                if (mFragmentThree == null) {
                    mFragmentThree = FragmentThree.newInstance("Third Fragment");
                }
                transaction.replace(R.id.content, mFragmentThree);
                break;
            default:
                mFragmentOne = FragmentOne.newInstance();
                transaction.replace(R.id.content, mFragmentOne);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
