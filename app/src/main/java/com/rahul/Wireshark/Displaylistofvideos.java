package com.rahul.Wireshark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rahul on 13/03/2017.
 */

public class Displaylistofvideos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaylistofvideos);
    }

    public void onPlayButtonClick(View v) {


        if (v.getId() == R.id.TButtonClick) {
            Intent i = new Intent(Displaylistofvideos.this, TCP.class);
            startActivity(i);
        }

        if (v.getId() == R.id.UButtonclick) {
            Intent i = new Intent(Displaylistofvideos.this, UDP.class);
            startActivity(i);
        }

    }
}
