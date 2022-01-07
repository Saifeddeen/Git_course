package com.example.myapplication.OOP;

public class Food {

    public static String[] categs = {"Carbohidrates","Fish", "Fruit", "UnCategorized"};
    private String name;
    private String category;
    private int calory;
    private String photo;

    public Food(String name, String category, int calory, String photo){

        this.setName(name);
        this.setCategory(category);
        this.setCalory(calory);
        this.setPhoto(photo);

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public int getCalory() {
        return calory;
    }

    public void setCategory(String category) {
        for(int i=0; i<4; i++){
            if(category.equalsIgnoreCase(Food.categs[i])){
                this.category = category;
                return;
            }
        }
        this.category = "UnCategorized";
    }

    public String getCategory() {
        return category;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }
}
