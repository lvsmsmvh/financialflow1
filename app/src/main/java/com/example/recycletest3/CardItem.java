package com.example.recycletest3;

public class CardItem {

    private String Name;
    private String Amount;



    public CardItem(String name, String amount) {
        Name = name;
        Amount = amount;
    }


    //Getter

    public String getName() {
        return Name;
    }

    public String getAmount() {
        return Amount;
    }




    //Setter

    public void setName(String name) {
        Name = name;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
