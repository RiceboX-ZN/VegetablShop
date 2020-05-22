package com.coderpig.vegetableshop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author hark_
 */
public class ClassificationActivity extends AppCompatActivity {

    GlobalDataActivity globalData;
    LinearLayout btnItem01_1, btnItem01_2, btnItem01_3, btnItem01_4, btnItem01_5;
    LinearLayout btnItem02_1, btnItem02_2, btnItem02_3, btnItem02_4, btnItem02_5;

    ListView listView;
    String[] items;
    String nowType = "ic_item01_1";

    ArrayList<HashMap<String, Object>> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        globalData = (GlobalDataActivity) getApplicationContext();

        btnItem01_1 = (LinearLayout) findViewById(R.id.item01_1);
        btnItem01_2 = (LinearLayout) findViewById(R.id.item01_2);
        btnItem01_3 = (LinearLayout) findViewById(R.id.item01_3);
        btnItem01_4 = (LinearLayout) findViewById(R.id.item01_4);
        btnItem01_5 = (LinearLayout) findViewById(R.id.item01_5);

        btnItem02_1 = (LinearLayout) findViewById(R.id.item02_1);
        btnItem02_2 = (LinearLayout) findViewById(R.id.item02_2);
        btnItem02_3 = (LinearLayout) findViewById(R.id.item02_3);
        btnItem02_4 = (LinearLayout) findViewById(R.id.item02_4);
        btnItem02_5 = (LinearLayout) findViewById(R.id.item02_5);

        listView = (ListView) findViewById(R.id.classification_list);
        initClassification();
    }

    public void inflateType(String type2) {
        items = globalData.getGoods(type2);
        listData.clear();

        for (int i = 0; i < items.length; i++) {
            addItemInfo(items[i]);
        }
        addSimpleAdpter();

    }

    private void addSimpleAdpter() {
        String[] names = {"image", "title", "price"};

        int[] layId = {R.id.item_picture, R.id.item_title, R.id.item_price};

        SimpleAdapter simpleAdapter = new SimpleAdapter(ClassificationActivity.this, listData,
                R.layout.activity_classfication_item, names, layId);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClassificationActivity.this, DetailsActivity.class);
                intent.putExtra("type", items[position]);
                startActivity(intent);

            }
        });
    }

    private void addItemInfo(String type3) {
        Object[] itemInfo = (Object[]) globalData.getInfo(type3);
        HashMap<String, Object> map = new HashMap<>();
        map.put("image", ((int[]) itemInfo[2])[0]);
        map.put("title", (String) itemInfo[0]);
        map.put("price", (float) itemInfo[1]);
        listData.add(map);
    }


    private void initClassification() {
        String type = getIntent().getStringExtra("type");
        if (type != null) {
            nowType = type;
        }
        inflateType(nowType);
        type = null;
        btnItem01_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item01_1") {
                    return;
                }

                nowType = "ic_item01_1";
                btnItem01_1.setBackgroundColor(Color.YELLOW);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem01_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item01_2") {
                    return;
                }

                nowType = "ic_item01_2";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.YELLOW);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem01_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item01_3") {
                    return;
                }

                nowType = "ic_item01_3";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.YELLOW);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem01_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item01_4") {
                    return;
                }

                nowType = "ic_item01_4";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.YELLOW);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem01_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item01_5") {
                    return;
                }

                nowType = "ic_item01_5";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.YELLOW);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem02_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item02_1") {
                    return;
                }

                nowType = "ic_item02_1";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.YELLOW);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem02_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item02_2") {
                    return;
                }

                nowType = "ic_item02_2";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.YELLOW);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem02_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item02_3") {
                    return;
                }

                nowType = "ic_item02_3";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.YELLOW);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem02_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item02_4") {
                    return;
                }

                nowType = "ic_item02_4";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.YELLOW);
                btnItem02_5.setBackgroundColor(Color.WHITE);

                inflateType(nowType);
            }
        });

        btnItem02_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowType == "ic_item02_5") {
                    return;
                }

                nowType = "ic_item02_5";
                btnItem01_1.setBackgroundColor(Color.WHITE);
                btnItem01_2.setBackgroundColor(Color.WHITE);
                btnItem01_3.setBackgroundColor(Color.WHITE);
                btnItem01_4.setBackgroundColor(Color.WHITE);
                btnItem01_5.setBackgroundColor(Color.WHITE);

                btnItem02_1.setBackgroundColor(Color.WHITE);
                btnItem02_2.setBackgroundColor(Color.WHITE);
                btnItem02_3.setBackgroundColor(Color.WHITE);
                btnItem02_4.setBackgroundColor(Color.WHITE);
                btnItem02_5.setBackgroundColor(Color.YELLOW);

                inflateType(nowType);
            }
        });
    }

    public void openPersonCenterActivity5(View view) {
        Intent intent = new Intent(ClassificationActivity.this, PersonCenterActivity.class);
        startActivity(intent);
        finish();
    }

    public void openSettingActivity3(View view) {
        Intent intent = new Intent(ClassificationActivity.this, SettingActivity.class);
        startActivity(intent);
        finish();
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(ClassificationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void openShoppingCartActivity(View view) {
        Intent intent = new Intent(ClassificationActivity.this, ShoppingCartActivity.class);
        startActivity(intent);
        finish();
    }

    public void openPersonCenterActivity(View view) {
        Intent intent = new Intent(ClassificationActivity.this, PersonCenterActivity.class);
        startActivity(intent);
        finish();
    }
}
