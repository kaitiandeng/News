package com.example.administrator.zhihunews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrator.zhihunews.Util.HttpCallbackListener;
import com.example.administrator.zhihunews.Util.HttpUtil;
import com.example.administrator.zhihunews.gson.Latest;
import com.google.gson.Gson;



public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private boolean isLight;
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ContentAdapter contentAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        isLight = sp.getBoolean("isLight", true);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);   //得到ToolBar实例

        toolbar.setBackgroundColor(getResources().getColor(isLight ? R.color.colorPrimary : R.color.colorPrimaryDark)
        );
        setSupportActionBar(toolbar);                      //传入ToolBar实例，是外观和功能都与ActionBar一样

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);              //设置导航按钮图标显示出来   默认为一个返回箭头   功能是返回上一个活动
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);     //设置按钮图标的图片
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);   //实例化DrawerLayout
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);//实例化NavigationV
        View headerView = navigationView.getHeaderView(0);        //要在headerView里添加点击事件  首先要获得该View    才能继续进行
        navigationView.setCheckedItem(R.id.nav_home);           //设置home按钮为默认选中
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {   //设置菜单选项事件的监听器
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();             //关闭DrawerLayout
                return true;
            }
        });
        TextView tv_collect = (TextView) headerView.findViewById(R.id.tv_collect);       //获取headerView中TextView中的id
        TextView tv_download = (TextView) headerView.findViewById(R.id.tv_download);
        tv_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "正在开发中敬请期待！！！", Toast.LENGTH_LONG).show();
            }
        });
        tv_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "正在开发中敬请期待！！！", Toast.LENGTH_LONG).show();
            }
        });
        ImageButton imageButton_1 = (ImageButton) headerView.findViewById(R.id.imageButton_1);
        ImageButton imageButton_2 = (ImageButton) headerView.findViewById(R.id.imageButton_2);
        imageButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "正在开发中敬请期待！！！", Toast.LENGTH_LONG).show();
            }
        });
        imageButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "正在开发中敬请期待！！！", Toast.LENGTH_LONG).show();
            }
        });
        initData();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);                             //设置进度条颜色
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {                                                                    //设置下拉刷新的监听器
                refreshContents();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {             //加载toolBar.xml文件
        getMenuInflater().inflate(R.menu.toobar, menu);
        menu.getItem(0).setTitle(sp.getBoolean("isLight", true) ? "夜间模式" : "日间模式");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {             //处理菜单上的各种点击事件
        switch (item.getItemId()) {
            case android.R.id.home:                            //左上角的导航按钮是 HomeAsUp按钮   id永远都是 android.R.id.home
                mDrawerLayout.openDrawer(GravityCompat.START); //该方法将滑动菜单显示出来   传入Gravity参数，为保证与XML文件致，传入GravityCompat.START
                break;
            case R.id.notification:
                Toast.makeText(MainActivity.this, "This is a notificcation Bar", Toast.LENGTH_LONG).show();
                break;
            case R.id.mode:
                isLight = !isLight;
                item.setTitle(isLight ? "夜间模式" : "日间模式");
                toolbar.setBackgroundColor(getResources().getColor(isLight ? R.color.colorPrimary : R.color.black));

                break;
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }

    private void initData(){
        String address = "http://news-at.zhihu.com/api/4/news/latest";
        HttpUtil.sendRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(response!= null){
                            parseJson(response);
                            Toast.makeText(MainActivity.this,"刷新成功！",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"获取数据失败！",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });
    }
    private void parseJson(String response){
        Gson gson = new Gson();
        final Latest latest = gson.fromJson(response,Latest.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 1);
                recyclerView.setLayoutManager(layoutManager);
                contentAdapter = new ContentAdapter(latest.getStories());
                recyclerView.setAdapter(contentAdapter);
            }
        });
    }
    private void refreshContents() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {                                          //将线程切换到主线程
                    @Override
                    public void run() {
                        initData();
                        contentAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);                      //刷新完毕后消失
                    }
                });
            }
        }).start();
    }

    public boolean isLight() {
        return isLight;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {                    //监听返回键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Intent.ACTION_MAIN);                   //主启动，不期望接收数据
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);                  //新的activity栈中开启，或者已经存在就调到栈前
            intent.addCategory(Intent.CATEGORY_HOME);                          //添加种类，为设备首次启动显示的页面
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
