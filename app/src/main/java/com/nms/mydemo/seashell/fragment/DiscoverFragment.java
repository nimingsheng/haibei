package com.nms.mydemo.seashell.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.yangjw.minelibrary.bitmap.ImageLoader;
import com.google.gson.Gson;
import com.nms.mydemo.seashell.R;
import com.nms.mydemo.seashell.SixActivity;
import com.nms.mydemo.seashell.ThirdActivity;
import com.nms.mydemo.seashell.adapter.ListViewAdapter;
import com.nms.mydemo.seashell.bean.Header;
import com.nms.mydemo.seashell.bean.ProductInfo;
import com.nms.mydemo.seashell.httputils.HttpUtils;
import com.nms.mydemo.seashell.httputils.RequestCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/3/7.
 */
public class DiscoverFragment extends Fragment{

    private List<Header.DataEntity.TopicsEntity> topicList = new ArrayList<>();
    RequestCallBack requestCallBack =new RequestCallBack() {
        @Override
        public void onSuccess(String result,int requestCode) {
                    Gson gson = new Gson();
                    Header header = gson.fromJson(result, Header.class);
                    topicList.addAll(header.getData().getTopics());
                    adapter.notifyDataSetChanged();
            }
        @Override
        public void onFailed() {
        }
    };
    private View view;
    private ListView lvDiscover;
    private ListViewAdapter adapter;
    private ImageView ivSearch;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.discover_fragment,null);
        HttpUtils.requestGet("http://apicn.seashellmall.com/product/topics", requestCallBack, 2);
        initView();
        initSearchButton();
        return view;
    }

    private void initView() {
        lvDiscover = (ListView)view.findViewById(R.id.lv_discover);
        adapter = new ListViewAdapter(view.getContext(),topicList);
        lvDiscover.setAdapter(adapter);
        lvDiscover.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), SixActivity.class);
                intent.putExtra("position", position +"");
                String imageUrl = topicList.get(position).getImage();
                intent.putExtra("url", imageUrl);
                startActivity(intent);
            }
        });
    }
    private void initSearchButton() {
        ivSearch = (ImageView)view.findViewById(R.id.iv_search_discover);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
