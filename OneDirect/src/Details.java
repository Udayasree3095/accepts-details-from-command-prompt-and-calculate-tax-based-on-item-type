import java.util.ArrayList;
import java.util.Scanner;




public class Details {
	
	static Scanner scan;
	static String itemName, itemType, itemQuantity;
	static char more;
	static ArrayList<ItemEncaps> arrayList;
	static int count = 0;
	static String[] th = {"First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth","Eleventh","Twelfth","Thirteenth","Fourteenth","Fifteenth","Sixteenth","Seventeenth","Eighteenth","Nineteenth","Twentieth"};
	private static String itemPrice;
	
	
//**************************************************************************************
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		System.out.println(" FILL ITEM(S) DETAILS ");
		System.out.println();
		
		arrayList = new ArrayList<ItemEncaps>();
		
		itemDetails(true);
		
		display();
		
	}
//**************************************************************************************	
	
	
	
//**************************************************************************************
	/* User will enter the details of items */
	static public void itemDetails(boolean bool){
		if (bool == true) {
			System.out.println("-- Detail of "+th[count]+" Item --"+"\n");
			count++;
			System.out.print("Item Name : ");
			itemName = scan.nextLine();
			itemName = itemName.toUpperCase();
			System.out.println();
			//scan.nextLine();
			System.out.println("Select ITEM TYPES \n\t1. RAW \n\t2. MANUFACTURED \n\t3. IMPORTED ");
			System.out.print("Item Type (Digit) : ");
			itemType = scan.next();
			if(itemType.equals("1")){
				itemType = "RAW";
			} else if(itemType.equals("2")){
				itemType = "MANUFACTURED";
			} else if(itemType.equals("3")){
				itemType = "IMPORTED";
			} else{
				count = count - 1;
				scan.nextLine();
				System.out.println("INVALID - TRY AGAIN LATER");
				System.out.println();
				itemDetails(true);
				System.out.println();
			}
			System.out.println();
			scan.nextLine();
			System.out.print("Item Quantity (Digit) : ");
			itemQuantity = scan.next();
			System.out.println();
			scan.nextLine();
			System.out.print("Item Price (Digit) : ");
			itemPrice = scan.next();
			System.out.println();
			ItemEncaps itemEncaps = new ItemEncaps(itemName, itemType, itemQuantity, itemPrice);
			arrayList.add(itemEncaps);
			scan.nextLine();
			addMoreItem();
		}else {
			return;
		}
		
	}
//**************************************************************************************
	
	
	
//**************************************************************************************
	/* can enter the details multiple times */
	static public void addMoreItem(){
		System.out.print("Do you want to add more items (Y/N) : ");
		more = scan.next().trim().charAt(0);
		System.out.println();
		scan.nextLine();
		if (more == 'Y' || more == 'y') {
			itemDetails(true);
		} else if (more == 'N' || more == 'n') {
			
			itemDetails(false);
		} else {
			System.out.println("INVALID INPUT");
			addMoreItem();
		}
	}
//**************************************************************************************
	

	
//**************************************************************************************	
	/* Calculation of tax for the item type & item price  */
	static public void taxCalculator(String type, double price, long quantity) {
		double taxableAmount, totalTax, totalValue, finalCustomerPrice;
		switch (type) {
		case "RAW":
			
			System.out.println();
			taxableAmount = (((float) 12.5 * price ) / 100);
			System.out.println("\tTax for each item (12.5%) = "+taxableAmount);
			
			totalTax = taxableAmount * quantity;
			System.out.println("\tTotal Tax for quantity items = "+totalTax);
			
			totalValue = price * quantity;
			System.out.println("\tPrice of the total quantity items = "+totalValue);
			
			
			finalCustomerPrice = totalValue + totalTax;
			System.out.println("\tFinal Price for Customers including TAX = "+finalCustomerPrice);
			System.out.println();
			
			
			break;
		case "MANUFACTURED":
			
			System.out.println();
			taxableAmount = (((float) 12.5 * price) / 100);
			System.out.println("\tTax for each item (12.5%) = "+taxableAmount);
			
			totalTax = taxableAmount * quantity;
			System.out.println("\tTotal Tax for quantity items = "+totalTax);
			
			totalValue = price * quantity;
			System.out.println("\tPrice of the total quantity items = "+totalValue);
						
			double manufactTax = (((float) 2.0 * price ) / 100);
			System.out.println("\tManufactured Tax (2%) of each item = "+manufactTax);
			
			manufactTax *= quantity;
			System.out.println("\tTotal Manufactured Tax (2%) of quantity items = "+manufactTax);
			
			finalCustomerPrice = totalValue + totalTax + manufactTax;
			System.out.println("\tFinal Price for Customers including TAXs = "+finalCustomerPrice);
			System.out.println();
			
			
			break;
		case "IMPORTED":
			
			System.out.println();
			taxableAmount = (((float) 12.5 * price) / 100);
			System.out.println("\tTax for each item (12.5%) = "+taxableAmount);
			
			double importDuty = (((float) 10 * price) / 100);
			System.out.println("\tImport Duty Tax for each item (10%) = "+importDuty);
			
			totalTax = ((taxableAmount + importDuty) * quantity);
			System.out.println("\tTotal Tax for quantity items(Tax + Import Duty)  = "+totalTax);
			
			totalValue = price * quantity;
			System.out.println("\tPrice of the total quantity items = "+totalValue);
			
			finalCustomerPrice = totalValue + totalTax;
			
			
			if(finalCustomerPrice <= 100){
				//Rs. 5 if the final cost after applying tax
				finalCustomerPrice += 5;
				System.out.println("\tFinal Price for Customers including TAXs + Import Duty  + surcharge = "+finalCustomerPrice);
			} else if(finalCustomerPrice > 100 && finalCustomerPrice <= 200){
				//Rs. 10 if the cost exceeds 100
				finalCustomerPrice += 10;
				System.out.println("\tFinal Price for Customers including TAXs + Import Duty  + surcharge = "+finalCustomerPrice);
			} else {
				double tx = (((float) 5 * finalCustomerPrice) / 100);
				finalCustomerPrice += tx;
				System.out.println("\tFinal Price for Customers including TAXs + Import Duty + surcharge = "+finalCustomerPrice);
			}
			
			break;
		default:
			break;
		}
	}
//**************************************************************************************

	
	
//**************************************************************************************	
	/* Displaying the item details with tax calculation */
	static public void display(){
		for (int i = 0; i < arrayList.size(); i++) {
			ItemEncaps iEncaps = arrayList.get(i);
			System.out.println();
			System.out.print("Name : "+iEncaps.getName()+"  |  ");
			System.out.print("Type : "+iEncaps.getType()+"  |  ");
			System.out.print("Quantity : "+iEncaps.getQuantity()+"  |  ");
			double price = Double.parseDouble(iEncaps.getPrice());
			String pr = (price < 1) ? "paisa" : "Rupees";
			System.out.print("Price : "+price+" "+pr);
			System.out.println();
			taxCalculator(iEncaps.getType(), Double.parseDouble(iEncaps.getPrice()), Integer.parseInt(iEncaps.getQuantity()));
		}
	}
//**************************************************************************************
	
}
