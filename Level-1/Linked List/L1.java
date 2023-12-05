
public class Main
{
    public static class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    
    public static class LinkedList{
        Node head;
        int sz = 0;
        
        void addFirst(int val){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            
            sz++;
        }
        
        void addLast(int val){
            Node newNode = new Node(val);
            sz++;
            if(head == null){
                head= newNode;
                return;
            }
            
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            
            last.next = newNode;
        }
        
        void display(){
            Node node = head;
            while(node != null){
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
        }
        
        int size(){
            int cnt = 0;
            Node node = head;
            while(node != null){
                cnt++;
                node = node.next;
            }
            return cnt;
        }
        
        int getFirst(){
            if(sz == 0 ){
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }
        
        int getLast(){
            if(sz == 0){
                System.out.println("List is empty");
                return -1;
            }
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            return last.data;
        }
        
        int getAt(int idx){
            if(sz == 0){
                System.out.println("List is empty");
                return -1;
            }
            else if(idx<0 || idx>=sz){
                System.out.println("Invalid arguments");
                return -1;
            }
            else{
                Node temp = head;
                for(int i=0;i<idx;i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }
    }
    
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		linkedList.addFirst(6);
        linkedList.addFirst(5);
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        
        // System.out.print("Created Linked list is: ");
        // linkedList.display();
 
        // Insert 1 at the end
        linkedList.addLast(1);
        // System.out.print("\nAfter inserting 1 at the end: ");
        // linkedList.display();
        
        //  System.out.print("\nSize of ll : " + linkedList.size());
	
	    
	      System.out.print("\nGet first : " + linkedList.getFirst());
	      System.out.print("\nGet last : " + linkedList.getLast());
	      System.out.print("\nGet at : " + linkedList.getAt(3));
	}
}
