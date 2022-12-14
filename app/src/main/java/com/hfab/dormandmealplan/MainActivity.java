package com.hfab.dormandmealplan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This MainActivity class is used to caclualte the total of
 * a meal plan and a dorm plan. Once the user inputs the two plans,
 * the program will calculate the total based on the plans they have chosen.
 */
public class MainActivity extends AppCompatActivity {

    private Button btnCalculate; // Button Calculate
    private Spinner spDormPlan; // Spinner Dorm Plan
    private Spinner spMealPlan; // Spinner Meal Plan
    private TextView totalCostDisplay; // TextView of the total

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grab each fields information
        btnCalculate = findViewById(R.id.btn_calculate);
        spDormPlan = findViewById(R.id.dorm_spinner);
        spMealPlan = findViewById(R.id.meal_spinner);
        totalCostDisplay = findViewById(R.id.total_cost_text);


        // The button will calculate the total and display the total
        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                double dormTotal = 0;
                double mealTotal = 0;
                double total = 0;

                // If a specific meal and dorm plan are picked, the total will be calculated
                if (spDormPlan.getSelectedItem().equals("Allen Hall"))
                    dormTotal += 1800;

                else if (spDormPlan.getSelectedItem().equals("Pike Hall"))
                    dormTotal += 2200;

                else if (spDormPlan.getSelectedItem().equals("Farthing Hall"))
                    dormTotal += 2800;

                else if (spDormPlan.getSelectedItem().equals("University Suites"))
                    dormTotal += 3000;

                else
                    dormTotal += 0;



                if (spMealPlan.getSelectedItem().equals("7 meals per week"))
                    mealTotal += 600;

                else if (spMealPlan.getSelectedItem().equals("14 meals per week"))
                    mealTotal += 1100;

                else if (spMealPlan.getSelectedItem().equals("Unlimited meals per week"))
                    mealTotal += 1800;

                else
                    mealTotal += 0;

                // Adds the total
                total = mealTotal + dormTotal;

                // Displays the total to the user
                totalCostDisplay.setText(String.format("Cost: $%.2f", total));

            }

        });

    }
}