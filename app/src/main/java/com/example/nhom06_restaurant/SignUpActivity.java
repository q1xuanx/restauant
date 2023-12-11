package com.example.nhom06_restaurant;

import static java.util.Calendar.SECOND;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.nhom06_restaurant.model.Account;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    AppCompatButton checkPhone, signUpBtn;
    TextInputEditText phone,password, confirmPass, fullName, birthDay;
    String gender, phoneTemp;
    Boolean isChecked = false;
    RadioButton radioButtonBoy, radioButtonGirl;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            firebaseAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    isChecked = true;
                    Toast.makeText(SignUpActivity.this, "Verified", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            phoneTemp = null;
            Toast.makeText(SignUpActivity.this, e.toString(),Toast.LENGTH_LONG).show();
            Log.d(null, e.toString());
        }
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            Toast.makeText(SignUpActivity.this, "Check your sms to confirm OTP",Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth = FirebaseAuth.getInstance();
        checkPhone = findViewById(R.id.getVerify);
        signUpBtn = findViewById(R.id.signUp);
        phone = findViewById(R.id.phoneCheck);
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 11){
                    phone.setError("Phone number must have 11 number", getDrawable(R.drawable.img));
                }else phone.setError(null);
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password = findViewById(R.id.txtPassSign);
        confirmPass = findViewById(R.id.txtConfirmPassSign);
        fullName = findViewById(R.id.txtFullNameSign);
        birthDay = findViewById(R.id.txtBirthDaySign);
        radioButtonBoy = findViewById(R.id.radioBoy);
        radioButtonGirl = findViewById(R.id.radioGirl);
        checkPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPhone.getText().equals("Check")) {
                    if (phone.getText().toString().equals("")) {
                        Toast.makeText(SignUpActivity.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
                    } else {
                        checkPhone.setText("Verify");
                        String phoneNumber = "+84" + phone.getText().toString().trim();
                        phoneTemp = phone.getText().toString().trim();
                        phone.setText("");
                        PhoneAuthOptions opt = PhoneAuthOptions.newBuilder(firebaseAuth).setPhoneNumber(phoneNumber).
                                setTimeout(60L, TimeUnit.SECONDS).
                                setActivity(SignUpActivity.this).
                                setCallbacks(callbacks).build();
                        PhoneAuthProvider.verifyPhoneNumber(opt);
                    }
                }else {
                    checkPhone.setText("Check");
                }
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isChecked) {
                    Toast.makeText(SignUpActivity.this, "Please verify your phone number", Toast.LENGTH_SHORT).show();
                }else {
                    ProgressBar progressBar = new ProgressBar(SignUpActivity.this);
                    progressBar.setVisibility(View.VISIBLE);
                    if (password.getText().toString().equals("") || confirmPass.getText().toString().equals("") || fullName.getText().equals("") || birthDay.getText().equals("") || (!radioButtonBoy.isChecked() && !radioButtonGirl.isChecked())){
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(SignUpActivity.this,"Please fill full the box", Toast.LENGTH_SHORT).show();
                    }else {
                        progressBar.setVisibility(View.GONE);
                        gender = "Boy";
                        if (radioButtonGirl.isChecked()) gender = "Girl";
                        Account account = new Account(phoneTemp, password.getText().toString(), fullName.getText().toString(), birthDay.getText().toString(), gender);
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
                        DatabaseReference pushData = databaseReference.push();
                        pushData.setValue(account);
                        Toast.makeText(SignUpActivity.this,"Sign up success", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}