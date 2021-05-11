package tn.itbs.DAO;

import tn.itbs.entity.Admin;

public interface AdminDAO {
	boolean loginAdmin(String email,String password);
	Admin findAdbyEmail(String email);
}
