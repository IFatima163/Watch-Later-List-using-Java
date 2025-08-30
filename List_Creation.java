//Content:

//data insertion
//assigning priority
//Rearranging
//Sorting with priority
//printing default list
//printing oldest to newest
//printing newest to oldest
//Printing with priority
//printing searched priority

package list.priority;

import java.util.Scanner;

public class List_Creation
{
    //create head of list
    Node head=null,tail=null;
    //for assigning priority
    byte interest;
    //creating arraylist to sort priority from 1 to 5
    int prior1[]=new int[0];
    int prior1copy[];
    int prior2[]=new int[0];
    int prior2copy[];
    int prior3[]=new int[0];
    int prior3copy[];
    int prior4[]=new int[0];
    int prior4copy[];
    int prior5[]=new int[0];
    int prior5copy[];
    //size for setting queue size
    int size=100;
    //setting limit to 100
    //limit can be how many videos do you want the list to have  at max
    //for newest priority
    int count=-1,rear=-1,front=0;
    int queue[]=new int[size];
    
    //--------------------------------------------------------------------------------
    //          INSERTION
    //--------------------------------------------------------------------------------
    public void insert(int data)
    {
        //if list is empty, i.e. head is null
        if(head==null)
        {
            Node node=new Node();
            //take data in node
            node.data=data;
            //make first node and last node the same node
            node.next=node.previous;
            node.previous=node;
            // make head equal to that node
            head=node;
            //adding value for newest in queue
            rear=(rear+1)%size;
            queue[rear]=data;
            count++;
            //prioritizing the list:
            rearrange(data,priority(data));
        }
        //if we already have values in the list
        else
        {
            //create tail for the list and connect it with head to make it circular
            tail=head.previous;
            Node node=new Node();
            //take data value in a node block
            node.data=data;
            //connect front of node with head
            node.next=head;
            //connect the head itself with the node
            head.previous=node;
            //connect back of node with tail
            node.previous=tail;
            //connect tail with the node
            tail.next=node;
            //adding value for newest in queue
            rear=(rear+1)%size;
            queue[rear]=data;
            count++;
            //prioritizing the list:
            rearrange(data,priority(data));
        }
        //given data will now be added at a newly created node at the end of the list
    }
    
    //--------------------------------------------------------------------------------
    //          SORTING
    //--------------------------------------------------------------------------------
    public byte priority(int item)
    {
        //taking priority from user
        Scanner input=new Scanner(System.in);
        System.out.print("\nChoose your interest rate");
        System.out.print(" from 1(Least Interested) to 5(Most Interested)");
        System.out.print(" for the item "+item+"\nPriority : ");
        interest=input.nextByte();
        if(interest>0 && interest<=5)
        {
            return interest;
        }
        else
        {
            System.out.println("\nError, please enter between 1 to 5");
            priority(item);
        }
        return -1;
    }
    
    public void rearrange(int item,int preference)
    {
        switch (preference)
        {
            //sorting data individually based on their priorities:
            case 1:
                //creating copy array equal to original array
                prior1copy=new int[prior1.length];
                //copying all data of original array into copy array
                copyarray(prior1,prior1copy);
                //creating original array 1 larger than its previous length
                prior1=new int[prior1copy.length+1];
                //giving original array all the items it had with previous size
                copyarray(prior1copy,prior1);
                //adding the item
                prior1[prior1copy.length]=item;
            break;
            case 2:
                prior2copy=new int[prior2.length];
                copyarray(prior2,prior2copy);
                prior2=new int[prior2copy.length+1];
                copyarray(prior2copy,prior2);
                prior2[prior2copy.length]=item;
            break;
            case 3:
                prior3copy=new int[prior3.length];
                copyarray(prior3,prior3copy);
                prior3=new int[prior3copy.length+1];
                copyarray(prior3copy,prior3);
                prior3[prior3copy.length]=item;
            break;
            case 4:
                prior4copy=new int[prior4.length];
                copyarray(prior4,prior4copy);
                prior4=new int[prior4copy.length+1];
                copyarray(prior4copy,prior4);
                prior4[prior4copy.length]=item;
            break;
            case 5:
                prior5copy=new int[prior5.length];
                copyarray(prior5,prior5copy);
                prior5=new int[prior5copy.length+1];
                copyarray(prior5copy,prior5);
                prior5[prior5copy.length]=item;
            break;
        }
    }
    
    //copy array method to help with array list
    void copyarray(int arr1[],int arr2[])
    {
        for(int i=0;i<arr1.length;i++)
        {
            arr2[i]=arr1[i];
        }
    }
    
    //to have all the individual priorities
    public void sortPriority(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.println("\t    "+arr[i]);
        }
    }
    
    //to print all 5 priorities simultaneously
    public void printPriority(int order)
    {
        //descending order
        if(order==2)
        {
            System.out.println("\nPriority 5 : ");
            sortPriority(prior5);
            System.out.println("\nPriority 4 : ");
            sortPriority(prior4);
            System.out.println("\nPriority 3 : ");
            sortPriority(prior3);
            System.out.println("\nPriority 2 : ");
            sortPriority(prior2);
            System.out.println("\nPriority 1 : ");
            sortPriority(prior1);
        }
        //ascending order
        else
        {
            System.out.println("\nPriority 1 : ");
            sortPriority(prior1);
            System.out.println("\nPriority 2 : ");
            sortPriority(prior2);
            System.out.println("\nPriority 3 : ");
            sortPriority(prior3);
            System.out.println("\nPriority 4 : ");
            sortPriority(prior4);
            System.out.println("\nPriority 5 : ");
            sortPriority(prior5);
        }
    }
    
    public void printDefault()
    {
        //giving 'print' rights of head so head does not move
        Node print=head;
        //printing until we dont complete a full circle
        //i.e. start from head and return at head
        //here; we are checking next node so while loop will not print last value
        while(print.next!=head)
        {
            //printing value
            System.out.println("\t    "+print.data);
            //moving to next node
            print=print.next;
        }
        //printing last node's data
        System.out.println("\t    "+print.data);
    }
    
    public void printOldest()
    {
        printDefault();
    }
    
    public void sortNewest(int arr[])
    {
        for(int i=count;i>=0;i--)
        {
            System.out.println("\t    "+arr[i]);
        }
    }
    
    public void printNewest()
    {
        sortNewest(queue);
    }
    
    //--------------------------------------------------------------------------------
    //          SEARCHING
    //--------------------------------------------------------------------------------
    public void search_List(int priority)
    {
        if(priority==1 || priority==2 || priority==3 || priority==4 || priority==5)
        {
            switch(priority)
            {
                case 1:
                    System.out.println("\nAll videos under Priority 1 :");
                    sortPriority(prior1);
                break;
                case 2:
                    System.out.println("\nAll videos under Priority 2 :");
                    sortPriority(prior2);
                break;
                case 3:
                    System.out.println("\nAll videos under Priority 3 :");
                    sortPriority(prior3);
                break;
                case 4:
                    System.out.println("\nAll videos under Priority 4 :");
                    sortPriority(prior4);
                break;
                case 5:
                    System.out.println("\nAll videos under Priority 5 :");
                    sortPriority(prior5);
                break;
            }
        }
    }
    
}

class Node
{
    //Node block which contains the data, front(next) and back(previous) to connect
    int data;
    Node next;
    Node previous;
}