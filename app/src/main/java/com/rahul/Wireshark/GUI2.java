package com.rahul.Wireshark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rahul on 13/03/2017.
 */

public class GUI2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaylevel);

    }

    public void onBIAButtonClick(View v) {


        if (v.getId() == R.id.beginnerButton) {
            Intent i = new Intent(GUI2.this, Displaylistofvideos.class);
            startActivity(i);
        }

        if (v.getId() == R.id.intermediateButton) {
            Intent i = new Intent(GUI2.this, Displayintermediatevideos.class);
            startActivity(i);
        }

        if (v.getId() == R.id.advancedButton) {
            Intent i = new Intent(GUI2.this, Displayadvancedvideos.class);
            startActivity(i);
        }
    }

}
