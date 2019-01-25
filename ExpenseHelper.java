//ITE 221 - Programming 1 Project
//by 
//Pathompong Phongsaporamut (1801310010)
//Sai (ID)
//Williams Sissoko (1803130006)

/* 
   * Create a package folder and name it expenses, and add it like this below.
    
    package expenses
*/



import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.*;

public class ExpenseHelper {

	//Global variable
	private static int endprogram = 0;
	

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InputMismatchException {

		Object[] options1 = { "Input Expenses", "View Summary", "View Report",
		"Quit Program" };

		JPanel panel = new JPanel();

		panel.add(new JLabel("What would you like to do today?"));

		int result = JOptionPane.showOptionDialog(null, panel, "Welcome to Expense Solution!",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options1, null);
				

		switch(result) {
			case 0: 
			input();
			break;
			case 1: 
			summary();
			break;
			case 2: 
			report();
			break;
			case 3: 
			JOptionPane.showConfirmDialog(null,
			"Confirm Quit",
			"Confirm Quit", JOptionPane.YES_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else if (result == JOptionPane.NO_OPTION) {
					return;
			} 
			
			break;
		}
	 
}
	// Method for input
public static void input() throws FileNotFoundException {
		
		//variable
		int inputmenu;
		int day;
		// String month = "";
		//int month;
		int year;
		String filename ="";



		Object[] daysOption = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		
		JPanel panel = new JPanel();

		panel.add(new JLabel("Please put in the date"));

		int month = JOptionPane.showOptionDialog(null, null, "Welcome to Expense Solution!",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, daysOption, null);
		//day
			panel.add(new JLabel("Enter number between 0 and 31"));
			JTextField textField = new JTextField(10);
			
			
			
			
			panel.add(textField);

// 			Making sure user does no exceed past 31..
			do {
				
			 day = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, null, null);
		
					if (day == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null, textField.getText());
					}
			} while (Integer.parseInt(textField.getText()) >= 31);
		
		
		//year
		panel.add(new JLabel("Year (2xxx)"));
		JTextField yearTextField = new JTextField(10);
		panel.add(yearTextField);

		 year = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, null, null);
				
				if (year == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, yearTextField.getText());
				}


		JOptionPane.showMessageDialog(null, "Month" +  daysOption[month] + "Day " + textField.getText() + "Year" + yearTextField.getText());

		//define filename
		filename = Output.padLeft(textField.getText(), 2) + daysOption[month] + yearTextField.getText();
		
		
		try {
			
			
		// //menu to call input methods
		do {
			Helper.error = false;
			System.out.println("What is your input type?");
			System.out.println("1. Income");
			System.out.println("2. Expense");
			System.out.println("3. Back to main menu");
			System.out.println("Please put 1, 2, or 3");
			inputmenu = Helper.scan.nextInt();
			//Switch case to navigate menu
		} while (inputmenu!=1 && inputmenu!=2 && inputmenu!=3);
		
			switch (inputmenu) {
			case 1:
				Statement.income(filename);
				return;
			case 2:
				Statement.expense(filename);
				return;
			case 3:
				return;
			default:
				System.out.println("Invalid Menu Number"); //prevent other input
				return;
			}
		} catch (Exception e) {
			Helper.out("Program terminated Please enter the right Input... Exp: Number");
			Helper.error = true;
		}
	        
	}
	

// 	//method for summary

	public static int summary() throws FileNotFoundException {
		
		//variable
		int suminmenu;
		String month = "";
		int year;

		
		//menu for summary method
				do {
					System.out.println("What summary do you want to view?");
					System.out.println("1. Overall Summary");
					System.out.println("2. Monthy Summary");
					System.out.println("3. Annual Summary");
					System.out.println("4. Back to main menu");
					System.out.println("Please put 1, 2, 3, or 4");
					suminmenu = Helper.scan.nextInt();
				} while (suminmenu!=1 && suminmenu!=2 && suminmenu!=3 && suminmenu!=4);
				
				//Switch case to navigate menu
		        switch (suminmenu) {
		        case 1:
		            Summary.overallsum();
		            return (1);
		        case 2:
		        	//ask for month and year to view
		        	
					//month
		    		do {
			        	System.out.println("What month do you want to view?");
		    			System.out.println("Month (Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec)");
		    			month = Helper.scan.nextLine();
		    		} while (!(month.equalsIgnoreCase("Jan") || month.equalsIgnoreCase("Feb") || month.equalsIgnoreCase("Mar") || month.equalsIgnoreCase("Apr") || month.equalsIgnoreCase("May") || month.equalsIgnoreCase("Jun") || month.equalsIgnoreCase("Jul") || month.equalsIgnoreCase("Aug") || month.equalsIgnoreCase("Sep") || month.equalsIgnoreCase("Oct") || month.equalsIgnoreCase("Nov") || month.equalsIgnoreCase("Dec")));
		    		
		    		//year
		    		do {
			        	System.out.println("What year do you want to view?");
		    			System.out.println("Year (2xxx)");
		    			year = Helper.scan.nextInt();
		    		} while (year>2999 || year<2000);
		    		
		    		Summary.monthsum(year, month);
		            return (1);
		        case 3:
		        	//ask for year to view
		        	
		        	//year
		    		do {
			        	System.out.println("What year do you want to view?");
		    			System.out.println("Year (2xxx)");
		    			year = Helper.scan.nextInt();
		    		} while (year>2999 || year<2000);
		        	
		    		Summary.annualsum(year);
		        	return(1);
		        case 4:
		            return (1);
		        default:
		            System.out.println("Invalid Menu Number"); //prevent other input
		            return (1);
		        }
		
		
	}
	

