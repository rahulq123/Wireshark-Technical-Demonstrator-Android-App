package com.rahul.Wireshark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rahul on 22/04/2017.
 */

public class Displayintermediatevideos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayintermediatevideos);
    }

    public void onPlayButtonClick(View v) {


        if (v.getId() == R.id.TButtonClick) {
            Intent i = new Intent(Displayintermediatevideos.this, HTTP.class);
            startActivity(i);
        }

        if (v.getId() == R.id.UButtonclick) {
            Intent i = new Intent(Displayintermediatevideos.this, SMTP.class);
            startActivity(i);
        }

    }
}
