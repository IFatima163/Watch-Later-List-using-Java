package list.priority;

import java.util.Scanner;

public class ListPriority
{   
    int choice,order,searching;
    //adding values in list
    //outside of the main box to match same object as to printing method
    List_Creation list=new List_Creation();
    {
        list.insert(5);
        list.insert(2);
        list.insert(1);
    }
    
    public static void main(String[] args)
    {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\t\t\tPRIORITY LIST");
        System.out.println("--------------------------------------------------------------------------------");
        ListPriority list2=new ListPriority();
        list2.List();
    }
    
    Scanner input=new Scanner(System.in);
    //showing list
    public void List()
    {
        System.out.println("\nPlease choose your action :");
        System.out.println("\n1 : Printing List in default form");
        System.out.println("\n2 : Printing List via Priorities");
        System.out.println("\n3 : Printing Oldest To Newest added items");
        System.out.println("\n4 : Printing Newest To Oldest added items");
        System.out.println("\n5 : Printing item with searched priority");
        System.out.println("\n6 : Exit");
        System.out.println("\nChoose : ");
        choice=input.nextInt();
        if(choice>0 && choice<7)
        {
                
            Choice(choice);
        }
        else
        {
            System.out.println("\nPlease enter within 1 to 8");
            List();
        }
    }
    
    //choosing what to do
    public void Choice(int choice)
    {
        switch(choice)
        {
            case 1:
                System.out.println("\nPrinting Default List : \n");
                list.printDefault();
                List();
            break;
            case 2:
                System.out.println("\nPrinting List with priorities : \n");
                list.printPriority(Order());
                List();
            break;
            case 3:
                System.out.println("\nPrinting oldest to newest in list : \n");
                list.printOldest();
                List();
            break;
            case 4:
                System.out.println("\nPrinting newest to oldest in list : \n");
                list.printNewest();
                List();
            break;
            case 5:
                System.out.println("\nPrinting items with searched priority : \n");
                list.search_List(Search());
                List();
            break;
            case 6:
                System.out.println("\nExiting system");
                System.exit(0);
        }
    }
    
    //setting condition for order of priority
    public int Order()
    {
        System.out.println("\nPlease choose 1 for ascending order and 2 for descending order\nOrder : ");
        order=input.nextInt();
        if(order==1)
        {
            return 1;
        }
        else if(order==2)
        {
            return 2;
        }
        else
        {
            System.out.println("\n Please enter 1 or 2 only\n");
            Order();
        }
        return -1;
    }
    
    //method for searching conditions
    public int Search()
    {
        System.out.println("\nPlease enter which priority elements you want to view :\n");
        searching=input.nextInt();
        if(searching==1 || searching==2 || searching==3 || searching==4 || searching==5)
        {
            return searching;
        }
        else
        {
            System.out.println("\n Please enter from 1 to 5");
            Search();
        }
        return -1;
    }
    
}
