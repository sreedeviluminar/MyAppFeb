package com.sree.myappfeb.basic;

public class Versions {

    public String version;
    boolean isSelected = true;

    public Versions(String version) {

        this.version = version;
    }
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}