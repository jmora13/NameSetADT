import java.util.Scanner;

public class Driver {
	public static void main (String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		NameSetADT nameSet1 = new NameSetADT();
		NameSetADT nameSet2 = new NameSetADT();
		
		System.out.println("Add a name to Name set 1: "); //adds name to nameset1, user provided
		String a = keyboard.nextLine();
		nameSet1.addOne(a);		
		
		System.out.println("Add a name to Name set 2: "); //adds name to nameset2, user provided
		String b = keyboard.nextLine();
		nameSet2.addOne(b); 	
		
		System.out.println("Remove a name from Name set 1"); //removes name from nameset1, user provided
		String c = keyboard.nextLine();
		nameSet1.remove(c);
		
		nameSet1.eraseFirst(); //erases first name in nameset1
		
		System.out.println("Which name would you like to search?"); //searches for name, user provided
		String d = keyboard.nextLine();
		nameSet1.isThere(d); //checks to see if its there
		
		NameSetADT.intersect(nameSet1, nameSet2); //combines both name sets into a new name set
		nameSet1.greaterThan(nameSet2); //checks to see if items in nameset1 is greater than nameset2
		
		System.out.println(nameSet1.toString()); //prints names for nameset1
		System.out.println(nameSet2.toString()); //prints names for nameset2
		
	}

}
