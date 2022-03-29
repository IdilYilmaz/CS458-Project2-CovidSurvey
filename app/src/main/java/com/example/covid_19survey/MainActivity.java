package com.example.covid_19survey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;
import java.util.Calendar;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText surName;
    EditText city;
    EditText sideEffect,sym;
    Button register;
    RadioButton male,female,x,bio,sin,none;
    Button submit;
    private Button selectDate;
    private DatePickerDialog datePickerDialog;
    private TextView dateTxt;
    private Calendar calendar;
    private int year, month, dayOfMonth;
    boolean flag = false;
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
        none = (RadioButton) findViewById(R.id.radioButtonNone);
        sideEffect = (EditText)findViewById(R.id.editTextSideEffect);
        sym = (EditText)findViewById(R.id.editTextSymptoms);
        submit = (Button)findViewById(R.id.buttonRegister);
        selectDate = findViewById(R.id.selectDate);
        dateTxt = findViewById(R.id.dateTxt);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                dateTxt.setText("Birthday:"+ day + "/" + (month+1) + "/" + year);
                                flag = true;
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();

            }
        });
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
            if (isEmpty(city)) {
                Toast t2 = Toast.makeText(this, "You must enter city to submit form!", Toast.LENGTH_SHORT);
                t2.show();
            }


            if (male.isChecked() || female.isChecked() || x.isChecked()) {
            } else {
                Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();

            }
            if (bio.isChecked() || sin.isChecked() || none.isChecked()) {
            } else {
                Toast.makeText(getApplicationContext(), "Please select Vaccine Type", Toast.LENGTH_SHORT).show();
            }
            if(!isEmpty(name) && !isEmpty(surName) && !isEmpty(city)&&(male.isChecked() || female.isChecked() || x.isChecked()) && (bio.isChecked() || sin.isChecked()) && (flag) ){
                Toast.makeText(getApplicationContext(), "Submit Done", Toast.LENGTH_SHORT).show();
            }
            if(!flag){
                Toast t2 = Toast.makeText(this, "Please select Birthday", Toast.LENGTH_SHORT);
                t2.show();
            }
            else{
            }




        }
    }


