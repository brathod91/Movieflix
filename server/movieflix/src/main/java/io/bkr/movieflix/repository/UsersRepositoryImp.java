package io.bkr.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.bkr.movieflix.entity.Users;

@Repository
public class UsersRepositoryImp implements UsersRepository  {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Users createUser(Users user) {
		user.setRole("USER");
		em.persist(user);
		return user;
	}

	@Override
	public Users updateUser(Users user) {
		em.merge(user);
		return user;
	}

	@Override
	public void deleteUser(Users user) {
		em.remove(user);
	}

	@Override
	public List<Users> findAllUser() {
		TypedQuery<Users> query=em.createNamedQuery("Users.getAllUser",Users.class);
		query.setParameter("pRole", "USER");
		return query.getResultList();
	}

	@Override
	public Users getUser(String userName, String password) {
		TypedQuery<Users> query=em.createNamedQuery("Users.getUser",Users.class);
		query.setParameter("pUName", userName);
		query.setParameter("pPassword", password);
		return query.getSingleResult();
	}

	@Override
	public Users getAdmin(String adminUserName, String adminPassword) {
		TypedQuery<Users> query=em.createNamedQuery("Users.getAdmin",Users.class);
		query.setParameter("pUName", adminUserName);
		query.setParameter("pPassword", adminPassword);
		return query.getSingleResult();
	}

	@Override
	public Users getUserbyUName(String userName) {
		TypedQuery<Users> query=em.createNamedQuery("Users.getUserByName",Users.class);
		query.setParameter("pUName", userName);
		return query.getSingleResult();
	}

	@Override
	public Users getUserbyId(String userId) {
		TypedQuery<Users> query=em.createNamedQuery("Users.getUserById",Users.class);
		query.setParameter("pId", userId);
		return query.getSingleResult();
	}

	

}
