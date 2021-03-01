package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Called when user clicks the button
    public void onClickFindBeer(View view) {
        //get reference to the textview
        TextView brands = (TextView) findViewById(R.id.brands);

        //get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        //get selected item in spinner
        String beerType = String.valueOf(color.getSelectedItem());



        //Get recommendations from the BeerExpert class
        List<String> brandsList = expert.getBrand(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand: brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
        //Display the selected item
        brands.setText(brandsFormatted);
    }
}