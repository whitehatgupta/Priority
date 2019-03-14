import java.io.* ;
import java.util.Scanner ;
class linkedlist
{
    String check;
    static class node
    {
        String name;
        double cgpa;
        int token;
        node next;
        node prev;
    
        node(){
            name="";
            cgpa=0.0;
            token=0;
            next=prev=null;
            
        }
    }
    node head=new node();
    
    public void main() throws IOException
    {
        Scanner sc =new Scanner(System.in);
        System.out.println(" ");
        int  n= sc.nextInt();
        
        String name; int token; double cgpa;
        for (int i=0;i<n;i++)
        {
            check=sc.next();
            int a;
      
            
            if(check.length()==5){  //condition to check if the word is enter or served.
            
                name= sc.next();
                cgpa=sc.nextDouble();
                token= sc.nextInt();
              
                
                traverse(name, cgpa, token);
                
            }

            else
            {   
                head=head.next;     //serving the node with highest priority.
                head.prev=null;
                
            }
            
        }
        
        while(head.next!=null){             //loop for printing the left nodes.
            System.out.println(head.name);
            head=head.next;
        }
        System.out.println(head.name);  //for printing the last node which is not printed in the above loop.
    }

  

    void traverse(String name, double cgpa, int token)//for traversing and inserting the input according to priority.
    {
        node temp= new node();
        node tempi=new node();
        tempi.name=name;
        tempi.cgpa=cgpa;
        tempi.token=token;
        tempi.prev=null;
        temp=head;
        
        do
        {   //this if statement will check for priority.
            if((tempi.cgpa> temp.cgpa )||(( tempi.cgpa==temp.cgpa)&& (tempi.name.compareTo(temp.name)<0)) || (( tempi.cgpa==temp.cgpa)&& (tempi.name.compareTo(temp.name)==0)&& (tempi.token<temp.token)))
            {   
                
                    if(temp.prev==null)
                        head=tempi;
                    
                    tempi.next=temp;
                    tempi.prev=temp.prev;
                    if(temp.prev!=null)
                    temp.prev.next=tempi;
                    temp.prev=tempi;
                break;       
            }
            else
            {   
                temp=temp.next;
                if((temp.next==null)&&(temp.prev!=null))
                {
                    
                    
                    tempi.next=temp;
                    tempi.prev=temp.prev;
                    temp.prev.next=tempi;
                    temp.prev=tempi;
                    break;  
                }
            }
        }while(temp.next!=null);

        

    }
}


    