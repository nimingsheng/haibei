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

import com.google.gson.Gson;
import com.nms.mydemo.seashell.FifthActivity;
import com.nms.mydemo.seashell.R;
import com.nms.mydemo.seashell.ThirdActivity;
import com.nms.mydemo.seashell.adapter.Lv1CategoryAdapter;
import com.nms.mydemo.seashell.adapter.Lv2CategoryAdapter;
import com.nms.mydemo.seashell.bean.CategoryInfo;
import com.nms.mydemo.seashell.httputils.HttpUtils;
import com.nms.mydemo.seashell.httputils.RequestCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/3/7.
 */
public class CategoryFragment extends Fragment{
    private List<CategoryInfo.DataEntity.CategoriesEntity> categories = new ArrayList<>();
    private List<CategoryInfo.DataEntity.CategoriesEntity.SubEntity> sub = new ArrayList<>();
    private CategoryInfo categoryInfo;
    private RequestCallBack callBack = new RequestCallBack() {
        @Override
        public void onSuccess(String result, int requestCode) {
            Gson gson = new Gson();
            categoryInfo = gson.fromJson(result, CategoryInfo.class);
            categories.addAll(categoryInfo.getData().getCategories());
            adapter1.notifyDataSetChanged();
            sub.addAll(categoryInfo.getData().getCategories().get(0).getSub());
            lv1Position = categories.get(0).getId();
            adapter2.notifyDataSetChanged();
        }
        @Override
        public void onFailed() {
        }
    };
    private ListView listView1;
    private Lv1CategoryAdapter adapter1;
    private View view;
    private ListView listview2;
    private Lv2CategoryAdapter adapter2;
    private int lv1Position ;
    private ImageView ivSearch;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.category_fragment,null);
        HttpUtils.requestGet("http://apicn.seashellmall.com/category",callBack,1);
        initSearchButton();
        initListView1();
        initListView2();
        initListener();
        return view;    }

    private void initSearchButton() {
        ivSearch = (ImageView)view.findViewById(R.id.iv_search_category);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initListView2() {
        listview2 = (ListView)view.findViewById(R.id.lv2_category);
        adapter2 = new Lv2CategoryAdapter(view.getContext(),sub);
        listview2.setAdapter(adapter2);

    }

    private void initListView1() {
        listView1 = (ListView)view.findViewById(R.id.lv1_category);
        adapter1 = new Lv1CategoryAdapter(view.getContext(),categories);
        listView1.setAdapter(adapter1);
    }

    private void initListener() {
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (categoryInfo != null ){
                    sub.clear();
                    sub.addAll(categoryInfo.getData().getCategories().get(position).getSub());
                    adapter2.notifyDataSetChanged();
                    lv1Position = categories.get(position).getId();
                }
            }
        });
        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int lv2Position = sub.get(position).getId();
                Intent intent = new Intent(view.getContext(), FifthActivity.class);
                String url = "http://apicn.seashellmall.com/product/list/"+lv1Position+"-"+lv2Position+"?size=20&p=1";
                Log.d("demo","---------------------category.p1"+lv1Position+"------------------p2"+lv2Position);
                intent.putExtra("password","category");
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
}
