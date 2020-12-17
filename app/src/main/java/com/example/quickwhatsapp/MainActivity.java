package com.example.quickwhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    EditText message;
    CountryCodePicker ccp;
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
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s!=null && s.length()==10)
                send.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mess=message.getText().toString();
                String phn=ccp.getSelectedCountryCodeWithPlus()+phone.getText().toString();
                //do stuff
            }
        });
    }
    public void onCountryPickerClick(View view)
    {
        ccp = findViewById(R.id.ccp);
        String selInitial=ccp.getDefaultCountryCode();
        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                //Alert.showMessage(RegistrationActivity.this, ccp.getSelectedCountryCodeWithPlus());
                String selected_country_code = ccp.getSelectedCountryCodeWithPlus();
               ///do stuff
            }
        });
    }
}