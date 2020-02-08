package com.epam.demom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

abstract class Mygift
{
	String name;
	Integer quantity;
	Integer weight_in_grams;
	abstract int total_weight();
}

class Mychocolates extends Mygift
{
	Mychocolates(String name,int quantity,int weight_in_grams)
	{
		this.name=name;
		this.quantity =quantity;
		this.weight_in_grams = weight_in_grams;
	}
	
	int total_weight()
	{
		return this.quantity*this.weight_in_grams;
	}
}

class Mysweets extends Mygift
{
	Mysweets(String name,int quantity,int weight_in_grams)
	{
		this.name=name;
		this.quantity =quantity;
		this.weight_in_grams = weight_in_grams;
	}
	int total_weight()
	{
		return this.quantity*this.weight_in_grams;
	}
}

class Mycandy extends Mygift
{
	Mycandy(String name,int quantity,int weight_in_grams)
	{
		this.name=name;
		this.quantity =quantity;
		this.weight_in_grams = weight_in_grams;
	}
	int total_weight()
	{
		return this.quantity*this.weight_in_grams;
	}
}

 
public class App 
{
	static void name_sort(Vector<Mygift> child1,Vector<Mygift> child2)
	{
		Vector<Mychocolates> v=new Vector<Mychocolates>();
		for(Mygift g : child1)
		{
			if(g instanceof Mychocolates)
			{
				Mychocolates c=(Mychocolates) g;
				v.add(c);
			}
		}
		Comparator<Mychocolates> byname=(Mychocolates c1,Mychocolates c2) -> c1.name.compareTo(c2.name);
		Collections.sort(v,byname);
		System.out.println("\tFirst gift box : ");
		for(Mychocolates c:v)
			System.out.println("->"+c.name);
		v.clear();
		for(Mygift g : child2)
		{
			if(g instanceof Mychocolates)
			{
				Mychocolates c=(Mychocolates) g;
				v.add(c);
			}
		}
		Collections.sort(v,byname);
		System.out.println("\n\tSecond gift box : ");
		for(Mychocolates c:v)
			System.out.println("->"+c.name);
	}
	
	static void quantity_sort(Vector<Mygift> child1,Vector<Mygift> child2)
	{
		Vector<Mychocolates> v=new Vector<Mychocolates>();
		for(Mygift g : child1)
		{
			if(g instanceof Mychocolates)
			{
				Mychocolates c=(Mychocolates) g;
				v.add(c);
			}
		}
		Comparator<Mychocolates> byquant=(Mychocolates c1,Mychocolates c2) ->  c1.quantity.compareTo(c2.quantity);
		Collections.sort(v,byquant);
		System.out.println("\tFirst gift box : ");
		for(Mychocolates c:v)
			System.out.println("->"+c.name+":"+c.quantity);
		v.clear();
		for(Mygift g : child2)
		{
			if(g instanceof Mychocolates)
			{
				Mychocolates c=(Mychocolates) g;
				v.add(c);
			}
		}
		Collections.sort(v,byquant);
		System.out.println("\n\tSecond gift box : ");
		for(Mychocolates c:v)
			System.out.println("->"+c.name+":"+c.quantity);
	}
	static void weight_sort(Vector<Mygift> child1,Vector<Mygift> child2)
	{
		Vector<Mychocolates> v=new Vector<Mychocolates>();
		for(Mygift g : child1)
		{
			if(g instanceof Mychocolates)
			{
				Mychocolates c=(Mychocolates) g;
				v.add(c);
			}
		}
		Comparator<Mychocolates> byweight=(Mychocolates c1,Mychocolates c2) -> c1.weight_in_grams.compareTo(c2.weight_in_grams);
		Collections.sort(v,byweight);
		System.out.println("\nFirst gift box : ");
		for(Mychocolates c:v)
			System.out.println("->"+c.name+" : "+c.weight_in_grams+" gms");
		v.clear();
		for(Mygift g : child2)
		{
			if(g instanceof Mychocolates)
			{
				Mychocolates c=(Mychocolates) g;
				v.add(c);
			}
		}
		Collections.sort(v,byweight);
		System.out.println("\n\tSecond gift box : ");
		for(Mychocolates c:v)
			System.out.println("->"+c.name+" : "+c.weight_in_grams+" gms");
	}
	
