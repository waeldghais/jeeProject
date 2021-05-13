package tn.itbs.DAO;

import tn.itbs.entity.Admin;
import tn.itbs.entity.Evenment;

public interface EvenDAO {
 void addEven(Evenment ev );
 public void deleteEven(int id);
 void UpdateEven(String id,String Ename,String Edescr,String Edate);
}
