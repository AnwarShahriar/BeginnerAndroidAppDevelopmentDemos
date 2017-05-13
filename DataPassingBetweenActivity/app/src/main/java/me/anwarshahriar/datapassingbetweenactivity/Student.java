package me.anwarshahriar.datapassingbetweenactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String name;

    public Student() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    public static final Parcelable.Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public Student(Parcel in) {
        name = in.readString();
    }
}
