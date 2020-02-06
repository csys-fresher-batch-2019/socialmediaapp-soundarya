package com.chainsys.socialmediaapplication.daoimpl;

public class Logger {
	 public static Logger getInstance() {
	        Logger logger = new Logger();
	        return logger;
	    }
	     
	    public void debug(Object message) {
	        System.out.println(message);
	    }
}
