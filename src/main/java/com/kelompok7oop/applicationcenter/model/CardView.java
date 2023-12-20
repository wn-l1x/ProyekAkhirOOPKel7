package com.kelompok7oop.applicationcenter.model;

public abstract class CardView
{
    public String appName;
    public String filePath;
    public String iconPath;

    public CardView(String appName, String filePath, String iconPath){
        this.appName = appName;
        this.filePath = filePath;
        this.iconPath = iconPath;
    }

    public abstract String toCSVString();

    public static CardView parseCSVString(String csvString) {
        String[] values = csvString.split(",");
        String category = values[0].trim();

        switch (category) {
            case "Communication":
                return new CommunicationCard(values[1].trim(), values[2].trim(), values[3].trim());
            case "Entertainment":
                return new EntertainmentCard(values[1].trim(), values[2].trim(), values[3].trim());
            case "Productivity":
                return new ProductivityCard(values[1].trim(), values[2].trim(), values[3].trim());
            case "Utilities":
                return new UtilitiesCard(values[1].trim(), values[2].trim(), values[3].trim());
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }
    @Override
    public String toString() {
        return appName + "," + filePath +","+iconPath;
    }
}
