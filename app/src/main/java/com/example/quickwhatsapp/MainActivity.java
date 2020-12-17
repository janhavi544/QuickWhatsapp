package com.example.quickwhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("WA Direct Message");
    }
    public void onCountryPickerClick(View view)
    {
        CountryCodePicker ccp;
        ccp = findViewById(R.id.ccp);
        String selInitial=ccp.getDefaultCountryCode();
        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                //Alert.showMessage(RegistrationActivity.this, ccp.getSelectedCountryCodeWithPlus());
                String selected_country_code = ccp.getSelectedCountryCodeWithPlus();

            }
        });
    }
}