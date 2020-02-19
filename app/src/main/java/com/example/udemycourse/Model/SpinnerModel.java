package com.example.udemycourse.Model;

import java.util.List;

public class SpinnerModel {
    //the selected item index
    private int selectedItem = 0;
    //The data for the adapter
    private List<String> items;

    public SpinnerModel(List<String> items){
        this.items = items;
    }
    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }

    public List<String> getItems() {
        return items;
    }

}
