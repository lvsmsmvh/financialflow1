package com.example.recycletest3;

import java.util.ArrayList;

public class WalletHolder {
    private static ArrayList<CardItem> walletList = new ArrayList<>();

    public static ArrayList<CardItem> getWalletList() {
        return walletList;
    }

    public static void clearWallets(){
        walletList.clear();
    }
    public static CardItem getWalletByIndex(int index) {
        return walletList.get(index);
    }

    public static void addWallet(CardItem wallet) {
        walletList.add(wallet);
    }

    public static String[] getWalletNames() {
        String[] names = new String[walletList.size()];

        for (int i = 0; i < walletList.size(); i++) {
            names[i] = walletList.get(i).getName();
        }
        return names;
    }
}
