package com.coderpig.vegetableshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

/*主页面*/
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TYPE = "type";

    public float startX = 0;
    public float startY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*点击后直接进入分类视图，并且显示对应的蔬菜*/
        openClassificationActivityWithType(findViewById(R.id.ic_item01_1), "ic_item01_1");
        openClassificationActivityWithType(findViewById(R.id.ic_item01_2), "ic_item01_2");
        openClassificationActivityWithType(findViewById(R.id.ic_item01_3), "ic_item01_3");
        openClassificationActivityWithType(findViewById(R.id.ic_item01_4), "ic_item01_4");
        openClassificationActivityWithType(findViewById(R.id.ic_item01_5), "ic_item01_5");
        openClassificationActivityWithType(findViewById(R.id.ic_item02_1), "ic_item02_1");
        openClassificationActivityWithType(findViewById(R.id.ic_item02_2), "ic_item02_2");
        openClassificationActivityWithType(findViewById(R.id.ic_item02_3), "ic_item02_3");
        openClassificationActivityWithType(findViewById(R.id.ic_item02_4), "ic_item02_4");
        openClassificationActivityWithType(findViewById(R.id.ic_item02_5), "ic_item02_5");

        /*点击后进入详情页面，并显示对应的蔬菜信息*/
        openDetailsWithType(findViewById(R.id.ic_item01_1_01), "ic_item01_1_01");
        openDetailsWithType(findViewById(R.id.ic_item01_1_02), "ic_item01_1_02");
        openDetailsWithType(findViewById(R.id.ic_item01_1_03), "ic_item01_1_03");
        openDetailsWithType(findViewById(R.id.ic_item02_1_03), "ic_item02_1_03");
        openDetailsWithType(findViewById(R.id.ic_item02_1_02), "ic_item02_1_02");
        openDetailsWithType(findViewById(R.id.ic_item02_1_01), "ic_item02_1_01");

    }

    private void openDetailsWithType(View view, final String type) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(EXTRA_TYPE, type);
                startActivity(intent);
            }
        });
    }

    private void openClassificationActivityWithType(View view, final String type) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClassificationActivity.class);
                intent.putExtra(EXTRA_TYPE, type);
                startActivity(intent);
            }
        });
    }


    /*实现底部和顶部的页面跳转*/
    public void openClassificationActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ClassificationActivity.class);
        startActivity(intent);
        finish();
    }

    public void openShoppingCartActivity2(View view) {
        Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
        startActivity(intent);
        finish();
    }

    public void openPersonCenterActivity2(View view) {
        Intent intent = new Intent(MainActivity.this, PersonCenterActivity.class);
        startActivity(intent);
        finish();
    }

    public void openSettingActivity4(View view) {
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        startActivity(intent);
        finish();
    }

    public void openPersonCenterMain(View view) {
        Intent intent = new Intent(MainActivity.this, PersonCenterActivity.class);
        startActivity(intent);
        finish();
    }
}
