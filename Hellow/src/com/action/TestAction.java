package com.action;

public class TestAction {
	// 定义与表单元素名称对应的属性
	private String username;// 对应于<input name="username"/>
    public TestAction(){
    	System.out.println("WelcomeAction:调用构造方法...");
    }
	// 定义与业务相关的处理方法
	public String execute() throws Exception {
      System.out.println("WelcomeAction:execute()...");
      System.out.println("username="+username);
      if("monster".equals(username)){
    	  //返回视图页面对应的逻辑名称
    	  return "fail";     //对应于nameform.jsp
      }else{ 
    	  return "success";  //对应于welcome.jsp
      }
	}

	// getter and setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