	static void search(String cn,Vector<Mygift> child1,Vector<Mygift> child2)
	{
		boolean c1=false,c2=false;
		for(Mygift g : child1)
		{
			if(g instanceof Mycandy)
			{
				Mycandy c=(Mycandy) g;
				if(c.name.equals(cn))
				{
					c1=true;
					break;
				}
			}
		}
		for(Mygift g : child2)
		{
			if(g instanceof Mycandy)
			{
				Mycandy c=(Mycandy) g;
				if(c.name.equals(cn))
				{
					c2=true;
					break;
				}
			}
		}
		if(c1==false && c2==false)
			System.out.println(cn+" not found in either of boxes ");
		else
		{
			if(c1)
				System.out.println(cn+" found in gift box 1");
			if(c2)
				System.out.println(cn+" found in gift box 2");
		}
	}
	
    public static void main( String[] args ) throws IOException
    {
    	Vector<Mygift> child1=new Vector<Mygift>();
    	Vector<Mygift> child2=new Vector<Mygift>();
    	child1.add(new Mychocolates("Munch",3,10));
    	child1.add(new Mychocolates("Bar one",2,15));
    	child1.add(new Mychocolates("Dairy Milk",2,20));
    	child1.add(new Mychocolates("Five star",3,15));
    	child1.add(new Mysweets("Ladoo",2,200));
    	child1.add(new Mysweets("Jamun",3,150));
    	child1.add(new Mysweets("Jalebi",2,100));
    	child1.add(new Mycandy("Friut candy",1,5));
    	child1.add(new Mycandy("Kopiko",10,10));
    	child1.add(new Mycandy("Melody",5,2));
    	
    	child2.add(new Mychocolates("Dairy Milk silk",1,20));
    	child2.add(new Mychocolates("White Chocolate",10,100));
    	child2.add(new Mychocolates("Five Star",11,20));
    	child2.add(new Mysweets("Motichoor",2,500));
    	child2.add(new Mysweets(" Jalebi",1,50));
    	child2.add(new Mycandy("Gems",20,2));
    	child2.add(new Mycandy("Peppermint",5,6));
    	child2.add(new Mycandy("Kisses",1,3));
    	child2.add(new Mycandy("Kisme",1,2));
    	child2.add(new Mycandy("Kopiko",5,10));
    	
    	System.out.println("The contents of gift boxes of two children are :- ");
    	System.out.println("1st gift box");
    	for(Mygift g:child1)
    	{
    		System.out.println("\t"+g.name);
    	}
    	
    	System.out.println("2nd gift box");
    	for(Mygift g:child2)
    	{
    		System.out.println("\t"+g.name);
    	}
    	
    	System.out.print("\nTotal weight of the Mygift Boxes (in grams) : ");
    	int total_weight=0;
    	for(Mygift g:child1)
    		total_weight += g.total_weight();
    	for(Mygift g:child2)
    		total_weight += g.total_weight();
    	System.out.println(total_weight+"\n");
    	
    	
    	int decision=0;
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	while(decision!=4)
    	{
	    	System.out.println("\nOptions for sorting the chocolates of children :-");
	    	System.out.println("1) by name");
	    	System.out.println("2) by quantity");
	    	System.out.println("3) by weight");
	    	System.out.println("4) quit menu and find candies");
	    	decision=Integer.parseInt(br.readLine());
	    	switch(decision)
	    	{
	    	case 1: System.out.println("Sorted according to names : ");
	    			name_sort(child1,child2);
	    			break;
	    	case 2: System.out.println("Sorted according to quantity : ");
	    			quantity_sort(child1,child2);
	    			break;
	    	case 3: System.out.println("Sorted according to weight : ");
	    			weight_sort(child1,child2);
	    			break;
	    	case 4:break;
	    	default:System.out.println("Invalid option !");
	    	}
    	}
    	String s="yes";
    	while(!s.toLowerCase().equals("no"))
    	{
	    	System.out.println("Enter the candy's name you want to search in gift Boxes : ");
	    	String cn=br.readLine();
	    	search(cn,child1,child2);
	    	System.out.println("Do you want to continue to search candies( type yes/no)");
	    	s=br.readLine();
    	}
    }
}
