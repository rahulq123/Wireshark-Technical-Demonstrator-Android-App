/***************************************************************************************
 Title: Login and Sigup with local DB configuration in android
 Author: Anbarasi1993
 Date: 2016
 Type: Source Code
 Availability: https://github.com/Anbarasi1993/LoginSignupAppZoho

 ***************************************************************************************/


package com.rahul.Wireshark.LoginSignup;

import android.text.TextUtils;

import com.rahul.Wireshark.DatabaseHelper.Databasehelper;

import java.util.regex.Pattern;

/**
 * Created by USER on 26-09-2016.
 */

public class LoginPresenterModel implements LoginPresenter {

    private LoginView lv;
    Databasehelper db;


    public LoginPresenterModel(LoginView lv) {
        this.lv = lv;
    }

    public void Checkuserlogincredentials(String Email, String Password) {
        boolean error = false;
        if (lv != null) {

            if (TextUtils.isEmpty(Email)){
                lv.setEmailError();
                error = true;
            }

            if (TextUtils.isEmpty(Password)){
                lv.setPasswordError();
                error = true;
            }
            if (!error){
                db = new Databasehelper(lv.getApplicationContext());
                int sucess =  db.Check_login_account(Email,Password);
                if(sucess == 1) {
                    lv.onSuccess(Email,Password);
                }
                else
                {
                    lv.onFailure();
                }

            }
        }



    }

    public void createuserAccount(String Name, String Email,String password, String MobileNumber)
    {
        boolean error = false;
        if (lv != null) {

            if (TextUtils.isEmpty(Name)){
                lv.setRegNameError();
                error = true;
            }
            else
            {
                if(isAlphanumeric(Name))
                {
                    lv.setRegNameError();
                    error = true;
                }
                else
                {

                }
            }

            if (TextUtils.isEmpty(Email)){
                lv.setRegEmailError();
                error = true;
            }
            else
            {
                if(!isValidMail(Email))
                {
                    lv.setRegEmailError();
                    error = true;
                }
                else
                {

                }
            }
            if (TextUtils.isEmpty(password)){
                lv.setRegPasswordError();
                error = true;
            }
            else
            {
                if(!isPasswordMatches(password))
                {
                    lv.setRegPasswordError();
                    error = true;
                }
                else
                {

                }
            }
            if (TextUtils.isEmpty(MobileNumber)){
                lv.setRegContactError();
                error = true;
            }
            else
            {
                if(!isValidPhoneNumber(MobileNumber))
                {
                    lv.setRegContactError();
                    error = true;
                }
                else
                {

                }
            }
            if (!error){
                db = new Databasehelper(lv.getApplicationContext());
              int sucess =  db.Create_login_Account(Email,password,Name,MobileNumber);
                if(sucess == 1) {
                    lv.onRegistrationSuccess();
                }
                else
                {
                    lv.onRegistrationFailure();
                }

            }
        }
    }

    @Override public void onDestroy() {
        lv = null;
    }

    private boolean isAlphanumeric(String Name)
    {
        Pattern p = Pattern.compile("[^a-zA-Z0-9@*&]");
        return p.matcher(Name).find();
    }

    private boolean isValidMail(String email)
    {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static final boolean isValidPhoneNumber(String Phone) {
        if (Phone.length()!=10) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(Phone).matches();
        }
    }

    private boolean isPasswordMatches(String Password) {
        String passwordpattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        Pattern p = Pattern.compile(passwordpattern);
        return p.matcher(Password).matches();
    }
}
