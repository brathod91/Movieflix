package io.bkr.movieflix.repository;

import java.util.List;

import io.bkr.movieflix.entity.Users;

public interface UsersRepository {

	public Users createUser(Users user);
	public Users updateUser(Users user);
	public void deleteUser(Users user);
	public List<Users> findAllUser();
	public Users getUser(String userName,String password);
	public Users getUserbyUName(String userName) ;
	public Users getUserbyId(String userId);
	public Users getAdmin(String adminUserName,  String adminPassword);
}
