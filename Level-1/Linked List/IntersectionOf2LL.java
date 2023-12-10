/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    int getCount(ListNode node){
        ListNode tmp = node;
        int cnt=0;

        while(tmp!=null){
            cnt++;
            tmp = tmp.next;
        }
        return cnt;
    }

    ListNode solve(int d,ListNode h1,ListNode h2){
        ListNode t1=h1, t2=h2;

        for(int i=0;i<d;i++){
            if(t1==null){
                return null;
            }

            t1 = t1.next;
        }

        while(t1 != null && t2 != null){
            if(t1 == t2){
                return t1;
            }

            t1 = t1.next;
            t2 = t2.next;
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // METHOD 1 - HASHING
        // HashSet<ListNode>hst = new HashSet<ListNode>();

        // ListNode tmp = headA;
        // while(tmp!=null){
        //     hst.add(tmp);
        //     tmp = tmp.next;
        // }

        // tmp = headB;
        // while(tmp!=null){
        //     if(hst.contains(tmp)){
        //         return tmp;
        //     }

        //     tmp = tmp.next;
        // }

        // return null;

        // METHOD 2 - LENGTH
        int l1 = getCount(headA);
        int l2 = getCount(headB);

        if(l1 > l2){
            int d = l1-l2;
            return solve(d, headA, headB);
        }
        else{
            int d = l2-l1;
            return solve(d, headB, headA);
        }
    }
}
