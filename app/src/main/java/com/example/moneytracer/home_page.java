package com.example.moneytracer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class home_page<mAuth> extends AppCompatActivity {
    //textviews
    private TextView total_budget;
    private TextView current_balance;
    private TextView current_expense;
    private TextView current_debt;
    private TextView show_date;

    //buttons
    private Button addup_page_button;
    private Button others_page_button;
   // private Button reminder_set_button;
    private Button log_out_button;
    private Button menu_page_button;

    //variables
    private double homepage_show_debt;
    private double homepage_total_balance;
    private double homepage_current_balance;
    private double homepage_current_expense;

    UserHelperClass object;
    UserHelperClass reset_object = new UserHelperClass();



   /* //variable if object is null
    private double extra_homepage_show_debt;
    private double extra_homepage_total_balance;
    private double extra_homepage_current_balance;
    private double extra_homepage_current_expense;*/

    //database
    FirebaseDatabase database;
    DatabaseReference reference;


    private FirebaseAuth mAuth;
    private FirebaseUser FirebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Date reset = new Date();
        SimpleDateFormat reset_formatter = new SimpleDateFormat("dd MMMM, yyyy");
        String  reset_date = reset_formatter.format(reset);




        //current date and time
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
        String  currentDateTimeString = formatter.format(date);



        total_budget = (TextView) findViewById(R.id.total_budget_text);
        current_balance = (TextView) findViewById(R.id.current_balance_text);
        current_expense = (TextView) findViewById(R.id.current_expense_text);
        current_debt = (TextView) findViewById(R.id.current_debt_text);
        show_date = (TextView) findViewById(R.id.show_date);

        addup_page_button = (Button) findViewById(R.id.addup_button) ;
        others_page_button = (Button) findViewById(R.id.others_button) ;
        //reminder_set_button = (Button) findViewById(R.id.reminder_button) ;
        log_out_button = (Button) findViewById(R.id.logout_button) ;
        menu_page_button = (Button) findViewById(R.id.menu_button) ;




        //showing date
        show_date.setText(currentDateTimeString);


        //firebase
        String path = "users/"+MainActivity.currentUserID;
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        FirebaseUser = mAuth.getCurrentUser();
        reference= database.getReference(path);




        // If new month starts
        if (reset_date.startsWith("01")){

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    object = snapshot.getValue(UserHelperClass.class);

                    homepage_current_balance = object.getHomepage_current_balance();

                    reference.child("Carry Over Budget").setValue(homepage_current_balance);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            reset_object.setHomepage_total_balance(0);
            reset_object.setHomepage_current_balance(0);
            reset_object.setHomepage_current_expense(0);
            reset_object.setHomepage_show_debt(0);
            reference.setValue(reset_object);
        }


        //getData

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                object = snapshot.getValue(UserHelperClass.class);

                if(object == null){

                }
                else {

                    homepage_total_balance = object.getHomepage_total_balance();
                    homepage_current_balance = object.getHomepage_current_balance();
                    homepage_current_expense = object.getHomepage_current_expense();
                    homepage_show_debt = object.getHomepage_show_debt();

                    total_budget.setText(String.valueOf(homepage_total_balance));
                    current_balance.setText(String.valueOf(homepage_current_balance));
                    current_expense.setText(String.valueOf(homepage_current_expense));
                    current_debt.setText(String.valueOf(homepage_show_debt));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        addup_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_add_up_page_button = new Intent(home_page.this, addup.class);
                startActivity(intent_add_up_page_button);
            }
        });

        others_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_others_page_button = new Intent(home_page.this, others.class);
                startActivity(intent_others_page_button);
            }
        });

//        reminder_set_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });



        log_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember","false");
                editor.apply();

                finish();

                Intent intent_logout_button = new Intent(home_page.this, MainActivity.class);
                startActivity(intent_logout_button);
            }
        });

        menu_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_menu_page_button = new Intent(home_page.this, Expense.class);
                startActivity(intent_menu_page_button);
            }
        });

    }



}

