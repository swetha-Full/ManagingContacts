import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ManagingDetails {
	String addMore = "no";
	String displayMore = "no";
	String deleteMore="no";
	String editMore="no";
	HashMap<String, ArrayList<Details>> h = new HashMap<String, ArrayList<Details>>();
	ArrayList<Details> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String moreChoice = "n";
		
		Scanner sc = new Scanner(System.in);
		ManagingDetails mc = new ManagingDetails();
		System.out.println("Welcome to the contact Details:");
		System.out.println("User can Add,Retrieve,Edit and Delete any contact information");

		do {
			System.out.println("Enter what you want to do:");
			String choice = sc.next();
			mc.workOnContact(choice);
			System.out.println("Do you want to make more choices");
			moreChoice = sc.next();
		} while (moreChoice.equals("y"));
		System.out.println("Thank you");
	}

	private void workOnContact(String choice) {
		// TODO Auto-generated method stub
		if (choice.equals("add"))
			addDetail();
		else if (choice.equals("display"))
			display();
		else if(choice.equals("delete"))
			delete();
		

	}

	
	private void delete() {
		// TODO Auto-generated method stub
		do
		{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the name that you want to delete:");
			String input=s.next();
			if(h.isEmpty())
			{
				System.out.println("Contact list is empty");
				System.out.println("Do you want to delete any more contacts:");
				deleteMore=s.next();
			}
			else
			{
				
				h.remove(input);
				System.out.println(input+" has been removed");
				System.out.println("Do you want to delete any more contacts:");
				deleteMore=s.next();
			}
		}while(deleteMore.equals("yes"));
	}

	public void display() {
		// TODO Auto-generated method stub
		do {
			Details d = new Details();
			if(h.isEmpty())
			System.out.println("List is empty, please add first to view");
			else
			{
			System.out.println("Enter the name that you want to see:");
			Scanner s = new Scanner(System.in);
			String input = s.next();

	if (!h.containsKey(input)) {
				System.out.println("Such a contact not yet added");
				System.out.println("Do you want to display anything more:");
				displayMore = s.next();
			} else {
				ArrayList<Details> display = new ArrayList<Details>();
				display = h.get(input);
				for(Details d1:display)
				{
					
					System.out.println(display.get(display.indexOf(d1)).nameGetter()+" "+display.get(display.indexOf(d1)).numberGetter());
				}
				
				System.out.println("Do you want to display anything more:");
				displayMore = s.next();
			
		} 
			}
	}while (displayMore.equals("yes"));
	}
	private void addDetail() {
		// TODO Auto-generated method stub
		do {
			
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the name:");
			String name = s.next();
			System.out.println("Enter the number:");
			String number = s.next();
			Details detail = new Details(name, number);
			
			if(h.containsKey(name))
			{
				list.add(detail);
				
			}
			else
			{
				
				ArrayList<Details> list = new ArrayList<>();
				list.add(detail);
				h.put(name, list);
			}
			h.put(name, list);
			System.out.println("Do you want to add more:");
			addMore = s.next();
		} while (addMore.equals("yes"));
	}

}
