package com.example.quickwhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    EditText message;
    String countryCode="91";
    String URLEncoded;
    String messageToBeSend;
    String phnNumber;
    boolean msg=false;
    CountryCodePicker countryCodePicker;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("WA Direct Message");
        phone=(EditText)findViewById(R.id.editTextPhone);
        message=(EditText)findViewById(R.id.editTextTextMultiLine);
        send=(Button)findViewById(R.id.sendButton);
        send.setVisibility(View.INVISIBLE);
        countryCodePicker = findViewById(R.id.ccp);
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s!=null && s.length()==10)
            {
                phnNumber=countryCode+phone.getText().toString();
                msg=true;
            }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s!=null && s.length()>0)
            {
                send.setVisibility(View.VISIBLE);
                messageToBeSend=message.getText().toString();
                msg=true;
            }
            else
                msg=false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if(msg==true)
        {
            phnNumber=countryCode+phone.getText().toString();
            messageToBeSend=message.getText().toString();
        }
    }
    public void onCountryPickerClick(View view)
    {
        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                //Alert.showMessage(RegistrationActivity.this, ccp.getSelectedCountryCodeWithPlus());
                countryCode = countryCodePicker.getSelectedCountryCode();
            }
        });
    }
    public void sendButtonClicked(View view)
    {
        try {
            String query = URLEncoder.encode(messageToBeSend, "utf-8");
            URLEncoded = "https://wa.me/" + phnNumber + "?text=" + query;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URLEncoded));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}