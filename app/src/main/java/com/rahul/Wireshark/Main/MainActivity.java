/***************************************************************************************
 Title: Login and Sigup with local DB configuration in android
 Author: Anbarasi1993
 Date: 2016
 Type: Source Code
 Availability: https://github.com/Anbarasi1993/LoginSignupAppZoho

 ***************************************************************************************/


package com.rahul.Wireshark.Main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.VpnService;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.rahul.Wireshark.GUI1;
import com.rahul.Wireshark.LocalVPNService;
import com.rahul.Wireshark.R;

public class MainActivity extends Activity implements MainView {


    private TextView T_rahul_Name;
    private static final int VPN_REQUEST_CODE = 0x0F;

    private boolean waitingForVPNStart;


    private MainPresenter mainpresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button vpnButton = (Button)findViewById(R.id.capture);
        vpnButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startVPN();
            }
        });
        waitingForVPNStart = false;
        LocalBroadcastManager.getInstance(this).registerReceiver(vpnStateReceiver,
                new IntentFilter(LocalVPNService.BROADCAST_VPN_STATE));
        


        T_rahul_Name = (TextView)findViewById(R.id.T_rahul_Name);


        mainpresenter = new MainPresenterModel(this);

        Intent main = getIntent();
        String Email = main.getStringExtra("Email");
        String Password = main.getStringExtra("Password");

        mainpresenter.GetUserLoginDetails(Email,Password);
    }

    

    private BroadcastReceiver vpnStateReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            if (LocalVPNService.BROADCAST_VPN_STATE.equals(intent.getAction()))
            {
                if (intent.getBooleanExtra("running", false))
                    waitingForVPNStart = false;
            }
        }
    };

    public void SetTextName(String Name, String Email, String Mobile)
    {

        T_rahul_Name.setText("Welcome " + Name);

    }

    private void startVPN()
    {
        Intent vpnIntent = VpnService.prepare(this);
        if (vpnIntent != null)
            startActivityForResult(vpnIntent, VPN_REQUEST_CODE);
        else
            onActivityResult(VPN_REQUEST_CODE, RESULT_OK, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VPN_REQUEST_CODE && resultCode == RESULT_OK)
        {
            waitingForVPNStart = true;
            startService(new Intent(this, LocalVPNService.class));
            enableButton(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        enableButton(!waitingForVPNStart && !LocalVPNService.isRunning());
    }

    private void enableButton(boolean enable)
    {
        final Button vpnButton = (Button) findViewById(R.id.capture);
        if (enable)
        {
            vpnButton.setEnabled(true);
            vpnButton.setText(R.string.start_capture);
        }
        else
        {
            vpnButton.setEnabled(false);
            vpnButton.setText(R.string.stop_capture);
        }
    }

    public void onLetsBeginButtonClick(View v) {


        if (v.getId() == R.id.Lbegin) {
            Intent i = new Intent(MainActivity.this, GUI1.class);
            startActivity(i);
        }

    }

}
