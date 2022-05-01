package edu.neu.basic;

// import com.sun.tools.javac.util.Assert;

/**
 * @author arronshentu
 */
public class UnionFind {
  int[] parent;
  int[] quickFindParent;
  int[] rank;

  public UnionFind(int size, boolean rank) {
    this(size);
    if (rank) {
      this.rank = new int[size];
    }
  }

  public void unionWithRank(int x, int y) {
    int parentX = find(x);
    int parentY = find(y);
    if (parentX != parentY) {
      if (rank[parentX] > rank[parentY]) {
        parent[parentY] = parentX;
      } else if (rank[parentX] < rank[parentY]) {
        parent[parentX] = parentY;
      } else {
        parent[parentY] = parentX;
        rank[parentX] += 1;
      }
    }

  }

  public UnionFind(int size) {
    parent = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
    quickFindParent = new int[size];
    for (int i = 0; i < size; i++) {
      quickFindParent[i] = i;
    }
  }

  public int quickFind(int x) {
    return quickFindParent[x];
  }

  public int find(int x) {
    // quick-union
    while (x != parent[x]) {
      x = parent[x];
    }
    return x;
  }

  public boolean connected(int x, int y) {
    return find(x) == find(y) && quickFind(x) == quickFind(y);
  }

  public void union(int x, int y) {
    int parentX = find(x);
    int parentY = find(y);
    if (parentX != parentY) {
      parent[parentY] = parentX;
    }

    quickFindUnion(x, y);
  }

  public void quickFindUnion(int x, int y) {
    int parentX = quickFind(x);
    int parentY = quickFind(y);
    if (parentX != parentY) {
      // quick-find
      for (int i = 0; i < quickFindParent.length; i++) {
        if (quickFindParent[i] == parentY) {
          quickFindParent[i] = parentX;
        }
      }
    }
  }

  public static void main(String[] args) {
    UnionFind uf = new UnionFind(10);
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    // uf.union(8, 9);
    assert uf.connected(1, 5);
    assert uf.connected(5, 7);
    assert !uf.connected(4, 9);
    assert uf.connected(8, 9);
    // uf.union(9, 4);
    // Assert.check(uf.connected(4, 9));
  }

}
