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
import com.nms.mydemo.seashell.bean.Header;

import java.util.List;

/**
 * Created by my on 2016/3/9.
 */
public class ListViewAdapter extends BaseAdapter{
    private List<Header.DataEntity.TopicsEntity> topicList;
    private LayoutInflater inflater;
    private Context context;

    public ListViewAdapter(Context context,List<Header.DataEntity.TopicsEntity> topicList) {
        this.topicList = topicList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return topicList == null ? 0 : topicList.size();
    }

    @Override
    public Object getItem(int position) {
        return topicList == null ? null : topicList.get(position);
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
            convertView = inflater.inflate(R.layout.item_listview_discover,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_item_discover);
            viewHolder.textView = (TextView)convertView.findViewById(R.id.tv_item_discover);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(topicList.get(position).getTitle());
        String imageUrl = topicList.get(position).getImage();
        ImageLoader.load(context,imageUrl,viewHolder.imageView);
        return convertView;
    }
    public static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
