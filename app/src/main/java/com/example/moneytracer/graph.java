package com.example.moneytracer;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class graph extends AppCompatActivity {

    private double homepage_show_debt;
    private double homepage_total_balance;
    private double homepage_current_balance;
    private double homepage_current_expense;

    FirebaseDatabase database;
    DatabaseReference reference;
    private FirebaseAuth mAuth;
    private com.google.firebase.auth.FirebaseUser FirebaseUser;

    String s1,s2,s3,s4;
    float value1, value2, value3,value4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);




        /*String path = "users/"+MainActivity.currentUserID;
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        FirebaseUser = mAuth.getCurrentUser();
        reference= database.getReference(path);

        //getData

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass object = snapshot.getValue(UserHelperClass.class);



                    homepage_total_balance = object.getHomepage_total_balance();
                    homepage_current_balance = object.getHomepage_current_balance();
                    homepage_current_expense = object.getHomepage_current_expense();
                    homepage_show_debt = object.getHomepage_show_debt();

                    *//*s1 = String.valueOf(homepage_total_balance);
                    s2 = String.valueOf(homepage_current_balance);
                    s3 = String.valueOf(homepage_current_expense);
                    s3 = String.valueOf(homepage_show_debt);

                    value1 = Float.parseFloat(String.valueOf(s1));
                    value2 = Float.parseFloat(String.valueOf(s2));
                    value3 = Float.parseFloat(String.valueOf(s3));
                    value4 = Float.parseFloat(String.valueOf(s4));*//*

         *//* PieChart pieChart= findViewById(R.id.pieChart);
                ArrayList<PieEntry> visitors = new ArrayList<>();
                visitors.add(new PieEntry(value1,"Total Budget"));
                visitors.add(new PieEntry( value2,"Current Balance"));
                visitors.add(new PieEntry(value3,"Current Expense"));
                visitors.add(new PieEntry( value4,"Current Debt"));



                PieDataSet pieDataSet = new PieDataSet(visitors, "nunu");
                pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                pieDataSet.setValueTextColor(Color.BLACK);
                pieDataSet.setValueTextSize(16f);
                PieData pieData = new PieData((pieDataSet));
                pieChart.setData(pieData);
                pieChart.getDescription().setEnabled(false);
                pieChart.setCenterText("halo");
                pieChart.animate();

*//*

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        s1 = String.valueOf(homepage_total_balance);
        s2 = String.valueOf(homepage_current_balance);
        s3 = String.valueOf(homepage_current_expense);
        s3 = String.valueOf(homepage_show_debt);

        value1 = Float.parseFloat(String.valueOf(s1));
        value2 = Float.parseFloat(String.valueOf(s2));
        value3 = Float.parseFloat(String.valueOf(s3));
        value4 = Float.parseFloat(String.valueOf(s4));*/

        PieChart pieChart= findViewById(R.id.pieChart);
        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(1000,"Total Budget"));
        visitors.add(new PieEntry( 700,"Current Balance"));
        visitors.add(new PieEntry(300,"Current Expense"));




        PieDataSet pieDataSet = new PieDataSet(visitors, "Cost");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);
        PieData pieData = new PieData((pieDataSet));
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText(" ");
        pieChart.animate();





    }
}
