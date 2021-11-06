package model;



public class GlobalVariables {
	public static String ADDVALUE = "ADD";
	public static String UPDATEVALUE = "UPDATE";
	public static boolean isNumber(String in)
	{
		try {
			Integer.parseInt(in);
			return true;
		}catch(Exception E)
		{
			return false;
		}
		
	}
}
