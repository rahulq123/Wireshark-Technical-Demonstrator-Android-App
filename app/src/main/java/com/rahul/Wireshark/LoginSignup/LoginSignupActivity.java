/***************************************************************************************
 Title: Login and Sigup with local DB configuration in android
 Author: Anbarasi1993
 Date: 2016
 Type: Source Code
 Availability: https://github.com/Anbarasi1993/LoginSignupAppZoho

 ***************************************************************************************/


package com.rahul.Wireshark.LoginSignup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rahul.Wireshark.Main.MainActivity;
import com.rahul.Wireshark.R;

public class LoginSignupActivity extends Activity implements LoginView, View.OnClickListener {



    private TextView T_rahul_login;
    private TextView T_rahul_Signup;

    private LinearLayout L_rahul_Login;
    private LinearLayout L_rahul_Signup;

    private EditText EditT_rahul_Email;
    private EditText EditT_rahul_Password;

    private EditText EditT_rahul_RegisterName;
    private EditText EditT_rahul_RegisterEmail;
    private EditText EditT_rahul_RegisterPassword;
    private EditText EditT_rahul_RegisterContactNumber;



    private LoginPresenter loginpresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsigup);

        EditT_rahul_Email = (EditText) findViewById(R.id.EditT_rahul_Email);
        EditT_rahul_Password = (EditText) findViewById(R.id.EditT_rahul_Password);
        findViewById(R.id.B_rahul_LoginAction).setOnClickListener(this);



        EditT_rahul_RegisterName = (EditText) findViewById(R.id.EditT_rahul_RegisterName);
        EditT_rahul_RegisterEmail = (EditText) findViewById(R.id.EditT_rahul_RegisterEmail);
        EditT_rahul_RegisterPassword = (EditText) findViewById(R.id.EditT_rahul_RegisterPassword);
        EditT_rahul_RegisterContactNumber = (EditText) findViewById(R.id.EditT_rahul_RegisterContactNumber);

        T_rahul_login = (TextView)findViewById(R.id.T_rahul_Login);
        T_rahul_Signup = (TextView)findViewById(R.id.T_rahul_Signup);

        L_rahul_Login = (LinearLayout) findViewById(R.id.L_rahul_Login);
        L_rahul_Signup = (LinearLayout)findViewById(R.id.L_rahul_Signup);

        findViewById(R.id.B_rahul_LoginAction).setOnClickListener(this);

        findViewById(R.id.B_rahul_RegisterAction).setOnClickListener(this);

        T_rahul_login.setOnClickListener(this);

        T_rahul_Signup.setOnClickListener(this);

        loginpresenter = new LoginPresenterModel(this);

    }

    public void onClick(View v) {
        if(v.getId() == R.id.B_rahul_LoginAction)
        {
            loginpresenter.Checkuserlogincredentials(EditT_rahul_Email.getText().toString(), EditT_rahul_Password.getText().toString());
        }
        else if(v.getId() == R.id.B_rahul_RegisterAction)
        {
            loginpresenter.createuserAccount(EditT_rahul_RegisterName.getText().toString(), EditT_rahul_RegisterEmail.getText().toString(),EditT_rahul_RegisterPassword.getText().toString(),EditT_rahul_RegisterContactNumber.getText().toString());
        }

        else if(v.getId() == R.id.T_rahul_Login)
        {
            L_rahul_Login.setVisibility(View.VISIBLE);
            L_rahul_Signup.setVisibility(View.GONE);
            T_rahul_login.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            T_rahul_login.setAlpha(.5f);
            T_rahul_Signup.setBackgroundColor(getResources().getColor(R.color.white));
            EditT_rahul_Email.setText("");
            EditT_rahul_Password.setText("");
            EditT_rahul_Email.setError(null);
            EditT_rahul_Password.setError(null);

        }

        else if(v.getId() == R.id.T_rahul_Signup)
        {
            L_rahul_Login.setVisibility(View.GONE);
            L_rahul_Signup.setVisibility(View.VISIBLE);
            T_rahul_Signup.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            T_rahul_Signup.setAlpha(.5f);
            T_rahul_login.setBackgroundColor(getResources().getColor(R.color.white));

            EditT_rahul_RegisterName.setText("");
            EditT_rahul_RegisterEmail.setText("");
            EditT_rahul_RegisterPassword.setText("");
            EditT_rahul_RegisterContactNumber.setText("");
            EditT_rahul_RegisterName.setError(null);
            EditT_rahul_RegisterEmail.setError(null);
            EditT_rahul_RegisterPassword.setError(null);
            EditT_rahul_RegisterContactNumber.setError(null);
        }
        else
        {

        }
    }

    protected void onDestroy() {
        loginpresenter.onDestroy();
        super.onDestroy();
    }

   public void setEmailError() {
       EditT_rahul_Email.setError(getString(R.string.Login_Email_Error));
    }

    public void setPasswordError() {
        EditT_rahul_Password.setError(getString(R.string.Login_Password_Error));
    }

    public void setRegEmailError() {
        EditT_rahul_RegisterEmail.setError(getString(R.string.Register_Email_Error));
    }

    public void setRegPasswordError() {
        EditT_rahul_RegisterPassword.setError(getString(R.string.Register_Password_Error));
    }

    public void setRegNameError() {
        EditT_rahul_RegisterName.setError(getString(R.string.Register_Name_Error));
    }

    public void setRegContactError() {
        EditT_rahul_RegisterContactNumber.setError(getString(R.string.Register_contact_Number_Error));
    }

    public void onRegistrationFailure() {
        Toast.makeText(getApplicationContext(),"Account has been already Registered. Login or Create New Account",Toast.LENGTH_LONG).show();
    }

    public void onRegistrationSuccess() {
        Toast.makeText(getApplicationContext(),"Account created Sucessfully. Please Login using details",Toast.LENGTH_LONG).show();
        EditT_rahul_RegisterName.setText("");
        EditT_rahul_RegisterEmail.setText("");
        EditT_rahul_RegisterPassword.setText("");
        EditT_rahul_RegisterContactNumber.setText("");
    }

    public void onFailure()
    {
        Toast.makeText(getApplicationContext(),"Invalid Credentials.Please Try Again ",Toast.LENGTH_LONG).show();
    }
    public void onSuccess(String Email,String Password) {
        Toast.makeText(getApplicationContext(),"You are Sucessfully logged In.",Toast.LENGTH_LONG).show();
        EditT_rahul_Email.setText("");
        EditT_rahul_Password.setText("");
        Intent main = new Intent(this,MainActivity.class);
        main.putExtra("Email",Email);
        main.putExtra("Password",Password);
        startActivity(main);

    }
}
