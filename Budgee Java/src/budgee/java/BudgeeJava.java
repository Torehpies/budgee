
package budgee.java;


public class BudgeeJava {

	public static void main(String[] args) {

		IDandPass idandPass = new IDandPass();//link yung class na IDandPass.java
			
		LoginPage loginpage = new LoginPage(idandPass.getLoginInfo());//link den
	}

}
