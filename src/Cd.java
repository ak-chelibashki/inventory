/**
 * @author ak-chelibashki
 * Class go be a blueprint for a CD record
 */
public class Cd extends Product{
	/**
	 * class instances
	 */
	private String artist, label;
	private int numberOfSongs;


	/**
	 * Default constructor
	 */
	public Cd() {
		super();
		this.artist ="NA";
		this.label = "NA";
		this.numberOfSongs = 0;
	}

	/**
	 * Class constructor
	 * @param number
	 * @param name
	 * @param quantity
	 * @param price
	 * @param numberOfSongs
	 * @param artist
	 * @param label
	 */
	public Cd(int number, String name, int quantity
			,double price, int numberOfSongs, String artist, String label ) {
		super(number,name,quantity,price);
		
		this.numberOfSongs = numberOfSongs;
		this.label = label;
		this.artist = artist;
	}//end constructor

	/**
	 * Method to update  artist name
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}//end method

	/**
	 * Method to retrieve artist name
	 * @return
	 */
	public String getArtist() {
		return this.artist;
	}//end

	/**
	 * Method to update record label name
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}//end 

	/**
	 * Method to retrieve record label name
	 * @return
	 */
	public String getLabel() {
		return this.label;
	}//end

	/**
	 * Method to set number of songs for the album
	 * @param numSongs
	 */
	public void setNumberOfSongs(int numSongs) {
		this.numberOfSongs = numSongs;
	}//end

	/**
	 * Method to retrieve album song number
	 * @return
	 */
	public int getNumberOfSongs() {
		return this.numberOfSongs;
	}//end

	/**
	 * Method to generate a string with information
	 * about each album
	 * @return
	 */
	public String toString() {
		return super.toString()+"\nArtist:\t\t"+getArtist()
			+"\nSongs on Album:\t\t"+getNumberOfSongs()
			+"\nRecord Label:\t\t"+getLabel();
	}//end method
	
	
}//end class
