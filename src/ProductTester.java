import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//temporary variables
		//local instances
		Scanner in = new Scanner(System.in);
		int maxSize = 0 , menuChoice;
		
		maxSize = getNumProducts(in);
		
		if(maxSize == 0) {
			System.out.println("No products required");
		}
		else {
			Product[] arr = new Product[maxSize];
			for(int i=0; i<maxSize; i++) {
				arr[i] = addToInventory(maxSize, in);
			}
			do {
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice, arr, in);
			}while(menuChoice!=0);
			
		}//end if/else
		
		
		
		
		/*
		 * get number of products from the user
		 */
	//	maxSize=getNumProducts(in);

		//maxSize = getMenuOption(in);
		
		
		
		System.out.println("How many products you want to enter?");
		maxSize = in.nextInt();
		in.nextLine();
		
		
		
		
		/*
		 * for(int i=  maxSize; i<maxSize; i++) {
		 
			Product p =addToInventory(maxSize,in);
			arr[i] = p;
		}//end loop
		
		
		
		System.out.println(maxSize);
		*/
		
		
		
		/*
		 * populate array with object value
		 */
		

		//System.out.println(getProductNumber(arr,in));
		
		//deductInventory(arr,in);
		/*
		 * display array values to console
		 */
		//displayInventory(arr);

	}//end main
	
	public static void executeMenuChoice(int menuChoice, Product[] arr, Scanner in) {
		switch(menuChoice) {
		case 1:
			displayInventory(arr);
			break;
		case 2:
			addInventory(arr,in);
			break;
		case 3:
			deductInventory(arr,in);
			break;
		case 4:
			discontinueInventory(arr,in);
			break;
		case 0:
			System.out.println("Program shuting down!");
			System.exit(0);
		}//end switch
	}//end menu method
	
	public static void discontinueInventory(Product[] arr, Scanner in) {
		int productChoice;
		
		productChoice = getProductNumber(arr,in);
		
		if(arr[productChoice].getActive() == true)
			arr[productChoice].setActive(false);
		else
			arr[productChoice].setActive(true);
		
		System.out.println("Product " + arr[productChoice].getProductName() + " state is "+arr[productChoice].getActive()+"\n");
	}//end method
		
	
	
	//deduct items from inventory
	public static void deductInventory(Product[] arr,Scanner in) {
		
		int productChoice;
		int updateValue = -1;
		
		
		productChoice = getProductNumber(arr,in);
		
		System.out.println("How manu products you want to deduct?");
		
		do {
			try {
				updateValue = in.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				System.out.println(e);
				in.nextLine();
			}
			catch(Exception e) {
				System.out.println(e);
				in.nextLine();
			}
		}while(updateValue <0 || updateValue > arr.length+1);
		
		
		arr[productChoice].deductFromInventory(updateValue);
		System.out.println(arr[productChoice].toString());
	}//end method
	
	
	//add items to inventory
	public static void addInventory(Product[] arr, Scanner in) {
		int stockChoice = -1;
		
		
		
		/*
		 * 
		 
		
		do {
			try {
				System.out.println("1:CD\n2:DVD\nPlease enter product type");
				stockChoice = in.nextInt();
				if(stockChoice ==1) {
					System.out.println("How many CD's you would like to add");
					stockChoice = in.nextInt();
				
					
				}
				else if(stockChoice == 2) {
					System.out.println("How many DVD's you would like to add");
					stockChoice = in.nextInt();
					
				}
				break;
			}
			catch(InputMismatchException e) {
				System.out.println(e);
				in.nextLine();
			}//end catch
			catch(Exception e) {
				System.out.println("Invalid input");
				in.nextLine();
			}//end catch
		}while(stockChoice < 0 || stockChoice>2);
		
		*/
		
		//
		//add quantity to inventory
		
		System.out.println("How many products you want to add?");
		int productChoice = 0;
		productChoice = in.nextInt();
		arr[stockChoice].addToInventory(productChoice);
		System.out.println(arr[stockChoice].toString());
		
	}//end method
	
	/*
	 * get user choice from CD or DVD product
	 */
	public static int getInventoryChoice(Scanner in) {
		int stockChoice = -1;
		do {
			try {
				System.out.println("1:CD\n2:DVD\nPlease enter product type");
				stockChoice = in.nextInt();
				/*
				if(stockChoice ==1) {
					System.out.println("How many CD's you would like to add");
					stockChoice = in.nextInt();
				
					
				}
				else if(stockChoice == 2) {
					System.out.println("How many DVD's you would like to add");
					stockChoice = in.nextInt();
					
				}
				break;
				*/
			}
			catch(InputMismatchException e) {
				System.out.println(e);
				in.nextLine();
			}//end catch
			catch(Exception e) {
				System.out.println("Invalid input");
				in.nextLine();
			}//end catch
		}while(stockChoice < 0 || stockChoice>2);
		
		
		return stockChoice;
		
	}//end method
	
	public static int getProductNumber(Product[] arr , Scanner in) {
		int productChoice = -1;
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(""+(i+1)+ "\n"+arr[i].getProductName());
		}
		
		do {
			try {
				System.out.println("Choose a product");
				productChoice = in.nextInt();
				productChoice -= 1;
				System.out.println("\nProduct choice " + productChoice);
			}
			catch(Exception e) {
				System.out.println(e);
				in.nextLine();
			}//end catch
		}while(productChoice <0 || productChoice > arr.length-1);
		
		return productChoice;
	}//end method
	
	//display menu options to user and accept user choice
	public static int getMenuOption(Scanner in) {
		int menuOption = -1;
		
		String menuLine = "1.View Inventory"+
		"\n2.Add Stock"+"\n3.Deduct Stock"+"\n4.Discontinue Product"
				+"\n0.Exit"+"\n Please Enter a menu option:\n";
		
		do {
			try {
				System.out.println(menuLine);
				menuOption = in.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Incorrect data type entered!");
				in.nextLine();
				}//end catch
			catch(Exception e) {
				System.out.println(e);
				in.nextLine();
				}//end catch
			
		}while(menuOption<0 || menuOption>4);
		
		return menuOption;
	}//end method

	/*
	 * method to display array values to console
	 */
	public static void displayInventory(Product[] arr) {
		for(Product p : arr)
			System.out.println(p.toString()+"\n");
	}//end method
	
	
	/*
	 * add products to inventory
	 */
	public static Product addToInventory(int maxSize, Scanner in) {
		//local instances
		int tempNumber,tempQty;
		String tempName;
		double tempPrice;
		Product p = new Product();
		
		int stockChoice = -1;

			do {
				stockChoice = getInventoryChoice(in);
				in.nextLine();
				if(stockChoice == 1) {
					Cd cd1 = new Cd();
					cd1 = (Cd) addCdToInventory(maxSize,in);
					return cd1;
				}//end if
				else if(stockChoice == 2) {
					Dvdproduct dvdproduct1 = new Dvdproduct();
					dvdproduct1 = (Dvdproduct) addDvdToInventory(maxSize, in);
					return dvdproduct1;
				}//end else/if
				else {
					System.out.println("Invalid input! You can choose from option 1 and 2");
				}
			}while(stockChoice <0 || stockChoice >2);
			
			
			
			return null;
		
		
		/*
		 * 
		 
		if(maxSize == 0) {
			System.out.println("No products required!");
		}
		else {
			

				try {
					System.out.println("Enter product name");
					tempName = in.nextLine();
					
					System.out.println("Enter product number");
					tempNumber = in.nextInt();
				
					
					System.out.println("Enter product quantity");
					tempQty = in.nextInt();
					
					System.out.println("Enter product price");
					tempPrice = in.nextDouble();
					
					p = new Product(tempNumber, tempName, tempQty, tempPrice);
				
					in.nextLine();
				}catch(InputMismatchException e) {
					System.out.println(e);
					in.nextLine();
				}//end catch
				catch(Exception e) {
					System.out.println("Invalid input");
					in.nextLine();
				}
				*/
			
		}//end if else

	
	public static Product addCdToInventory(int maxSize, Scanner in) {
		//local instances
		int tempNumber,tempQty, tempNumberOfSongs;
		String tempName, tempArtist, tempLabel;
		double tempPrice;
		Cd cd1 = new Cd();
		
		if(maxSize == 0) {
			System.out.println("No products required!");
		}
		else {
			

				try {
					System.out.println("Enter CD name");
					tempName = in.nextLine();
					
					System.out.println("Enter artist name:");
					tempArtist = in.nextLine();
					
					System.out.println("Record label name");
					tempLabel = in.nextLine();
					
					System.out.println("Enter number of songs");
					tempNumberOfSongs = in.nextInt();
					
					System.out.println("Enter product number");
					tempNumber = in.nextInt();
				
					System.out.println("Enter product quantity");
					tempQty = in.nextInt();
					
					System.out.println("Enter product price");
					tempPrice = in.nextDouble();
					
					cd1 = new Cd(tempNumber, tempName, tempQty, tempPrice, tempNumberOfSongs, tempArtist,tempLabel);
				
					in.nextLine();
				}catch(InputMismatchException e) {
					System.out.println(e);
					in.nextLine();
				}//end catch
				catch(Exception e) {
					System.out.println("Invalid input");
					in.nextLine();
				}

			
		}//end if else
		return cd1;
	}//end method

	public static Product addDvdToInventory(int maxSize, Scanner in) {
		//local instances
		int tempNumber,tempQty, tempLength = 0, tempRating;
		String tempName, tempStudio;
		double tempPrice;
		Dvdproduct dvdproduct1 = new Dvdproduct();
		
		if(maxSize == 0) {
			System.out.println("No products required!");
		}
		else {
			

				try {
					System.out.println("Enter DVD name");
					tempName = in.nextLine();
					
					System.out.println("Enter studio name:");
					tempStudio = in.nextLine();
					
					System.out.println("Enter age rating");
					tempRating = in.nextInt();
					
					System.out.println("Enter film length");
					tempLength = in.nextInt();
					
					
					System.out.println("Enter product number");
					tempNumber = in.nextInt();
				
					System.out.println("Enter product quantity");
					tempQty = in.nextInt();
					
					System.out.println("Enter product price");
					tempPrice = in.nextDouble();
					
					dvdproduct1 = new Dvdproduct(tempNumber, tempName, tempQty, tempPrice, tempLength, tempRating,tempStudio);
				
					in.nextLine();
				}catch(InputMismatchException e) {
					System.out.println(e);
					in.nextLine();
				}//end catch
				catch(Exception e) {
					System.out.println("Invalid input");
					in.nextLine();
				}

			
		}//end if else
		return dvdproduct1;
	}//end method
	
	/*
	 * take user input for number of products to be added
	 */
	public static int getNumProducts(Scanner in) {
		int maxSize=-1;
		
		/*
		 * try to take user input in correct format
		 * continue until user enters correct value
		 */
		
			do {
				try {
					
					System.out.println("Enter the number of products\nyou would like to add/remove"
							+ "\nEnter 0 (zero) if you do not wish to add products:");
				
						maxSize = in.nextInt();		
					if(maxSize<0) {
						System.out.println("Incorrect Value Entered");
						
					}
					else if(maxSize ==0) {
						System.out.println("Program terminating...");
						System.exit(0);
					}
						
					
					in.nextLine();
					}
				catch(InputMismatchException e){
					System.out.println("Incorrect data type entered!");
					in.nextLine();
					}//end catch
				catch(Exception e) {
					System.out.println(e);
					in.nextLine();
					}//end catch
				
			}while(maxSize<0);
	
		
		return maxSize;
	}
	

}//end class
