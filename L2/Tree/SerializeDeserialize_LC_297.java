// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

public class Codec {

    // Encodes a tree to a single string.
    public void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }

        sb.append(root.val+",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder() ;
        preorder(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public  int idx = 0;
    TreeNode solve(String[] arr){
        if(idx >= arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));

        node.left = solve(arr);
        node.right = solve(arr);
        
        return node;
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        System.out.println(arr.length);
        return solve(arr);
    }
}
