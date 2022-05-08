package com.techelevator.User;

import com.techelevator.Fooditems.Food;
import com.techelevator.Sales.Finance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class UserOutput {

    public static void displayHomeScreen(){
        System.out.println("<<----------------------------------------->>");
        System.out.println("<<------  CATERING VENDING MACHINE   ------>>");
        System.out.println("<<----------------------------------------->>");

    }

    public static void listInventory(Map<String, Food> itemMap){
        System.out.print("\n");
        for(Map.Entry<String, Food> item : itemMap.entrySet()){
            System.out.println(" | " + item.getValue().getSlotLocation() + " | " + item.getValue().getName() + " | " + item.getValue().getType() + " | $" + item.getValue().getPrice());
        }
        System.out.print("\n");
    }

    public static void messageForItemNotAvailable(){
        System.out.println("\n>> This item is no longer available <<\n      " +
                ">> Please select again. <<\n");
    }

    public static void messageForInvalidSelection(){
        System.out.println("\n     >> This is not a valid option << \n        >> please select again <<\n");
    }

    public static void messageForMoreMoneyRequired(Map<String, Food> mapItems, Finance finance, String slotLocation, BigDecimal amountNeeded){
        System.out.println("\n>> Insufficient funds! <<\n" + ">> " +mapItems.get(slotLocation).getName() + " costs $" + mapItems.get(slotLocation).getPrice()
                + "<< \n>> please insert at least $" + amountNeeded + " <<\n");
    }

    public static void messageForRemainingBalance(BigDecimal customerBalance){
        System.out.println(">> Your remaining balance is : $ " + customerBalance + " <<\n");
    }

    public static void messageForFoodType(Map<String, Food> itemMap, String slotLocation){
        Food chosenItem = itemMap.get(slotLocation);
        System.out.println("\n         >>>  Success!  <<<");
        System.out.println(">>> Your " + chosenItem.getName() + " is dispensing! <<<");
        if(chosenItem.getType().equals("Munchy")){
            System.out.println("  >>> Munchy, Munchy, so Good! <<<\n");
        } else if(chosenItem.getType().equals("Sandwich")){
            System.out.println(" >>> Sandwich So Delicious, Yum! <<<\n");
        } else if(chosenItem.getType().equals("Drink")){
            System.out.println(" >>> Drinky, Drinky, Slurp Slurp! <<<\n");
        } else {
            System.out.println("    >>> Sugar, Sugar, so Sweet! <<<\n");
        }
    }

    public static void displayExitScreen(){
        System.out.println("<<----------------------------------------->>");
        System.out.println("<<----- THANK YOU FOR SHOPPING WITH ------->>");
        System.out.println("<<----------  TECH ELEVATOR  -------------->>");
        System.out.println("<<----------------------------------------->>");
    }

}
