package com.example.tifoaudy.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        editText = findViewById(R.id.editTextActivity2);
        button = findViewById(R.id.btn_activity2);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public void setVisibilityIntoGone(){
        editText.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
    }

    public void onSetView(View view){
        setVisibilityIntoGone();

        //init Bundle
        Bundle bundle = new Bundle();
        bundle.putString("data", editText.getText().toString());

        Fragment1 fragment1 = new Fragment1();
        fragment1.setArguments(bundle);

        fragmentTransaction.add(R.id.ui_container, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        button.setEnabled(false);
    }
}
