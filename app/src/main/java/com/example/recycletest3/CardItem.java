package com.example.recycletest3;


/**
 * class containing values for a wallet
 */


public class CardItem {

    /**
     * name
     */
    private String Name;

    /**
     * amount
     */
    private String Amount;

    private int idWallet;
    private int idUser;


    /**
     * constructor with parameters
     * @param name name.
     * @param amount amount.
     */
    public CardItem( int idWallet,  int idUser, String name, String amount) {
        Name = name;
        Amount = amount;
        this.idUser = idUser;
        this.idWallet = idWallet;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * getter for name
     * @return name
     */

    public String getName() {
        return Name;
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
     * setter for amount
     * @param amount amount.
     */

    public void setAmount(String amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return getName();
    }
}