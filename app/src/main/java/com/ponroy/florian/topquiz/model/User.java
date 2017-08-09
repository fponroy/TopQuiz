package com.ponroy.florian.topquiz.model;

/**
 * Created by Florian PONROY - OpenClassrooms on 09/08/17.
 */

public class User {
    private String mFirstname;

    public String getFirstname() {
        return mFirstname;
    }

    public void setFirstname(String firstname) {
        mFirstname = firstname;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFirstname='" + mFirstname + '\'' +
                '}';
    }
}
