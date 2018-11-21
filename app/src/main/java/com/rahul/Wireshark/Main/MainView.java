/***************************************************************************************
 Title: Login and Sigup with local DB configuration in android
 Author: Anbarasi1993
 Date: 2016
 Type: Source Code
 Availability: https://github.com/Anbarasi1993/LoginSignupAppZoho

 ***************************************************************************************/


package com.rahul.Wireshark.Main;

import android.content.Context;

/**
 * Created by USER on 28-09-2016.
 */

public interface MainView {

    void SetTextName(String Name, String Email, String Mobile);

    Context getApplicationContext();
}
