package com.example.moneytracer;

public class UserHelperClass {
    private String name, email, phone, password;
    private double homepage_show_debt;
    private double homepage_total_balance;
    private double homepage_current_balance;
    private double homepage_current_expense;

    public UserHelperClass() {

    }

    public UserHelperClass(String name, String email, String phone, String password,double homepage_show_debt,double homepage_total_balance,double homepage_current_balance,double homepage_current_expense) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.homepage_show_debt= homepage_show_debt;
        this.homepage_total_balance = homepage_total_balance;
        this.homepage_current_balance = homepage_current_balance;
        this.homepage_current_expense = homepage_current_expense;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getHomepage_show_debt() {
        return homepage_show_debt;
    }

    public void setHomepage_show_debt(double homepage_show_debt) {
        this.homepage_show_debt = homepage_show_debt;
    }

    public double getHomepage_total_balance() {
        return homepage_total_balance;
    }

    public void setHomepage_total_balance(double homepage_total_balance) {
        this.homepage_total_balance = homepage_total_balance;
    }

    public double getHomepage_current_balance() {
        return homepage_current_balance;
    }

    public void setHomepage_current_balance(double homepage_current_balance) {
        this.homepage_current_balance = homepage_current_balance;
    }

    public double getHomepage_current_expense() {
        return homepage_current_expense;
    }

    public void setHomepage_current_expense(double homepage_current_expense) {
        this.homepage_current_expense = homepage_current_expense;
    }
}


