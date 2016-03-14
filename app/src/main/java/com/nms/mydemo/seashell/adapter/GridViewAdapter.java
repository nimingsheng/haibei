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
import com.nms.mydemo.seashell.bean.ProductInfo;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by my on 2016/3/5.
 */
public class GridViewAdapter extends BaseAdapter{
    private List<ProductInfo.DataEntity.ProductsEntity> list;
    private LayoutInflater inflater;
    private Context context;
    public GridViewAdapter(Context context,List<ProductInfo.DataEntity.ProductsEntity> list) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_gridview,null);
            holder.ivShow = (ImageView)convertView.findViewById(R.id.iv_item_logo);
            holder.tvDiscount = (TextView)convertView.findViewById(R.id.tv_discount);
            holder.tvPrice = (TextView)convertView.findViewById(R.id.tv_price_item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        float price = (float)list.get(position).getCurrent_sku().getReal_price().getCNY() / 100;
        DecimalFormat df = new DecimalFormat("0.00");
        String sPrice = df.format(price);
        holder.tvPrice.setText("￥ " + price);

        holder.tvDiscount.setText(getDiscount(position));
        String imageUrl = list.get(position).getImages().get(0).getUrl();
        holder.ivShow.setImageResource(R.drawable.placeholder_logo);
        ImageLoader.load(context, imageUrl, holder.ivShow);
        return convertView;
    }



    private String getDiscount(int position) {
        float discount = (float)list.get(position).getCurrent_sku().getReal_price().getCNY()*10/list.get(position).getCurrent_sku().getList_price().getCNY();
        DecimalFormat df = new DecimalFormat("0.0");
        String sDiscount = df.format(discount);
        return sDiscount;
    }

    public static class ViewHolder{
        ImageView ivShow;
        TextView tvPrice;
        TextView tvDiscount;
    }
}
