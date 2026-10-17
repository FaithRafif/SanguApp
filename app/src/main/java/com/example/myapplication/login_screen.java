package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONObject;

public class login_screen extends Fragment {
    String putEmail;
    String putPassword;
    Button btnLogin;

    EditText email;
    EditText password;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_screen,container,false);
        btnLogin = view.findViewById(R.id.btnLogin);
        email = view.findViewById(R.id.edEmail);
        password = view.findViewById(R.id.edPass);
        btnLogin.setOnClickListener(v -> {
            String email = putEmail.trim().toString();
            String password = putPassword.trim().toString();
            JSONObject jsonObject = new JSONObject();
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(requireContext(), "Email or password is empty", Toast.LENGTH_SHORT).show();
            } else if () {
                
            }else {
                Toast.makeText(requireContext(), "Wrong password or email", Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }
    public void loginApi(){
      SanguApi.getLogin(putPassword,putEmail,new SanguApi.login() {
          @Override
          public void onSucces(String result) {

          }

          @Override
          public void onFail(String errorMessage) {

          }
      });
}}