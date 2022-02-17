package com.company;

public class Profile {

private String name;
private String hairStyle;
private String hairColor;
private String eyeColor;
private String gender;
private String isAvailable;

//Constructor
    public Profile(){
        this.name=name;
        this.hairStyle=hairStyle;
        this.hairColor=hairColor;
        this.eyeColor=eyeColor;
        this.gender=gender;
        this.isAvailable=isAvailable;
    }
    public String printProfile(){
        return ("Available? "+isAvailable+" Name: "+name+",  Hair Style: "+hairStyle+",  Hair Color: "+hairColor+",  Eye Color: "+eyeColor
        +",  Gender: "+gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHairStyle() {
        return hairStyle;
    }

    public void setHairStyle(String hairStyle) {
        this.hairStyle = hairStyle;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
}
