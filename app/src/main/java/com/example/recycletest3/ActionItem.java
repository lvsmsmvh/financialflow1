package com.example.recycletest3;

public class ActionItem {

    private String Name;
    private String Date;
    private String Card;
    private String Amount;

    public ActionItem(String name, String date, String card, String amount) {
        Name = name;
        Date = date;
        Card = card;
        Amount = amount;
    }


    //Getter

    public String getName() {
        return Name;
    }

    public String getDate() {
        return Date;
    }

    public String getCard() {
        return Card;
    }

    public String getAmount() {
        return Amount;
    }




    //Setter

    public void setName(String name) {
        Name = name;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setCard(String card) {
        Card = card;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
