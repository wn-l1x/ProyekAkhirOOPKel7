package com.kelompok7oop.applicationcenter.model;

import com.kelompok7oop.applicationcenter.model.CardView;

public class ProductivityCard extends CardView
{

    public ProductivityCard(String appName, String filePath, String iconPath) {
        super(appName, filePath, iconPath);
    }

    @Override
    public String toCSVString() {
        return "Productivity," + appName + "," + filePath+","+iconPath;
    }

    @Override
    public String toString() {
        return "Productivity [" + super.toString() + "]\n";
    }
}
