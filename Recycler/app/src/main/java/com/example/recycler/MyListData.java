package com.example.recycler;

public class MyListData {
    private String Month_Name;
    private int Month_Id;
    private int ImageId;

    public MyListData(String month_Name, int month_Id, int imageId) {
        this.Month_Name = month_Name;
        this.Month_Id = month_Id;
        this.ImageId = imageId;
    }

    public String getMonth_Name() {
        return Month_Name;
    }

    public void setMonth_Name(String month_Name) {
        Month_Name = month_Name;
    }

    public int getMonth_Id() {
        return Month_Id;
    }

    public void setMonth_Id(int month_Id) {
        Month_Id = month_Id;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }
}
