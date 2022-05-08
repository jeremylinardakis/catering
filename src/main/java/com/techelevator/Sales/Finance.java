package com.techelevator.Sales;

import com.techelevator.Fooditems.Food;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Finance {


    private BigDecimal customerBalance = new BigDecimal("0.00");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
    LocalDateTime now = LocalDateTime.now();
    private String rightNow = dtf.format(now);


    public BigDecimal getCustomerBalance() {
        return customerBalance;
    }

    public void vend(BigDecimal price){
        customerBalance = customerBalance.subtract(price);
    }

    public BigDecimal verifyBalance(BigDecimal price){  //changed to accept price instead of food, made the necessary changes to CLI
        BigDecimal amountNeeded = price.subtract(customerBalance);
        return amountNeeded;
    }

    public boolean hasMoneyRequired(BigDecimal price){
        if(price.compareTo(customerBalance) > 0){
            return false;
        }
        return true;
    }

    public void deposit(BigDecimal depositAmount){
            customerBalance = customerBalance.add(depositAmount);
    }

    public String customerChange(){

        BigDecimal number = customerBalance;
        BigDecimal change = number.multiply(new BigDecimal("100"));
        int tempChange = change.intValue();

        int dollars = tempChange / 100;
        tempChange %= 100;
        int quarters = tempChange / 25;
        tempChange %= 25;
        int dimes = tempChange / 10;
        tempChange %= 10;
        int nickels = tempChange / 5;

        customerBalance = new BigDecimal("0.00");
        return "Your balance is now $" + customerBalance + ". Your change is " + dollars + "\ndollar(s), " + quarters +
                   " quarter(s), " + dimes + " dime(s), " + nickels + " nickel(s).\n\n";

    }

    public void auditPurchaseWriter(Logger logger, Food food){
        logger.write(rightNow + " $" + customerBalance.add(food.getPrice()) + " $" + customerBalance);

    }

    public void auditFeedMoneyWriter(Logger logger, BigDecimal depositedMoney){
        logger.write(rightNow + " $" + customerBalance.add(depositedMoney) + " $" + customerBalance);
    }

    public void auditReceiptWriter(Logger logger){
        logger.write(rightNow + " $" + customerBalance + " $0.00");
    }










}

