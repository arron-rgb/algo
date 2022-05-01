// package edu.neu;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import edu.neu.base.TreeNode;
//
/// **
// * @author arronshentu
// */
// public class Main {
// public static void main(String[] args) {
// Solution solution = new Solution();
// Main main = new Main();
// // root = [1,null,2,null,3,null,4,null,5], ops = {{1,2,4},{1,1,3},{0,3,5}}
// TreeNode root = new TreeNode(1);
// root.right = new TreeNode(2);
// root.right.right = new TreeNode(3);
// root.right.right.right = new TreeNode(4);
// root.right.right.right.right = new TreeNode(5);
// int number = solution.getNumber(root, new int[][] {{1, 2, 4}, {1, 1, 3}, {0, 3, 5}});
// System.out.println(number);
// root = new TreeNode(4);
// root.left = new TreeNode(2);
// root.right = new TreeNode(7);
// root.right.left = new TreeNode(5);
// root.right.left.right = new TreeNode(6);
// root.left.left = new TreeNode(1);
//
// number = solution.getNumber(root, new int[][] {{0, 2, 2}, {1, 1, 5}, {0, 4, 5}, {1, 5, 7}});
// System.out.println(number);
// }
//
// List<Integer> res;
//
// public int getNumber(TreeNode root, int[][] ops) {
// res = new ArrayList<>();
// dfs(root);
// root = null;
//// NumArray numArray = new NumArray(res.toArray(new Long[0]));
// for (int[] op : ops) {
// if (op[0] == 0) {
// // 蓝色
//// numArray.rangeUpdate(op[1], op[2], -1);
// } else {
// // 红色
//// numArray.rangeUpdate(op[1], op[2], 1);
// }
// }
// int count = 0;
// for (int i : res) {
//// if (numArray.nums[i] > 0) {
// count++;
//// }
// }
// return count;
// }
//
// void dfs(TreeNode root) {
// if (root == null) {
// return;
// }
// dfs(root.left);
// res.add(root.val);
// dfs(root.right);
// }
// }
