package com.example.exercisetodoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TaskActivity extends AppCompatActivity {
    TextView Nama;
    EditText Task, Jenis, Time;
    FloatingActionButton submit;
    String nama, task, jenis, time;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSubmit){
            Bundle b = new Bundle();
            b.putString("task", Task.getText().toString().trim());
            b.putString("jenis", Jenis.getText().toString().trim());
            b.putString("time", Time.getText().toString().trim());

            Intent i = new Intent(getApplicationContext(), HasilActivity.class);
            i.putExtras(b);
            startActivity(i);
        }
        else if (item.getItemId() == R.id.mnLogout){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Nama = findViewById(R.id.setNama);
        Task = findViewById(R.id.inTask);
        Jenis = findViewById(R.id.inJenis);
        Time = findViewById(R.id.inTime);
        submit = findViewById(R.id.fabSubmit);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("name");
        Nama.setText(nama);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = Task.getText().toString();
                jenis = Jenis.getText().toString();
                time = Time.getText().toString();

                if(Task.getText().toString().equals("") && Jenis.getText().toString().equals("") && Time.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(), "Wajib diisi Semua!!!", Toast.LENGTH_SHORT).show();
                }
                else if (Task.getText().toString().length()==0) {
                    Task.setError("Masukkan Task!");
                    Toast.makeText(getApplicationContext(), "Task Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if (Jenis.getText().toString().length()==0) {
                    Jenis.setError("Masukkan Jenis Task!");
                    Toast.makeText(getApplicationContext(), "Jenis Task Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if (Time.getText().toString().length()==0) {
                    Time.setError("Masukkan Time Task!");
                    Toast.makeText(getApplicationContext(), "Time Task Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Berhasil!", Toast.LENGTH_SHORT).show();

                    Bundle bundle = new Bundle();

                    bundle.putString("task", task.trim());
                    bundle.putString("jenis", jenis.trim());
                    bundle.putString("time", time.trim());

                    Intent data = new Intent(getApplicationContext(), HasilActivity.class);

                    data.putExtras(bundle);

                    startActivity(data);
                }
            }
        });
    }
}