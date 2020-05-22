package com.coderpig.vegetableshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hark_
 * @date
 */
public class ShoppingCartActivity extends AppCompatActivity {

    GlobalDataActivity globalData;
    TextView tvAllPrice;
    ListView lv;

    int sumGoods;
    float allPrice;  //所有商品的总价

    ArrayList<HashMap<String, Object>> list = new ArrayList<>();

    @Override

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_shoppingcart);

        globalData = (GlobalDataActivity) getApplicationContext();

        Intent intent = getIntent();
        initList();

        setAdpter();
    }

    private void setAdpter() {
        String[] names = {"image", "title", "price", "sum"};
        int[] layId = {R.id.picture, R.id.shop_item_title, R.id.shop_item_price, R.id.shop_item_sum};


        SimpleAdapter simpleAdapter = new SimpleAdapter(ShoppingCartActivity.this, list,
                R.layout.activity_shopping_cart_item, names, layId) {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                /*在View里面，找到对应的子视图的控件资源id，实现控件的绑定*/
                Button btnReduce = (Button) view.findViewById(R.id.shop_item_reduce_item);    //减号控件id
                Button btnAdd = (Button) view.findViewById(R.id.shop_item_add_item);          //加号控件id
                /*这儿使用常量，相当于这个TextView找到这个对应的视图后，就不变啦*/
                final TextView tv = (TextView) view.findViewById(R.id.shop_item_sum); //这个是数量控件（文本型）

                //找到购物车页面的所有商品总价控件，因为要更新总价，这个是提交订单的那个总价格
                final TextView tvSum = (TextView) findViewById(R.id.all_price);

                /*设置减少按钮的监听器和点击事件*/
                btnReduce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        /*ArrayList的get（int） 是找到对应下标里面的值，这儿的position是从0开始的，刚好于ArrayList相对应*/
                        /*通过list.get（int）返回一个position位置的map，再用过map.get(String) 获取到对应的数量*/
                        int sum = (Integer) list.get(position).get("sum");     //获取该位置商品的数量
                        if (sum <= 0) {
                            /*如果数量小于0，则这个按钮不做任何反应*/
                            return;
                        }
                        /*tv是显示该商品数量的控件（TextView）
                         * 如果商品数量大于0，则把商品数量减一*/
                        tv.setText(String.valueOf(--sum)); //因为TextVIew显示的是字符串，所以先把sum（int）先转化为String

                        /*刷新SelectGoods（存放了商品的序列号和数量）里面该商品的数量信息
                         * SelectGoods是map型，当键相同时，新值会覆盖旧值
                         * list.get(position).get("type")是获取map里面商品序列号，然后把序列号作为key，把sum作为值覆盖旧值
                         * 使用确保能够百分之百是String类型，不会因此而出差错*/
                        globalData.selectData.put((String) list.get(position).get("type"), sum);

                        if (sum == 0) {
                            /*如果该位置商品的数量==0，则总商品类型则减一*/
                            sumGoods--;
                        }
                        /*通过list获取到map，然后通过map获取该商品的单价
                         * 总价等于总价减去单价，因为数量大于0，按一下reduce按钮，该商品就会减少一件
                         * 总价再initInfo（）里面就获取到了总价
                         * allPrice指的是所有商品累加再一起的总价*/
                        allPrice -= (Float) list.get(position).get("price");
                        allPrice = GlobalDataActivity.formatNumber(allPrice);//精确化总价，保留两位小数
                        tvSum.setText(String.valueOf(allPrice));//tv_sum是购物车页面的提价订单的总价，显示再上面
                        list.get(position).put("sum", sum); //更新ArrayList<Map<>>里面的该商品数量
                    }
                });

                /*设置+控件的监听器和点击事件*/
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        //因为再存储的时候，用的是泛型，所以要用（Integer）转换以下，保险一些
                        int sum = (Integer) list.get(position).get("sum");  //这是该商品的总数量
                        if (sum >= 20) {
                            /*如果商品数量上限，则弹出提示消息*/
                            Toast.makeText(getApplicationContext(), "一次只能购买20件哦", Toast.LENGTH_SHORT);
                            return;
                        }

                        /*tv是显示该商品数量的控件，因为是展现的时候是String形式，所以需要转换*/
                        /*把该商品的数量加1*/
                        tv.setText(String.valueOf(++sum));

                        /*更新selecData(Map<String,Integer>)里面存储该商品的数量信息*/
                        globalData.selectData.put((String) list.get(position).get("type"), sum);


                        if (sum == 1) {
                            sumGoods++;
                        }

                        /*更新总价*/
                        allPrice += (Float) list.get(position).get("price");
                        allPrice = GlobalDataActivity.formatNumber(allPrice); //精确化数据（采用的是大叔类型），保留小数点偶两位
                        tvSum.setText(String.valueOf(allPrice)); //tv_sum是购物车页面的提价订单的总价，显示在上面
                        list.get(position).put("sum", sum);     //更新list（ArrayList<Map<>>）里面该商品的数量
                    }
                });

                return view;
            }
        };

        tvAllPrice.setText(String.valueOf(allPrice));
        lv.setAdapter(simpleAdapter);


        Button purchase = (Button) findViewById(R.id.shop_submit);
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sumGoods == 0) {
                    Toast.makeText(ShoppingCartActivity.this, "欢迎下次光临", Toast.LENGTH_SHORT).show();
                    allPrice = 0;
                    list.clear();
                    globalData.clearSelectGoods();
                    findViewById(R.id.submit_cart).setVisibility(View.GONE);
                    return;
                }
                float money = globalData.getInitMoney() - allPrice;
                money = GlobalDataActivity.formatNumber(money);
                if (money <= 0) {
                    Toast.makeText(ShoppingCartActivity.this, "余额不足", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(ShoppingCartActivity.this, "下单成功，欢迎下次再来", Toast.LENGTH_SHORT).show();
                globalData.setInitMoney(money);
                allPrice = 0;
                list.clear();
                globalData.clearSelectGoods();
                findViewById(R.id.submit_cart).setVisibility(View.GONE);

            }
        });
    }

    private void initList() {
        lv = (ListView) findViewById(R.id.shop_list);
        tvAllPrice = (TextView) findViewById(R.id.all_price);

        Map<String, Integer> goods = globalData.getSelectData();
        sumGoods = goods.size();

        if (sumGoods == 0) {
            findViewById(R.id.submit_cart).setVisibility(View.GONE);
            return;
        }

        for (Map.Entry<String, Integer> entry : goods.entrySet()) {
            addItemInfo(entry.getKey(), entry.getValue());
        }
    }

    private void addItemInfo(String type, int sum) {
        Object[] itemInfo = (Object[]) globalData.getInfo(type);
        HashMap<String, Object> map = new HashMap<>();

        map.put("image", ((int[]) itemInfo[2])[0]);
        map.put("title", (String) itemInfo[0]);
        map.put("price", (Float) itemInfo[1]);
        map.put("sum", sum);
        map.put("type", type);
        list.add(map);

        allPrice += (Float) itemInfo[1] * sum;
        allPrice = GlobalDataActivity.formatNumber(allPrice);

    }

    public void openMainActivitySC(View view) {
        Intent intent = new Intent(ShoppingCartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void openSettingSC(View view) {
        Intent intent = new Intent(ShoppingCartActivity.this, SettingActivity.class);
        startActivity(intent);
        finish();
    }

    public void openClassificationSC(View view) {
        Intent intent = new Intent(ShoppingCartActivity.this, ClassificationActivity.class);
        startActivity(intent);
        finish();
    }

    public void openPersonCenterSC(View view) {
        Intent intent = new Intent(ShoppingCartActivity.this, PersonCenterActivity.class);
        startActivity(intent);

        finish();
    }

}
