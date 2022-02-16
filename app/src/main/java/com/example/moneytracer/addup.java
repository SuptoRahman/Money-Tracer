package com.example.moneytracer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class addup extends AppCompatActivity {

    //textviews
    private EditText add_total_budget;
    private EditText add_expense;
    private EditText add_debt;

    //buttons
    private Button add__budget_button;
    private Button add__expense_button;
    private Button pay__debt_button;

    private double add_total_budget_in_add_up;
    private double add_direct_expense_in_add_up;
    private double add_pay_debt_in_add_up;

    private double Homepage_show_debt;
    private double Homepage_total_balance;
    private double Homepage_current_balance;
    private double Homepage_current_expense;
    private double my_debt;


    //firebase
    private FirebaseAuth mAuth;
    private FirebaseUser FirebaseUser;
    FirebaseDatabase database;
    DatabaseReference addup_ref;


    UserHelperClass obj;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addup);

        add_total_budget = (EditText) findViewById(R.id.add_total_budget_bar);
        add_expense = (EditText) findViewById(R.id.add_expense_bar);
        add_debt = (EditText) findViewById(R.id.add_debt_bar);


        add__budget_button = (Button) findViewById(R.id.add_budget_button);
        add__expense_button = (Button) findViewById(R.id.add_expence_button);
        pay__debt_button = (Button) findViewById(R.id.pay_debt_button);





        String path = "users/"+MainActivity.currentUserID;

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        addup_ref= database.getReference(path);
        FirebaseUser = mAuth.getCurrentUser();


        addup_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                obj = snapshot.getValue(UserHelperClass.class);

                Homepage_total_balance = obj.getHomepage_total_balance();
                Homepage_current_balance = obj.getHomepage_current_balance();
                Homepage_current_expense = obj.getHomepage_current_expense();
                Homepage_show_debt = obj.getHomepage_show_debt();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });



        add__budget_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_total_budget_in_add_up = Double.parseDouble(add_total_budget.getText().toString());
                Homepage_total_balance +=add_total_budget_in_add_up;
                Homepage_current_balance+=add_total_budget_in_add_up;
                obj.setHomepage_total_balance(Homepage_total_balance);
                obj.setHomepage_current_balance(Homepage_current_balance);
                addup_ref.setValue(obj);
                Intent intent = new Intent(addup.this, home_page.class);
                startActivity(intent);
            }
        });

        add__expense_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_direct_expense_in_add_up = Double.parseDouble(add_expense.getText().toString());
                Homepage_current_expense+=add_direct_expense_in_add_up;
                obj.setHomepage_current_expense(Homepage_current_expense);
                if(Homepage_current_balance>=add_direct_expense_in_add_up){
                    Homepage_current_balance -= add_direct_expense_in_add_up;
                }
                else{
                    Homepage_show_debt += (add_direct_expense_in_add_up - Homepage_current_balance);
                    Homepage_current_balance =0;
                }
                obj.setHomepage_current_balance(Homepage_current_balance);

                obj.setHomepage_show_debt(Homepage_show_debt);
                addup_ref.setValue(obj);
                Intent intent = new Intent(addup.this, home_page.class);
                startActivity(intent);
            }
        });

        pay__debt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_pay_debt_in_add_up = Double.parseDouble(add_debt.getText().toString());
                if(Homepage_show_debt>0){
                    if(add_pay_debt_in_add_up<=Homepage_show_debt){
                        Homepage_show_debt-=add_pay_debt_in_add_up;
                        Homepage_total_balance+=add_pay_debt_in_add_up;

                        obj.setHomepage_total_balance(Homepage_total_balance);
                        obj.setHomepage_show_debt(Homepage_show_debt);
                        addup_ref.setValue(obj);
                        Intent intent = new Intent(addup.this, home_page.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(addup.this,"Can't pay more than debt",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}