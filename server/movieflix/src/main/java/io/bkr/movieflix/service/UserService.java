package io.bkr.movieflix.service;

import java.util.List;

import io.bkr.movieflix.entity.Users;

public interface UserService {

	public Users createUser(Users user);
	public Users updateUser(String userId,Users user);
	public void deleteUser(String userId);
	public List<Users> findAllUser();
	public Users getUser(String userName,String password);
	public Users getUserbyId(String userId);
	public Users getAdmin(String adminName,  String adminPassword);
	public Users authenticateUser(Users user);
	public Users authenticateAdmin( Users user);
	
}
