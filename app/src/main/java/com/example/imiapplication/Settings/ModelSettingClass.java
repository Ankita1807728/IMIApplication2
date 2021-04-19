package com.example.imiapplication.Settings;

public class ModelSettingClass {
    private int imageIcon;
    private String text;

    public ModelSettingClass(int imageIcon, String text) {
        this.imageIcon = imageIcon;
        this.text = text;
    }

    public int getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(int imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}