/**
 * @author ak-chelibashki
 */
public class Dvdproduct extends Product{
	private int length, ageRating;
	private String filmStudio;

	/**
	 * Default class constructor
	 */
	public Dvdproduct() {
		super();
		this.length= 0;
		this.ageRating = 0;
		this.filmStudio = "NA";
	}//end constructor

	/**
	 * Constructor passing parameters to assign to object instances
	 * @param number
	 * @param name
	 * @param quantity
	 * @param price
	 * @param length
	 * @param ageRating
	 * @param studio
	 */
	public Dvdproduct(int number, String name, int quantity
			, double price, int length, int ageRating, String studio ) {
		super(number, name, quantity, price);
		this.length = length;
		this.ageRating = ageRating;
		this.filmStudio = studio;
	}//end constructor

	/**
	 * Method to update length value
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}//end method

	/**
	 * Method to retrieve length value
	 * @return
	 */
	public int getLength() {
		return this.length;
	}//end method

	/**
	 * Method to retrieve age rating for the dvd
	 * @return
	 */
	public int getAgeRating() {
		return this.ageRating;
	}//end method

	/**
	 * Method to update age rating for the dvd
	 * @param ageRate
	 */
	public void setAgeRating(int ageRate) {
		this.ageRating = ageRate;
	}//end method

	/**
	 * Method to retrieve film
	 * @return
	 */
	public String getFilmStudio() {
		return this.filmStudio;
	}//end method

	/**
	 * Method to update film studio
	 * @param studio
	 */
	public void setFilmStudio(String studio) {
		this.filmStudio = studio;
	}//end method

	/**
	 * Method to calculate inventory total value
	 * @param restockingFee
	 * @return
	 */
	public double calculateInventoryValue( double restockingFee ) {	
		return (getUnitPrice() * getUnitsInStock() * restockingFee) +(getUnitPrice() * getUnitsInStock());
	}//end method

	/**
	 * Method to generate string with information about each film in the inventory
	 * @return
	 */
	public String toString() {
		return super.toString() +
				"\nFilm Studio:\t\t"+getFilmStudio()
				+"\nMovid Length:\t\t"+getLength()
				+"\nAge Rating:\t\t"+getAgeRating();
	}//end method
	
	
}//end class 
