package com.techelevator;

import com.techelevator.Fooditems.Food;
import com.techelevator.Sales.Finance;
import com.techelevator.Sales.Inventory;
import com.techelevator.Sales.Logger;
import com.techelevator.Sales.SalesReportLogger;
import com.techelevator.User.UserInput;
import com.techelevator.User.UserOutput;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class CaTEringCapstoneCLI {

	private Menu menu;
	Inventory inventory = new Inventory();
	Map<String, Food> mapItems;
	Logger logger;

	public CaTEringCapstoneCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) throws Exception {
		Menu menu = new Menu();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		cli.run();
	}

	public void run() throws Exception{
		Inventory inventory = new Inventory();
		mapItems = inventory.readFromFile2();
		logger = new Logger("auditFile.txt");

		//
		boolean shouldLoop = true;
		while (shouldLoop) {
			UserOutput.displayHomeScreen();
			String selectedOption = UserInput.getHomeScreenOptions();

			if (selectedOption.equals("display")) {
				//Displays a list of all available items
				listAllFood(mapItems);
			} else if (selectedOption.equals("purchase")) {
				//Takes user to purchase menu
				purchaseMenu();

			} else if(selectedOption.equals("secret")){
				//Could not get Secret sales report to work right :(
//				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy_HH:mm:ss a");
//				LocalDateTime now = LocalDateTime.now();
//				String rightNow = "SalesReportFor_" + dtf.format(now) + ".txt";
//				SalesReportLogger salesLogger = new SalesReportLogger(rightNow);
//				inventory.createSalesReport(mapItems, salesLogger);
			} else if(selectedOption.equals("exit")) {
				UserOutput.displayExitScreen();
				shouldLoop = false;
			}
		}
	}

	public void purchaseMenu(){
		boolean shouldStillLoop = true;
		Finance finance = new Finance();
		while (shouldStillLoop) {
			String purchaseOption = UserInput.getPurchaseScreenOptions(finance.getCustomerBalance());
			if (purchaseOption.equals("feed")) {
				//Allows user to insert money into machine
				BigDecimal depositedMoney = UserInput.getUserBalance();
				finance.deposit(depositedMoney);
				finance.auditFeedMoneyWriter(logger, depositedMoney);
				//logger.close();
			} else if (purchaseOption.equals("select")) {
				//Displays list of all items and lets user select an option if it's possible
				listAllFood(mapItems);
				String slotLocation = UserInput.getUserSelection();
				if (!mapItems.containsKey(slotLocation)) {
					UserOutput.messageForInvalidSelection();
					//If the quantity is greater than 0 and the customer has enough money
				} else if (mapItems.get(slotLocation).getQuantity() > 0 && finance.hasMoneyRequired(mapItems.get(slotLocation).getPrice())) {
					inventory.vend(mapItems.get(slotLocation));
					finance.vend(mapItems.get(slotLocation).getPrice());
					finance.auditPurchaseWriter(logger, mapItems.get(slotLocation));
					//logger.close();
					UserOutput.messageForFoodType(mapItems, slotLocation);
					UserOutput.messageForRemainingBalance(finance.getCustomerBalance());
					//If the quantity is greater than 0 but they don't have enough money
				} else if (mapItems.get(slotLocation).getQuantity() > 0 && !finance.hasMoneyRequired(mapItems.get(slotLocation).getPrice())) {
					UserOutput.messageForMoreMoneyRequired(mapItems, finance, slotLocation, finance.verifyBalance(mapItems.get(slotLocation).getPrice()));
				} else {
					UserOutput.messageForItemNotAvailable();
				}
			} else if (purchaseOption.equals("finish")) {
				shouldStillLoop = false;

				finance.auditReceiptWriter(logger);
				//logger.close();
				String receipt = finance.customerChange();

				System.out.println(receipt);

			}
		}
	}

	public void listAllFood(Map<String, Food> itemMap){
		UserOutput.listInventory(itemMap);
	}
}
