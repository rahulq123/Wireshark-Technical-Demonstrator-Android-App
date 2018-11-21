/***************************************************************************************
 Title: Login and Sigup with local DB configuration in android
 Author: Anbarasi1993
 Date: 2016
 Type: Source Code
 Availability: https://github.com/Anbarasi1993/LoginSignupAppZoho

 ***************************************************************************************/


package com.rahul.Wireshark.Main;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rahul.Wireshark.DatabaseHelper.Databasehelper;
import com.rahul.Wireshark.Utils.Constants;


/**
 * Created by USER on 28-09-2016.
 */

public class MainPresenterModel implements MainPresenter {
    private MainView mv;
    Databasehelper db;


    public MainPresenterModel(MainView mv) {
        this.mv = mv;
    }

    public void GetUserLoginDetails(String Email, String Password)
    {

        if (mv != null) {
            db = new Databasehelper(mv.getApplicationContext());
            String TextViewName = "";
            String TextViewEmail = "";
            String TextViewMobile = "";

            String selectQuery = "SELECT * FROM "+ Constants.TABLE_USER +" WHERE "+ Constants.USER_EMAIL +"='"+Email+"' AND "+ Constants.USER_PASSWORD+"='"+Password+"' ";
            SQLiteDatabase sdb = db.getWritableDatabase();
            Cursor cursor = sdb.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {

                    TextViewName = cursor.getString(cursor.getColumnIndex(Constants.USER_NAME));
                    TextViewEmail = cursor.getString(cursor.getColumnIndex(Constants.USER_EMAIL));
                    TextViewMobile = cursor.getString(cursor.getColumnIndex(Constants.USER_PHONE));

                } while (cursor.moveToNext());
            }

            // return contact list
            cursor.close();
            db.close();
            mv.SetTextName(TextViewName,TextViewEmail,TextViewMobile);

        }


    }
}
