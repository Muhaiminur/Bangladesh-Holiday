package com.bangladesh_holiday.bangladeshholiday;

public class IMAGE_LOCATION {
    String name;
    Integer loc;

    public IMAGE_LOCATION(String name, Integer loc) {
        this.name = name;
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLoc() {
        return loc;
    }

    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "IMAGE_LOCATION{" +
                "name='" + name + '\'' +
                ", loc=" + loc +
                '}';
    }
}
