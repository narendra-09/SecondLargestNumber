package com.example.secondlargestnumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.secondlargestnumber.databinding.ActivityResultBinding;


public class ResultActivity extends AppCompatActivity {
    private ActivityResultBinding resultBinding;
    private MyAdapter myAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resultBinding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(resultBinding.getRoot());

        MainViewModel.getMutableLiveData().observe(this, addNumbers -> {
            myAdapter = new MyAdapter(this, addNumbers);
            resultBinding.recyclerTwo.setLayoutManager(new GridLayoutManager(this, 5));
            resultBinding.recyclerTwo.setAdapter(myAdapter);
        });

        String result = resultBinding.text.getText().toString() + MainViewModel.secondLargestNumber();
        if (MainViewModel.secondLargestNumber() == -202) {
            resultBinding.text.setText("No Numbers");
        } else {
            resultBinding.text.setText(result);
        }
        resultBinding.text.setBackgroundResource(R.drawable.button_style);
    }
}