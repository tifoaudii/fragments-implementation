package com.example.tifoaudy.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    public Fragment1(){}
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    String strText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        strText = getArguments().getString("data");
        return inflater.inflate(R.layout.fragment1_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Button button = getActivity().findViewById(R.id.Button_Fragment1);
        final EditText editText = getActivity().findViewById(R.id.EditText_Fragment1);

        editText.setText(strText);

        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("data", strText);

                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);

                fragmentTransaction.replace(R.id.ui_container, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}
