package com.kelompok7oop.applicationcenter;
import com.kelompok7oop.applicationcenter.CardView;

public class UtilitiesCard extends CardView
{
    public UtilitiesCard(String appName, String filePath, String iconPath) {
        super(appName, filePath, iconPath);
    }

    @Override
    public String toCSVString() {
        return "Utilities," + appName + "," + filePath+","+iconPath;
    }

    @Override
    public String toString() {
        return "Utilities [" + super.toString() + "]\n";
    }
}
