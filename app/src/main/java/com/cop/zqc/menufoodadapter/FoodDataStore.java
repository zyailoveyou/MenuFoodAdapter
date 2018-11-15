package com.cop.zqc.menufoodadapter;

import java.util.ArrayList;

public class FoodDataStore {

    private ArrayList<CatagoryFoodData> mCatagoryFoodDataStore;

    public FoodDataStore(ArrayList<CatagoryFoodData> foodDataStore) {
        mCatagoryFoodDataStore = foodDataStore;
    }

    public ArrayList<CatagoryFoodData> getmCatagoryFoodDataStore() {
        return mCatagoryFoodDataStore;
    }
}
