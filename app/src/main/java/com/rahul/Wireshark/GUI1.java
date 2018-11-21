package com.rahul.Wireshark;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by rahul on 13/03/2017.
 */

public class GUI1 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaybutton);

    }

    public void onVCPButtonClick(View v) {


        if (v.getId() == R.id.Vbutton) {
            Intent i = new Intent(GUI1.this, GUI2.class);
            startActivity(i);
        }

        if (v.getId() == R.id.Cbutton) {
            Intent i = new Intent(GUI1.this, Displaylistofcommandprompt.class);
            startActivity(i);
        }

        if (v.getId() == R.id.Pbutton) {
            Intent i = new Intent(GUI1.this, Displaylistofpdf.class);
            startActivity(i);
        }


    }

}
