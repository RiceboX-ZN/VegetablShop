package com.coderpig.vegetableshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PersonCenterActivity extends AppCompatActivity {
    GlobalDataActivity globalData;         //全局数据库
    Button at5_btn_addMoney;        //抽奖控件
    TextView at5_tv_money;  //当前余额的显示控件;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        globalData = (GlobalDataActivity) getApplicationContext();

        at5_tv_money = (TextView) findViewById(R.id.money);
        at5_btn_addMoney = (Button) findViewById(R.id.choujiang);

        init();
    }

    private void init() {
        at5_tv_money.setText(String.valueOf(globalData.getInitMoney()));
        at5_btn_addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalData.getInitMoney() > 999999) {
                    Toast.makeText(getApplicationContext(), "你的财富已经够了，可以去购物啦", Toast.LENGTH_SHORT).show();
                    return;
                }

                int max = 70000;
                int min = -25000;

                Random random = new Random();
                float s = Float.valueOf((random.nextInt(max) % (max - min + 1) + min)) / 100;

                if (s < 0) {
                    Toast.makeText(getApplicationContext(), "运气不好，损失" + s + "元", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "恭喜你，抽到" + s + "元", Toast.LENGTH_SHORT).show();
                }

                float money = GlobalDataActivity.formatNumber(globalData.getInitMoney() + s);

                if (money < 0) {
                    money = 0;
                }

                globalData.setInitMoney(money);
                at5_tv_money.setText(String.valueOf(globalData.getInitMoney()));

            }
        });
    }

    public void openMainActivityPC(View view) {
        Intent intent = new Intent(PersonCenterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void openClassificationPC(View view) {
        Intent intent = new Intent(PersonCenterActivity.this, ClassificationActivity.class);
        startActivity(intent);
        finish();
    }

    public void openShoppingPC(View view) {
        Intent intent = new Intent(PersonCenterActivity.this, ShoppingCartActivity.class);
        startActivity(intent);
        finish();
    }


}
