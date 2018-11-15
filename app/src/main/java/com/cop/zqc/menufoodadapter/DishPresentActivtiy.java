package com.cop.zqc.menufoodadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DishPresentActivtiy extends Activity {

    private ArrayList<String> mDishPresentList = new ArrayList<>();
    private ArrayList<TextView> mDishPresentTextViewList = new ArrayList<>();
    private TextView DishContentTextView1;
    private TextView DishContentTextView2;
    private TextView DishContentTextView3;
    private TextView DishContentTextView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishpresentlayout);

        DishContentTextView1=findViewById(R.id.dishpresnet1);
        DishContentTextView2=findViewById(R.id.dishpresnet2);
        DishContentTextView3=findViewById(R.id.dishpresnet3);
        DishContentTextView4=findViewById(R.id.dishpresnet4);


        mDishPresentList = new ArrayList<>();

        mDishPresentList = getIntent().getBundleExtra("DishPresnetList").getStringArrayList("DishPresentArrayList");


            mDishPresentTextViewList.add(DishContentTextView1);
            mDishPresentTextViewList.add(DishContentTextView2);
            mDishPresentTextViewList.add(DishContentTextView3);
            mDishPresentTextViewList.add(DishContentTextView4);

            for (int i = 0; i < mDishPresentList.size(); i++) {

                mDishPresentTextViewList.get(i).setText(mDishPresentList.get(i));

            }



    }
}
