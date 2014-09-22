package javabeans;

public class Post {
	 private String postId,postName,postTitle,postContent = null;
	 
	 public void setPostId(String postId)
	 {
		 this.postId = postId;
	 }
	 public String getPostId()
	 {
		 return postId;
	 }
	 
	 public void setPostName(String postName)
	 {
		 this.postName = postName;
	 }
	 public String getPostName()
	 {
		 return postName;
	 }
	 
	 public void setPostTitle(String postTitle)
	 {
		 this.postTitle = postTitle;
	 }
	 public String getPostTitle()
	 {
		 return postTitle;
	 }
	 
	 public void setPostContent(String postContent)
	 {
		 this.postContent = postContent;
	 }
	 public String getPostContent()
	 {
		 return postContent;
	 }
}
