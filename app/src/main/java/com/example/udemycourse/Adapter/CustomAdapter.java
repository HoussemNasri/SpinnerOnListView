package com.example.udemycourse.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.udemycourse.Model.SpinnerModel;
import com.example.udemycourse.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<SpinnerModel> {
    //List of models
    private List<SpinnerModel> spinnerModels;
    private Context context;
    private static final String TAG = "XCustomAdapter";

    public CustomAdapter(@NonNull Context context, List<SpinnerModel> spinnerModels) {
        super(context, R.layout.list_view_item, spinnerModels);
        this.context = context;
        this.spinnerModels = spinnerModels;
    }

    @SuppressLint({"ViewHolder", "SetTextI18n"})
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.list_view_item, parent, false);
        
        Spinner spinner = convertView.findViewById(R.id.spinner_item);

        //Creating the spinner adapter with data from the model
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,spinnerModels.get(position).getItems());
        spinner.setAdapter(spinnerAdapter);

        //Retrieve The Selected Position From The Model (default = 0)
        spinner.setSelection(spinnerModels.get(position).getSelectedItem());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelectedAt : " + position + " selectedItem : " + i);
                //Store The Selected Position On The Model
                spinnerModels.get(position).setSelectedItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(TAG, "onNothingSelected: ");
            }
        });
        //Simple text
        TextView textView = convertView.findViewById(R.id.spinner_text);
        textView.setText("Spinner " + position);

        return convertView;
    }

    @Override
    public int getCount() {
        return spinnerModels.size();
    }
}