// 	//method for report

	public static int report() throws FileNotFoundException {
		
		//variable
				int suminmenu;
				int day;
				String month = "";
				int year;

				
				//menu for summary method
						do {
							Helper.out("What summary do you want to view?");
							Helper.out("1. Overall Report");
							Helper.out("2. Daily Report");
							Helper.out("3. Monthy Report");
							Helper.out("4. Annual Report");
							Helper.out("5. Back to main menu");
							Helper.out("Please put 1, 2, 3, 4, or 5");
							suminmenu = Helper.scan.nextInt();
						} while (suminmenu!=1 && suminmenu!=2 && suminmenu!=3 && suminmenu!=4);
						
						//Switch case to navigate menu
				        switch (suminmenu) {
				        case 1:
				            Report.overallreport();
				            return (1);
				        case 2:
				        	//ask for day, month and year to view
				        	
				        	//day
				    		do {
				    			System.out.println("Day (1-31)");
				    			day = Helper.scan.nextInt();
				    			Helper.scan.nextLine();
				    		} while (day>31 || day<1); //use or to prevent input more than 31 and less then 0
				        	
				        	//month
				    		do {
					        	System.out.println("What month do you want to view?");
				    			System.out.println("Month (Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec)");
				    			month = Helper.scan.nextLine();
				    		} while (!(month.equalsIgnoreCase("Jan") || month.equalsIgnoreCase("Feb") || month.equalsIgnoreCase("Mar") || month.equalsIgnoreCase("Apr") || month.equalsIgnoreCase("May") || month.equalsIgnoreCase("Jun") || month.equalsIgnoreCase("Jul") || month.equalsIgnoreCase("Aug") || month.equalsIgnoreCase("Sep") || month.equalsIgnoreCase("Oct") || month.equalsIgnoreCase("Nov") || month.equalsIgnoreCase("Dec")));
				    		
				    		//year
				    		do {
					        	System.out.println("What year do you want to view?");
				    			System.out.println("Year (2xxx)");
				    			year = Helper.scan.nextInt();
				    		} while (year>2999 || year<2000);
				    		
				    		Report.dailyreport(day, year, month);
				            return (1);
				        case 3:
				        	//ask for month and year to view
				    		Scanner moreportinput = new Scanner (System.in);
				        	
				        	//month
				    		do {
					        	System.out.println("What month do you want to view?");
				    			System.out.println("Month (Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec)");
				    			month = moreportinput.nextLine();
				    		} while (!(month.equalsIgnoreCase("Jan") || month.equalsIgnoreCase("Feb") || month.equalsIgnoreCase("Mar") || month.equalsIgnoreCase("Apr") || month.equalsIgnoreCase("May") || month.equalsIgnoreCase("Jun") || month.equalsIgnoreCase("Jul") || month.equalsIgnoreCase("Aug") || month.equalsIgnoreCase("Sep") || month.equalsIgnoreCase("Oct") || month.equalsIgnoreCase("Nov") || month.equalsIgnoreCase("Dec")));
				    		
				    		//year
				    		do {
					        	System.out.println("What year do you want to view?");
				    			System.out.println("Year (2xxx)");
				    			year = moreportinput.nextInt();
				    		} while (year>2999 || year<2000);
				    		
				    		Report.monthreport(year, month);

				            //moreportinput.close();
				            
				            return (1);
				        case 4:
				        	//ask for year to view
				        	
				        	//year
				    		do {
					        	System.out.println("What year do you want to view?");
				    			System.out.println("Year (2xxx)");
				    			year = Helper.scan.nextInt();
				    		} while (year>2999 || year<2000);
				        	
				    		Report.annualreport(year);
				        	return(1);
				        case 5:
				            return (1);
				        default:
				            System.out.println("Invalid Menu Number"); //prevent other input
				            return (1);
				        }
				
					}
}
		
