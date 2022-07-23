// package edu.neu;
//
// import java.util.*;
//
// import edu.neu.base.TreeNode;
//
// public class Main {
//
// long f(String s, String t) {
// long a = 0, b = 0, c = 0;
// for (char x : s.toCharArray()) {
// if (x == t.charAt(2)) {
// c += b;
// }
// if (x == t.charAt(1)) {
// b += a;
// }
// if (x == t.charAt(0)) {
// a += 1;
// }
// }
// return c;
// }
//
// public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
// Set<Integer> set = new HashSet<>();
// for (int i : nums1) {
// set.add(i);
// }
// Set<Integer> res = new HashSet<>();
// // List<Integer> res = new ArrayList<>();
// for (int i : nums2) {
// if (!set.contains(i)) {
// res.add(i);
// }
// }
// Set<Integer> res2 = new HashSet<>();
// set.clear();
// for (int i : nums2) {
// set.add(i);
// }
// for (int i : nums1) {
// if (!set.contains(i)) {
// res2.add(i);
// }
// }
// List<List<Integer>> tmp = new ArrayList<>();
// tmp.add(new ArrayList<>());
// for (Integer i : res) {
// tmp.get(0).add(i);
// }
// tmp.add(new ArrayList<>());
// for (Integer i : res2) {
// tmp.get(1).add(i);
// }
// return tmp;
// }
//
// public int minSwaps(String s) {
// int n = s.length();
// int res = Integer.MAX_VALUE;
// // 符合题目要求的只有两种
// // 情况1(1在前，1多)："1010"（偶数） "10101"（奇数）模式是i+1%2也就是说!=i%2
// // 情况2(0在前，0多)："0101"（偶数） "01010"（奇数）
// // fori i%2产生 0%2=0 1%2=1
// // 统计源字符中的'0'和'1'的个数
// int n1 = count(s, '1');
// int n0 = count(s, '0');
// // 情况一
// if (n1 == (n + 1) / 2 && n0 == n / 2) {
// int diff1 = 0;
// for (int i = 0; i < n; i++) {
// // 判断和第一种情况模式不同的个数
// if (s.charAt(i) - '0' == i % 2) {
// diff1++;
// }
// }
// res = Math.min(res, diff1 / 2);
// }
// // 情况二
// if (n0 == (n + 1) / 2 && n1 == n / 2) {
// int diff2 = 0;
// for (int i = 0; i < n; i++) {
// // 判断和第二种情况模式不同的个数
// if (s.charAt(i) - '0' != i % 2) {
// diff2++;
// }
// }
// res = Math.min(res, diff2 / 2);
// }
// return res == Integer.MAX_VALUE ? -1 : res;
// }
//
// // 统计给定字符个数
// public int count(String s, char c) {
// char[] chars = s.toCharArray();
// int count = 0;
// for (char a : chars) {
// if (a == c) {
// count++;
// }
// }
// return count;
// }
//
// public int stoneGameVIII(int[] stones) {
// int n = stones.length;
// for (int i = 1; i < n; i++) {
// stones[i] += stones[i - 1];
// }
//
// int ans = stones[n - 1];
// for (int i = n - 2; i > 0; i--) {
// stones[i] -= stones[i + 1];
// stones[i] = Math.max(stones[i], stones[i + 1]);
// ans = Math.max(ans, stones[i]);
// }
//
// return ans;
// }
//
// int[] coins;
// int maxJump;
// int total;
// List<Integer> res;
// int[] min;
//
// public List<Integer> cheapestJump(int[] coins, int maxJump) {
// this.coins = coins;
// this.maxJump = maxJump;
// this.total = Integer.MAX_VALUE;
// this.min = new int[coins.length];
// res = new ArrayList<>();
// List<Integer> tmp = new ArrayList<>();
// tmp.add(1);
// build(tmp, 0, 0);
// return res;
// }
//
// void build(List<Integer> route, int index, int total) {
// if (index > coins.length - 1) {
// return;
// }
// if (coins[index] == -1) {
// return;
// }
// if (index == coins.length - 1) {
// if (total < this.total) {
// res = new ArrayList<>(route);
// this.total = total;
// } else if (total == this.total && compare(route)) {
// res = new ArrayList<>(route);
// }
// return;
// }
// for (int i = 1; i <= Math.min(maxJump, coins.length - 1); i++) {
// route.add(index + i + 1);
// build(route, index + i, total + coins[index]);
// route.remove(route.size() - 1);
// }
// }
//
// boolean compare(List<Integer> tmp) {
// if (res.isEmpty()) {
// return true;
// }
// int i = 0;
// int j = 0;
// while (i < tmp.size() && j < res.size()) {
// if (!tmp.get(i).equals(res.get(j))) {
// return tmp.get(i) < res.get(i);
// }
// i++;
// j++;
// }
// return tmp.size() < res.size();
// }
//
// public int minimumWhiteTiles(String s, int numCarpets, int carpetLen) {
// if (s.length() <= numCarpets * carpetLen) {
// return 0;
// }
// char[] floor = s.toCharArray();
// int n = s.length();
// while (numCarpets-- > 0) {
// int count = 0;
// int index = 0;
// int max = 0;
// for (int i = 0; i < n; i++) {
// if (floor[i] == '1') {
// count++;
// }
// if (i >= carpetLen && floor[i - carpetLen] == '1') {
// count--;
// }
// if (count > max) {
// max = count;
// index = i;
// }
// }
// if (max == 0) {
// return 0;
// }
// for (int i = index; i >= 0 && i > (index - carpetLen); i--) {
// floor[i] = '0';
// }
// }
// int count = 0;
// for (char c : floor) {
// if (c == '1') {
// count++;
// }
// }
// return count;
// }
//
// public long maximumSubsequenceCount(String text, String p) {
// int n = text.length();
// long ans1 = 0, ans2 = 0;
// int p0 = 1, p1 = 1;
// for (char ch : text.toCharArray()) {
// if (ch == p.charAt(1)) {
// ans1 += p0;
// }
// if (ch == p.charAt(0)) {
// ++p0;
// }
// }
// for (int i = n - 1; i >= 0; --i) {
// if (text.charAt(i) == p.charAt(0)) {
// ans2 += p1;
// }
// if (text.charAt(i) == p.charAt(1)) {
// ++p1;
// }
// }
// return Math.max(ans1, ans2);
// }
//
// private int ans = 0;
//
// public int minCameraCover(TreeNode root) {
// if (root == null) {
// return 0;
// }
// if (build(root) == 2) {
// ans++;
// }
// return ans;
// }
//
// private int build(TreeNode node) {
// if (node == null) {
// return 1;
// }
// int left = build(node.left), right = build(node.right);
// if (left == 2 || right == 2) {
// ans++;
// return 0;
// } else if (left == 0 || right == 0) {
// return 1;
// } else {
// return 2;
// }
// }
//
// public void merge(int[] nums1, int m, int[] nums2, int n) {
// int x = m - 1;
// int y = n - 1;
// int len = nums1.length - 1;
// if (len == 0) {
// nums1[0] = nums2[0];
// }
// while (x >= 0 && y >= 0) {
// nums1[len] = Math.max(nums1[x], nums2[y]);
// if (nums1[len--] == nums1[x]) {
// x--;
// } else {
// y--;
// }
// }
// while (len >= 0 && y >= 0) {
// nums1[len--] = nums1[y--];
//
// }
// }
//
// public int[] maxSlidingWindow(int[] nums, int k) {
// if (nums.length == 0 || k == 0) {
// return new int[0];
// }
// Deque<Integer> deque = new LinkedList<>();
// int[] res = new int[nums.length - k + 1];
// // 未形成窗口
// for (int i = 0; i < k; i++) {
// while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
// deque.removeLast();
// }
// deque.addLast(nums[i]);
// }
// res[0] = deque.peekFirst();
// // 形成窗口后
// for (int i = k; i < nums.length; i++) {
// if (deque.peekFirst() == nums[i - k]) {
// deque.removeFirst();
// }
// while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
// deque.removeLast();
// }
// deque.addLast(nums[i]);
// res[i - k + 1] = deque.peekFirst();
// }
// return res;
// }
//
// int[] counts = new int[100005];
//
// // public int maxFrequency(int[] nums, int k) {
// //
// // Arrays.sort(nums);
// // int n = nums.length;
// // long total = 0;
// // int left = 0;
// // int res = 1;
// // for (int right = 1; right < n; right++) {
// // total += (long)(nums[right] - nums[right - 1]) * (right - left);
// // while (total > k) {
// // total -= nums[right] - nums[left];
// // left++;
// // }
// // res = Math.max(res, right - left + 1);
// // }
// // return res;
// // }
//
// class AllOne {
// Node root;
// Map<String, Node> nodes;
//
// public AllOne() {
// root = new Node();
// root.prev = root;
// root.next = root; // 初始化链表哨兵，下面判断节点的 next 若为 root，则表示 next 为空（prev 同理）
// nodes = new HashMap<>();
// }
//
// public void inc(String key) {
// if (nodes.containsKey(key)) {
// Node cur = nodes.get(key);
// Node nxt = cur.next;
// if (nxt == root || nxt.count > cur.count + 1) {
// nodes.put(key, cur.insert(new Node(key, cur.count + 1)));
// } else {
// nxt.keys.add(key);
// nodes.put(key, nxt);
// }
// cur.keys.remove(key);
// if (cur.keys.isEmpty()) {
// cur.remove();
// }
// } else { // key 不在链表中
// if (root.next == root || root.next.count > 1) {
// nodes.put(key, root.insert(new Node(key, 1)));
// } else {
// root.next.keys.add(key);
// nodes.put(key, root.next);
// }
// }
// }
//
// public void dec(String key) {
// Node cur = nodes.get(key);
// if (cur.count == 1) { // key 仅出现一次，将其移出 nodes
// nodes.remove(key);
// } else {
// Node pre = cur.prev;
// if (pre == root || pre.count < cur.count - 1) {
// nodes.put(key, cur.prev.insert(new Node(key, cur.count - 1)));
// } else {
// pre.keys.add(key);
// nodes.put(key, pre);
// }
// }
// cur.keys.remove(key);
// if (cur.keys.isEmpty()) {
// cur.remove();
// }
// }
//
// public String getMaxKey() {
// return root.prev != null ? root.prev.keys.iterator().next() : "";
// }
//
// public String getMinKey() {
// return root.next != null ? root.next.keys.iterator().next() : "";
// }
// }
//
// class Node {
// Node prev;
// Node next;
// Set<String> keys;
// int count;
//
// public Node() {
// this("", 0);
// }
//
// public Node(String key, int count) {
// this.count = count;
// keys = new HashSet<String>();
// keys.add(key);
// }
//
// public Node insert(Node node) { // 在 this 后插入 node
// node.prev = this;
// node.next = this.next;
// node.prev.next = node;
// node.next.prev = node;
// return node;
// }
//
// public void remove() {
// this.prev.next = this.next;
// this.next.prev = this.prev;
// }
// }
//
// public int[] largestSubarray(int[] nums, int k) {
// int max = 0, start = 0, n = nums.length;
// for (int i = n - k; i >= 0; i--) {
// if (nums[i] > max) {
// start = i;
// max = nums[i];
// }
// }
// int[] ans = new int[k];
// System.arraycopy(nums, start, ans, 0, k);
// return ans;
// }
//
// public int[][] intervalIntersection(int[][] A, int[][] B) {
// List<int[]> ans = new ArrayList<>();
// int i = 0, j = 0;
//
// while (i < A.length && j < B.length) {
// int left = Math.max(A[i][0], B[j][0]);
// int right = Math.min(A[i][1], B[j][1]);
// if (left <= right) {
// ans.add(new int[] {left, right});
// }
//
// if (A[i][1] < B[j][1]) {
// i++;
// } else {
// j++;
// }
// }
//
// return ans.toArray(new int[0][]);
// }
//
// public int[] find_left_repeat_numII(int[] nums) {
// Map<Integer, Integer> map = new HashMap<>();
// int[] res = new int[nums.length];
// for (int i = 0; i < nums.length; i++) {
// int num = nums[i];
// res[i] = map.getOrDefault(num, -1);
// map.put(num, i);
// }
// return res;
// }
//
// public List<Integer> largestValues(TreeNode root) {
// List<Integer> res = new ArrayList<>();
// if (root == null) {
// return res;
// }
// build(root, 0, res);
// return res;
// }
//
// void build(TreeNode root, int depth, List<Integer> tmp) {
// if (root == null) {
// return;
// }
// if (tmp.size() == depth) {
// tmp.add(root.val);
// } else {
// tmp.set(depth, root.val > tmp.get(depth) ? root.val : tmp.get(depth));
// }
// build(root.left, depth + 1, tmp);
// build(root.right, depth + 1, tmp);
// }
//
// public int maxFrequency(int[] nums, int k) {
// Arrays.sort(nums);
// int max = 1;
// int left = 0;
// long total = 0;
// for (int right = 1; right < nums.length; right += 1) {
// total += (long)(nums[right] - nums[right - 1]) * (right - left);
// while (total > k) {
// left++;
// total -= (nums[right] - nums[left]);
// }
// max = Math.max(max, right - left + 1);
// }
// return max;
// }
//
// public double[] medianSlidingWindow(int[] nums, int k) {
// PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
// PriorityQueue<Integer> max = new PriorityQueue<>();
// for (int i = 0; i < k; i++) {
// max.offer(nums[i]);
// }
// for (int i = 0; i < k / 2; i++) {
// min.offer(max.poll());
// }
// double[] res = new double[nums.length - k + 1];
// res[0] = getMid(min, max);
// for (int i = k; i < nums.length; i++) {
// int add = nums[i], del = nums[i - k];
// if (add >= max.peek()) {
// max.offer(add);
// } else {
// min.offer(add);
// }
// if (del >= max.peek()) {
// max.remove(del);
// } else {
// min.remove(del);
// }
// adjust(min, max);
// res[i - k + 1] = getMid(min, max);
// }
//
// return res;
//
// }
//
// void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
// while (left.size() > right.size()) {
// right.add(left.poll());
// }
// while (right.size() - left.size() > 1) {
// left.add(right.poll());
// }
// }
//
// double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
// if (left.size() == right.size()) {
// return (left.peek() / 2.0) + (right.peek() / 2.0);
// } else {
// return right.peek() * 1.0;
// }
// }
//
// class Trie {
// Trie[] children;
// boolean isEnd;
//
// public Trie() {
// children = new Trie[26];
// isEnd = false;
// }
//
// public void insert(String word) {
// Trie node = this;
// for (int i = 0; i < word.length(); i++) {
// char ch = word.charAt(i);
// int index = ch - 'a';
// if (node.children[index] == null) {
// node.children[index] = new Trie();
// }
// node = node.children[index];
// }
// node.isEnd = true;
// }
//
// public boolean search(String word) {
// Trie node = this;
// for (int i = 0; i < word.length(); i++) {
// char ch = word.charAt(i);
// int index = ch - 'a';
// if (node.children[index] == null || !node.children[index].isEnd) {
// return false;
// }
// node = node.children[index];
// }
// return node != null && node.isEnd;
// }
// }
//
// public int findPeakElement(int[] nums) {
// int n = nums.length;
// int idx = (int)(Math.random() * n);
//
// while (!(compare(nums, idx - 1, idx) < 0 && compare(nums, idx, idx + 1) > 0)) {
// if (compare(nums, idx, idx + 1) < 0) {
// idx += 1;
// } else {
// idx -= 1;
// }
// }
//
// return idx;
// }
//
// public int[] get(int[] nums, int idx) {
// if (idx == -1 || idx == nums.length) {
// return new int[] {0, 0};
// }
// return new int[] {1, nums[idx]};
// }
//
// public int compare(int[] nums, int idx1, int idx2) {
// int[] num1 = get(nums, idx1);
// int[] num2 = get(nums, idx2);
// if (num1[0] != num2[0]) {
// return num1[0] > num2[0] ? 1 : -1;
// }
// if (num1[1] == num2[1]) {
// return 0;
// }
// return num1[1] > num2[1] ? 1 : -1;
// }
//
// public int strStr(String haystack, String needle) {
// if (needle == null || needle.isEmpty()) {
// return 0;
// }
// int n = haystack.length(), m = needle.length();
// for (int i = 0; i + m <= n; i++) {
// boolean flag = true;
// for (int j = 0; j < m; j++) {
// if (haystack.charAt(i + j) != needle.charAt(j)) {
// flag = false;
// break;
// }
// }
// if (flag) {
// return i;
// }
// }
// return -1;
// }
//
// Map<Character, Integer> symbolValues = new HashMap<>() {
// {
// put('I', 1);
// put('V', 5);
// put('X', 10);
// put('L', 50);
// put('C', 100);
// put('D', 500);
// put('M', 1000);
// }
// };
//
// public int romanToInt(String s) {
// int ans = 0;
// int n = s.length();
// for (int i = 0; i < n; ++i) {
// int value = symbolValues.get(s.charAt(i));
// if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
// ans -= value;
// } else {
// ans += value;
// }
// }
// return ans;
// }
//
// }
//
// class Bank {
// long[] balance;
// int n;
//
// public Bank(long[] balance) {
// this.balance = balance;
// this.n = balance.length;
// }
//
// public boolean transfer(int account1, int account2, long money) {
// if (account1 < 0 || account1 > n) {
// return false;
// }
// if (account2 < 0 || account2 > n) {
// return false;
// }
// if (balance[account1 - 1] < money) {
// return false;
// }
// balance[account1 - 1] -= money;
// balance[account2 - 1] += money;
// return true;
// }
//
// public boolean deposit(int account, long money) {
// if (account < 0 || account > n) {
// return false;
// }
// balance[account - 1] += money;
// return true;
// }
//
// public boolean withdraw(int account, long money) {
// if (account < 0 || account > n) {
// return false;
// }
// if (balance[account - 1] < money) {
// return false;
// }
// balance[account - 1] -= money;
// return true;
// }
//
// public String tree2strDfs(TreeNode root) {
// StringBuilder stringBuilder = new StringBuilder();
// build(stringBuilder, root);
//
// return stringBuilder.substring(1, stringBuilder.length() - 1);
// }
//
// void build(StringBuilder stringBuilder, TreeNode root) {
// if (root == null) {
// return;
// }
// stringBuilder.append('(').append(root.val);
// if (root.left != null) {
// build(stringBuilder, root.left);
// } else if (root.right != null) {
// stringBuilder.append("()");
// }
// if (root.right != null) {
// build(stringBuilder, root.right);
// }
// stringBuilder.append(")");
// }
//
// public String tree2str(TreeNode root) {
// StringBuilder sb = new StringBuilder();
// Set<TreeNode> vis = new HashSet<>();
// Deque<TreeNode> d = new ArrayDeque<>();
// d.addLast(root);
// while (!d.isEmpty()) {
// TreeNode t = d.pollLast();
// if (vis.contains(t)) {
// sb.append(")");
// } else {
// d.addLast(t);
// sb.append("(");
// sb.append(t.val);
// if (t.right != null) {
// d.addLast(t.right);
// }
// if (t.left != null) {
// d.addLast(t.left);
// } else if (t.right != null) {
// sb.append("()");
// }
// vis.add(t);
// }
// }
// return sb.substring(1, sb.length() - 1);
// }
//
// boolean negative = false;
//
// public double myPow(double x, int n) {
// if (x == 0) {
// return 0;
// }
// long b = n;
// double res = 1.0;
// if (b < 0) {
// x = 1 / x;
// b = -b;
// }
// while (b > 0) {
// if ((b & 1) == 1) {
// res *= x;
// }
// x *= x;
// b >>= 1;
// }
// return res;
// }
//
// public int divide(int a, int b) {
// long x = a, y = b;
// boolean isNeg = (x > 0 && y < 0) || (x < 0 && y > 0);
// if (x < 0) {
// x = -x;
// }
// if (y < 0) {
// y = -y;
// }
// long l = 0, r = x;
// while (l < r) {
// long mid = l + r + 1 >> 1;
// if (mul(mid, y) <= x) {
// l = mid;
// } else {
// r = mid - 1;
// }
// }
// long ans = isNeg ? -l : l;
// if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
// return Integer.MAX_VALUE;
// }
// return (int)ans;
// }
//
// long mul(long a, long k) {
// long ans = 0;
// while (k > 0) {
// if ((k & 1) == 1) {
// ans += a;
// }
// k >>= 1;
// a += a;
// }
// return ans;
// }
//
// public int longestValidParentheses(String s) {
// int maxans = 0;
// int[] dp = new int[s.length()];
// for (int i = 1; i < s.length(); i++) {
// if (s.charAt(i) == ')') {
// if (s.charAt(i - 1) == '(') {
// dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
// } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
// dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
// }
// maxans = Math.max(maxans, dp[i]);
// }
// }
// return maxans;
// }
//
// }
