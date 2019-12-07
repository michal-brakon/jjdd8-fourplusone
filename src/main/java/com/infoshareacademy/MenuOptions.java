package com.infoshareacademy;

public class MenuOptions {

    private String displayedText;
    private int position;
    private int parent;

    public void setDisplayedText(String displayedText) {
        this.displayedText = displayedText;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getParent() {
        return parent;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public MenuOptions(String displayedText, int position, int parent) {
        this.displayedText = displayedText;
        this.position = position;
        this.parent = parent;
    }

    public int getPosition() {
        return position;
    }

    public String getDisplayedText() {
        return displayedText;
    }

    @Override
    public String toString() {
        return "MenuOptions{" +
                "displayedText='" + displayedText + '\'' +
                ", position=" + position +
                ", parent=" + parent +
                '}';
    }
}


