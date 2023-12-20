package com.kelompok7oop.applicationcenter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AppCenterModel {
    static List<CardView> appList = CSVHandler.readCSV("cards.csv");

    public void addAppList(CardView app){
        this.appList.add(app);
    }

    public void removeFromList(CardView app) {
        Iterator<CardView> iterator = appList.iterator();
        while (iterator.hasNext()) {
            CardView a = iterator.next();
            if (a.equals(app)) {
                iterator.remove();
            }
        }
    }
    public List<CardView> getAppList(){
        return appList;
    }
    public List<String> getName(List<CardView> cardList) {
        List<String> appNames = new ArrayList<String>();
        cardList.forEach(x -> appNames.add(x.appName));
        return appNames;
    }
    public List<String> getPath(List<CardView> cardList) {
        List<String> appPaths = new ArrayList<String>();
        cardList.forEach(x -> appPaths.add(x.filePath));
        return appPaths;
    }
    public List<String> getIcon(List<CardView> cardList){
        List<String> appIcons = new ArrayList<String>();
        cardList.forEach(x -> appIcons.add((x.iconPath)));
        return appIcons;
    }

    public List<CardView> filterList(Category category) {
        if (category.equals(Category.NO_CATEGORY)) {
            return appList;
        }
        return appList.stream()
                .filter(cardView -> {

                    if (cardView instanceof CommunicationCard && category == Category.COMMUNICATION) {
                        return true;
                    } else if (cardView instanceof EntertainmentCard && category == Category.ENTERTAINMENT) {
                        return true;
                    } else if (cardView instanceof ProductivityCard && category == Category.PRODUCTIVITY) {
                        return true;
                    } else return cardView instanceof UtilitiesCard && category == Category.UTILITIES;
                })
                .collect(Collectors.toList());
    }
}
