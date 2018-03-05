import java.util.ArrayList;

public class Details {
private String name;
private String number;
Details()
{
	
}
public void nameSetter(String name)
{
	this.name=name;
	
}
public String nameGetter()
{
	return name;
}
public void numberSeter(String number)
{
	this.number=number;
	
	}
public String numberGetter()
{
	return number;
}
Details(String name,String number)
{
	this.name=name;
	this.number=number;
}


}
