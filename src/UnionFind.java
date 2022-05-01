import java.util.Arrays;

/**
 * @author arronshentu
 */
public class UnionFind {
  private int[] parent;
  // 数据个数
  private int count;

  public UnionFind(int n) {
    count = n;
    parent = new int[n];
    // 初始化, 每一个id[i]指向自己, 没有合并的元素
    for (int i = 0; i < n; i++)
      parent[i] = i;
  }

  // 查找过程, 查找元素p所对应的集合编号
  private int find(int p) {
    assert p >= 0 && p < count;
    return parent[p];
  }

  // 查看元素p和元素q是否所属一个集合
  // O(1)复杂度
  public boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }

  // 合并元素p和元素q所属的集合
  // O(n) 复杂度
  public void union(int p, int q) {

    int pID = find(p);
    int qID = find(q);

    if (pID == qID)
      return;

    // 合并过程需要遍历一遍所有元素, 将两个元素的所属集合编号合并
    for (int i = 0; i < count; i++)
      if (parent[i] == pID)
        parent[i] = qID;
  }

  public static void main(String[] args) {
    UnionFind unionFind = new UnionFind(4);
    unionFind.union(1, 2);
    unionFind.union(0, 3);
    unionFind.union(0, 2);
    System.out.println(Arrays.toString(unionFind.parent));
  }
}
