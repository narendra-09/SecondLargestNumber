package com.example.secondlargestnumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import com.example.secondlargestnumber.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private MainViewModel mainViewModel;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflate View
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        //Get MainViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //Code
        mainBinding.addNumber.setEnabled(false);
        mainBinding.addNumber.setImageResource(R.drawable.not_add);
        //Watch for Empty Values
        mainBinding.numberField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!TextUtils.isEmpty(mainBinding.numberField.getText().toString())) {
                    mainBinding.addNumber.setEnabled(true);
                    mainBinding.addNumber.setImageResource(R.drawable.add);
                } else {
                    mainBinding.addNumber.setEnabled(false);
                    mainBinding.addNumber.setImageResource(R.drawable.not_add);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //Add Click
        mainBinding.addNumber.setOnClickListener(view -> {
            String number = mainBinding.numberField.getText().toString();
            int mNumber = Integer.parseInt(number.trim());
            mainViewModel.addTheNumber(mNumber);

            //Clear text
            mainBinding.numberField.setText("");
        });
        //Clear Click
        mainBinding.clear.setOnClickListener(view -> mainViewModel.clearTheLast());
        //Result Click
        mainBinding.result.setOnClickListener(view -> startActivity(new Intent(this, ResultActivity.class)));
        //Get Data
        MainViewModel.getMutableLiveData().observe(this, addNumbers -> {
            myAdapter = new MyAdapter(this, addNumbers);
            mainBinding.recyclerOne.setLayoutManager(new GridLayoutManager(this, 5));
            mainBinding.recyclerOne.setAdapter(myAdapter);
        });

    }
}