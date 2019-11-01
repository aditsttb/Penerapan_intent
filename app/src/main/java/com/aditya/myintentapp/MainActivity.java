package com.aditya.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Parcel;
import android.os.Parcelable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //pindah tanpa data
        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        //pindah dengan data
        Button btnMoveActivityWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveActivityWithDataActivity.setOnClickListener(this);

        //pindah dengan objek
        Button btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        //Dial a number
        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //pindah tanpa data
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;

            //pindah dengan data
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "GITS get it simple");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 10);
                startActivity(moveWithDataIntent);
                break;

            //pindah dengan object (parcelable)
            case R.id.btn_move_activity_object: {
                Person person = new Person();
                person.setName("GITS");
                person.setAge(10);
                person.setEmail("connect.to@gits.com");
                person.setCity("Bandung");

                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);
                break;
            }

            case R.id.btn_dial_number:
                String phoneNumber = "081210841382";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            }
        }
    }


