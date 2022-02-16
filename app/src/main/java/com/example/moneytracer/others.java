package com.example.moneytracer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class others extends AppCompatActivity {

    private Button show_statement;
    private Button show_graph;
    private Button shopping_list;
    private Button carry_over_budget;

    double previous_carry_over_budget;

    //database
    FirebaseDatabase database;
    DatabaseReference reference;


    private FirebaseAuth mAuth;
    private com.google.firebase.auth.FirebaseUser FirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        show_statement = (Button) findViewById(R.id.statement_button);
        show_graph = (Button) findViewById(R.id.graph_button);
       // shopping_list = (Button) findViewById(R.id.shopping_list_button);
        carry_over_budget = (Button) findViewById(R.id.carry_over_budget_button);


        //firebase
        String path = "users/"+MainActivity.currentUserID;
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        FirebaseUser = mAuth.getCurrentUser();
        reference= database.getReference(path);

        Date reset = new Date();
        SimpleDateFormat reset_formatter = new SimpleDateFormat("dd MMMM, yyyy");
        String  reset_date = reset_formatter.format(reset);

        carry_over_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(others.this);
                builder.setCancelable(true);
                builder.setTitle("Confirmation");
                builder.setMessage("Do you want to add carry over budget ??");
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                reference.child("Carry Over Budget").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                                        previous_carry_over_budget = Double.parseDouble(String.valueOf(snapshot.getValue()));

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                                reference.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        UserHelperClass object = snapshot.getValue(UserHelperClass.class);


                                        Double new_home_page_current_balance = object.getHomepage_current_balance()+previous_carry_over_budget;
                                        previous_carry_over_budget += object.getHomepage_total_balance();

                                        object.setHomepage_total_balance(previous_carry_over_budget);
                                        object.setHomepage_current_balance(new_home_page_current_balance);

                                        reference.setValue(object);
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        show_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_show_graph = new Intent(others.this, graph.class);
                startActivity(intent_show_graph);
            }
        });


    }
}