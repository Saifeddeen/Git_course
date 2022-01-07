package com.example.myapplication.OOP;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AppMethodsData {

    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Food> food = new ArrayList<Food>();

    private static User authUser;
    private static Food selectedFood;

    //users list methods
    public static void setUsers(ArrayList<User> users) {
        AppMethodsData.users = users;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User user){
        AppMethodsData.users.add(user);
    }

    public static void deleteUser(User user){
        AppMethodsData.users.remove(user);
    }
    ///////////////////////////////////////////////

    //food list methods
    public static void setFood(ArrayList<Food> food) {
        AppMethodsData.food = food;
    }

    public static ArrayList<Food> getFood() {
        return food;
    }

    public static void addFood(Food newfood){
        AppMethodsData.food.add(newfood);
    }

    public static void deleteFood(Food toDelFood){
        AppMethodsData.food.remove(toDelFood);
    }
    ///////////////////////////////////////////////

    //set, get auth user
    public static void setAuthUser(User authUser) {
        AppMethodsData.authUser = authUser;
    }

    public static User getAuthUser() {
        return authUser;
    }
    ///////////////////////////////////////////////

    //user registration
    public static User register(String name, String email, String password, String confirmPassword, Context context){
        if(name!=null && email!=null && password!=null && confirmPassword!=null){
            //check email
            if(User.checkEmail(email)){
                if(!User.findEmail(email, AppMethodsData.users)){
                    //check password
                    if(password.equals(confirmPassword)){
                        return new User(name,email,password);
                    }else{
                        Toast.makeText(context, "password does not match confirmation!!!", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(context, "email exists!!!", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(context, "email not valid!!!", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(context, "complete all fields!!!", Toast.LENGTH_LONG).show();
        }
        return null;
    }
    ///////////////////////////////////////////////

    //user login
    public static User login(String email, String password){
        User user = AppMethodsData.findUserFromEmail(email);
        if(user != null){
            if(user.getPassword().equals(password)){
                AppMethodsData.authUser = user;
                return user;
            }
        }
        return null;
    }

    //get user from email
    public static User findUserFromEmail(String email){
        for(int i=0; i<=users.size(); i++){
            if(email.equals(AppMethodsData.users.get(i).getEmail())){
                return AppMethodsData.users.get(i);
            }
        }
        return null;
    }

    //set, get selected food
    public static void setSelectedFood(Food selectedFood) {
        AppMethodsData.selectedFood = selectedFood;
    }

    public static Food getSelectedFood() {
        return selectedFood;
    }

    //user status methods
    //notes
    /*
    * dates problems
    * images problems
    * increase and decrease buttons
    * user status
    * trying the app*/

}
