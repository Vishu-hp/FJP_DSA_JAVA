class Solution
{
    void leftBoundary(Node node, ArrayList<Integer> ans){
        if(node == null){
            return;
        }

        if(node.left != null){
            ans.add(node.data);
            leftBoundary(node.left, ans);
        }
        else if(node.right != null){
            ans.add(node.data);
            leftBoundary(node.right, ans);
        }
    }
    
    void leaves(Node node, ArrayList<Integer> ans){
        if(node == null){
            return;
        }

        if(node.left==null && node.right==null){
            ans.add(node.data);
        }

        leaves(node.left, ans);
        leaves(node.right, ans);
    }
    
    void rightBoundary(Node node, ArrayList<Integer> ans){
        if(node == null){
            return;
        }

        if(node.right != null){
            rightBoundary(node.right, ans);
            ans.add(node.data);
        }
        else if(node.left != null){
            rightBoundary(node.left, ans);
            ans.add(node.data);
        }
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer>ans = new ArrayList<>();
	    
	    if(node == null){
	        return ans;
	    }
	    
	    if(node.left == null && node.right == null){
	        ans.add(node.data);
	        return ans;
	    }
	    
	    ans.add(node.data);
	    
	   // left boundary
	   if(node.left != null){
	        leftBoundary(node.left, ans);
	   }
	   
	   //leaf nodes
	   leaves(node, ans);
	   
	   //right boundary
	   if(node.right != null){
	        rightBoundary(node.right, ans);
	   }
	   
	   return ans;
	}
}
