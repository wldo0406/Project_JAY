package com.example.project_jay;

import java.util.ArrayList;

/**
 * Created by jyheo on 2016-07-22.
 * source: https://guides.codepath.com/android/using-the-recyclerview
 */

public class Contact {
    private String mName;
    private boolean mOnline;


    public Contact(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList1(int numContacts) {
        ArrayList<Contact> contacts1 = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts1.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts1;
    }

    public static ArrayList<Contact> createContactsList2(int numContacts) {
        ArrayList<Contact> contacts2 = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts2.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts2;
    }

    public static ArrayList<Contact> createContactsList3(int numContacts) {
        ArrayList<Contact> contacts3 = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts3.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts3;
    }



}
