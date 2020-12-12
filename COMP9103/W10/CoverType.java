

import java.util.*;

// Class:   CoverType
// Purpose: Represents a type of insurance cover that can be included on a policy.

// YOU SHOULD NOT NEED TO MODIFY THIS CLASS.

public class CoverType
{
	private String name;		// The name of this type of insurance cover
	private int price;			// The price of this type of insurance cover
	
	// a universal (i.e. not instance specific) attribute for keeping all known CoverTypes.
	private static ArrayList<CoverType> allTypes = null;
	
	// Constructor - deliberately not public.
	protected CoverType(String name, int price)
	{
		this.name = name;
		this.price = price;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	
	// static Method:  getCoverTypesList
	// Purpose:  It returns a List containing all the CoverTypes that are available in this program.
	public static List<CoverType> getCoverTypesList()
	{
		if (allTypes == null)		// Means that this method has not previously been called
		{
			// So we need to set up the system to contain the following hard-coded cover types
			allTypes = new ArrayList<CoverType>();
			
			allTypes.add( new CoverType("Fire",250) );		// Protection against fire
			allTypes.add( new CoverType("Flood",175) );		// Protection against flood
			allTypes.add( new CoverType("Storm Damage",160) );	// etc.
			allTypes.add( new CoverType("Theft",420) );	
		}
		
		// give back an ArrayList that contains the above cover types...
		return (List<CoverType>) allTypes.clone();
	}
}