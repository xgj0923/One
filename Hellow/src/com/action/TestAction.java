package com.action;

public class TestAction {
	// �������Ԫ�����ƶ�Ӧ������
	private String username;// ��Ӧ��<input name="username"/>
    public TestAction(){
    	System.out.println("WelcomeAction:���ù��췽��...");
    }
	// ������ҵ����صĴ�����
	public String execute() throws Exception {
      System.out.println("WelcomeAction:execute()...");
      System.out.println("username="+username);
      if("monster".equals(username)){
    	  //������ͼҳ���Ӧ���߼�����
    	  return "fail";     //��Ӧ��nameform.jsp
      }else{ 
    	  return "success";  //��Ӧ��welcome.jsp
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
