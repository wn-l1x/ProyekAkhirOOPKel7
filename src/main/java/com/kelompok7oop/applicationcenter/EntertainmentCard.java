package com.kelompok7oop.applicationcenter;
public class EntertainmentCard extends CardView
{
    public EntertainmentCard(String appName, String filePath, String iconPath) {
        super(appName, filePath, iconPath);
    }

    @Override
    public String toCSVString() {
        return "Entertainment," + appName + "," + filePath+","+iconPath;
    }

    
    @Override
    public String toString() {
        return "Entertainment [" + super.toString() + "]\n";
    }
}
