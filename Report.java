import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Report {

	//method for daily report
	public static void dailyreport(int day, int year, String month) throws FileNotFoundException {
		
				//date
				String dayaddz = Output.padLeft(Integer.toString(day, 10), 2);
				String datetxt = dayaddz+month+year+".txt";
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
				//report variable
				double inplusex = 0;
				double percentin = 0;
				double percentex = 0;
				double maxincate = 0;
				double minincate = 0;
				double maxexcate = 0;
				double minexcate = 0;
				String maxincatetext = "";
				String minincatetext = "";
				String maxexcatetext = "";
				String minexcatetext = "";
				//System variable
				String line = "";
				String category = "";
				double value = 0;
				String monthtext = "";
				int noinfile = 1;
				int noexfile = 1;
				
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
				
				
				//find income file
				System.out.println("===================");
				System.out.println("Please wait . . . .");
				System.out.println("===================");
				System.out.println();
				
				File fileincome = new File(Helper.INCOME_PATH+year+File.separator+month+File.separator+datetxt);
				if(fileincome.isFile()) { //check if file exist


			    	System.out.println("Reading file " + fileincome.getAbsolutePath());
			    	Scanner scanner = new Scanner(new File(Helper.INCOME_PATH+year+File.separator+month+File.separator+datetxt));
			    	while(scanner.hasNextLine()) {
			    		line = scanner.nextLine();
				    	//System.out.println(line);
				    	category = Output.getCategory(line);
				    	value = Output.getValuedaily(line);
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
			    	} else { //don't have file show
			    	noinfile = 0;
			    	System.out.println("You do not have any income");
			    }
			    
			    //find expense file
				File fileexpense = new File(Helper.EXPENSE_PATH+year+File.separator+month+File.separator+datetxt);
				if(fileexpense.isFile()) { //check if file exist

			    	System.out.println("Reading file " + fileexpense.getAbsolutePath());
			    	Scanner scanner = new Scanner(new File (Helper.EXPENSE_PATH+year+File.separator+month+File.separator+datetxt));
			    	while(scanner.hasNextLine()) {
			    		line = scanner.nextLine();
				    	//System.out.println(line);
				    	category = Output.getCategory(line);
				    	value = Output.getValuedaily(line);
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
				    	
			    } else {
			    	noexfile = 0;
			    	System.out.println("You do not have any expense");
			    }
			    
		    	//compute for total income + expense + profit/loss + avarage
		    	totalincome = wholesalesum + retailsum + otinsum;
		    	totalexpense = Invsum + Salsum + Ultsum + otexsum;
		    	profitloss = totalincome - totalexpense;
		    	inplusex = totalincome + totalexpense;
		    	percentin = (totalincome/inplusex)*100;
		    	percentex = (totalexpense/inplusex)*100;
		    	
		    	//max + min category
		    	maxincate = Math.max(wholesalesum, (Math.max(retailsum, otinsum)));
		    	minincate = Math.min(wholesalesum, (Math.min(retailsum, otinsum)));
		    	maxexcate = Math.max(Invsum, (Math.max(Salsum, (Math.max(Ultsum, otexsum)))));
		    	minexcate = Math.min(Invsum, (Math.min(Salsum, (Math.min(Ultsum, otexsum)))));
		    	
		    	//max + min cate text
			    	//max income
			    	if (maxincate == wholesalesum) {
			    		maxincatetext = "Wholesale";
			    	} else if (maxincate == retailsum) {
			    		maxincatetext = "Retail";
			    	} else if (maxincate == otinsum) {
			    		maxincatetext = "Other Income";
			    	}
			    	
			    	//min income
			    	if (minincate == wholesalesum) {
			    		minincatetext = "Wholesale";
			    	} else if (minincate == retailsum) {
			    		minincatetext = "Retail";
			    	} else if (minincate == otinsum) {
			    		minincatetext = "Other Income";
			    	}
			    	
			    	//max expense
			    	if (maxexcate == Invsum) {
			    		maxexcatetext = "Inventory";
			    	} else if (maxexcate == Salsum) {
			    		maxexcatetext = "Salary";
			    	} else if (maxexcate == Ultsum) {
			    		maxexcatetext = "Ultilities";
			    	} else if (maxexcate == otexsum) {
			    		maxexcatetext = "Other Expense";
			    	}

			    	//min expense
			    	if (minexcate == Invsum) {
			    		minexcatetext = "Inventory";
			    	} else if (minexcate == Salsum) {
			    		minexcatetext = "Salary";
			    	} else if (minexcate == Ultsum) {
			    		minexcatetext = "Ultilities";
			    	} else if (minexcate == otexsum) {
			    		minexcatetext = "Other Expense";
			    	}
		    			
		    	//Print
			    	if (noinfile == 1 && noexfile == 1) {
		    	System.out.println("====================");
		    	System.out.println("***"+day+" "+monthtext+" "+year+" Report***");
		    	System.out.println("====================");
		    	System.out.println("\n- "+day+" "+monthtext+" "+year+" Income Report -");
		    	System.out.println("\nMax Income Category: " + maxincatetext);
		    	System.out.printf("%.2f", maxincate);
		    	System.out.println();
		    	System.out.println("\nMin Income Category: " + minincatetext);
		    	System.out.printf("%.2f", minincate);
		    	System.out.println();
		    	System.out.println("\nTotal Income: ");
		    	System.out.printf("%.2f", totalincome);
		    	System.out.println();
		    	System.out.println("\n- "+day+" "+monthtext+" "+year+" Expense Report -");
		    	System.out.println("\nMax Expense Category: " + maxexcatetext);
		    	System.out.printf("%.2f", maxexcate);
		    	System.out.println();
		    	System.out.println("\nMin Expense Category: " + minexcatetext);
		    	System.out.printf("%.2f", minexcate);
		    	System.out.println();
		    	System.out.println("\nTotal Expense: ");
		    	System.out.printf("%.2f", totalexpense);
		    	System.out.println();
		    	System.out.println("\n====================\n");
		    	System.out.println("Income to Expense Percentage");
		    	System.out.println("\nIncome: ");
		    	System.out.printf("%.2f", percentin);
		    	System.out.println("%");
		    	System.out.println("\nExpense: ");
		    	System.out.printf("%.2f", percentex);
		    	System.out.println("%");
		    	System.out.println("\n******");
		    	System.out.println(day+" "+monthtext+" "+year+" Total: ");
		    	System.out.printf("%.2f", profitloss);
		    	System.out.println();
		    	System.out.println("******");
		    	System.out.println("====================");

		    } else if (noinfile == 1 && noexfile == 0){
		    	
		    	System.out.println("====================");
		    	System.out.println("***"+day+" "+monthtext+" "+year+" Report***");
		    	System.out.println("====================");
		    	System.out.println("\n- "+day+" "+monthtext+" "+year+" Income Report -");
		    	System.out.println("\nMax Income Category: " + maxincatetext);
		    	System.out.printf("%.2f", maxincate);
		    	System.out.println();
		    	System.out.println("\nMin Income Category: " + minincatetext);
		    	System.out.printf("%.2f", minincate);
		    	System.out.println();
		    	System.out.println("\nTotal Income: ");
		    	System.out.printf("%.2f", totalincome);
		    	System.out.println();
		    	System.out.println("\n- "+day+" "+monthtext+" "+year+" Expense Report -");
		    	System.out.println("\nYou have no expense");
		    	System.out.println();
		    	System.out.println("\n====================\n");
		    	System.out.println("Income to Expense Percentage");
		    	System.out.println("Income: 100.00%");
		    	System.out.println("\nExpense: 0.00%");
		    	System.out.println("\n******");
		    	System.out.println(day+" "+monthtext+" "+year+" Total: ");
		    	System.out.printf("%.2f", totalincome);
		    	System.out.println();
		    	System.out.println("******");
		    	System.out.println("====================");
		    	
		    } else if (noinfile == 0 && noexfile == 1) {
		    	System.out.println("====================");
		    	System.out.println("***"+day+" "+monthtext+" "+year+" Report***");
		    	System.out.println("====================");
		    	System.out.println("\n- "+day+" "+monthtext+" "+year+" Income Report -");
		    	System.out.println("\nYou have no income");
		    	System.out.println("\n- "+day+" "+monthtext+" "+year+" Expense Report -");
		    	System.out.println("\nMax Expense Category: " + maxexcatetext);
		    	System.out.printf("%.2f", maxexcate);
		    	System.out.println();
		    	System.out.println("\nMin Expense Category: " + minexcatetext);
		    	System.out.printf("%.2f", minexcate);
		    	System.out.println();
		    	System.out.println("\nTotal Expense: ");
		    	System.out.printf("%.2f", totalexpense);
		    	System.out.println();
		    	System.out.println("\n====================\n");
		    	System.out.println("Income to Expense Percentage");
		    	System.out.println("\nIncome: 0.00%");
		    	System.out.println("\nExpense: 100.00%");
		    	System.out.println("\n******");
		    	System.out.println(day+" "+monthtext+" "+year+" Total: ");
		    	System.out.printf("%.2f", totalexpense);
		    	System.out.println();
		    	System.out.println("******");
		    	System.out.println("====================");
		    	
		    } else {
		    	
		    	System.out.println("\nxxxxxxxxxx\n");
		    	System.out.println("Sorry you do not have information on selected time frame");
		    	System.out.println("\nxxxxxxxxxx\n");
		    }
 }
	public static void monthreport(int year, String month) throws FileNotFoundException {
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
		//report variable
		double inplusex = 0;
		double percentin = 0;
		double percentex = 0;
		double maxincate = 0;
		double minincate = 0;
		double maxexcate = 0;
		double minexcate = 0;
		String maxincatetext = "";
		String minincatetext = "";
		String maxexcatetext = "";
		String minexcatetext = "";
		//System variable
		String line = "";
		String category = "";
		double value = 0;
		String monthtext = "";
		int noinfile = 1;
		int noexfile = 1;
		
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
	    	noinfile = 0;
	    	System.out.println("You do not have any income");
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
	    	noexfile = 0;
	    	System.out.println("You do not have any expense");
	    }
	    
    	//compute for total income + expense + profit/loss + avarage
    	totalincome = wholesalesum + retailsum + otinsum;
    	totalexpense = Invsum + Salsum + Ultsum + otexsum;
    	profitloss = totalincome - totalexpense;
    	inplusex = totalincome + totalexpense;
    	percentin = (totalincome/inplusex)*100;
    	percentex = (totalexpense/inplusex)*100;
    	
    	//max + min category
    	maxincate = Math.max(wholesalesum, (Math.max(retailsum, otinsum)));
    	minincate = Math.min(wholesalesum, (Math.min(retailsum, otinsum)));
    	maxexcate = Math.max(Invsum, (Math.max(Salsum, (Math.max(Ultsum, otexsum)))));
    	minexcate = Math.min(Invsum, (Math.min(Salsum, (Math.min(Ultsum, otexsum)))));
    	
    	//max + min cate text
	    	//max income
	    	if (maxincate == wholesalesum) {
	    		maxincatetext = "Wholesale";
	    	} else if (maxincate == retailsum) {
	    		maxincatetext = "Retail";
	    	} else if (maxincate == otinsum) {
	    		maxincatetext = "Other Income";
	    	}
	    	
	    	//min income
	    	if (minincate == wholesalesum) {
	    		minincatetext = "Wholesale";
	    	} else if (minincate == retailsum) {
	    		minincatetext = "Retail";
	    	} else if (minincate == otinsum) {
	    		minincatetext = "Other Income";
	    	}
	    	
	    	//max expense
	    	if (maxexcate == Invsum) {
	    		maxexcatetext = "Inventory";
	    	} else if (maxexcate == Salsum) {
	    		maxexcatetext = "Salary";
	    	} else if (maxexcate == Ultsum) {
	    		maxexcatetext = "Ultilities";
	    	} else if (maxexcate == otexsum) {
	    		maxexcatetext = "Other Expense";
	    	}

	    	//min expense
	    	if (minexcate == Invsum) {
	    		minexcatetext = "Inventory";
	    	} else if (minexcate == Salsum) {
	    		minexcatetext = "Salary";
	    	} else if (minexcate == Ultsum) {
	    		minexcatetext = "Ultilities";
	    	} else if (minexcate == otexsum) {
	    		minexcatetext = "Other Expense";
	    	}
    			
    	//Print
	   if (noinfile == 1 && noexfile == 1) {
    	System.out.println("====================");
    	System.out.println("***"+monthtext+" "+year+" Report***");
    	System.out.println("====================");
    	System.out.println("\n- "+monthtext+" "+year+" Income Report -");
    	System.out.println("\nMax Income Category: " + maxincatetext);
    	System.out.printf("%.2f", maxincate);
    	System.out.println();
    	System.out.println("\nMin Income Category: " + minincatetext);
    	System.out.printf("%.2f", minincate);
    	System.out.println();
    	System.out.println("\nTotal Income: ");
    	System.out.printf("%.2f", totalincome);
    	System.out.println();
    	System.out.println("\n- "+monthtext+" "+year+" Expense Report -");
    	System.out.println("\nMax Expense Category: " + maxexcatetext);
    	System.out.printf("%.2f", maxexcate);
    	System.out.println();
    	System.out.println("\nMin Expense Category: " + minexcatetext);
    	System.out.printf("%.2f", minexcate);
    	System.out.println();
    	System.out.println("\nTotal Expense: ");
    	System.out.printf("%.2f", totalexpense);
    	System.out.println();
    	System.out.println("\n====================\n");
    	System.out.println("Income to Expense Percentage");
    	System.out.println("\nIncome: ");
    	System.out.printf("%.2f", percentin);
    	System.out.println("%");
    	System.out.println("\nExpense: ");
    	System.out.printf("%.2f", percentex);
    	System.out.println("%");
    	System.out.println("\n******");
    	System.out.println(monthtext+" "+year+" Total: ");
    	System.out.printf("%.2f", profitloss);
    	System.out.println();
    	System.out.println("******");
    	System.out.println("====================");
    } else if (noinfile == 1 && noexfile == 0){
    	
    	System.out.println("====================");
    	System.out.println("***"+monthtext+" "+year+" Report***");
    	System.out.println("====================");
    	System.out.println("\n- "+monthtext+" "+year+" Income Report -");
    	System.out.println("\nMax Income Category: " + maxincatetext);
    	System.out.printf("%.2f", maxincate);
    	System.out.println();
    	System.out.println("\nMin Income Category: " + minincatetext);
    	System.out.printf("%.2f", minincate);
    	System.out.println();
    	System.out.println("\nTotal Income: ");
    	System.out.printf("%.2f", totalincome);
    	System.out.println();
    	System.out.println("\n- "+monthtext+" "+year+" Expense Report -");
    	System.out.println("\nYou have no expense\n");
    	System.out.println("\n====================");
    	System.out.println("\nIncome to Expense Percentage");
    	System.out.println("\bIncome: 100.00%");
    	System.out.println("\nExpense: 0.00%");
    	System.out.println("\n******");
    	System.out.println(monthtext+" "+year+" Total: ");
    	System.out.printf("%.2f", totalincome);
    	System.out.println();
    	System.out.println("******");
    	System.out.println("====================");
    	
    } else if (noinfile == 0 && noexfile == 1) {
    	System.out.println("====================");
    	System.out.println("***"+monthtext+" "+year+" Report***");
    	System.out.println("====================\n");
    	System.out.println("- "+monthtext+" "+year+" Income Report -");
    	System.out.println("\nYou have no income");
    	System.out.println("\n- "+monthtext+" "+year+" Expense Report -");
    	System.out.println("\nMax Expense Category: " + maxexcatetext);
    	System.out.printf("%.2f", maxexcate);
    	System.out.println();
    	System.out.println("\nMin Expense Category: " + minexcatetext);
    	System.out.printf("%.2f", minexcate);
    	System.out.println();
    	System.out.println("\nTotal Expense: ");
    	System.out.printf("%.2f", totalexpense);
    	System.out.println();
    	System.out.println("\n====================");
    	System.out.println("\nIncome to Expense Percentage");
    	System.out.println("\nIncome: 0.00%");
    	System.out.println("\nExpense: 100.00%");
    	System.out.println("\n******");
    	System.out.println(monthtext+" "+year+" Total: ");
    	System.out.printf("%.2f", totalexpense);
    	System.out.println();
    	System.out.println("******");
    	System.out.println("====================");
    	
    } else {
    	System.out.println("\nxxxxxxxxxx\n");
    	System.out.println("Sorry you do not have information on selected time frame");
    	System.out.println("\nxxxxxxxxxx\n");
    }
    	
	}
	
	
	
//	Annual Report
	public static void annualreport(int year) throws FileNotFoundException {
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
		//report variable
		double inplusex = 0;
		double percentin = 0;
		double percentex = 0;
		double maxincate = 0;
		double minincate = 0;
		double maxexcate = 0;
		double minexcate = 0;
		String maxincatetext = "";
		String minincatetext = "";
		String maxexcatetext = "";
		String minexcatetext = "";
		//System variable
		String line = "";
		String category = "";
		double value = 0;
		int noinfile = 1;
		int noexfile = 1;
		
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
	    	noinfile = 0;
	    	System.out.println("You do not have any income");
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
	    	noexfile = 0;
	    	System.out.println("You do not have any expense");
	    }
	    
    	//compute for total income + expense + profit/loss + avarage
    	totalincome = wholesalesum + retailsum + otinsum;
    	totalexpense = Invsum + Salsum + Ultsum + otexsum;
    	profitloss = totalincome - totalexpense;
    	inplusex = totalincome + totalexpense;
    	percentin = (totalincome/inplusex)*100;
    	percentex = (totalexpense/inplusex)*100;
    	
    	//max + min category
    	maxincate = Math.max(wholesalesum, (Math.max(retailsum, otinsum)));
    	minincate = Math.min(wholesalesum, (Math.min(retailsum, otinsum)));
    	maxexcate = Math.max(Invsum, (Math.max(Salsum, (Math.max(Ultsum, otexsum)))));
    	minexcate = Math.min(Invsum, (Math.min(Salsum, (Math.min(Ultsum, otexsum)))));
    	
    	//max + min cate text
	    	//max income
	    	if (maxincate == wholesalesum) {
	    		maxincatetext = "Wholesale";
	    	} else if (maxincate == retailsum) {
	    		maxincatetext = "Retail";
	    	} else if (maxincate == otinsum) {
	    		maxincatetext = "Other Income";
	    	}
	    	
	    	//min income
	    	if (minincate == wholesalesum) {
	    		minincatetext = "Wholesale";
	    	} else if (minincate == retailsum) {
	    		minincatetext = "Retail";
	    	} else if (minincate == otinsum) {
	    		minincatetext = "Other Income";
	    	}
	    	
	    	//max expense
	    	if (maxexcate == Invsum) {
	    		maxexcatetext = "Inventory";
	    	} else if (maxexcate == Salsum) {
	    		maxexcatetext = "Salary";
	    	} else if (maxexcate == Ultsum) {
	    		maxexcatetext = "Ultilities";
	    	} else if (maxexcate == otexsum) {
	    		maxexcatetext = "Other Expense";
	    	}

	    	//min expense
	    	if (minexcate == Invsum) {
	    		minexcatetext = "Inventory";
	    	} else if (minexcate == Salsum) {
	    		minexcatetext = "Salary";
	    	} else if (minexcate == Ultsum) {
	    		minexcatetext = "Ultilities";
	    	} else if (minexcate == otexsum) {
	    		minexcatetext = "Other Expense";
	    	}
    			
    	//Print
	    if (noinfile == 1 && noexfile == 1) {
	    		
	    	System.out.println("====================");
	    	System.out.println("***"+year+" Report***");
	    	System.out.println("====================");
	    	System.out.println("\n- "+year+" Income Report -");
	    	System.out.println("\nMax Income Category: " + maxincatetext);
	    	System.out.printf("%.2f", maxincate);
	    	System.out.println();
	    	System.out.println("\nMin Income Category: " + minincatetext);
	    	System.out.printf("%.2f", minincate);
	    	System.out.println();
	    	System.out.println("\nTotal Income: ");
	    	System.out.printf("%.2f", totalincome);
	    	System.out.println();
	    	System.out.println("\n- "+year+" Expense Report -");
	    	System.out.println("\nMax Expense Category: " + maxexcatetext);
	    	System.out.printf("%.2f", maxexcate);
	    	System.out.println();
	    	System.out.println("\nMin Expense Category: " + minexcatetext);
	    	System.out.printf("%.2f", minexcate);
	    	System.out.println();
	    	System.out.println("\nTotal Expense: ");
	    	System.out.printf("%.2f", totalexpense);
	    	System.out.println();
	    	System.out.println("\n====================");
	    	System.out.println("\nIncome to Expense Percentage");
	    	System.out.println("\nIncome: ");
	    	System.out.printf("%.2f", percentin);
	    	System.out.println("%");
	    	System.out.println("\nExpense: ");
	    	System.out.printf("%.2f", percentex);
	    	System.out.println("%");
	    	System.out.println("\n******");
	    	System.out.println(year+" Total: ");
	    	System.out.printf("%.2f", profitloss);
	    	System.out.println();
	    	System.out.println("******");
	    	System.out.println("====================");
    	
	    } else if (noinfile == 1 && noexfile == 0){
        	
        	System.out.println("====================");
        	System.out.println("***"+year+" Report***");
        	System.out.println("====================");
        	System.out.println("\n- "+year+" Income Report -");
        	System.out.println("\nMax Income Category: " + maxincatetext);
        	System.out.printf("%.2f", maxincate);
        	System.out.println();
        	System.out.println("\nMin Income Category: " + minincatetext);
        	System.out.printf("%.2f", minincate);
        	System.out.println();
        	System.out.println("\nTotal Income: ");
        	System.out.printf("%.2f", totalincome);
        	System.out.println();
        	System.out.println("\n- "+year+" Expense Report -");
        	System.out.println("\nYou have no expense");
        	System.out.println("\n\n====================");
        	System.out.println("\nIncome to Expense Percentage");
        	System.out.println("\nIncome: 100.00%");
        	System.out.println("\nExpense: 0.00%");
        	System.out.println("\n******");
        	System.out.println(year+" Total: ");
        	System.out.printf("%.2f", totalincome);
        	System.out.println();
        	System.out.println("******");
        	System.out.println("====================");
        	
        } else if (noinfile == 0 && noexfile == 1) {
        	System.out.println("====================");
        	System.out.println("***"+year+" Report***");
        	System.out.println("====================");
        	System.out.println("\n- "+year+" Income Report -\n");
        	System.out.println("You have no income\n");
        	System.out.println("\n- "+year+" Expense Report -");
        	System.out.println("\nMax Expense Category: " + maxexcatetext);
        	System.out.printf("%.2f", maxexcate);
        	System.out.println();
        	System.out.println("\nMin Expense Category: " + minexcatetext);
        	System.out.printf("%.2f", minexcate);
        	System.out.println();
        	System.out.println("\nTotal Expense: ");
        	System.out.printf("%.2f", totalexpense);
        	System.out.println();
        	System.out.println("\n====================");
        	System.out.println("\nIncome to Expense Percentage");
        	System.out.println("\nIncome: 0.00%");
        	System.out.println("\nExpense: 100.00%");
        	System.out.println("\n******");
        	System.out.println(year+" Total: ");
        	System.out.printf("%.2f", totalexpense);
        	System.out.println();
        	System.out.println("******");
        	System.out.println("====================");
        	
        } else {
	    	System.out.println("\nxxxxxxxxxx\n");
	    	System.out.println("Sorry you do not have information on selected time frame");
	    	System.out.println("\nxxxxxxxxxx\n");
        }
    	
	}
	
	//method for overall report
	public static void overallreport() throws FileNotFoundException {
		
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
				//report variable
				double inplusex = 0;
				double percentin = 0;
				double percentex = 0;
				double maxincate = 0;
				double minincate = 0;
				double maxexcate = 0;
				double minexcate = 0;
				String maxincatetext = "";
				String minincatetext = "";
				String maxexcatetext = "";
				String minexcatetext = "";
				//System variable
				String line = "";
				String category = "";
				double value = 0;
				int noinfile = 1;
				int noexfile = 1;
				
				
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
			    	noinfile = 0;
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
			    	noexfile = 0;
			    	System.out.println("You do not have any expense");
			    }
			    
		    	//compute for total income + expense + profit/loss + avarage
		    	totalincome = wholesalesum + retailsum + otinsum;
		    	totalexpense = Invsum + Salsum + Ultsum + otexsum;
		    	profitloss = totalincome - totalexpense;
		    	inplusex = totalincome + totalexpense;
		    	percentin = (totalincome/inplusex)*100;
		    	percentex = (totalexpense/inplusex)*100;
		    	
		    	//max + min category
		    	maxincate = Math.max(wholesalesum, (Math.max(retailsum, otinsum)));
		    	minincate = Math.min(wholesalesum, (Math.min(retailsum, otinsum)));
		    	maxexcate = Math.max(Invsum, (Math.max(Salsum, (Math.max(Ultsum, otexsum)))));
		    	minexcate = Math.min(Invsum, (Math.min(Salsum, (Math.min(Ultsum, otexsum)))));
		    	
		    	//max + min cate text
			    	//max income
			    	if (maxincate == wholesalesum) {
			    		maxincatetext = "Wholesale";
			    	} else if (maxincate == retailsum) {
			    		maxincatetext = "Retail";
			    	} else if (maxincate == otinsum) {
			    		maxincatetext = "Other Income";
			    	}
			    	
			    	//min income
			    	if (minincate == wholesalesum) {
			    		minincatetext = "Wholesale";
			    	} else if (minincate == retailsum) {
			    		minincatetext = "Retail";
			    	} else if (minincate == otinsum) {
			    		minincatetext = "Other Income";
			    	}
			    	
			    	//max expense
			    	if (maxexcate == Invsum) {
			    		maxexcatetext = "Inventory";
			    	} else if (maxexcate == Salsum) {
			    		maxexcatetext = "Salary";
			    	} else if (maxexcate == Ultsum) {
			    		maxexcatetext = "Ultilities";
			    	} else if (maxexcate == otexsum) {
			    		maxexcatetext = "Other Expense";
			    	}

			    	//min expense
			    	if (minexcate == Invsum) {
			    		minexcatetext = "Inventory";
			    	} else if (minexcate == Salsum) {
			    		minexcatetext = "Salary";
			    	} else if (minexcate == Ultsum) {
			    		minexcatetext = "Ultilities";
			    	} else if (minexcate == otexsum) {
			    		minexcatetext = "Other Expense";
			    	}
		    			
		    	//Print
			    if (noinfile == 1 && noexfile == 1) {
			    	System.out.println("====================");
			    	System.out.println("***Overall Report***");
			    	System.out.println("====================");
			    	System.out.println("\n- Overall Income Report -");
			    	System.out.println();
			    	System.out.println("Max Income Category: " + maxincatetext);
			    	System.out.printf("%.2f", maxincate);
			    	System.out.println();
			    	System.out.println("\nMin Income Category: " + minincatetext);
			    	System.out.printf("%.2f", minincate);
			    	System.out.println();
			    	System.out.println("\nTotal Income: ");
			    	System.out.printf("%.2f", totalincome);
			    	System.out.println();
			    	System.out.println("\n- Overall Expense Report -");
			    	System.out.println("\nMax Expense Category: " + maxexcatetext);
			    	System.out.printf("%.2f", maxexcate);
			    	System.out.println();
			    	System.out.println("\nMin Expense Category: " + minexcatetext);
			    	System.out.printf("%.2f", minexcate);
			    	System.out.println();
			    	System.out.println("\nTotal Expense: ");
			    	System.out.printf("%.2f", totalexpense);
			    	System.out.println();
			    	System.out.println("\n====================\n");
			    	System.out.println("Income to Expense Percentage");
			    	System.out.println("\nIncome: ");
			    	System.out.printf("%.2f", percentin);
			    	System.out.println("%");
			    	System.out.println("\nExpense: ");
			    	System.out.printf("%.2f", percentex);
			    	System.out.println("%");
			    	System.out.println("\n******");
			    	System.out.println("Overall Total: ");
			    	System.out.printf("%.2f", profitloss);
			    	System.out.println();
			    	System.out.println("******");
			    	System.out.println("====================");
			    } else if (noinfile == 1 && noexfile == 0){
			    	
			    	System.out.println("====================");
			    	System.out.println("***Overall Report***");
			    	System.out.println("====================");
			    	System.out.println("\n- Overall Income Report -");
			    	System.out.println("\nMax Income Category: " + maxincatetext);
			    	System.out.printf("%.2f", maxincate);
			    	System.out.println();
			    	System.out.println("\nMin Income Category: " + minincatetext);
			    	System.out.printf("%.2f", minincate);
			    	System.out.println();
			    	System.out.println("\nTotal Income: ");
			    	System.out.printf("%.2f", totalincome);
			    	System.out.println();
			    	System.out.println("\n- Overall Expense Report -\n");
			    	System.out.println("You have no expense\n\n");
			    	System.out.println("====================\n");
			    	System.out.println("Income to Expense Percentage");
			    	System.out.println("Income: 100.00%");
			    	System.out.println("\nExpense: 0.00%");
			    	System.out.println("\n******");
			    	System.out.println("Overall Total: ");
			    	System.out.printf("%.2f", totalincome);
			    	System.out.println();
			    	System.out.println("******");
			    	System.out.println("====================");
			    	
			    } else if (noinfile == 0 && noexfile == 1) {
			    	System.out.println("====================");
			    	System.out.println("***Overall Report***");
			    	System.out.println("====================");
			    	System.out.println("\n- Overall Income Report -");
			    	System.out.println("\nYou have no income");
			    	System.out.println("\n- Overall Expense Report -");
			    	System.out.println("\nMax Expense Category: " + maxexcatetext);
			    	System.out.printf("%.2f", maxexcate);
			    	System.out.println();
			    	System.out.println("\nMin Expense Category: " + minexcatetext);
			    	System.out.printf("%.2f", minexcate);
			    	System.out.println();
			    	System.out.println("\nTotal Expense: ");
			    	System.out.printf("%.2f", totalexpense);
			    	System.out.println();
			    	System.out.println("\n====================\n");
			    	System.out.println("Income to Expense Percentage");
			    	System.out.println("\nIncome: 0.00%");
			    	System.out.println("\nExpense: 100.00%");
			    	System.out.println("\n******");
			    	System.out.println("Overall Total: ");
			    	System.out.printf("%.2f", totalexpense);
			    	System.out.println();
			    	System.out.println("******");
			    	System.out.println("====================");
			    	
			    } else {
			    	System.out.println("Sorry you do not have information on selected time frame");
			    	
			    }
	}	
}
