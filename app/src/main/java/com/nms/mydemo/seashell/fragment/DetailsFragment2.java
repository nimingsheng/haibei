package com.nms.mydemo.seashell.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nms.mydemo.seashell.R;
import com.nms.mydemo.seashell.bean.ProductDetails;

import java.util.List;

/**
 * Created by my on 2016/3/9.
 */
public class DetailsFragment2 extends Fragment{
    private ProductDetails productDetails;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_frament2, null);
        String result = this.getArguments().getString("data");
        Gson gson = new Gson();
        productDetails = gson.fromJson(result, ProductDetails.class);
        String data1 = productDetails.getData().getProduct().getLocation();
        String data2 = productDetails.getData().getProduct().getMerchant().getName();
        String data3 = productDetails.getData().getProduct().getName();
        String data4 = productDetails.getData().getProduct().getReview_count()+"";
        TextView textView1 = (TextView)view.findViewById(R.id.tv1_fragment2_details);
        TextView textView2 = (TextView)view.findViewById(R.id.tv2_fragment2_details);
        TextView textView3 = (TextView)view.findViewById(R.id.tv3_fragment2_details);
        TextView textView4 = (TextView)view.findViewById(R.id.tv4_fragment2_details);
        textView1.setText(data1);
        textView2.setText(data2);
        textView3.setText(data3);
        textView4.setText(data4);
        int score1 = productDetails.getData().getProduct().getMerchant().getScore();
        int score2 = productDetails.getData().getProduct().getScore();
        RatingBar ratingBar1 = (RatingBar)view.findViewById(R.id.ratingBar1_fragment);
        RatingBar ratingBar2 = (RatingBar)view.findViewById(R.id.ratingBar2_fragment);
        Log.d("demo", "-------------------------------------------" + score1);
        Log.d("demo", "-------------------------------------------" + score2);

        ratingBar1.setProgress(score1);
        ratingBar2.setProgress(score2);
        return view;

    }
}
