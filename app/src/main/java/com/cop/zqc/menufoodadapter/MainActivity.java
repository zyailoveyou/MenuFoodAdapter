package com.cop.zqc.menufoodadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView foodproduce;
    public ArrayList<String> MainFoodMainTaste;
    public ArrayList<String> MainFoodSupportMiddle;
    public ArrayList<String> SideDishFoodMainTaste;
    public ArrayList<String> SideDishFoodSupportMiddle;
    public ArrayList<String> SoupFoodMainTaste;
    public ArrayList<String> SoupFoodSupportMiddle;
    public ArrayList<String> CoodFoodMainTaste;
    public ArrayList<String> CoodSupportMiddle;


    private CatagoryFoodData mMainFood;
    private CatagoryFoodData mSideDishFood;
    private CatagoryFoodData mSoupFood;
    private ArrayList<CatagoryFoodData> mCatagoryFoodDataCollection;
    private FoodDataStore mFoodDataStore;
    private CatagoryFoodData[] mMCatagoryFoodDataCollectionStore;
    private Myfoodadapter mMyfoodadapter;


    String[] MainFoodMainTastelist = new String[]{

            "肉沫茄子","芋儿烧鸡","鱼香肉丝","土豆烧牛肉","泡椒炒猪肝","芹菜炒鸡杂","土豆烧排骨","梭边鱼","萝卜烧牛肉","魔芋烧鸭","粉蒸牛肉","土豆烧肘子","胡萝卜烧肘子","苦瓜烧肉","干锅"
    };


    String[] MainFoodSupportMiddlelist = new String[]{

            "青椒肉丝","芹菜炒牛肉","西南花炒鸡丁","莴笋肉片","仔姜肉丝","黄瓜肉片","莴笋肉片","京酱肉丝","腊肉炒花菜","芹菜肉丝"

    };

    String[] SideDishFoodMainTastelist = new String[]{

            "蒸蛋","娃娃菜粉丝","锅巴土豆","玉米蔬菜丁丁","肉沫豌豆","熊掌豆腐","碎肉豇豆"
    };

    String[] SideDishFoodSupportMiddlelist = new String[]{

            "西湖肉片","韭菜鸡蛋饼","炒瓢儿白菜	","炒生菜","豆芽炒胡萝卜","苦瓜炒蛋","干煸四季豆","炒凤尾","炒莲白","青椒土豆丝","家常豆腐"

    };

    String[] SoupFoodMainTastelist = new String[]{

            "酸菜粉丝汤","棒子骨玉米汤","鲫鱼汤","棒子骨萝卜","酸萝卜老鸭汤","海带炖鸭子","香菇炖鸡","海带炖排骨"

    };

    String[] SoupFoodSupportMiddlelist = new String[]{

            "紫菜蛋花汤","白菜豆腐汤","海带豆芽汤","番茄蛋汤","黄瓜皮蛋汤"

    };


    String[] CoodFoodMainTastelist = new String[]{

            "凉拌金针菇","凉拌黒木耳","凉拌莴笋+胡萝卜","凉拌折耳根","凉拌萝卜丝"

    };

    String[] CoodSupportMiddlelist = new String[]{

            "凉拌三丝","凉拌海带丝","凉拌花菜"


    };
    private CatagoryFoodData mCoodFood;
    private Button mCreateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodproduce);
        foodproduce = findViewById(R.id.Listfood);


        MainFoodMainTaste =new ArrayList<String>();
        MainFoodSupportMiddle=new ArrayList<String>();
        SideDishFoodMainTaste=new ArrayList<String>();
        SideDishFoodSupportMiddle=new ArrayList<String>();
        SoupFoodMainTaste=new ArrayList<String>();
        SoupFoodSupportMiddle=new ArrayList<String>();
        CoodFoodMainTaste = new ArrayList<String>();
        CoodSupportMiddle = new ArrayList<String>();


        mCatagoryFoodDataCollection= new ArrayList<CatagoryFoodData>();



        for (int i = 0; i < MainFoodMainTastelist.length; i++) {
            MainFoodMainTaste.add(MainFoodMainTastelist[i]);
        }


        for (int i = 0; i < MainFoodSupportMiddlelist.length; i++) {
            MainFoodSupportMiddle.add(MainFoodSupportMiddlelist[i]);
        }


        for (int i = 0; i < SideDishFoodMainTastelist.length; i++) {
            SideDishFoodMainTaste.add(SideDishFoodMainTastelist[i]);
        }


        for (int i = 0; i < SideDishFoodSupportMiddlelist.length; i++) {
            SideDishFoodSupportMiddle.add(SideDishFoodSupportMiddlelist[i]);
        }


        for (int i = 0; i < SoupFoodMainTastelist.length; i++) {
            SoupFoodMainTaste.add(SoupFoodMainTastelist[i]);
        }


        for (int i = 0; i < SoupFoodSupportMiddlelist.length; i++) {
            SoupFoodSupportMiddle.add(SoupFoodSupportMiddlelist[i]);
        }


        for (int i = 0; i < CoodFoodMainTastelist.length; i++) {
            CoodFoodMainTaste.add(CoodFoodMainTastelist[i]);
        }


        for (int i = 0; i < CoodSupportMiddlelist.length; i++) {
            CoodSupportMiddle.add(CoodSupportMiddlelist[i]);
        }


        mMainFood = new CatagoryFoodData(MainFoodMainTaste,MainFoodSupportMiddle,"主食","主味","中味");
        mSideDishFood = new CatagoryFoodData(SideDishFoodMainTaste,SideDishFoodSupportMiddle,"副食","主味","中味");
        mSoupFood = new CatagoryFoodData(SoupFoodMainTaste,SoupFoodSupportMiddle,"汤菜","浓汤","清汤");
        mCoodFood = new CatagoryFoodData(CoodFoodMainTaste,CoodSupportMiddle,"凉菜","开胃","中性");


        mMCatagoryFoodDataCollectionStore = new CatagoryFoodData[]{mMainFood,mSideDishFood,mSoupFood,mCoodFood};


        for (int i = 0; i < mMCatagoryFoodDataCollectionStore.length; i++) {

            mCatagoryFoodDataCollection.add(mMCatagoryFoodDataCollectionStore[i]);

        }

        mFoodDataStore = new FoodDataStore(mCatagoryFoodDataCollection);

        mMyfoodadapter = new Myfoodadapter(mFoodDataStore,this);

        foodproduce.setAdapter(mMyfoodadapter);

        mCreateButton = findViewById(R.id.Create);

        mCreateButton.setOnClickListener(mMyfoodadapter);
    }
}
