package com.nms.mydemo.seashell;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.nms.mydemo.seashell.fragment.CategoryFragment;
import com.nms.mydemo.seashell.fragment.DiscoverFragment;
import com.nms.mydemo.seashell.fragment.HomeFragment;

/**
 * Created by my on 2016/3/7.
 */
public class SecondActivity extends AppCompatActivity{

    private RadioGroup radioGroup;
    private FragmentManager manager;
    private Fragment homeFragment,discoverFragment,categoryFragment;
    private RadioButton rbHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        manager = getSupportFragmentManager();

        radioGroup = (RadioGroup)findViewById(R.id.radiogroup_base);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                hideAllFragment(transaction);
                switch (checkedId){
                    case R.id.rb_home:
                        if (homeFragment == null){
                            homeFragment = new HomeFragment();
                            transaction.add(R.id.gl_base,homeFragment);
                        }else {
                            transaction.show(homeFragment);
                        }
                        break;
                    case R.id.rb_discover:
                        if (discoverFragment == null){
                            discoverFragment = new DiscoverFragment();
                            transaction.add(R.id.gl_base,discoverFragment);
                        }else {
                            transaction.show(discoverFragment);
                        }
                        break;
                    case R.id.rb_category:
                        if (categoryFragment == null){
                            categoryFragment = new CategoryFragment();
                            transaction.add(R.id.gl_base,categoryFragment);
                        }else {
                            transaction.show(categoryFragment);
                        }
                        break;
                }
                transaction.commit();
            }
        });
        rbHome = (RadioButton)findViewById(R.id.rb_home);
        rbHome.setChecked(true);
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (homeFragment != null){
            transaction.hide(homeFragment);
        }
        if (discoverFragment != null){
            transaction.hide(discoverFragment);
        }
        if (categoryFragment != null){
            transaction.hide(categoryFragment);
        }
    }
}
