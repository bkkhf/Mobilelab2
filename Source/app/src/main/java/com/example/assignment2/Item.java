package com.example.assignment2;

public class Item {

    String birdListName;
    int birdListImage;
    public String color;

    public Item(String birdName,int birdImage, String c )
    {
        this.birdListImage=birdImage;
        this.birdListName=birdName;
        color=c;
    }
    public String getbirdName()
    {
        return birdListName;
    }
    public int getbirdImage()
    {
        return birdListImage;
    }

}