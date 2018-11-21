/***************************************************************************************
 Title: Login and Sigup with local DB configuration in android
 Author: Anbarasi1993
 Date: 2016
 Type: Source Code
 Availability: https://github.com/Anbarasi1993/LoginSignupAppZoho

 ***************************************************************************************/

package com.rahul.Wireshark.LoginSignup;

/**
 * Created by USER on 26-09-2016.
 */

public interface LoginPresenter {

    void Checkuserlogincredentials(String Email, String Password);

    void createuserAccount(String Name, String Eamil,String password, String MobileNumber);

    void onDestroy();
}
