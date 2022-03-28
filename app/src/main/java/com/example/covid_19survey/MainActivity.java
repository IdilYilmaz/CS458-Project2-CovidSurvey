package com.example.covid_19survey;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText surName;
    EditText city;
    EditText sideEffect,sym;
    Button register;
    RadioButton male,female,x,bio,sin;
    Button submit;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editTextUsername);
        surName = (EditText)findViewById(R.id.editTextSurname);
        city = (EditText)findViewById(R.id.editTextCity);
        male = (RadioButton) findViewById(R.id.radioButtonMale);
        female = (RadioButton) findViewById(R.id.radioButtonFemale);
        x = (RadioButton) findViewById(R.id.radioButtonX);
        bio = (RadioButton) findViewById(R.id.radioButtonBio);
        sin = (RadioButton) findViewById(R.id.radioButtonSinovac);
        sideEffect = (EditText)findViewById(R.id.editTextSideEffect);
        sym = (EditText)findViewById(R.id.editTextSymptoms);
        submit = (Button)findViewById(R.id.buttonRegister);
        submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkDataEntered();

                }
            });
        }

        boolean isEmpty(EditText text) {
            CharSequence str = text.getText().toString();
            return TextUtils.isEmpty(str);
        }

        void checkDataEntered() {
            if (isEmpty(name)) {
                Toast t = Toast.makeText(this, "You must enter first name to submit form!", Toast.LENGTH_SHORT);
                t.show();
            }

            if (isEmpty(surName)) {
                Toast t2 = Toast.makeText(this, "You must enter last name to submit form!", Toast.LENGTH_SHORT);
                t2.show();
            }
            if (isEmpty(sideEffect)) {
                Toast t3 = Toast.makeText(this, "You must fill the blank!", Toast.LENGTH_SHORT);
                t3.show();
            }


            if (male.isChecked() || female.isChecked() || x.isChecked()) {
            } else {
                Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();

            }
            if (bio.isChecked() || sin.isChecked()) {
            } else {
                Toast.makeText(getApplicationContext(), "Please select Vaccine Type", Toast.LENGTH_SHORT).show();
            }
            if(!isEmpty(name) && !isEmpty(surName) && !isEmpty(sideEffect) && (male.isChecked() || female.isChecked() || x.isChecked()) && (bio.isChecked() || sin.isChecked())  ){
                Toast.makeText(getApplicationContext(), "Submit Done", Toast.LENGTH_SHORT).show();
            }




        }
    }


