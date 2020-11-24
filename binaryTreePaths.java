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
        traversal(root,lst, level,"");
        //System.out.println(lst);
        return lst;
    }
    public static void traversal(TreeNode node, List<String> lst, int level, String s) {
        if (node!=null) {
            level++;
            int cont = 0;
            if (level>0) {
                String temp=lst.get(lst.size()-1);
                s=temp;    
                
                for(int i=0; i<temp.length(); i++) {
                   if(temp.charAt(i) == '>') {
                      cont++;
                       if (cont==level) {
                         s=temp.substring(0,i-1);
                         break;
                        }
                    } 
                }
            }
            if (level==0) s=String.valueOf(node.val);
            else s+=("->"+String.valueOf(node.val));
            //System.out.println("level="+level+"; s="+s);
            //if (lst.size()>=1) System.out.println("s.length="+s.length()+"; pre-len="+lst.get(lst.size()-1).length());
            //if (lst.size()>=1 && s.length()>lst.get(lst.size()-1).length()) {
            if (lst.size()>=1 && cont<level) {
                lst.set(lst.size()-1,s);
            } else {
                lst.add(s);
            }
            
            //System.out.println(lst);
            traversal(node.left,lst,level,s);
            traversal(node.right,lst,level,s);
        }
    }
    
}
