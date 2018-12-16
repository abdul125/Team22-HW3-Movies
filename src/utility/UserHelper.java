package utility;

import dbmodel.UsersDB;

public class UserHelper {
	
	private static int getUserIDByUserName(String username){
		return UsersDB.GetUserIDByUserName(username);
	}

	public static int GetUserIDByUserName(String username){
		return getUserIDByUserName(username);
	}
}
