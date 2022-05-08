package com.techelevator;

import com.techelevator.Sales.Finance;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FinanceTest {
    Finance finance = new Finance();

    @Test
    public void does_customer_change_return_expected_exact_change() {
        //Arrange
        finance.deposit(BigDecimal.valueOf(10.00));
        //Act
        String actual = finance.customerChange();
        String expected = "Your balance is now $0.00. Your change is 10 dollar(s), 0 quarter(s), 0 dime(s), 0 nickel(s).\n\n";
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void does_customer_change_return_expected_exact_change_2() {
        //Arrange
        finance.deposit(BigDecimal.valueOf(5.65));
        //Act
        String actual = finance.customerChange();
        String expected = "Your balance is now $0.00. Your change is 5 dollar(s), 2 quarter(s), 1 dime(s), 1 nickel(s).\n\n";
        //Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void does_customer_change_return_expected_exact_change_with_0_Balance() {
        //Arrange
        finance.deposit(BigDecimal.valueOf(0));
        //Act
        String actual = finance.customerChange();
        String expected = "Your balance is now $0.00. Your change is 0 dollar(s), 0 quarter(s), 0 dime(s), 0 nickel(s).\n\n";
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void does_customer_balance_change_with_purchase() {

        finance.deposit(BigDecimal.valueOf(5.00));
        BigDecimal price = new BigDecimal(1.25);

        finance.vend(price);
        BigDecimal actual = finance.getCustomerBalance();
        BigDecimal expected = new BigDecimal(3.75);

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void does_customer_balance_go_negative_with_purchase() { //logic is in CLI : human test?

        finance.deposit(BigDecimal.valueOf(1.00));
        BigDecimal price = new BigDecimal(1.25);


        boolean actual = finance.hasMoneyRequired(price);
        boolean expected = false;

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void does_customer_balance_change_with_purchase3() {

        finance.deposit(BigDecimal.valueOf(12.75));
        BigDecimal price = new BigDecimal(5.35);

        finance.vend(price);
        BigDecimal actual = finance.getCustomerBalance();
        BigDecimal expected = new BigDecimal(7.40);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void does_customer_have_money_true() {
        finance.deposit(BigDecimal.valueOf(1));
        BigDecimal price = new BigDecimal("1.25");

        boolean actual = finance.hasMoneyRequired(price);

        boolean expected = false;

        Assert.assertFalse(actual);

    }

    @Test
    public void does_customer_have_money_false() {
        finance.deposit(BigDecimal.valueOf(2));
        BigDecimal price = new BigDecimal("1.25");

        boolean actual = finance.hasMoneyRequired(price);

        boolean expected = true;

        Assert.assertTrue(actual);

    }
    @Test
    public void how_much_more_does_customer_need() {
        finance.deposit(BigDecimal.valueOf(3));
        BigDecimal price = new BigDecimal("4.25");

        BigDecimal actual = finance.verifyBalance(price);

        BigDecimal expected = new BigDecimal("1.25");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void how_much_more_does_customer_need1() {
        finance.deposit(BigDecimal.valueOf(3));
        BigDecimal price = new BigDecimal("12.43");

        BigDecimal actual = finance.verifyBalance(price);

        BigDecimal expected = new BigDecimal("9.43");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void how_much_more_does_customer_need3() {
        finance.deposit(BigDecimal.valueOf(0));
        BigDecimal price = new BigDecimal("8.67");

        BigDecimal actual = finance.verifyBalance(price);

        BigDecimal expected = new BigDecimal("8.67");

        Assert.assertEquals(expected, actual);
    }





}
