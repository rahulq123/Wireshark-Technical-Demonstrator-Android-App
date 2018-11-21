/***************************************************************************************
 Title: Login and Sigup with local DB configuration in android
 Author: Anbarasi1993
 Date: 2016
 Type: Source Code
 Availability: https://github.com/Anbarasi1993/LoginSignupAppZoho

 ***************************************************************************************/


package com.rahul.Wireshark.Utils;

/**
 * Created by USER on 27-09-2016.
 */

public interface Constants {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WIRESHARKDB";

    /*=====================================Out skirts table fields ===============================================*/
    public static final String TABLE_USER = "user_master";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME= "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PHONE = "user_phone";
    public static final String USER_PASSWORD = "user_password";

}
