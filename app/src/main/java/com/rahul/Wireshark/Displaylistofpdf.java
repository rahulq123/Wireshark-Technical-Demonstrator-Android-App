package com.rahul.Wireshark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rahul on 14/03/2017.
 */

public class Displaylistofpdf extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaylistofpdf);
    }

    public void onWebviewButtonClick(View v) {


        if (v.getId() == R.id.pdfbutton1) {
            Intent i = new Intent(Displaylistofpdf.this, Webview.class);
            startActivity(i);
        }

    }
}
