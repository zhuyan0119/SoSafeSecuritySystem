package model;

import java.io.*;

public class PassWordData implements Serializable
{
	private String passWord;
	private boolean setOrNot = false;

	public void setPassWord(String pswd) throws Exception
	{
		if(setOrNot == false)
		{
			passWord = pswd;
			setOrNot = true;
			FileOutputStream fout = new FileOutputStream("password.txt");  
			ObjectOutputStream out = new ObjectOutputStream(fout);  

			out.writeObject(this);  
			out.flush();  
			fout.close();
		}
		else
		{
			throw new Exception("Dont't set password again!");
		} 
	}
	
	
	// return false means not set password, true means already set password
	public boolean checkPwSetOrNot()
	{
		return setOrNot;
	}
	public boolean checkPassWord(String newPswd)
	{
		//System.out.println("DEBUG0");
		//System.out.println(passWord);
		//System.out.println(newPswd);
		//System.out.println(newPswd.equals(passWord));
		return newPswd.equals(passWord);
	}


}
