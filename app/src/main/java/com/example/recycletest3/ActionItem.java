package com.example.recycletest3;



/**
 * class containing values for an action (expenses and incomes)
 */

public class ActionItem {
    /**
     * name
     */
    private String Name;
    /**
     * date
      */
    private String Date;
    /**
     * card (bank (oshadbank, privatbank, etc.) )
     */
    private String Card;
    /**
     * amount
     */
    private String Amount;

    /**
     * constructor with parameters
     * @param name name.
     * @param date date.
     * @param card card.
     * @param amount amount.
     */
    public ActionItem(String name, String date, String card, String amount) {
        Name = name;
        Date = date;
        Card = card;
        Amount = amount;
    }


    /**
     * getter for name
     * @return name
     */


    public String getName() {
        return Name;
    }

    /**
     * getter for date
     * @return date
     */

    public String getDate() {
        return Date;
    }

    /**
     * getter for card
     * @return card
     */

    public String getCard() {
        return Card;
    }


    /**
     * getter for amount
     * @return amount
     */

    public String getAmount() {
        return Amount;
    }


    /**
     * setter for name
     * @param name name.
     */
    public void setName(String name) {
        Name = name;
    }


    /**
     * setter for date
     * @param date date.
     */
    public void setDate(String date) {
        Date = date;
    }


    /**
     * setter for card
     * @param card card.
     */
    public void setCard(String card) {
        Card = card;
    }


    /**
     * setter for amount
     * @param amount amount.
     */
    public void setAmount(String amount) {
        Amount = amount;
    }
}
