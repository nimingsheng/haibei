package com.nms.mydemo.seashell.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yangjw.minelibrary.bitmap.ImageLoader;
import com.nms.mydemo.seashell.R;
import com.nms.mydemo.seashell.bean.CategoryInfo;

import java.util.List;

/**
 * Created by my on 2016/3/9.
 */
public class Lv1CategoryAdapter extends BaseAdapter{
    private List<CategoryInfo.DataEntity.CategoriesEntity> categories;
    private LayoutInflater inflater;
    private Context context;

    public Lv1CategoryAdapter(Context context, List<CategoryInfo.DataEntity.CategoriesEntity> categories) {
        this.categories = categories;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return categories == null ? 0 : categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories == null ? null : categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_listview1_category,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_item_listview1);
            viewHolder.textView = (TextView)convertView.findViewById(R.id.tv_item_listview1);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(categories.get(position).getName());
        String imageUrl = categories.get(position).getIcon();
        ImageLoader.load(context,imageUrl,viewHolder.imageView);
        return convertView;
    }
    public static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
