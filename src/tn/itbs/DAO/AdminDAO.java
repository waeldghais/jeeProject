package tn.itbs.DAO;

import tn.itbs.entity.Admin;

public interface AdminDAO {
	
	Admin findAdbyEmail(String email);
	public boolean loginAdmin(String email,String password);
}
