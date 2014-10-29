/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = root, levelcur;
        while (cur.left != null) {
            levelcur = cur;
            while (levelcur != null) {
                levelcur.left.next = levelcur.right;
                if (levelcur.next != null) levelcur.right.next = levelcur.next.left;
                levelcur = levelcur.next;
            }
            cur = cur.left;
        }
    }
}