package com.example.psingh.sohaapp;

import java.util.Date;

/**
 * Created by psingh on 6/7/15.
 */
public class PregnantData {

    public static final String TABLE = "PregnantInputData";

    // Labels Table Columns names
    public static  final String KEY_ID = "ID";
    public static final String KEY_phoneNumber = "phoneNumber";
    public static final String KEY_name = "name";
    public static final String KEY_email = "email";
    //we should validate the password
    public static final String KEY_passWord = "passWord";

    public static final String KEY_currentDate = "currentDate" ;
    public static final String KEY_edDate = "edDate" ;

    public int id;
    public int phoneNumber;
    public String name;
    public String eMail;
    public String passWord;
    //edd is Expected Date of delivery
    public static Date edDate;
    //current date is registration date
    public  static Date currentDate;


}
