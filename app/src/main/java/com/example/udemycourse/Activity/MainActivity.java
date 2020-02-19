package com.example.udemycourse.Activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.udemycourse.Adapter.CustomAdapter;
import com.example.udemycourse.Model.SpinnerModel;
import com.example.udemycourse.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "XMainActivity";

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);

        String[] myResArray = getResources().getStringArray(R.array.my_array);
        List<String> myResArrayList = Arrays.asList(myResArray);
        List<SpinnerModel> spinnerModelList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            spinnerModelList.add(new SpinnerModel(myResArrayList));
        }

        CustomAdapter adapter = new CustomAdapter(MainActivity.this, spinnerModelList);
        listView.setAdapter(adapter);

    }




}
