package me.anwarshahriar.datapassingbetweenactivity;

import org.parceler.Parcel;

@Parcel
public class Student {
    private String name;

    public Student() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
