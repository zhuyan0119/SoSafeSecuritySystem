package model;

public class PassWordData
{
	private String passWord;
	private boolean setOrNot = false;

	
	public void setPassWord(String pswd) throws Exception
	{
		if(setOrNot == false)
		{
			passWord = pswd;
			setOrNot = true;
		}
		else
			{
				throw new Exception("Dont't set password again!");
			} 
	}
	
	/*
	public void setPassWord(String pswd){
		if(setOrNot == false)
		{
			passWord = pswd;
			setOrNot = true;
		}
	}
	*/
	
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