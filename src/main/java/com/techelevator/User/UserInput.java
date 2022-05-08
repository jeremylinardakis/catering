package com.techelevator.User;

import com.techelevator.Fooditems.Food;
import com.techelevator.Sales.Finance;
import com.techelevator.Sales.Inventory;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private static Scanner userInput = new Scanner(System.in);
    String option = "";

    public static String getHomeScreenOptions() {
        System.out.println("<<-------------- HOME SCREEN -------------->>\n");

        System.out.println("(D) Display caTEring Items");
        System.out.println("(P) Purchase");
        System.out.println("(E) Exit\n");
        System.out.println("  ---> Please select an option:\n");

        String option = userInput.nextLine();
        String selectedOption = option.trim().toLowerCase();

        switch (selectedOption) {
            case "d":
                return "display";
            case "p":
                return "purchase";
            case "e":
                return "exit";
            case "s":
                return "secret";
            default :
                UserOutput.displayHomeScreen();
                getHomeScreenOptions();
                return "";

        }

    }

    public static String getPurchaseScreenOptions(BigDecimal currentBalance){
        System.out.println("\n<<----------- PURCHASE SCREEN ------------>>");
        System.out.println("  ---> Please select an option:\n");
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction\n");
        System.out.println("Your current balance is: $" + currentBalance + "\n");
        String option = userInput.nextLine();
        String selectedOption = option.trim().toLowerCase();


        switch (selectedOption) {
            case "m":
                return "feed";
            case "s":
                return "select";
            case "f":
                return "finish";
            default:
                return "";
        }
    }

    public static String getUserSelection() {
        System.out.println("\nPlease enter your item letter and number: \n");
        String slotLocation = userInput.nextLine().toUpperCase();
        return slotLocation;
    }

    public static BigDecimal getUserBalance(){
        BigDecimal deposit;
        System.out.println("\n>> Please enter the amount you depositing in \nwhole dollar amounts ($1, $5, $10, $20) <<\n");
        String depositAmount = userInput.nextLine();
        deposit = new BigDecimal(depositAmount);

        if(deposit.compareTo(new BigDecimal("1.00")) == 0){
            return deposit;
        } else if (deposit.compareTo(new BigDecimal("5.00")) == 0){
            return deposit;
        } else if (deposit.compareTo(new BigDecimal("10.00")) == 0){
            return deposit;
        } else if (deposit.compareTo(new BigDecimal("20.00")) == 0){
            return deposit;
        } else {
            System.out.println("\n>> This is not a valid entry. <<\n>> Please enter whole dollar amount: \n($1, $5, $10, $20) <<\n");
            return new BigDecimal("0.00");
        }





    }


}
