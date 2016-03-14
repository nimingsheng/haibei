package com.nms.mydemo.seashell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yangjw.minelibrary.bitmap.ImageLoader;
import com.google.gson.Gson;
import com.nms.mydemo.seashell.adapter.GridViewAdapter;
import com.nms.mydemo.seashell.bean.ProductInfo;
import com.nms.mydemo.seashell.httputils.HttpUtils;
import com.nms.mydemo.seashell.httputils.RequestCallBack;
import com.nms.mydemo.seashell.layout.GridViewWithHeaderAndFooter;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/3/10.
 */
public class SixActivity extends AppCompatActivity{
    private GridViewWithHeaderAndFooter gvShow;
    private List<ProductInfo.DataEntity.ProductsEntity> list = new ArrayList<>();
    private GridViewAdapter adapter;
    private RequestCallBack callBack = new RequestCallBack() {
        @Override
        public void onSuccess(String result, int requestCode) {
            Log.d("nms", "---------------------" + result);
            Gson gson = new Gson();
            ProductInfo productInfo = gson.fromJson(result,ProductInfo.class);
            list.clear();
            list.addAll(productInfo.getData().getProducts());
            adapter.notifyDataSetChanged();
        }
        @Override
        public void onFailed() {

        }
    };
    private String url;
    private String position;
    private int i = 2;

    private String imageUrl;
    private ImageView imageView;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        adapter = new GridViewAdapter(this, list);
        getData();
        initGridView();
        initFreshLayout();
    }

    private void getData() {
        Intent intent = getIntent();
        String mPosition = intent.getExtras().getString("position");
        int iPosition = Integer.valueOf(mPosition)+1;
        position = iPosition+"";
        imageUrl = intent.getStringExtra("url");
        url = "http://apicn.seashellmall.com/product/topic/"+position+"/products?size=20&p=1";
        HttpUtils.requestGet(url, callBack, 1);
    }

    private void initGridView() {
        gvShow = (GridViewWithHeaderAndFooter)findViewById(R.id.gv_show_home_six);
        CreateImageView();
        gvShow.addHeaderView(view);
        gvShow.setAdapter(adapter);
        gvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list != null && !list.isEmpty()) {
                    String detailsUrl = "http://apicn.seashellmall.com/product/sku/" + list.get(position).getCurrent_sku().getId();
                    Log.d("demo", "---------------" + detailsUrl);
                    Intent intent = new Intent(SixActivity.this, FouthActivity.class);
                    intent.putExtra("url", detailsUrl);
                    startActivity(intent);
                } else {
                    Toast.makeText(view.getContext(), "网速慢，请稍后再试！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void CreateImageView() {
        LayoutInflater inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.imageview_header_six,null);
        imageView = (ImageView) view.findViewById(R.id.iv_activity_six);
        ImageLoader.load(this,imageUrl,imageView);
    }

    private void initFreshLayout() {
        final SwipyRefreshLayout refreshLayout = (SwipyRefreshLayout)findViewById(R.id.refresh_layout_six);
        refreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {

                if (direction == SwipyRefreshLayoutDirection.TOP) {
                    HttpUtils.requestGet(url, callBack, 1);
                    refreshLayout.setRefreshing(false);
                } else {
                    String newUrl = "http://apicn.seashellmall.com/product/topic/"+position+"/products?size="+20*i+"&p=1";
                    HttpUtils.requestGet(newUrl, callBack, 1);
                    refreshLayout.setRefreshing(false);
                    i++;
                }
            }
        });
    }
    public void back(View v){
        finish();
    }
}
