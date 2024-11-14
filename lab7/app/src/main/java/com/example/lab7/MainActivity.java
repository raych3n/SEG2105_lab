package com.example.lab7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText fName, lName, email, password;
    TextView valid;
    Button submit;
    private ValidateDetails vlad = new ValidateDetails();

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

        valid = findViewById(R.id.isTextValid);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!vlad.validate(fName.getText().toString())) valid.setText("invalid first name");
                else if (!vlad.validate(lName.getText().toString())) valid.setText("invalid last name");
                else if (!vlad.validate(email.getText().toString())) valid.setText("invalid email");
                else if (!vlad.validate(password.getText().toString())) valid.setText("invalid password");
                else valid.setText("valid");
            }
        });

    }
}