package com.chainsys.socialmediaapplication.likes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.CommentsClass;
import com.chainsys.socialmediaapplication.daoimpl.LikesClass;
import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class TestDisplayLikes {

	
		private static final Logger LOGGER = Logger.getInstance();
		public static void main(String[] args) throws IOException {
			//LikesClass u=new LikesClass();
			CommentsClass u=new CommentsClass();
			@SuppressWarnings("resource")
			Scanner s=new Scanner(System.in);
			LOGGER.debug("Enter the post ID:");
			u.setCmtPostId(s.nextInt());
			//u.setLikePostId(s.nextInt());
			//List<LikesClass> list = u.displayLikes(u);
			List<CommentsClass> list = u.displayComments(u);
			for (CommentsClass likesClass : list) {
				LOGGER.debug(likesClass.toString2());
			}
			}

	}


