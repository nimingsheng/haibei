package com.nms.mydemo.seashell;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.yangjw.minelibrary.bitmap.ImageLoader;
import com.google.gson.Gson;
import com.nms.mydemo.seashell.adapter.HeadPagerAdapter;
import com.nms.mydemo.seashell.bean.ProductDetails;
import com.nms.mydemo.seashell.fragment.DetailsFragment1;
import com.nms.mydemo.seashell.fragment.DetailsFragment2;
import com.nms.mydemo.seashell.httputils.HttpUtils;
import com.nms.mydemo.seashell.httputils.RequestCallBack;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/3/9.
 */
public class FouthActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvName;
    private ProductDetails productDetails;
    private Bundle bundle;
    private RequestCallBack callBack = new RequestCallBack() {
        @Override
        public void onSuccess(String result, int requestCode) {
            Log.d("demo","----------------"+result);
            Gson gson = new Gson();
            productDetails = gson.fromJson(result, ProductDetails.class);
            setData();
            bundle = new Bundle();
            bundle.putString("data",result);
        }
        @Override
        public void onFailed() {
        }
    };
    private TextView tvRealPrice;
    private RatingBar ratingBar;
    private TextView tvDiscount;
    private TextView tvListPrice;
    private ViewPager viewPager;
    private List<View> viewList;
    private TextView tvBottom1;
    private TextView tvBottom2;
    private FragmentManager manager;
    private DetailsFragment1 fragment1;
    private DetailsFragment2 fragment2;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private FragmentTransaction transaction;

    private void setData() {
        String name = productDetails.getData().getProduct().getName();
        tvName.setText(name);
        float price = (float)productDetails.getData().getProduct().getCurrent_sku().getReal_price().getCNY() / 100;
        DecimalFormat df1 = new DecimalFormat("0.00");
        String realPrice = df1.format(price);
        tvRealPrice.setText("￥"+realPrice);
        float mPrice = (float)productDetails.getData().getProduct().getCurrent_sku().getList_price().getCNY() / 100;
        String listPrice = df1.format(mPrice);
        tvListPrice.setText("￥"+listPrice);
        tvListPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        float discount = (float)productDetails.getData().getProduct().getCurrent_sku().getReal_price().getCNY()*10
                                    /productDetails.getData().getProduct().getCurrent_sku().getList_price().getCNY();
        DecimalFormat df2 = new DecimalFormat("0.0");
        String sDiscount = df2.format(discount);
        tvDiscount.setText(sDiscount + "折");
        int score2 = productDetails.getData().getProduct().getMerchant().getScore();
        ratingBar.setProgress(score2);
        createViewPager();
    }

    private void createViewPager() {
        viewPager = (ViewPager)findViewById(R.id.viewpager_top_details);
        viewList = new ArrayList<>();
        List<ProductDetails.DataEntity.ProductEntity.ImagesEntity> images = productDetails.getData().getProduct().getImages();
        for (int i =0;i<images.size();i++){
            addRadioButton();

            String imageUrl = images.get(i).getUrl();
            ImageView imageView = new ImageView(this);
            ImageLoader.load(this,imageUrl,imageView);
            viewList.add(imageView);
        }
        if (images.size()<2){
            addRadioButton();
            String imageUrl = images.get(0).getThumb();
            ImageView imageView = new ImageView(this);
            ImageLoader.load(this,imageUrl,imageView);
            viewList.add(imageView);
        }
        HeadPagerAdapter adapter = new HeadPagerAdapter(viewList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        radioGroup.check(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                radioGroup.check(position+1);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void addRadioButton() {
        RadioButton radioButton = new RadioButton(this);
        radioButton.setButtonDrawable(R.drawable.dot_radiobutton);
        radioGroup.addView(radioButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        HttpUtils.requestGet(url, callBack, 3);
        initView();
        manager = getSupportFragmentManager();
    }

    private void initView() {
        tvName = (TextView)findViewById(R.id.tv_name_big_details);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        tvRealPrice = (TextView)findViewById(R.id.real_price_details);
        tvDiscount = (TextView)findViewById(R.id.tv_discount_details);
        tvListPrice = (TextView)findViewById(R.id.list_price_details);
        tvBottom1 = (TextView)findViewById(R.id.tv1_bottom_details);
        tvBottom2 = (TextView)findViewById(R.id.tv2_bottom_details);
        tvBottom1.setOnClickListener(this);
        tvBottom2.setOnClickListener(this);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup_dot);
        radioButton1 = (RadioButton)findViewById(R.id.rb1_line);
        radioButton2 = (RadioButton)findViewById(R.id.rb2_line);

        radioButton1.setChecked(true);

    }

    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.tv1_bottom_details:
                radioButton1.setChecked(true);
                if (fragment2 != null){
                    transaction.hide(fragment2);
                }
                if (fragment1 == null){
                    if (bundle != null) {
                        fragment1 = new DetailsFragment1();
                        fragment1.setArguments(bundle);
                        transaction.add(R.id.container_bottom_details, fragment1);
                    }
                }else {
                    transaction.show(fragment1);
                }
                break;
            case R.id.tv2_bottom_details:
                radioButton2.setChecked(true);
                if (fragment1 != null){
                    transaction.hide(fragment1);
                }
                if (fragment2 == null){
                    if (bundle != null){
                    fragment2 = new DetailsFragment2();
                    fragment2.setArguments(bundle);
                    transaction.add(R.id.container_bottom_details,fragment2);
                    }
                }else {
                    transaction.show(fragment2);
                }
                break;
        }
        transaction.commit();
    }
    public void back(View v){
        finish();
    }
    public void share(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/*");
        startActivity(intent);
    }
}
