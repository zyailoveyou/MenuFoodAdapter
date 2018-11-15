package com.cop.zqc.menufoodadapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Myfoodadapter extends BaseAdapter implements View.OnClickListener {

    private FoodDataStore mFoodDataStore;
    private Context mContext;
    private ArrayList<CheckBoxSave> CheckedMap =  new ArrayList<CheckBoxSave>();
    private CheckBoxSave mCheckBoxSaver;


    private class CheckBoxSave{

        public CheckBox MainTaste;
        public CheckBox SupportMiddle;
        public TextView FoodName;
        public boolean MainTasteIsChecked = false;
        public boolean SupportMiddleIsChecked = false;

    }



    public Myfoodadapter(FoodDataStore foodDataStore,Context context) {
        mFoodDataStore = foodDataStore;
        mContext = context;
    }


    @Override
    public int getCount() {
        return mFoodDataStore.getmCatagoryFoodDataStore().size();


    }

    @Override
    public Object getItem(int position) {
        return mFoodDataStore.getmCatagoryFoodDataStore().get(position);

    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        ConstraintLayout layoutfill;


        if (convertView == null) {

            mCheckBoxSaver = new CheckBoxSave();

            layoutfill=(ConstraintLayout)LayoutInflater.from(mContext).inflate(R.layout.foodfill,null);

            mCheckBoxSaver.FoodName = layoutfill.findViewById(R.id.FoodName);
            mCheckBoxSaver.MainTaste = layoutfill.findViewById(R.id.MainTasteName);
            mCheckBoxSaver.SupportMiddle = layoutfill.findViewById(R.id.SupportMiddleName);

            layoutfill.setTag(mCheckBoxSaver);

        }

        else {

            layoutfill=(ConstraintLayout) convertView;
            mCheckBoxSaver = (CheckBoxSave) layoutfill.getTag();

        }


        mCheckBoxSaver.FoodName.setText(mFoodDataStore.getmCatagoryFoodDataStore().get(position).getName());
        mCheckBoxSaver.MainTaste.setText(mFoodDataStore.getmCatagoryFoodDataStore().get(position).getMainTasteName());
        mCheckBoxSaver.SupportMiddle.setText(mFoodDataStore.getmCatagoryFoodDataStore().get(position).getMiddleTasteName());


            CheckedMap.add(mCheckBoxSaver);


        mCheckBoxSaver.MainTaste.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                System.out.println("111111");

                if(CheckedMap.get(position).MainTaste.isChecked())

                {
                    CheckedMap.get(position).MainTasteIsChecked = true;
                }

                else
                {
                    CheckedMap.get(position).MainTasteIsChecked = false;
                }

            }
        });


        mCheckBoxSaver.SupportMiddle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                System.out.println("22222");

                if(CheckedMap.get(position).SupportMiddle.isChecked())


                {
                    CheckedMap.get(position).SupportMiddleIsChecked = true;
                }

                else
                {
                    CheckedMap.get(position).SupportMiddleIsChecked = false;
                }

            }
        });


        return layoutfill;

    }




    @Override
    public void onClick(View v) {

        Random choices = new Random();
        Bundle DishPresentListBundle = new Bundle();
        ArrayList<String> DishPresentListString = new ArrayList<>();

        int choicepozitonMainTaste = -1;
        int choicepozitonMiddleSupport = -1;

        for (int i = 0; i < CheckedMap.size(); i++) {

            if(CheckedMap.get(i).MainTasteIsChecked)

            {

                choicepozitonMainTaste = choices.nextInt(mFoodDataStore.getmCatagoryFoodDataStore().get(i).getMaintaste().size());
               System.out.println(mFoodDataStore.getmCatagoryFoodDataStore().get(i).getMaintaste().get(choicepozitonMainTaste));
               DishPresentListString.add(mFoodDataStore.getmCatagoryFoodDataStore().get(i).getMaintaste().get(choicepozitonMainTaste));

            }

            if(CheckedMap.get(i).SupportMiddleIsChecked)
            {

                choicepozitonMiddleSupport = choices.nextInt(mFoodDataStore.getmCatagoryFoodDataStore().get(i).getSupportMiddle().size());
                System.out.println(mFoodDataStore.getmCatagoryFoodDataStore().get(i).getSupportMiddle().get(choicepozitonMiddleSupport));
                DishPresentListString.add(mFoodDataStore.getmCatagoryFoodDataStore().get(i).getSupportMiddle().get(choicepozitonMiddleSupport));
            }

        }

        Intent JumpToDishPrensentActivityIntent = new Intent(mContext,DishPresentActivtiy.class);

        DishPresentListBundle.putStringArrayList("DishPresentArrayList",DishPresentListString);

        JumpToDishPrensentActivityIntent.putExtra("DishPresnetList",DishPresentListBundle);

        mContext.startActivity(JumpToDishPrensentActivityIntent);


    }
}
