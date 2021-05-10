package tn.itbs.DAO;

import tn.itbs.entity.User;

public interface UserDAO {
	void registerUser(User us);
	boolean loginUser(String email,String password); 
	void findiduserByemail(String email);
}
