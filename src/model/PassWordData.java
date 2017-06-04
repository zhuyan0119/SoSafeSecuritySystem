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
	public boolean checkPwSetOrNot()
	{
		return setOrNot;
	}


}