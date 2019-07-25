package com.billability.auth.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.billability.auth.model.UserDAO;

@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public UserDAO getActiveUser(String userName) {
		UserDAO activeUserInfo = new UserDAO();
		short enabled = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM com.billability.auth.model.UserDAO u WHERE email=?1 and enabled=?2")
				.setParameter(1, userName).setParameter(2, enabled).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (UserDAO)list.get(0);
		}
		return activeUserInfo;
	}
}	
