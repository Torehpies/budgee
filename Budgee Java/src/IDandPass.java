import java.util.HashMap;

public class IDandPass {
	
	HashMap<String,String> logininfo = new HashMap<String,String>();//declaration ng Hashmap yung 2 string represents User at Pass
																		//yung log in info yung pantawag sa userID at pass
	IDandPass(){
		
		logininfo.put("mawrk","pogi");
		logininfo.put("benog","kalbo");
		logininfo.put("seiper","challenge");
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
		
	}
	
}

//mga userID at pass ^^^^^^^^^^^