package com.sree.myappfeb.basic;

public class Item {

   private String iconListName;
   private int iconListImage;

    public Item(String iconName,int iconImage)
    {
        this.iconListImage=iconImage;
        this.iconListName=iconName;
    }

    public int getIconListImage() {

        return iconListImage;
    }

    public String getIconListName() {

        return iconListName;
    }
}