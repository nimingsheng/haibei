package com.nms.mydemo.seashell.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nms.mydemo.seashell.R;
import com.nms.mydemo.seashell.bean.ProductDetails;

/**
 * Created by my on 2016/3/9.
 */
public class DetailsFragment1 extends Fragment{
    private ProductDetails productDetails;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment1,null);
        String result = this.getArguments().getString("data");
        Gson gson = new Gson();
        productDetails = gson.fromJson(result, ProductDetails.class);
        String details = productDetails.getData().getProduct().getDesc();
        TextView tvDetails = (TextView)view.findViewById(R.id.tv_fragment1_details);
        tvDetails.setText(details);
        return view;

    }
}
