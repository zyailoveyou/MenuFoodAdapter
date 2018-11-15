package com.cop.zqc.menufoodadapter;

import java.util.ArrayList;

public class CatagoryFoodData {

    private ArrayList<String> Maintaste;
    private ArrayList<String> SupportMiddle;
    private String Name;
    private String MainTasteName;
    private String MiddleTasteName;


    public CatagoryFoodData(ArrayList<String> maintaste, ArrayList<String> supportMiddle, String name, String mainTasteName, String middleTasteName) {
        Maintaste = maintaste;
        SupportMiddle = supportMiddle;
        Name = name;
        MainTasteName = mainTasteName;
        MiddleTasteName = middleTasteName;
    }

    public String getName() {
        return Name;
    }

    public String getMainTasteName() {
        return MainTasteName;
    }

    public String getMiddleTasteName() {
        return MiddleTasteName;
    }

    public ArrayList<String> getMaintaste() {
        return Maintaste;
    }

    public ArrayList<String> getSupportMiddle() {
        return SupportMiddle;
    }
}
