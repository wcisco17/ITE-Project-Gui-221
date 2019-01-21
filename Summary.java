import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Summary {
	
//	Checking the Annual Summary
	public static void annualsum(int year) throws FileNotFoundException {
		
		//variable income
		double retailsum = 0;
		double wholesalesum = 0;
		double otinsum = 0;
		double totalincome = 0;
		//variable expense
		double Invsum = 0;
		double Salsum = 0;
		double Ultsum = 0;
		double otexsum = 0;
		double totalexpense = 0;
		//total variable
		double profitloss = 0; // totalincome - totalexpense
		//System variable
		String line = "";
		String category = "";
		double value = 0;
		
		
		//combine income file
		System.out.println("===================");
		System.out.println("Please wait . . . .");
		System.out.println("===================");
		System.out.println();
		
		List<File> files = Output.getAllFiles(Helper.INCOME_PATH+year);
	    if(files.size() > 0) { //check if have file then perform
	    		
	    for(File f : files) {
	    	System.out.println("Reading file " + f.getAbsolutePath());
	    	Scanner scanner = new Scanner(f);
	    	while(scanner.hasNextLine()) {
	    		line = scanner.nextLine();
		    	//System.out.println(line);
		    	category = Output.getCategory(line);
		    	value = Output.getValue(line);
		    	System.out.println("Category : "+category+", Value : "+value);
		    	//compute for total of each category
		    	if(category.equalsIgnoreCase("ws")) {
		    		wholesalesum += value;
		    	} else if (category.equalsIgnoreCase("rs")) {
		    		retailsum += value;
		    	} else if (category.equalsIgnoreCase("ot")) {
		    		otinsum += value;
		    	} 
	    	}
	    	
	    	scanner.close();
	    }
		
	    } else { //don't have file show
	    	System.out.println("You do not have any income in "+ year);
	    }
	    
	    //combine expense file
	    files = Output.getAllFiles(Helper.EXPENSE_PATH+year);
	    if(files.size() > 0) {
	  
	    for(File f : files) {
	    	System.out.println("Reading file " + f.getAbsolutePath());
	    	Scanner scanner = new Scanner(f);
	    	while(scanner.hasNextLine()) {
	    		line = scanner.nextLine();
		    	System.out.println(line);
		    	category = Output.getCategory(line);
		    	value = Output.getValue(line);
		    	System.out.println("Category : "+category+", Value : "+value);
		    	//compute for total of each category
		    	if(category.equalsIgnoreCase("iv")) {
		    		Invsum += value;
		    	} else if (category.equalsIgnoreCase("sl")) {
		    		Salsum += value;
		    	} else if (category.equalsIgnoreCase("ut")) {
		    		Ultsum += value;
		    	} else if (category.equalsIgnoreCase("ot")) {
		    		otexsum += value;
		    	} 
	    	}
	    	
	    	scanner.close();
		    	
	    }
	    } else {
	    	System.out.println("You do not have any expense in "+ year);
	    }
	    
    	//compute for total income + expense + profit/loss
    	totalincome = wholesalesum + retailsum + otinsum;
    	totalexpense = Invsum + Salsum + Ultsum + otexsum;
    	profitloss = totalincome - totalexpense;
    			
    	//Print
    	Helper.out("====================");
    	Helper.out("***"+year+" Summary***");
    	Helper.out("====================\n");
    	Helper.out("- Income Summary -");
    	Helper.out("Retail: ");
    	System.out.printf("%.2f", retailsum);
    	Helper.out("");
    	Helper.out("Wholesale: ");
    	System.out.printf("%.2f", wholesalesum);
    	Helper.out("");
    	Helper.out("Other: ");
    	System.out.printf("%.2f", otinsum);
    	Helper.out("");
    	Helper.out("\nTotal Income: ");
    	System.out.printf("%.2f", totalincome);
    	Helper.out("");
    	Helper.out("\n- Expense Summary -");
    	Helper.out("Inventory: ");
    	System.out.printf("%.2f", Invsum);
    	Helper.out("");
    	Helper.out("Salary: ");
    	System.out.printf("%.2f", Salsum);
    	Helper.out("");
    	Helper.out("Utilities: ");
    	System.out.printf("%.2f", Ultsum);
    	Helper.out("");
    	Helper.out("Other: ");
    	System.out.printf("%.2f", otexsum);
    	Helper.out("");
    	Helper.out("\nTotal Expense: ");
    	System.out.printf("%.2f", totalexpense);
    	Helper.out("");
    	Helper.out("\n====================\n");
    	Helper.out("Total Income: ");
    	System.out.printf("%.2f", totalincome);
    	Helper.out("");
    	Helper.out("\nTotal Expense: ");
    	System.out.printf("%.2f", totalexpense);
    	Helper.out("");
    	Helper.out("\n******\n");
    	Helper.out("Overall Total: ");
    	System.out.printf("%.2f", profitloss);
    	Helper.out("");
    	Helper.out("******");
    	Helper.out("\n====================");

	}
	
//	Month Summary
	public static void monthsum(int year, String month) throws FileNotFoundException {
		
		//variable income
				double retailsum = 0;
				double wholesalesum = 0;
				double otinsum = 0;
				double totalincome = 0;
				//variable expense
				double Invsum = 0;
				double Salsum = 0;
				double Ultsum = 0;
				double otexsum = 0;
				double totalexpense = 0;
				//total variable
				double profitloss = 0; // totalincome - totalexpense
				//System variable
				String line = "";
				String category = "";
				double value = 0;
				String monthtext = "";
				
				//convert month to monthtext
				switch (month) {
				case "Jan":
					monthtext = "January";
					break;
				case "Feb":
					monthtext = "Febuary";
					break;
				case "Mar":
					monthtext = "March";
					break;
				case "Apr":
					monthtext = "April";
					break;
				case "May":
					monthtext = "May";
					break;
				case "Jun":
					monthtext = "June";
					break;
				case "Jul":
					monthtext = "July";
					break;
				case "Aug":
					monthtext = "August";
					break;
				case "Sep":
					monthtext = "September";
					break;
				case "Oct":
					monthtext = "October";
					break;
				case "Nov":
					monthtext = "November";
					break;
				case "Dec":
					monthtext = "December";
					break;
				default:
					break;
				}
				
				
				//combine income file
				System.out.println("===================");
				System.out.println("Please wait . . . .");
				System.out.println("===================");
				System.out.println();
				
				List<File> files = Output.getAllFiles(Helper.INCOME_PATH+year+File.separator+month);
			    if(files.size() > 0) { //check if have file then perform
			    		
			    for(File f : files) {
			    	System.out.println("Reading file " + f.getAbsolutePath());
			    	Scanner scanner = new Scanner(f);
			    	while(scanner.hasNextLine()) {
			    		line = scanner.nextLine();
				    	//System.out.println(line);
				    	category = Output.getCategory(line);
				    	value = Output.getValue(line);
				    	System.out.println("Category : "+category+", Value : "+value);
				    	//compute for total of each category
				    	if(category.equalsIgnoreCase("ws")) {
				    		wholesalesum += value;
				    	} else if (category.equalsIgnoreCase("rs")) {
				    		retailsum += value;
				    	} else if (category.equalsIgnoreCase("ot")) {
				    		otinsum += value;
				    	} 
			    	}
			    	
			    	scanner.close();
			    }
				
			    } else { //don't have file show
			    	System.out.println("You do not have any income in "+ monthtext + year);
			    }
			    
			    //combine expense file
			    files = Output.getAllFiles(Helper.EXPENSE_PATH+year+File.separator+month);
			    if(files.size() > 0) {
			  
			    for(File f : files) {
			    	System.out.println("Reading file " + f.getAbsolutePath());
			    	Scanner scanner = new Scanner(f);
			    	while(scanner.hasNextLine()) {
			    		line = scanner.nextLine();
				    	System.out.println(line);
				    	category = Output.getCategory(line);
				    	value = Output.getValue(line);
				    	System.out.println("Category : "+category+", Value : "+value);
				    	//compute for total of each category
				    	if(category.equalsIgnoreCase("iv")) {
				    		Invsum += value;
				    	} else if (category.equalsIgnoreCase("sl")) {
				    		Salsum += value;
				    	} else if (category.equalsIgnoreCase("ut")) {
				    		Ultsum += value;
				    	} else if (category.equalsIgnoreCase("ot")) {
				    		otexsum += value;
				    	} 
			    	}
			    	
			    	scanner.close();
				    	
			    }
			    } else {
			    	System.out.println("You do not have any expense in "+ monthtext + year);
			    }
			    
		    	//compute for total income + expense + profit/loss
		    	totalincome = wholesalesum + retailsum + otinsum;
		    	totalexpense = Invsum + Salsum + Ultsum + otexsum;
		    	profitloss = totalincome - totalexpense;
		    			
		    	//Print
		    	System.out.println("====================");
		    	System.out.println("***"+monthtext+" "+year+" Summary***");
		    	System.out.println("====================");
		    	System.out.println("\n- Income Summary -");
		    	System.out.println("Retail: ");
		    	System.out.printf("%.2f", retailsum);
		    	System.out.println();
		    	System.out.println("Wholesale: ");
		    	System.out.printf("%.2f", wholesalesum);
		    	System.out.println();
		    	System.out.println("Other: ");
		    	System.out.printf("%.2f", otinsum);
		    	System.out.println();
		    	System.out.println("\nTotal Income: ");
		    	System.out.printf("%.2f", totalincome);
		    	System.out.println();
		    	System.out.println("\n- Expense Summary -");
		    	System.out.println("Inventory: ");
		    	System.out.printf("%.2f", Invsum);
		    	System.out.println();
		    	System.out.println("Salary: ");
		    	System.out.printf("%.2f", Salsum);
		    	System.out.println();
		    	System.out.println("Utilities: ");
		    	System.out.printf("%.2f", Ultsum);
		    	System.out.println();
		    	System.out.println("Other: ");
		    	System.out.printf("%.2f", otexsum);
		    	System.out.println();
		    	System.out.println("\nTotal Expense: ");
		    	System.out.printf("%.2f", totalexpense);
		    	System.out.println();
		    	System.out.println("\n====================");
		    	System.out.println("\nTotal Income: ");
		    	System.out.printf("%.2f", totalincome);
		    	System.out.println();
		    	System.out.println("\nTotal Expense: ");
		    	System.out.printf("%.2f", totalexpense);
		    	System.out.println();
		    	System.out.println("\n******");
		    	System.out.println("Overall Total: ");
		    	System.out.printf("%.2f", profitloss);
		    	System.out.println();
		    	System.out.println("******");
		    	System.out.println("\n====================");
		
		
	}
	
	//method for overall summary
		public static void overallsum() throws FileNotFoundException {
			

			//variable income
			double retailsum = 0;
			double wholesalesum = 0;
			double otinsum = 0;
			double totalincome = 0;
			//variable expense
			double Invsum = 0;
			double Salsum = 0;
			double Ultsum = 0;
			double otexsum = 0;
			double totalexpense = 0;
			//total variable
			double profitloss = 0; // totalincome - totalexpense
			//System variable
			String line = "";
			String category = "";
			double value = 0;
			
			
			//combine income file
			System.out.println("===================");
			System.out.println("Please wait . . . .");
			System.out.println("===================");
			System.out.println();
			
		    List<File> files = Output.getAllFiles(Helper.INCOME_PATH);
		    if(files.size() > 0) { //check if have file then perform
		    		
		    for(File f : files) {
		    	System.out.println("Reading file " + f.getAbsolutePath());
		    	Scanner scanner = new Scanner(f);
		    	while(scanner.hasNextLine()) {
		    		line = scanner.nextLine();
			    	//System.out.println(line);
			    	category = Output.getCategory(line);
			    	value = Output.getValue(line);
			    	System.out.println("Category : "+category+", Value : "+value);
			    	//compute for total of each category
			    	if(category.equalsIgnoreCase("ws")) {
			    		wholesalesum += value;
			    	} else if (category.equalsIgnoreCase("rs")) {
			    		retailsum += value;
			    	} else if (category.equalsIgnoreCase("ot")) {
			    		otinsum += value;
			    	} 
		    	}
		    	
		    	scanner.close();
		    }
			
		    } else { //don't have file show
		    	System.out.println("You do not have any income");
		    }
		    
		    //combine expense file
		    files = Output.getAllFiles(Helper.EXPENSE_PATH);
		    if(files.size() > 0) {
		  
		    for(File f : files) {
		    	System.out.println("Reading file " + f.getAbsolutePath());
		    	Scanner scanner = new Scanner(f);
		    	while(scanner.hasNextLine()) {
		    		line = scanner.nextLine();
			    	System.out.println(line);
			    	category = Output.getCategory(line);
			    	value = Output.getValue(line);
			    	System.out.println("Category : "+category+", Value : "+value);
			    	//compute for total of each category
			    	if(category.equalsIgnoreCase("iv")) {
			    		Invsum += value;
			    	} else if (category.equalsIgnoreCase("sl")) {
			    		Salsum += value;
			    	} else if (category.equalsIgnoreCase("ut")) {
			    		Ultsum += value;
			    	} else if (category.equalsIgnoreCase("ot")) {
			    		otexsum += value;
			    	} 
		    	}
		    	
		    	scanner.close();
			    	
		    }
		    } else {
		    	System.out.println("You do not have any expense");
		    }
		    
	    	//compute for total income + expense + profit/loss
	    	totalincome = wholesalesum + retailsum + otinsum;
	    	totalexpense = Invsum + Salsum + Ultsum + otexsum;
	    	profitloss = totalincome - totalexpense;
	    			
	    	//Print
	    	System.out.println("====================");
	    	System.out.println("***Overall Summary***");
	    	System.out.println("====================");
	    	System.out.println("\n- Income Summary -");
	    	System.out.println("Retail: ");
	    	System.out.printf("%.2f", retailsum);
	    	System.out.println();
	    	System.out.println("Wholesale: ");
	    	System.out.printf("%.2f", wholesalesum);
	    	System.out.println();
	    	System.out.println("Other: ");
	    	System.out.printf("%.2f", otinsum);
	    	System.out.println();
	    	System.out.println("\nTotal Income: ");
	    	System.out.printf("%.2f", totalincome);
	    	System.out.println();
	    	System.out.println("\n- Expense Summary -");
	    	System.out.println("Inventory: ");
	    	System.out.printf("%.2f", Invsum);
	    	System.out.println();
	    	System.out.println("Salary: ");
	    	System.out.printf("%.2f", Salsum);
	    	System.out.println();
	    	System.out.println("Utilities: ");
	    	System.out.printf("%.2f", Ultsum);
	    	System.out.println();
	    	System.out.println("Other: ");
	    	System.out.printf("%.2f", otexsum);
	    	System.out.println();
	    	System.out.println("\nTotal Expense: ");
	    	System.out.printf("%.2f", totalexpense);
	    	System.out.println();
	    	System.out.println("\n====================");
	    	System.out.println("\nTotal Income: ");
	    	System.out.printf("%.2f", totalincome);
	    	System.out.println();
	    	System.out.println("\nTotal Expense: ");
	    	System.out.printf("%.2f", totalexpense);
	    	System.out.println();
	    	System.out.println("\n******");
	    	System.out.println("Overall Total: ");
	    	System.out.printf("%.2f", profitloss);
	    	System.out.println();
	    	System.out.println("******");
	    	System.out.println("\n====================");
	    	
	    
			
		}
	
}
