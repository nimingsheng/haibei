package com.nms.mydemo.seashell.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yangjw.minelibrary.bitmap.ImageLoader;
import com.google.gson.Gson;
import com.nms.mydemo.seashell.FouthActivity;
import com.nms.mydemo.seashell.R;
import com.nms.mydemo.seashell.SixActivity;
import com.nms.mydemo.seashell.ThirdActivity;
import com.nms.mydemo.seashell.adapter.GridViewAdapter;
import com.nms.mydemo.seashell.adapter.HeadPagerAdapter;
import com.nms.mydemo.seashell.bean.HomeHeader;
import com.nms.mydemo.seashell.bean.ProductInfo;
import com.nms.mydemo.seashell.httputils.HttpUtils;
import com.nms.mydemo.seashell.httputils.RequestCallBack;
import com.nms.mydemo.seashell.layout.GridViewWithHeaderAndFooter;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by my on 2016/3/7.
 */
public class HomeFragment extends Fragment{

    private List<ProductInfo.DataEntity.ProductsEntity> list = new ArrayList<>();
    private List<HomeHeader.DataEntity.BannersEntity> banners = new ArrayList<>();
    RequestCallBack requestCallBack =new RequestCallBack() {
        @Override
        public void onSuccess(String result,int requestCode) {
            switch (requestCode){
                case 1:
                    Gson gson = new Gson();
                    ProductInfo productInfo = gson.fromJson(result,ProductInfo.class);
                    list.clear();
                    list.addAll(productInfo.getData().getProducts());
                    adapter.notifyDataSetChanged();

                   break;
                case 2:
                    Gson gson1 = new Gson();
                    HomeHeader homeHeader = gson1.fromJson(result, HomeHeader.class);
                    banners = homeHeader.getData().getBanners();
                    initGridView();
                    break;
            }
        }
        @Override
        public void onFailed() {
        }
    };

    private GridViewAdapter adapter;

    private ImageView ivSearch;
    private GridViewWithHeaderAndFooter gvShow;
    private View view1;
    private int i = 2;

    private ViewPager viewPager;
    int index = 0;
    private static final int MSG_UPDATE_UI = 0x123;
    private Handler mHandler;
    private View view;
    private List<View> viewList;
    private LayoutInflater mInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflater = inflater;
        loadData();
        view = inflater.inflate(R.layout.home_fragment,null);
        view1 = inflater.inflate(R.layout.viewpager_header_home,null);
        initFreshLayout();
        initSearchButton();
        startTimerTask();

        return view;
    }

    private void startTimerTask() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (viewList !=null &&!viewList.isEmpty()) {
                    if (index >= viewList.size()) {
                        index = 0;
                    }
                    viewPager.setCurrentItem(index);
                    index++;
                }
            }

        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(MSG_UPDATE_UI);
            }
        }, 10, 3000);

    }

    private void initSearchButton() {
        ivSearch = (ImageView)view.findViewById(R.id.iv_search_home);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initFreshLayout() {
        final SwipyRefreshLayout refreshLayout = (SwipyRefreshLayout)view.findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {

                if (direction == SwipyRefreshLayoutDirection.TOP) {
                    HttpUtils.requestGet("http://apicn.seashellmall.com/product/list/?size=20&p=1", requestCallBack, 1);
                    refreshLayout.setRefreshing(false);
                } else {
                        String url = "http://apicn.seashellmall.com/product/list/?size=" + 20 * i + "&p=1";
                        HttpUtils.requestGet(url, requestCallBack, 1);
                        refreshLayout.setRefreshing(false);
                        i++;
                    }
                }
        });
    }

    private void loadData() {
        HttpUtils.requestGet("http://apicn.seashellmall.com/product/list/?size=20&p=1", requestCallBack, 1);
        HttpUtils.requestGet("http://apicn.seashellmall.com/banner/index", requestCallBack, 2);
    }

    private void initGridView() {
        gvShow = (GridViewWithHeaderAndFooter)view.findViewById(R.id.gv_show_home);
        createViewPager();
        gvShow.addHeaderView(view1);
        adapter = new GridViewAdapter(view.getContext(),list);
        gvShow.setAdapter(adapter);

        gvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list != null && !list.isEmpty()) {
                    String detailsUrl = "http://apicn.seashellmall.com/product/sku/" + list.get(position).getCurrent_sku().getId();
                    Log.d("demo", "---------------" + detailsUrl);
                    Intent intent = new Intent(view.getContext(), FouthActivity.class);
                    intent.putExtra("url", detailsUrl);
                    startActivity(intent);
                } else {
                    Toast.makeText(view.getContext(), "网速慢，请稍后再试！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void createViewPager() {
        view1 = mInflater.inflate(R.layout.viewpager_header_home,null);
        viewPager = (ViewPager) view1.findViewById(R.id.vp_header);
        viewList = new ArrayList<>();
        for (int i=0;i<banners.size();i++) {
            String imageUrl = banners.get(i).getImage();
            ImageView imageView = new ImageView(view.getContext());
            imageView.setClickable(true);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("demo","----------------------position.view"+v.getId());
                    Intent intent = new Intent(view.getContext(), SixActivity.class);
                    int position = 0;
                    intent.putExtra("position", position+"");
                    String imageUrl = banners.get(0).getImage();
                    intent.putExtra("url", imageUrl);
                    startActivity(intent);
                }
            });
            ImageLoader.load(view.getContext(), imageUrl, imageView);
            viewList.add(imageView);
        }
        HeadPagerAdapter adapter = new HeadPagerAdapter(viewList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

    }



}
