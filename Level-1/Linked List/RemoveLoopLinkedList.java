class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node s = head, f=head;
        while(f!=null && f.next !=null){
            s = s.next;
            f = f.next.next;
            
            if(s==f){
                break;
            }
        }
        
        if(f==null || f.next==null){
            return;
        }
        
       s = head;
       if(s!=f){
        while(s.next != f.next){
            s = s.next;
            f = f.next;
        }
        
        f.next = null;
       }
       else{
           while(f.next != s){
               f = f.next;
           }
           f.next = null;
       }
        
        return;
    }
}
