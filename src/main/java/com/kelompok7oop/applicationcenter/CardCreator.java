package com.kelompok7oop.applicationcenter;
public class CardCreator
{
    public static CardView createCard(Category category, String appName, String filePath, String iconPath){
        switch (category) {
            case COMMUNICATION:
                return new CommunicationCard(appName, filePath, iconPath);
            case ENTERTAINMENT:
                return new EntertainmentCard(appName, filePath, iconPath);
            case PRODUCTIVITY:
                return new ProductivityCard(appName, filePath, iconPath);
            case UTILITIES:
                return new UtilitiesCard(appName, filePath, iconPath);
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }
}
