package com.rahul.Wireshark;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by rahul on 13/03/2017.
 */

public class Webview extends Activity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.webview);

            String url ="https://drive.google.com/file/d/0BzjV_rigHRHQUk85QV84VFVfbWc/view?usp=sharing";
            WebView view=(WebView) this.findViewById(R.id.web);
            view.getSettings().setJavaScriptEnabled(true);
            view.loadUrl(url);
        }

}
