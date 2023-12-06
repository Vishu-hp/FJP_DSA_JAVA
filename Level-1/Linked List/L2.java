
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
            else if(idx<0 || idx>sz){
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
        
        Node getNodeAt(int idx){
            if(sz == 0){
                System.out.println("List is empty");
                return null;
            }
            else if(idx<0 || idx>sz){
                System.out.println("Invalid arguments");
                return null;
            }
            else{
                Node temp = head;
                for(int i=0;i<idx;i++){
                    temp = temp.next;
                }
                return temp;
            }
        }
        
        void addAt(int idx, int val){
            if(idx < 0 || idx > sz){
                System.out.println("Invalid arguments");
            }
            else if(idx == 0){
                addFirst(val);
            }
            else if(idx == sz){
                addLast(val);
            }
            else{
                Node newNode = new Node(val);
            
                Node temp = head;
                for(int i=0;i<idx-1;i++){
                    temp = temp.next;
                }
                
                newNode.next = temp.next;
                temp.next = newNode;
                
                sz++;
            }
            
        }
        
        void removeFirst(){
            if(sz == 0){
                System.out.println("List is empty");
            }
            else if(sz == 1){
                head = null;
                sz =0;
            }
            else{
                head = head.next;
                sz--;
            }
        }
        
        void removeLast(){
            if(sz == 0){
                System.out.println("List is empty");
            }
            else if(sz == 1){
                head = null;
                sz =0;
            }
            else{
                Node temp = head;
                Node prev= null;
                while(temp.next != null){
                    prev= temp;
                    temp = temp.next;
                }
                prev.next = null;
                sz--;
            }
        }
        
        void removeAt(int idx){
            if(idx<0 || idx>=sz){
                System.out.println("Invalid arguments");
            }
            else if(idx == 0){
                removeFirst();
            }
            else if(idx == sz-1){
                removeLast();
            }
            else{
                Node prev= null;
                
                Node temp = head;
                for(int i=0;i<idx;i++){
                    prev = temp;
                    temp = temp.next;
                }
                
                prev.next = temp.next;
                sz--;
            }
        }
        
        int kthFromLast(int k){
            Node f=head, s=head;
            
            for(int i=0;i<k;i++){
                 s = s.next;
            }
            
            while(s != null){
                f = f.next;
                s = s.next;
            }
            
            return f.data;
        }
        
        int mid(){
            Node f= head, s=head;
            
            while(f.next != null && f.next.next != null){
                f = f.next.next;
                s = s.next;
            }
            return s.data;
        }
        
        void reverseDataIterative(){
            int li = 0, ri = sz-1;
            
            while(li<ri){
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);
                
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                
                li++;
                ri--;
            }
        }
        
        void reversePointerIterative(){
            Node curr=head, prev=null, next= null;
            
            while(curr != null){
                Node nextN = curr.next;
                
                curr.next = prev;
                
                prev= curr;
                curr= nextN;
            }
            
            head = prev;
        }
    }
    
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		linkedList.addFirst(6);
        linkedList.addFirst(5);
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        
        linkedList.addLast(1);
        
        System.out.println();
        linkedList.display();
        
    //     linkedList.addAt(2, 200);
    //   System.out.println();
    //   linkedList.display();
       
    //   linkedList.removeFirst();
    //   System.out.println();
    //   linkedList.display();
       
    //     linkedList.removeLast();
    //   System.out.println();
    //   linkedList.display();
       
    //     linkedList.removeAt();
    //   System.out.println();
    //   linkedList.display();
    
    //   System.out.println(linkedList.kthFromLast(6));
    
    // System.out.println(linkedList.mid());
    
    linkedList.reverseDataIterative();
    linkedList.display();
       
    linkedList.reversePointerIterative();
    linkedList.display();
	}
}
