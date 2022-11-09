package com.prabathj;

import java.util.HashMap;
import java.util.Iterator;

/*
1. Declare the class as final so it can’t be extended.
2. Make all fields private so that direct access is not allowed.
3. Don’t provide setter methods for variables.
4. Make all mutable fields final so that its value can be assigned only once.
5. Initialize all the fields via a constructor performing deep copy.
6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.

https://www.digitalocean.com/community/tutorials/how-to-create-immutable-class-in-java
https://dzone.com/articles/how-to-create-an-immutable-class-in-java
*/
public final class ImmutableStudent {
	
	public final char[] state="HHHH".toCharArray();
	//https://stackoverflow.com/questions/28410386/in-immutable-class-why-fields-are-marked-as-private#:~:text=Non%2Dprivate%20fields%20may%20still,private%20will%20prevent%20this%20possibility.&text=Save%20this%20answer.,-Show%20activity%20on
	public final int id;	//this no need to be private to be immutable but its better use private 
	public final String Name;	//Reference of Immutable type
	private final HashMap<String,String> testMap;	//reference of mutable type
	
	private final ImmutableAge iAge;
	private final Age age;	//reference of mutable custom type
	
	
	/*
	 * Constructor without DEEP copy
	 * 
	public ImmutableStudent(int id, String age, HashMap<String, String> testMap) {
		super();
		this.id = id;
		this.Name = age;
		this.testMap = testMap;
	}
	*/

	
	//Deep COPY
	
	public ImmutableStudent(int id, String name, HashMap<String, String> hm, Age age,ImmutableAge iAge) {
		System.out.println("Performing Deep Copy for Object initialization");
		this.id=id;
		this.Name=name;
		
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap=tempMap;
		
		this.age=age;
		this.iAge=iAge;
		
		
	}
	
	public ImmutableAge getiAge() {
		return iAge;
	}

	public char[] getState() {
		return state.clone();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public HashMap<String, String> getTestMap() {
		//return testMap as a clone;
		//return (HashMap<String, String>) testMap.clone();
	
		return testMap;
	}

	public Age getAge() {
		return age;
	}	
	
	/*
	public HashMap<String, String> getTestMap() {
		//return testMap as a clone;
		return (HashMap<String, String>) testMap.clone();
	}	
	*/
	
	public static void main(String[] args) {
		
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		
		String s = "original";
		
		int i=10;
		Age age=new Age(18,02,1894);
		ImmutableAge iAge=new ImmutableAge(34);
		ImmutableStudent ce = new ImmutableStudent(i,s,h1,age,iAge);
		
		//Lets see whether its copy by field or reference
		System.out.println(s==ce.getName());
		System.out.println(h1 == ce.getTestMap());
		System.out.println(age == ce.getAge());
		System.out.println(iAge == ce.getiAge());
		
		//print the ce values
		System.out.println("ce id:"+ce.getId());		
		System.out.println("ce name:"+ce.getName());
		System.out.println("ce testMap:"+ce.getTestMap());
		System.out.println("ce state :"+ String.valueOf(ce.getState()));
		System.out.println("ce age :"+ ce.getAge().toString());
		System.out.println("ce iAge :"+ ce.getiAge().getAge());
		//change the local variable values
		i=20;
		s="modified";
		h1.put("3", "third");
		ce.state[0]='L';
		age.setYear(2994);
		int a=ce.id;
		
		//print the values again
		System.out.println("ce id after local variable change:"+ce.getId());
		System.out.println("ce name after local variable change:"+ce.getName());
		System.out.println("ce testMap after local variable change:"+ce.getTestMap());
		System.out.println("ce state after local variable change:"+String.valueOf(ce.getState()));
		System.out.println("ce age after local variable change :"+ ce.getAge().toString());
		System.out.println("ce iAge local variable change ::"+ ce.getiAge().getAge());
		
		System.out.println(iAge == ce.getiAge());
		
		HashMap<String, String> hmTest = ce.getTestMap();
		hmTest.put("4", "new");
		
		System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());

	}




}
