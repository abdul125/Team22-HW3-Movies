package utility;

import java.util.ArrayList;

import dbmodel.TheatresDB;
import model.Theatres;

public class TheatreHelper {


	///////////////////////////////////////////////
	//////// Private Method Section ///////////////
	///////////////////////////////////////////////
	
	private static ArrayList<Theatres> getTheatreNames (){
		return TheatresDB.getTheatres();
	}
	
	
	
	
	
	///////////////////////////////////////////////
	//////// End Private Method Section ///////////
	///////////////////////////////////////////////
	
	
	///////////////////////////////////////////////
	//////// Public Method Section ///////////////
	///////////////////////////////////////////////
	
	public static ArrayList<Theatres> GetTheatreNames (){
		return getTheatreNames();
	}
	

	///////////////////////////////////////////////
	//////// End Public Method Section ///////////
	///////////////////////////////////////////////
}