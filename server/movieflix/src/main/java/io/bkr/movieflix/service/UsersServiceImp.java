package io.bkr.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.bkr.movieflix.entity.Users;
import io.bkr.movieflix.exception.DataAlreadyExistsException;
import io.bkr.movieflix.exception.NoDataFoundException;
import io.bkr.movieflix.repository.UsersRepository;

@Service
public class UsersServiceImp implements UserService{

	@Autowired
	UsersRepository repository;
	
	@Override
	@Transactional
	public Users createUser(Users user) {
		Users existing=repository.getUserbyUName(user.getUserName());
		if(existing != null){
			throw new DataAlreadyExistsException("Cannot Create: User Already Exist!");
		}
		return repository.createUser(user);
	}

	@Override
	@Transactional
	public Users updateUser(String userId, Users user) {
		Users existing=repository.getUserbyUName(user.getUserName());
		if(existing == null){
			throw new NoDataFoundException("User Does Not Exists!");
		}
		return repository.updateUser(existing);
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {
		Users existing=repository.getUserbyId(userId);
		if(existing == null){
			throw new NoDataFoundException("User Does Not Exists!");
		}
		repository.deleteUser(existing);
	}

	@Override
	@Transactional
	public List<Users> findAllUser() {
		return repository.findAllUser();
	}

	@Override
	public Users getUser(String userName, String password) {
		Users existing =repository.getUser(userName, password);
		if(existing==null){
			throw new NoDataFoundException("User Does Not Exists");
		}
		return existing;
	}

	@Override
	public Users getAdmin(String adminUserName, String adminPassword) {
		Users existing =repository.getUser(adminUserName, adminPassword);
		if(existing==null){
			throw new NoDataFoundException("Admin User Does Not Exists");
		}
		return existing;
	}
	
	@Override
	public Users getUserbyId(String userId) {
		return repository.getUserbyId(userId);
	}

	@Override
	public Users authenticateUser(Users user) {
		Users existing =repository.getUser(user.getUserId(), user.getPassword());
		if(existing==null){
			throw new NoDataFoundException("User Does Not Exists");
		}
		return existing	;
	}

	@Override
	public Users authenticateAdmin(Users user) {
		Users existing =repository.getAdmin(user.getUserId(), user.getPassword());
		if(existing==null){
			throw new NoDataFoundException("Admin User Does Not Exists");
		}
		return existing	;
	}

}
