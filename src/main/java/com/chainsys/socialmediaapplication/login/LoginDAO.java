package com.chainsys.socialmediaapplication.login;

public interface LoginDAO {
	 public String login(String username,String password);
		public void updatePassword(String email,String oldPassword,String newPassword);
		public void addLogin(LoginClass add);

}
