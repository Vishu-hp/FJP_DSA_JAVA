// didn't solve 

class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Map<Integer, TreeNode> levels = new HashMap<>();
        int i = 0;
        while(i < S.length()) {
            int curLevel = 0, curNum = 0;
            while(i < S.length() && S.charAt(i) == '-') {
                ++curLevel;
                ++i;
            }
            while(i < S.length() && S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                curNum = curNum*10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode curNode = new TreeNode(curNum);
            levels.put(curLevel, curNode);
            if(curLevel > 0) {
                TreeNode parent = levels.get(curLevel - 1);
                if(parent.left == null) parent.left = curNode;
                else parent.right = curNode;
            }
        }
        return levels.get(0);
    }
}
