class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node s=head, f=head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            
            if(s==f){
                break;
            }
        }
        
        if(f==null || f.next==null){
            return 0;
        }
        
        Node curr=head;
        while(s != curr){
            s = s.next;
            curr =curr.next;
        }
        
        int cnt=0;
        Node tmp = curr;
        while(tmp.next != curr){
            tmp = tmp.next;
            cnt++;
        }
        return cnt+1;
    }
}
