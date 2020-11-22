/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst=new ArrayList<String>();
        if (root==null) return lst;
        int level = -1;
        //lst.add(String.valueOf(root.val));
        traversal(root,lst, level,"",0);
        //System.out.println(lst);
        return lst;
    }
    public static void traversal(TreeNode node, List<String> lst, int level, String s,int count) {
        if (node!=null) {
            level++;
            //String s="";
            if (level==0) {
                lst.add(String.valueOf(node.val));
            } else {
                if (level>=(lst.get(count).length()-1)/3) {
                    s=lst.get(count);
                } else if (level<(lst.get(count).length()-1)/3) {
                    s=lst.get(count).substring(0,level);
                    count+=lst.size();
                }
            }
            //System.out.println("1st s="+s);
            if (s=="") s=String.valueOf(node.val);
            else s=s+"->"+String.valueOf(node.val);
            System.out.println(s);
            //if (level<s.length()-1) count++; 
            System.out.println("count="+count);
            if (count==lst.size()-1) {
                lst.set(count,s);
            } else {
                lst.add(lst.size(),s);
            }
            System.out.println("lst="+lst);
            traversal(node.left,lst,level,s,count);
            traversal(node.right,lst,level,s,count);
        }
    }
}
