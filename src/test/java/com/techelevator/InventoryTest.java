package com.techelevator;

import com.techelevator.Fooditems.Food;
import com.techelevator.Sales.Inventory;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class InventoryTest {

    Inventory inventory = new Inventory();
    Food food = new Food("D7", "cheese curlz", "muchy", new BigDecimal(3.23), 7);

    Map<String, Food> itemsMap = new HashMap<>();

    //Our logic preventing user from buying an option that's out of stock exists in main class
    @Test
    public void does_quantity_subtract_correctly(){

        int expected = 6;

        inventory.vend(food);
        int actual = food.getQuantity();


        Assert.assertEquals(expected, actual);

        int newExpected = 5;

        inventory.vend(food);
        int newActual = food.getQuantity();


        Assert.assertEquals(newExpected, newActual);
    }
    //These tests are for catering.csv
    @Test
    public void does_map_size_equal_text_file_size(){

        int actual = inventory.readFromFile2().size();
        int expected = 16;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void does_map_contain_specific_item_slotLocation(){
        //drink
        boolean actual = inventory.readFromFile2().containsKey("B3");

        Assert.assertTrue(actual);


    }
    @Test
    public void map_doesnt_contain_specific_item_slotLocation(){
        //doesn't exist
        boolean actual = inventory.readFromFile2().containsKey("R3");

        Assert.assertFalse(actual);

    }
    @Test
    public void does_map_contain_specific_item_slotLocation_C1(){
        //munchy
        boolean actual = inventory.readFromFile2().containsKey("C1");

        Assert.assertTrue(actual);


    }
    @Test
    public void does_map_contain_specific_item_slotLocation_A2(){
        //sandwich
        String actual = inventory.readFromFile2().get("A2").getName();

        String expected = "Walking Tacos";

        Assert.assertEquals(expected, actual);
    }
    //These tests are for catering1.csv

    @Test
    public void does_map_size_equal_text_file_size_file_2(){

        int actual = inventory.readFromFile().size();
        int expected = 16;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void does_map_contain_specific_item_slotLocation_file_2(){
        //drink
        boolean actual = inventory.readFromFile().containsKey("B3");

        Assert.assertTrue(actual);


    }
    @Test
    public void map_doesnt_contain_specific_item_slotLocation_file_2(){
        //doesn't exist
        boolean actual = inventory.readFromFile().containsKey("R3");

        Assert.assertFalse(actual);

    }
    @Test
    public void does_map_contain_specific_item_slotLocation_C1_file_2(){
        //munchy
        boolean actual = inventory.readFromFile().containsKey("C1");

        Assert.assertTrue(actual);


    }
    @Test
    public void does_map_contain_specific_item_slotLocation_A2_file_2(){
        //sandwich
        String actual = inventory.readFromFile().get("A2").getName();

        String expected = "Walking Tacos";

        Assert.assertEquals(expected, actual);
    }


    }

