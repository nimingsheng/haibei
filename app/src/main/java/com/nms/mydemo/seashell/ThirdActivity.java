package com.nms.mydemo.seashell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nms.mydemo.seashell.bean.HotWord;
import com.nms.mydemo.seashell.httputils.HttpUtils;
import com.nms.mydemo.seashell.httputils.RequestCallBack;
import com.nms.mydemo.seashell.layout.FlowViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by my on 2016/3/7.
 */
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private RequestCallBack callBack = new RequestCallBack() {
        @Override
        public void onSuccess(String result, int requestCode) {
            switch (requestCode){
                case 3:
                    Gson gson = new Gson();
                    HotWord hotWord = gson.fromJson(result, HotWord.class);
                    Log.d("nms", "-------------------" + hotWord.getData().getKeywords());
                    List<String> wordList = hotWord.getData().getKeywords();
                    createTextView(wordList);
                    break;
            }
        }

        @Override
        public void onFailed() {

        }
    };
    private TextView tvCancel;
    private EditText editText;
    private ListView listView;
    private List<String> historyList = new ArrayList<String>();
    private final static String DEFULT_CONTENT = "nms";
    private ArrayAdapter<String> arrayAdapter;
    private TextView tvClear;

    private void createTextView(List<String> wordList) {
        FlowViewGroup flowViewGroup = (FlowViewGroup) findViewById(R.id.container_hot_word);
        for (int i=0;i<wordList.size();i++){
            TextView textView = new TextView(this);
            textView.setBackgroundResource(R.drawable.textview_bg_flow);
            textView.setText(wordList.get(i));
            textView.setTextSize(14);
            textView.setClickable(true);
            textView.setOnClickListener(this);
            textView.setAlpha(0.5f);
            flowViewGroup.addView(textView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        HttpUtils.requestGet("http://apicn.seashellmall.com/search/keywords/hot", callBack, 3);
        initView();
        initListener();
        getData();
    }
    public void startActivity(String content){
        Intent intent = new Intent(this,FifthActivity.class);
        intent.putExtra("password","three");
        intent.putExtra("content",content);
        startActivity(intent);
    }


    private void initView() {
        tvCancel = (TextView)findViewById(R.id.tv_cancel);
        editText = (EditText)findViewById(R.id.et_search_third);
        listView = (ListView)findViewById(R.id.lv_third_activity);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,historyList);
        listView.setAdapter(arrayAdapter);
        tvClear = (TextView)findViewById(R.id.tv_clear_history);

    }

    @Override
    public void onClick(View v) {
        v.setAlpha(1.0f);
        TextView textView = (TextView)v;
        String content = textView.getText().toString();
        Log.d("demo", "-----------------------content" + content);
        saveContent(content);
        getData();
        startActivity(content);
    }

    private void saveContent(String content) {
        SharedPreferences sharedPreferences = getSharedPreferences("history", Context.MODE_APPEND);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Collection<?> values = sharedPreferences.getAll().values();
        int index = values.size();
        editor.putString(index + "", content);
        editor.commit();
        tvClear.setText("清空历史记录");
    }
    private void getData(){
        historyList.clear();
        SharedPreferences sharedPreferences = getSharedPreferences("history", Context.MODE_APPEND);
        if (sharedPreferences != null) {
            Collection<?> values = sharedPreferences.getAll().values();
            for (int i = 0;i< values.size();i++){
                String result =sharedPreferences.getString(i+"",DEFULT_CONTENT);
                if (!result.equals(DEFULT_CONTENT)) {
                    if (!historyList.contains(result)) {
                        historyList.add(result);
                    }
                }
            }
        }
            if (historyList.isEmpty()) {
                historyList.add("没有搜索历史");
            }

        arrayAdapter.notifyDataSetChanged();
    }

    public void cancel(View view){
        if (tvCancel.getText().equals("取消")){
            finish();
        }else {
            Toast.makeText(ThirdActivity.this, "开始搜索", Toast.LENGTH_SHORT).show();
            String content = editText.getEditableText().toString();
            saveContent(content);
            getData();
            startActivity(content);
        }
    }
    public void clear(View view){
        clearHistory();
        tvClear.setText("");
    }

    private void clearHistory() {
        SharedPreferences sharedPreferences = getSharedPreferences("history", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Collection<?> values = sharedPreferences.getAll().values();
        for (int i=0;i<values.size();i++) {
            editor.putString(i + "", DEFULT_CONTENT);
        }
        editor.commit();
        getData();
    }

    private void initListener() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int start = editText.getSelectionStart();
                int end = editText.getSelectionEnd();
                if (start == 0 || end == 0){
                    tvCancel.setText("取消");
                }else {
                    tvCancel.setText("搜索");
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String content = historyList.get(position);
                startActivity(content);
            }
        });
    }
}
