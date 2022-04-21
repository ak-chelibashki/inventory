/**
 * Parent class for CD and DVD classes
 * @author ak-chelibashki
 */
public class Product {

	/**
	 * Class instance fields declarations
	 */
	private int itemNumber, unitsInStock;
	private String productName;
	private double unitPrice;
	boolean active= true;


	/**
	 * Default constructor
	 * Initialize instances with default values
	 */
	public Product() {
		this.itemNumber=0;
		this.unitsInStock = 0;
		this.productName = "NA";
		this.unitPrice = 0.0;
	}//end constructor

	/**
	 * Constructor accepting to
	 * initialize class fields with parameter values
	 * provided from the user
	 * @param number
	 * @param name
	 * @param qty
	 * @param price
	 */
	public Product(int number, String name, int qty, double price) {
		this.itemNumber = number;
		this.productName = name;
		this.unitsInStock = qty;
		this.unitPrice = price;
	}//end constructor
	
	/**
	 * Method to add items to the inventory
	 */
	public void addToInventory(int quantity) {
		this.unitsInStock += quantity;
	}//end method

	/**
	 * Method to remove items from the inventory
	 * @param quantity
	 */
	public void deductFromInventory(int quantity) {
		this.unitsInStock -= quantity;
	}//end method

	/**
	 * Method to update product name value
	 * @param name
	 */
	public void setProductName(String name) {
		this.productName = name;
	}//end method

	/**
	 * Method to retrieve product name value
	 * @return
	 */
	public String getProductName() {
		return this.productName;
	}//end method


	/**
	 * Method to update itemNumber value
	 * @param num
	 */
	public void setItemNumber(int num) {
		this.itemNumber = num;
	}//end method

	/**
	 * Method to retrieve itemNumber value
	 * @return
	 */
	public int getItemNumber() {
		return this.itemNumber;
	}//end method
	
	/**
	 * Method to update the value for unitsInStock
	 */
	public void setUnitsInStock(int num) {
		this.unitsInStock = num;
	}//end method

	/**
	 * Method to retrieve the value for unitsInStock
	 * @return
	 */
	public int getUnitsInStock() {
		return this.unitsInStock;
	}//end method

	/**
	 * Method to update the value for unitPrice
	 * @param price
	 */
	public void setUnitPrice(double price) {
		this.unitPrice = price;
	}//end method

	/**
	 * Method to retrieve the value for unitPrice
	 * @return
	 */
	public double getUnitPrice() {
		return this.unitPrice;
	}//end method

	/**
	 * Method to update the value for active product
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}//end method

	/**
	 * Method to retrieve value for active
	 * @return
	 */
	public boolean getActive() {
		return this.active;
	}//end method

	/**
	 * Method to calculate inventory value
	 * @return
	 */
	public double calculateInventoryValue() {
		return getUnitPrice() *getUnitsInStock();
	}//end method

	/**
	 * Method to generate string of information about the object
	 * @return
	 */
	public String toString() {
		String line ="";
		//test if a product is active or discontinued
		String test = (this.active == true) ? ("Active") : ("Discontinued");
		
		line = "\nItem Number:\t\t"+this.itemNumber
				+"\nName:\t\t\t"+this.productName
				+"\nQuantity in Stock:\t"+this.unitsInStock
				+"\nPrice:\t\t\t"+this.unitPrice
				+"\nStock Value:\t\t"+calculateInventoryValue()
				+"\nProduct Status:\t\t"+test;
		return line;
	}//end method
}//end class

