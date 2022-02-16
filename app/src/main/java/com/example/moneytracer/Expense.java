package com.example.moneytracer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Expense extends AppCompatActivity {

    private Button food;
    private Button car;
    private Button transport;
    private Button entertainment;
    private Button rent;
    private Button eatingout;
    private Button toiletry;
    private Button sports;
    private Button health;
    private Button communications;
    private Button investments;
    private Button gift;
    private Button clothes;
    private Button bill;
    private Button shopping;

    public String expense_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        food = (Button) findViewById(R.id.food_button);
        car = (Button) findViewById(R.id.car_button);
        transport = (Button) findViewById(R.id.transport_button);
        entertainment = (Button) findViewById(R.id.entertainment_button);
        rent = (Button) findViewById(R.id.rent_button);
        eatingout = (Button) findViewById(R.id.eatingout_button);
        toiletry = (Button) findViewById(R.id.toiletries_button);
        sports = (Button) findViewById(R.id.sports_button);
        health = (Button) findViewById(R.id.health_button);
        communications = (Button) findViewById(R.id.communication_button);
        investments = (Button) findViewById(R.id.investment_button);
        gift = (Button) findViewById(R.id.gift_button);
        clothes = (Button) findViewById(R.id.clothes_button);
        bill = (Button) findViewById(R.id.bill_button);
        shopping = (Button) findViewById(R.id.shopping_button);



        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Food";
                Intent intent_food = new Intent(Expense.this,Calculator.class);
                intent_food.putExtra("key",expense_var);
                startActivity(intent_food);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Car";
                Intent intent_car = new Intent(Expense.this,Calculator.class);
                intent_car.putExtra("key",expense_var);
                startActivity(intent_car);

            }
        });

        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Transport";
                Intent intent_transport = new Intent(Expense.this,Calculator.class);
                intent_transport.putExtra("key",expense_var);
                startActivity(intent_transport);

            }
        });

        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Entertainment";
                Intent intent_entertainment = new Intent(Expense.this,Calculator.class);
                intent_entertainment.putExtra("key",expense_var);
                startActivity(intent_entertainment);

            }
        });

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Rent";
                Intent intent_rent = new Intent(Expense.this,Calculator.class);
                intent_rent.putExtra("key",expense_var);
                startActivity(intent_rent);

            }
        });

        eatingout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Eating Out";
                Intent intent_eatingout = new Intent(Expense.this,Calculator.class);
                intent_eatingout.putExtra("key",expense_var);
                startActivity(intent_eatingout);

            }
        });

        toiletry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Toiletry";
                Intent intent_toiletry = new Intent(Expense.this,Calculator.class);
                intent_toiletry.putExtra("key",expense_var);
                startActivity(intent_toiletry);

            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Sports";
                Intent intent_sports = new Intent(Expense.this,Calculator.class);
                intent_sports.putExtra("key",expense_var);
                startActivity(intent_sports);

            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Health";
                Intent intent_health = new Intent(Expense.this,Calculator.class);
                intent_health.putExtra("key",expense_var);
                startActivity(intent_health);

            }
        });

        communications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Communications";
                Intent intent_communications = new Intent(Expense.this,Calculator.class);
                intent_communications.putExtra("key",expense_var);
                startActivity(intent_communications);

            }
        });

        investments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Investments";
                Intent intent_investments = new Intent(Expense.this,Calculator.class);
                intent_investments.putExtra("key",expense_var);
                startActivity(intent_investments);

            }
        });

        gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Gift";
                Intent intent_gift = new Intent(Expense.this,Calculator.class);
                intent_gift.putExtra("key",expense_var);
                startActivity(intent_gift);

            }
        });

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Clothes";
                Intent intent_clothes = new Intent(Expense.this,Calculator.class);
                intent_clothes.putExtra("key",expense_var);
                startActivity(intent_clothes);

            }
        });

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Bills";
                Intent intent_bill = new Intent(Expense.this,Calculator.class);
                intent_bill.putExtra("key",expense_var);
                startActivity(intent_bill);

            }
        });

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expense_var = "Shopping";
                Intent intent_shopping = new Intent(Expense.this,Calculator.class);
                intent_shopping.putExtra("key",expense_var);
                startActivity(intent_shopping);

            }
        });

    }
}