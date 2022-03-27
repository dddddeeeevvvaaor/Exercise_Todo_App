package com.example.exercisetodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DaftarActivity extends AppCompatActivity {

    Button Regis;

    EditText Nama, Email, Pass, Repass;

    String nama, email, password, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        Regis = findViewById(R.id.bRegister);
        Nama = findViewById(R.id.txNama);
        Email = findViewById(R.id.txEmail);
        Pass = findViewById(R.id.regPass);
        Repass = findViewById(R.id.regRepass);

        Regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama    = Nama.getText().toString();
                email   = Email.getText().toString();
                password = Pass.getText().toString();
                repassword = Repass.getText().toString();

                if(Nama.getText().toString().equals("") && Email.getText().toString().equals("") && Pass.getText().toString().equals("") && Regis.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Wajib diisi Semua!!!", Toast.LENGTH_SHORT).show();
                }
                else if (Nama.getText().toString().length()==0) {
                    Nama.setError("Masukkan Nama!");
                    Toast.makeText(getApplicationContext(), "Nama Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if (Email.getText().toString().length()==0) {
                    Email.setError("Masukkan Email!");
                    Toast.makeText(getApplicationContext(), "Email Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if (Pass.getText().toString().length()==0) {
                    Toast.makeText(getApplicationContext(), "Password Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if (Repass.getText().toString().length()==0) {
                    Toast.makeText(getApplicationContext(), "Konfirmasi Password Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (!password.equals(repassword)){
                        Toast t = Toast.makeText(getApplicationContext(),"Password harus sama!",Toast.LENGTH_LONG);
                        t.show();
                    }
                    else {
                        Bundle b = new Bundle();

                        b.putString("name", nama.trim());
                        Toast t = Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG);
                        t.show();

                        Intent i = new Intent(getApplicationContext(), TaskActivity.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
            }
        });
    }
}