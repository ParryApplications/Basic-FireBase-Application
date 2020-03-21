package com.example.paras.firstfirebaseapplication;

import android.widget.EditText;

public class Model
{
    public Model() {
    }

    public Model(String name_id, String email_send_id, String pass_send_id, String age_send_id, String phone_send_id, String user_id) {
        this.name_id = name_id;
        this.email_send_id = email_send_id;
        this.pass_send_id = pass_send_id;
        this.age_send_id = age_send_id;
        this.phone_send_id = phone_send_id;
        this.user_id = user_id;
    }

    public String getName_id() {
        return name_id;
    }

    public void setName_id(String name_id) {
        this.name_id = name_id;
    }

    public String getEmail_send_id() {
        return email_send_id;
    }

    public void setEmail_send_id(String email_send_id) {
        this.email_send_id = email_send_id;
    }

    public String getPass_send_id() {
        return pass_send_id;
    }

    public void setPass_send_id(String pass_send_id) {
        this.pass_send_id = pass_send_id;
    }

    public String getAge_send_id() {
        return age_send_id;
    }

    public void setAge_send_id(String age_send_id) {
        this.age_send_id = age_send_id;
    }

    public String getPhone_send_id() {
        return phone_send_id;
    }

    public void setPhone_send_id(String phone_send_id) {
        this.phone_send_id = phone_send_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    private String name_id,email_send_id,pass_send_id,age_send_id,phone_send_id;
    private String user_id;
}
