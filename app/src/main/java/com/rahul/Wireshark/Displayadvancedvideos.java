package com.rahul.Wireshark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rahul on 22/04/2017.
 */

public class Displayadvancedvideos extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayadvancedvideos);
    }

    public void onPlayButtonClick(View v) {


        if (v.getId() == R.id.TButtonClick) {
            Intent i = new Intent(Displayadvancedvideos.this, Advanced1.class);
            startActivity(i);
        }

        if (v.getId() == R.id.UButtonclick) {
            Intent i = new Intent(Displayadvancedvideos.this, Advanced2.class);
            startActivity(i);
        }

    }
}
