package com.coderpig.vegetableshop;

import android.app.Application;
import android.content.Intent;
import android.view.View;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;

/**
 * @author hark_
 */
public class GlobalDataActivity extends Application {

    private Map<String, Object[]> ProductData = new HashMap<>();
    private Map<String, String[]> GoodsList = new HashMap<>();
    public Map<String, Integer> selectData = new HashMap<>();

    private float initMoney = 1086.0F;

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    public void initData() {

        /*蔬菜系列分类（5类），每个种类又10个产品*/
        GoodsList.put("ic_item01_1", new String[]{"ic_item01_1_01", "ic_item01_1_02", "ic_item01_1_03",
                "ic_item01_1_04", "ic_item01_1_05", "ic_item01_1_06", "ic_item01_1_07", "ic_item01_1_08",
                "ic_item01_1_09"});
        GoodsList.put("ic_item01_2", new String[]{"ic_item01_2_01", "ic_item01_2_02", "ic_item01_2_03",
                "ic_item01_2_04", "ic_item01_2_05", "ic_item01_2_06", "ic_item01_2_07", "ic_item01_2_08"});
        GoodsList.put("ic_item01_3", new String[]{"ic_item01_3_01", "ic_item01_3_02", "ic_item01_3_03",
                "ic_item01_3_04", "ic_item01_3_05"});
        GoodsList.put("ic_item01_4", new String[]{"ic_item01_4_01", "ic_item01_4_02", "ic_item01_4_03",
                "ic_item01_4_04", "ic_item01_4_05"});
        GoodsList.put("ic_item01_5", new String[]{"ic_item01_5_01", "ic_item01_5_02", "ic_item01_5_03",
                "ic_item01_5_04", "ic_item01_5_05"});

        /*水果系列分类（5类），每个产品又10个产品*/
        GoodsList.put("ic_item02_1", new String[]{"ic_item02_1_01", "ic_item02_1_02", "ic_item02_1_03",
                "ic_item02_1_04", "ic_item02_1_05", "ic_item02_1_06", "ic_item02_1_07", "ic_item02_1_08"});
        GoodsList.put("ic_item02_2", new String[]{"ic_item02_2_01", "ic_item02_2_02", "ic_item02_2_03",
                "ic_item02_2_04", "ic_item02_2_05"});
        GoodsList.put("ic_item02_3", new String[]{"ic_item02_3_01", "ic_item02_3_02", "ic_item02_3_03",
                "ic_item02_3_04", "ic_item02_3_05"});
        GoodsList.put("ic_item02_4", new String[]{"ic_item02_4_01", "ic_item02_4_02", "ic_item02_4_03",
                "ic_item02_4_04", "ic_item02_4_05"});
        GoodsList.put("ic_item02_5", new String[]{"ic_item02_5_01", "ic_item02_5_02", "ic_item02_5_03",
                "ic_item02_5_04", "ic_item02_5_05"});

        /*新鲜蔬菜系列*/
        ProductData.put("ic_item01_1_01", new Object[]{"胡萝卜", 4.0f,
                new int[]{R.mipmap.ic_item01_1_01, R.mipmap.ic_item01_1_01_01,
                        R.mipmap.ic_item01_1_01_02, R.mipmap.ic_item01_1_01_03}});
        ProductData.put("ic_item01_1_02", new Object[]{"番茄", 7.6f,
                new int[]{R.mipmap.ic_item01_1_02, R.mipmap.ic_item01_1_02_01,
                        R.mipmap.ic_item01_1_02_02, R.mipmap.ic_item01_1_02_03, R.mipmap.ic_item01_1_02_04}});
        ProductData.put("ic_item01_1_03", new Object[]{"白菜", 4.5f,
                new int[]{R.mipmap.ic_item01_1_03, R.mipmap.ic_item01_1_03_01,
                        R.mipmap.ic_item01_1_03_02, R.mipmap.ic_item01_1_03_03, R.mipmap.ic_item01_1_03_04}});
        ProductData.put("ic_item01_1_04", new Object[]{"竹笋", 10.5f,
                new int[]{R.mipmap.ic_item01_1_04, R.mipmap.ic_item01_1_04_01,
                        R.mipmap.ic_item01_1_04_02, R.mipmap.ic_item01_1_04_03, R.mipmap.ic_item01_1_04_04}});
        ProductData.put("ic_item01_1_05", new Object[]{"竹笋", 9.5f,
                new int[]{R.mipmap.ic_item01_1_05, R.mipmap.ic_item01_1_05_01,
                        R.mipmap.ic_item01_1_05_02, R.mipmap.ic_item01_1_05_03}});
        ProductData.put("ic_item01_1_06", new Object[]{"山药", 8.0f,
                new int[]{R.mipmap.ic_item01_1_06, R.mipmap.ic_item01_1_06_01,
                        R.mipmap.ic_item01_1_06_02, R.mipmap.ic_item01_1_06_03, R.mipmap.ic_item01_1_06_04}});
        ProductData.put("ic_item01_1_07", new Object[]{"黄瓜", 4.5f,
                new int[]{R.mipmap.ic_item01_1_07, R.mipmap.ic_item01_1_07_01,
                        R.mipmap.ic_item01_1_07_02, R.mipmap.ic_item01_1_07_03, R.mipmap.ic_item01_1_07_04}});
        ProductData.put("ic_item01_1_08", new Object[]{"菠菜", 5.5f,
                new int[]{R.mipmap.ic_item01_1_08, R.mipmap.ic_item01_1_08_01,
                        R.mipmap.ic_item01_1_08_02, R.mipmap.ic_item01_1_08_03, R.mipmap.ic_item01_1_08_04}});
        ProductData.put("ic_item01_1_09", new Object[]{"黄南瓜", 3.5f,
                new int[]{R.mipmap.ic_item01_1_09, R.mipmap.ic_item01_1_09_01,
                        R.mipmap.ic_item01_1_09_02, R.mipmap.ic_item01_1_09_03, R.mipmap.ic_item01_1_09_04}});

        /*进口蔬菜*/
        ProductData.put("ic_item01_2_01", new Object[]{"胡萝卜", 4.0f,
                new int[]{R.mipmap.ic_item01_2_01, R.mipmap.ic_item01_2_01_01,
                        R.mipmap.ic_item01_2_01_02, R.mipmap.ic_item01_2_01_03, R.mipmap.ic_item01_2_01_04}});
        ProductData.put("ic_item01_2_02", new Object[]{"蚕豆", 7.5f,
                new int[]{R.mipmap.ic_item01_2_02, R.mipmap.ic_item01_2_02_01,
                        R.mipmap.ic_item01_2_02_02, R.mipmap.ic_item01_2_02_03}});
        ProductData.put("ic_item01_2_03", new Object[]{"银耳", 7.5f,
                new int[]{R.mipmap.ic_item01_2_03, R.mipmap.ic_item01_2_03_01,
                        R.mipmap.ic_item01_2_03_02, R.mipmap.ic_item01_2_03_03}});
        ProductData.put("ic_item01_2_04", new Object[]{"茄子", 6.5f,
                new int[]{R.mipmap.ic_item01_2_04, R.mipmap.ic_item01_2_04_01,
                        R.mipmap.ic_item01_2_04_02, R.mipmap.ic_item01_2_04_03}});
        ProductData.put("ic_item01_2_05", new Object[]{"茄子", 6.5f,
                new int[]{R.mipmap.ic_item01_2_05, R.mipmap.ic_item01_2_05_01,
                        R.mipmap.ic_item01_2_05_02, R.mipmap.ic_item01_2_05_03}});
        ProductData.put("ic_item01_2_06", new Object[]{"蒜苗", 9.5f,
                new int[]{R.mipmap.ic_item01_2_06, R.mipmap.ic_item01_2_06_01,
                        R.mipmap.ic_item01_2_06_02, R.mipmap.ic_item01_2_06_03, R.mipmap.ic_item01_2_06_04}});
        ProductData.put("ic_item01_2_07", new Object[]{"油菜", 7.5f,
                new int[]{R.mipmap.ic_item01_2_07, R.mipmap.ic_item01_2_07_01,
                        R.mipmap.ic_item01_2_07_02, R.mipmap.ic_item01_2_07_03}});
        ProductData.put("ic_item01_2_08", new Object[]{"辣椒", 10.5f,
                new int[]{R.mipmap.ic_item01_2_08, R.mipmap.ic_item01_2_08_01,
                        R.mipmap.ic_item01_2_08_02, R.mipmap.ic_item01_2_08_03, R.mipmap.ic_item01_2_08_04}});
        /*本地蔬菜*/
        ProductData.put("ic_item01_3_01", new Object[]{"芋头", 3.7f,
                new int[]{R.mipmap.ic_item01_3_01, R.mipmap.ic_item01_3_01_01,
                        R.mipmap.ic_item01_3_01_02, R.mipmap.ic_item01_3_01_03}});
        ProductData.put("ic_item01_3_02", new Object[]{"豆薯", 7.5f,
                new int[]{R.mipmap.ic_item01_3_02, R.mipmap.ic_item01_3_02_01,
                        R.mipmap.ic_item01_3_02_02, R.mipmap.ic_item01_3_02_03}});
        ProductData.put("ic_item01_3_03", new Object[]{"胡瓜", 8.5f,
                new int[]{R.mipmap.ic_item01_3_03, R.mipmap.ic_item01_3_03_01,
                        R.mipmap.ic_item01_3_03_02, R.mipmap.ic_item01_3_03_03, R.mipmap.ic_item01_3_03_04}});
        ProductData.put("ic_item01_3_04", new Object[]{"牛蒡", 12.5f,
                new int[]{R.mipmap.ic_item01_3_04, R.mipmap.ic_item01_3_04_01,
                        R.mipmap.ic_item01_3_04_02, R.mipmap.ic_item01_3_04_03}});
        ProductData.put("ic_item01_3_05", new Object[]{"慈姑", 14.5f,
                new int[]{R.mipmap.ic_item01_3_05, R.mipmap.ic_item01_3_05_01,
                        R.mipmap.ic_item01_3_05_02, R.mipmap.ic_item01_3_05_03}});

        /*高级蔬菜*/
        ProductData.put("ic_item01_4_01", new Object[]{"紫包菜", 10.5f,
                new int[]{R.mipmap.ic_item01_4_01, R.mipmap.ic_item01_4_01_01,
                        R.mipmap.ic_item01_4_01_02, R.mipmap.ic_item01_4_01_03}});
        ProductData.put("ic_item01_4_02", new Object[]{"凤尾菇", 7.5f,
                new int[]{R.mipmap.ic_item01_4_02, R.mipmap.ic_item01_4_02_01,
                        R.mipmap.ic_item01_4_02_02, R.mipmap.ic_item01_4_02_03}});
        ProductData.put("ic_item01_4_03", new Object[]{"龙须菜", 8.5f,
                new int[]{R.mipmap.ic_item01_4_03, R.mipmap.ic_item01_4_03_01,
                        R.mipmap.ic_item01_4_03_02, R.mipmap.ic_item01_4_03_03}});
        ProductData.put("ic_item01_4_04", new Object[]{"金针菜", 6.5f,
                new int[]{R.mipmap.ic_item01_4_04, R.mipmap.ic_item01_4_04_01,
                        R.mipmap.ic_item01_4_04_02, R.mipmap.ic_item01_4_04_03}});
        ProductData.put("ic_item01_4_05", new Object[]{"佛手瓜", 13.5f,
                new int[]{R.mipmap.ic_item01_4_05, R.mipmap.ic_item01_4_05_01,
                        R.mipmap.ic_item01_4_05_02, R.mipmap.ic_item01_4_05_03}});

        /*海南蔬菜*/
        ProductData.put("ic_item01_5_01", new Object[]{"黄豆芽", 3.5f,
                new int[]{R.mipmap.ic_item01_5_01, R.mipmap.ic_item01_5_01_01,
                        R.mipmap.ic_item01_5_01_02, R.mipmap.ic_item01_5_01_03}});
        ProductData.put("ic_item01_5_02", new Object[]{"木耳叶", 5.5f,
                new int[]{R.mipmap.ic_item01_5_02, R.mipmap.ic_item01_5_02_01,
                        R.mipmap.ic_item01_5_02_02, R.mipmap.ic_item01_5_02_03}});
        ProductData.put("ic_item01_5_03", new Object[]{"人参蔡", 6.5f,
                new int[]{R.mipmap.ic_item01_5_03, R.mipmap.ic_item01_5_03_01,
                        R.mipmap.ic_item01_5_03_02, R.mipmap.ic_item01_5_03_03}});
        ProductData.put("ic_item01_5_04", new Object[]{"紫菜蔓", 10.5f,
                new int[]{R.mipmap.ic_item01_5_04, R.mipmap.ic_item01_5_04_01,
                        R.mipmap.ic_item01_5_04_02, R.mipmap.ic_item01_5_04_03}});
        ProductData.put("ic_item01_5_05", new Object[]{"猴头菇", 11.5f,
                new int[]{R.mipmap.ic_item01_5_05, R.mipmap.ic_item01_5_05_01,
                        R.mipmap.ic_item01_5_05_02, R.mipmap.ic_item01_5_05_03}});


        /*春季水果*/
        ProductData.put("ic_item02_1_01", new Object[]{"葡萄", 15.0f,
                new int[]{R.mipmap.ic_item02_1_01, R.mipmap.ic_item02_1_01_01,
                        R.mipmap.ic_item02_1_01_02, R.mipmap.ic_item02_1_01_03, R.mipmap.ic_item02_1_01_04}});
        ProductData.put("ic_item02_1_02", new Object[]{"苹果", 7.0f,
                new int[]{R.mipmap.ic_item02_1_02, R.mipmap.ic_item02_1_02_01,
                        R.mipmap.ic_item02_1_02_02, R.mipmap.ic_item02_1_02_03, R.mipmap.ic_item02_1_02_04}});
        ProductData.put("ic_item02_1_03", new Object[]{"火龙果", 11.5f,
                new int[]{R.mipmap.ic_item02_1_03, R.mipmap.ic_item02_1_03_01,
                        R.mipmap.ic_item02_1_03_02, R.mipmap.ic_item02_1_03_03, R.mipmap.ic_item02_1_03_04}});
        ProductData.put("ic_item02_1_04", new Object[]{"人参果", 12.5f,
                new int[]{R.mipmap.ic_item02_1_04, R.mipmap.ic_item02_1_04_01,
                        R.mipmap.ic_item02_1_04_02, R.mipmap.ic_item02_1_04_03}});
        ProductData.put("ic_item02_1_05", new Object[]{"榴莲", 14.8f,
                new int[]{R.mipmap.ic_item02_1_05, R.mipmap.ic_item02_1_05_01,
                        R.mipmap.ic_item02_1_05_02, R.mipmap.ic_item02_1_05_03}});
        ProductData.put("ic_item02_1_06", new Object[]{"石榴", 13.5f,
                new int[]{R.mipmap.ic_item02_1_06, R.mipmap.ic_item02_1_06_01,
                        R.mipmap.ic_item02_1_06_02, R.mipmap.ic_item02_1_06_03}});
        ProductData.put("ic_item02_1_07", new Object[]{"西瓜", 5.5f,
                new int[]{R.mipmap.ic_item02_1_07, R.mipmap.ic_item02_1_07_01,
                        R.mipmap.ic_item02_1_07_02, R.mipmap.ic_item02_1_07_03}});
        ProductData.put("ic_item02_1_08", new Object[]{"百香果", 9.5f,
                new int[]{R.mipmap.ic_item02_1_08, R.mipmap.ic_item02_1_08_01,
                        R.mipmap.ic_item02_1_08_02, R.mipmap.ic_item02_1_08_03}});

        /*夏季水果*/
        ProductData.put("ic_item02_2_01", new Object[]{"桂圆", 15.0f,
                new int[]{R.mipmap.ic_item02_2_01, R.mipmap.ic_item02_2_01_01,
                        R.mipmap.ic_item02_2_01_02, R.mipmap.ic_item02_2_01_03}});
        ProductData.put("ic_item02_2_02", new Object[]{"李子", 7.5f,
                new int[]{R.mipmap.ic_item02_2_02, R.mipmap.ic_item02_2_02_01,
                        R.mipmap.ic_item02_2_02_02, R.mipmap.ic_item02_2_02_03}});
        ProductData.put("ic_item02_2_03", new Object[]{"菠萝", 11.5f,
                new int[]{R.mipmap.ic_item02_2_03, R.mipmap.ic_item02_2_03_01,
                        R.mipmap.ic_item02_2_03_02, R.mipmap.ic_item02_2_03_03}});
        ProductData.put("ic_item02_2_04", new Object[]{"杨梅", 19.5f,
                new int[]{R.mipmap.ic_item02_2_04, R.mipmap.ic_item02_2_04_01,
                        R.mipmap.ic_item02_2_04_02, R.mipmap.ic_item02_2_04_03}});
        ProductData.put("ic_item02_2_05", new Object[]{"柚子", 8.5f,
                new int[]{R.mipmap.ic_item02_2_05, R.mipmap.ic_item02_2_05_01,
                        R.mipmap.ic_item02_2_05_02, R.mipmap.ic_item02_2_05_03}});

        /*秋季水果*/
        ProductData.put("ic_item02_3_01", new Object[]{"无花果", 17.6f,
                new int[]{R.mipmap.ic_item02_3_01, R.mipmap.ic_item02_3_01_01,
                        R.mipmap.ic_item02_3_01_02, R.mipmap.ic_item02_3_01_03}});
        ProductData.put("ic_item02_3_02", new Object[]{"哈密瓜", 11.4f,
                new int[]{R.mipmap.ic_item02_3_02, R.mipmap.ic_item02_3_02_01,
                        R.mipmap.ic_item02_3_02_02, R.mipmap.ic_item02_3_02_03}});
        ProductData.put("ic_item02_3_03", new Object[]{"樱桃", 15.0f,
                new int[]{R.mipmap.ic_item02_3_03, R.mipmap.ic_item02_3_03_01,
                        R.mipmap.ic_item02_3_03_02, R.mipmap.ic_item02_3_03_03}});
        ProductData.put("ic_item02_3_04", new Object[]{"蛋黄果", 13.5f,
                new int[]{R.mipmap.ic_item02_3_04, R.mipmap.ic_item02_3_04_01,
                        R.mipmap.ic_item02_3_04_02, R.mipmap.ic_item02_3_04_03}});
        ProductData.put("ic_item02_3_05", new Object[]{"椰子", 10.5f,
                new int[]{R.mipmap.ic_item02_3_05, R.mipmap.ic_item02_3_05_01,
                        R.mipmap.ic_item02_3_05_02, R.mipmap.ic_item02_3_05_03}});

        /*冬季水果*/
        ProductData.put("ic_item02_4_01", new Object[]{"山楂", 7.8f,
                new int[]{R.mipmap.ic_item02_4_01, R.mipmap.ic_item02_4_01_01,
                        R.mipmap.ic_item02_4_01_02, R.mipmap.ic_item02_4_01_03}});
        ProductData.put("ic_item02_4_02", new Object[]{"云莓", 9.6f,
                new int[]{R.mipmap.ic_item02_4_02, R.mipmap.ic_item02_4_02_01,
                        R.mipmap.ic_item02_4_02_02, R.mipmap.ic_item02_4_02_03}});
        ProductData.put("ic_item02_4_03", new Object[]{"柿子", 11.0f,
                new int[]{R.mipmap.ic_item02_4_03, R.mipmap.ic_item02_4_03_01,
                        R.mipmap.ic_item02_4_03_02, R.mipmap.ic_item02_4_03_03}});
        ProductData.put("ic_item02_4_04", new Object[]{"白兰瓜", 9.5f,
                new int[]{R.mipmap.ic_item02_4_04, R.mipmap.ic_item02_4_04_01,
                        R.mipmap.ic_item02_4_04_02, R.mipmap.ic_item02_4_04_03}});
        ProductData.put("ic_item02_4_05", new Object[]{"乌饭果", 14.5f,
                new int[]{R.mipmap.ic_item02_4_05, R.mipmap.ic_item02_4_05_01,
                        R.mipmap.ic_item02_4_05_02, R.mipmap.ic_item02_4_05_03}});

        /*反季水果*/
        ProductData.put("ic_item02_5_01", new Object[]{"沙棘", 12.5f,
                new int[]{R.mipmap.ic_item02_5_01, R.mipmap.ic_item02_5_01_01,
                        R.mipmap.ic_item02_5_01_02, R.mipmap.ic_item02_5_01_03}});
        ProductData.put("ic_item02_5_02", new Object[]{"余甘子", 13.7f,
                new int[]{R.mipmap.ic_item02_5_02, R.mipmap.ic_item02_5_02_01,
                        R.mipmap.ic_item02_5_02_02, R.mipmap.ic_item02_5_02_03}});
        ProductData.put("ic_item02_5_03", new Object[]{"黑老虎", 15.5f,
                new int[]{R.mipmap.ic_item02_5_03, R.mipmap.ic_item02_5_03_01,
                        R.mipmap.ic_item02_5_03_02, R.mipmap.ic_item02_5_03_03}});
        ProductData.put("ic_item02_5_04", new Object[]{"神秘果", 13.5f,
                new int[]{R.mipmap.ic_item02_5_04, R.mipmap.ic_item02_5_04_01,
                        R.mipmap.ic_item02_5_04_02, R.mipmap.ic_item02_5_04_03}});
        ProductData.put("ic_item02_5_05", new Object[]{"猫屎瓜", 18.5f,
                new int[]{R.mipmap.ic_item02_5_05, R.mipmap.ic_item02_5_05_01,
                        R.mipmap.ic_item02_5_05_02, R.mipmap.ic_item02_5_05_03}});

    }

    public Object getInfo(String type) {
        return ProductData.get(type);
    }

    public String[] getGoods(String type) {
        return GoodsList.get(type);
    }

    public float getInitMoney() {
        return initMoney;
    }

    public float setInitMoney(float money) {
        return initMoney = money;
    }

    public void addSelectGoods(String type, int num) {
        selectData.put(type, num);
    }

    public Map<String, Integer> getSelectData() {
        return selectData;
    }

    public void removeSelectGoods(String type) {
        selectData.remove(type);
    }

    public void clearSelectGoods() {
        selectData.clear();
    }


    public static float formatNumber(double d) {
        String dd = String.valueOf(d);
        BigDecimal bigDecimal = new BigDecimal(dd);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }
}
