package com.kelompok7oop.applicationcenter.model;
public class CommunicationCard extends CardView
{
    public CommunicationCard(String appName, String filePath, String iconPath) {
        super(appName, filePath, iconPath);
    }

    @Override
    public String toCSVString() {
        return "Communication," + appName + "," + filePath+","+iconPath;
    }

    @Override
    public String toString() {
        return "Communication [" + super.toString() + "]\n";
    }
}
