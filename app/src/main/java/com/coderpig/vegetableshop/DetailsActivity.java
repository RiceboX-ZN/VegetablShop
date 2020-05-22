package com.coderpig.vegetableshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {

    GlobalDataActivity mGlobalData;

    String mType;
    String mTitle;

    float mPrice;
    float mAllPrice;

    int mSum = 1;
    int[] mImageGround;

    /*主图*/

    ImageView mImageViewHeader;

    TextView mProductTitle, mProductPrice, mProductAllPrice, mProductSum;

    Button mSubmit, mAdd, mReduce;

    ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mGlobalData = (GlobalDataActivity) getApplicationContext();
        mType = getIntent().getStringExtra("type");

        /*获取到该商品的一切信息*/
        Object[] itemInfo = (Object[]) mGlobalData.getInfo(mType);
        mTitle = (String) itemInfo[0];
        mPrice = (float) itemInfo[1];
        mImageGround = (int[]) itemInfo[2];

        mImageViewHeader = (ImageView) findViewById(R.id.Image_header);
        mProductTitle = (TextView) findViewById(R.id.product_title);
        mProductPrice = (TextView) findViewById(R.id.product_price);
        mProductAllPrice = (TextView) findViewById(R.id.product_all_price);
        mProductSum = (TextView) findViewById(R.id.product_sum);
        mSubmit = (Button) findViewById(R.id.product_submit);
        mAdd = (Button) findViewById(R.id.product_add);
        mReduce = (Button) findViewById(R.id.product_reduce);
        mScrollView = (ScrollView) findViewById(R.id.scroll);

        upDataInfo();


        /*以下为List填充item*/

        mScrollView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                mScrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });

        ArrayList<HashMap<String, Object>> ListData = new ArrayList<>();

        for (int i = 1; i < mImageGround.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("image", mImageGround[i]);
            ListData.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(DetailsActivity.this, ListData,
                R.layout.activity_details_item, new String[]{"image"}, new int[]{R.id.image_item});
        ListView listView = (ListView) findViewById(R.id.list_picture);
        listView.setAdapter(simpleAdapter);

    }

    private void upDataInfo() {
        mAllPrice = mPrice;
        mImageViewHeader.setImageResource(mImageGround[0]);
        mProductTitle.setText(mTitle);
        mProductPrice.setText(String.valueOf(mPrice));
        mProductAllPrice.setText(String.valueOf(mAllPrice));
        mProductSum.setText(String.valueOf(mSum));

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSum < 1) {
                    Toast.makeText(getApplicationContext(), "亲，请选择需要购买的数量",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mGlobalData.getSelectData().get(mType) != null) {
                    Toast.makeText(getApplicationContext(), "亲，该商品已经在购物车里面了哟", Toast.LENGTH_SHORT).show();
                    return;
                }

                mGlobalData.addSelectGoods(mType, mSum);
                Toast.makeText(getApplicationContext(), "亲，添加商品成功", Toast.LENGTH_SHORT).show();

            }
        });

        mReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSum <= 0) {
                    return;
                }

                mProductSum.setText(String.valueOf(--mSum));
                mAllPrice -= (float) mPrice;
                mAllPrice = GlobalDataActivity.formatNumber(mAllPrice);
                mProductAllPrice.setText(String.valueOf(mAllPrice));

            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            int mInt = 20;
            @Override
            public void onClick(View v) {
                if (mSum >= mInt) {
                    Toast.makeText(getApplicationContext(), "亲，商品数额已经最大啦", Toast.LENGTH_SHORT).show();
                    return;
                }

                mProductSum.setText(String.valueOf(++mSum));
                mAllPrice += (float) mPrice;
                mAllPrice = GlobalDataActivity.formatNumber(mAllPrice);
                mProductAllPrice.setText(String.valueOf(mAllPrice));

            }
        });

    }

    public void openSettingActivity2(View view) {
        Intent intent = new Intent(DetailsActivity.this, SettingActivity.class);
        startActivity(intent);
        finish();
    }

    public void backMainActivity(View view) {
        finish();
    }

}
