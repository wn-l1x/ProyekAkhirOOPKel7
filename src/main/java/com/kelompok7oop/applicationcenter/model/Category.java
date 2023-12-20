package com.kelompok7oop.applicationcenter.model;
public enum Category
{
    UTILITIES, PRODUCTIVITY, COMMUNICATION, ENTERTAINMENT,NO_CATEGORY;

    @Override
    public String toString() {
        switch (this.ordinal()){
            case 0 :
                return "Utilities";
            case 1 :
                return "Productivity";
            case 2 :
                return "Communication";
            case 3 :
                return "Entertainment";
            case 4 :
                return "All";
            default:
                return "";
        }
    }
}
