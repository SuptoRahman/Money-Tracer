package com.example.moneytracer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Calculator extends AppCompatActivity {

    double in1 = 0, i2 = 0;
    TextView edittext1;
    boolean Add, Sub, Multiply, Divide, Remainder, deci;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_Del, button_Dot, button_Remainder,add_expense;

    public String expense_var;

    TextView show_expense_category;

    //variables
    private double homepage_show_debt;
    private double homepage_total_balance;
    private double homepage_current_balance;
    private double homepage_current_expense;
    private double transfer_expense;

    //database
    FirebaseDatabase database;
    DatabaseReference reference;


    private FirebaseAuth mAuth;
    private com.google.firebase.auth.FirebaseUser FirebaseUser;
    UserHelperClass object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        button_0 = (Button) findViewById(R.id.zero_button);
        button_1 = (Button) findViewById(R.id.one_button);
        button_2 = (Button) findViewById(R.id.two_button);
        button_3 = (Button) findViewById(R.id.three_button);
        button_4 = (Button) findViewById(R.id.four_button);
        button_5 = (Button) findViewById(R.id.five_button);
        button_6 = (Button) findViewById(R.id.six_button);
        button_7 = (Button) findViewById(R.id.seven_button);
        button_8 = (Button) findViewById(R.id.eight_button);
        button_9 = (Button) findViewById(R.id.nine_button);
        button_Dot = (Button) findViewById(R.id.dot_button);
        button_Add = (Button) findViewById(R.id.add_button);
        button_Sub = (Button) findViewById(R.id.minus_button);
        button_Mul = (Button) findViewById(R.id.mul_button);
        button_Div = (Button) findViewById(R.id.div_button);
        button_Remainder = (Button) findViewById(R.id.remainder_button);
        button_Del = (Button) findViewById(R.id.del_button);
        button_Equ = (Button) findViewById(R.id.equal_button);
        add_expense = (Button) findViewById(R.id.add_new_expense_button);

        edittext1 = (TextView) findViewById(R.id.add_total_budget_bar);

        show_expense_category = (TextView) findViewById(R.id.from_menu);

        //firebase
        String path = "users/"+MainActivity.currentUserID;
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        FirebaseUser = mAuth.getCurrentUser();
        reference= database.getReference(path);


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                object = snapshot.getValue(UserHelperClass.class);

                homepage_total_balance = object.getHomepage_total_balance();
                homepage_current_balance = object.getHomepage_current_balance();
                homepage_current_expense = object.getHomepage_current_expense();
                homepage_show_debt = object.getHomepage_show_debt();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        add_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transfer_expense = Double.parseDouble(edittext1.getText().toString());



                homepage_current_expense+=transfer_expense;
                object.setHomepage_current_expense(homepage_current_expense);
                if(homepage_current_balance>=transfer_expense){
                    homepage_current_balance -= transfer_expense;
                }
                else{
                    homepage_show_debt += (transfer_expense - homepage_current_balance);
                    homepage_current_balance =0;
                }
                object.setHomepage_current_balance(homepage_current_balance);
                object.setHomepage_show_debt(homepage_show_debt);

                reference.setValue(object);
                Intent intent = new Intent(Calculator.this, home_page.class);
                startActivity(intent);

            }
        });


        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "9");
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "0");
            }
        });

        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Add = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Sub = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Multiply = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Divide = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Remainder = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });

        button_Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Add || Sub || Multiply || Divide || Remainder) {
                    i2 = Float.parseFloat(edittext1.getText() + "");
                }

                if (Add) {

                    edittext1.setText(in1 + i2 + "");
                    Add = false;
                }

                if (Sub) {

                    edittext1.setText(in1 - i2 + "");
                    Sub = false;
                }

                if (Multiply) {
                    edittext1.setText(in1 * i2 + "");
                    Multiply = false;
                }

                if (Divide) {
                    edittext1.setText(in1 / i2 + "");
                    Divide = false;
                }
                if (Remainder) {
                    edittext1.setText(in1 % i2 + "");
                    Remainder = false;
                }
            }
        });

        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText("");
                in1 = 0.0;
                i2 = 0.0;
            }
        });

        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deci) {
                    //do nothing or you can show the error
                } else {
                    edittext1.setText(edittext1.getText() + ".");
                    deci = true;
                }

            }
        });

        expense_var = getIntent().getStringExtra("key");
        show_expense_category.setText(expense_var);



    }
}