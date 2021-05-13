package tn.itbs.DAO;

import tn.itbs.entity.Evenment;
import tn.itbs.entity.Feedback;
import tn.itbs.entity.User;

public interface FeedbackDAO {
	void AddComm(Feedback fe,String idEvn,String EmailUser);
}
