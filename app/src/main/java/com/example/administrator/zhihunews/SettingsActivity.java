package com.example.administrator.zhihunews;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private List<Settings> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar_settings);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);                 //显示出左上角的导航图标  默认为一个返回箭头
        initData();
        SettingsAdapter adapter_1 = new SettingsAdapter(SettingsActivity.this, R.layout.settingitem, dataList);
        ListView lv_1 = (ListView) findViewById(R.id.lv_set_top);
        lv_1.setAdapter(adapter_1);
        lv_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Settings settings = dataList.get(position);
                Toast.makeText(SettingsActivity.this, "功能仍在开发中敬请期待！！！", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {           //设置导航图标的默认功能
        if (item.getItemId() == android.R.id.home) ;
        finish();
        return true;
    }

    private void initData() {

        Settings settings_1 = new Settings("自动离线下载");
        dataList.add(settings_1);
        Settings settings_2 = new Settings("无图模式");
        dataList.add(settings_2);
        Settings settings_3 = new Settings("大字号");
        dataList.add(settings_3);
        Settings settings_4 = new Settings("推送消息");
        dataList.add(settings_4);
        Settings settings_5 = new Settings("点评分享到微博");
        dataList.add(settings_5);
        Settings settings_6 = new Settings("检查更新");
        dataList.add(settings_6);
        Settings settings_7 = new Settings("意见反馈");
        dataList.add(settings_7);

    }
}
