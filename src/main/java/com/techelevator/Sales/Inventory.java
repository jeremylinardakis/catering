package com.techelevator.Sales;

import com.techelevator.Fooditems.Food;
import com.techelevator.User.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {

    public Map<String, Food> readFromFile2() {
        Scanner scanner;
        File file = new File("catering.csv");

        Map<String, Food> itemsMap = new TreeMap<>();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(",");
                Food food = new Food(lineArray[0], lineArray[1], lineArray[2], BigDecimal.valueOf(Double.parseDouble(lineArray[3])), 7);
                itemsMap.put(lineArray[0], food);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemsMap;
    }


    public void vend(Food food){
        food.setQuantity(food.getQuantity() - 1);
    }

    //This read from file is only used in our tests so we could check both txt files
    public Map<String, Food> readFromFile() {
        Scanner scanner;
        File file = new File("catering1.csv");
        Map<String, Food> allItems = new TreeMap<>();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(",");
                Food food = new Food(lineArray[0], lineArray[1], lineArray[2], BigDecimal.valueOf(Double.parseDouble(lineArray[3])), 7);
                allItems.put(lineArray[0], food);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allItems;
    }

    public void createSalesReport(Map<String, Food> itemMap, SalesReportLogger logger){
        for(Map.Entry<String, Food> item : itemMap.entrySet()){
             logger.write(item.getValue().getName() + " " + quantitySold(item.getValue()));
        }
    }

    public int quantitySold(Food food){
        int startingQuantity = 7;

        return startingQuantity - food.getQuantity();
    }


}
