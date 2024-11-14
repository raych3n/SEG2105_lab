package com.example.lab7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText fName, lName, email, password;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate(fName)) Toast.makeText(v.getContext(), "invalid first name", Toast.LENGTH_LONG).show();
                else if (!validate(lName)) Toast.makeText(v.getContext(), "invalid last name", Toast.LENGTH_LONG).show();
                else if (!validate(email)) Toast.makeText(v.getContext(), "invalid email", Toast.LENGTH_LONG).show();
                else if (!validate(password)) Toast.makeText(v.getContext(), "invalid password", Toast.LENGTH_LONG).show();
                else Toast.makeText(v.getContext(), "valid", Toast.LENGTH_LONG).show();
            }
        });

    }

    public boolean validate(EditText txt) {
        return txt.length() > 0;
    }
}