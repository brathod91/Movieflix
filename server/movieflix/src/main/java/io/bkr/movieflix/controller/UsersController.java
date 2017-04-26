package io.bkr.movieflix.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.bkr.movieflix.entity.Users;
import io.bkr.movieflix.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UsersController {

	@Autowired
	UserService service;
	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users createUser(@RequestBody Users user){
		return service.createUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "{uid}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users updateUser(@PathVariable("uid") String userId, @RequestBody Users user){
		return service.updateUser(userId, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,path = "{uid}")
	public void deleteUser(@PathVariable String userId){
		service.deleteUser(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Users> findAllUser(){
		return service.findAllUser();
	}
	
	@RequestMapping(method = RequestMethod.GET, path= "{unm}/{password}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users getUser(@PathVariable("unm") String userName, @PathVariable("password") String password){
		return service.getUser(userName, password);
	}
	
	@RequestMapping(method = RequestMethod.GET, path= "admin/{adminUserName}/{adminPassword}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users getAdmin(@PathVariable("adminUserName") String adminUserName, @PathVariable("adminPassword") String adminPassword){
		return service.getAdmin(adminUserName, adminPassword);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "auth/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users authenticateUser(@RequestBody Users user){
		return service.authenticateUser(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "auth/admin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users authenticateAdmin(@RequestBody Users user){
		return service.authenticateAdmin(user);
	}
	
	
	
	
}
