package edu.neu.basic;

/**
 * @author arronshentu
 */
public class Binary {
  /**
   * @implNote a&b: 相同位都为1，则为1；否则为0
   * @apiNote a|b: 相同位存在1，则为1；否则为0
   * @apiNote a^b: 相同位不同，则为1；否则为0
   * @apiNote >>>: 无符号右移
   */
  public static void main(String[] args) {
    // format();
    tagExample();
  }

  private static void format() {
    int x = (1 << 31) - 1;
    printBinary(x);
    int y = -(1 << 31);
    printBinary(y);
    printBinary(-5);
    printBinary(5);
  }

  private static void printBinary(int x) {
    System.out.println(x + ": " + String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
  }

  /**
   * 同时只有，容易想到使用「状态压缩」来代表「当前点的访问状态」：
   *
   * 我们可以通过一个具体的样例，来感受下「状态压缩」是什么意思：
   *
   * 例如代表编号为和编号为的节点已经被访问过，而编号为的节点尚未被访问。
   *
   * 然后再来看看使用「状态压缩」的话，一些基本的操作该如何进行：
   *
   * 假设变量存放了「当前点的访问状态」，当我们需要检查编号为的点是否被访问过时，可以使用位运算a=(state>>x)&1，来获取中第位的二进制表示，
   *
   * 如果a为代表编号为的节点已被访问，如果为则未被访问。
   *
   * 同理，当我们需要将标记编号为的节点已经被访问的话，可以使用位运算state|(1<<x)来实现标记。
   */
  private static void tagExample() {
    Tag tag = new Tag(32);
    tag.tag(5);
    printBinary(tag.state);
    System.out.println(tag.visited(5));
    System.out.println(tag.visited(6));
    tag.tag(6);
    System.out.println(tag.visited(6));
    printBinary(tag.state);
  }

  private static class Tag {
    /**
     * 使用二进制表示长度为的int的低来代指点是否被访问过
     */
    int state;

    public Tag(int x) {
      this.state = x;
    }

    /**
     * <b>注意一下 为什么要用state右移 &1</b>
     *
     *
     * @param a
     *          第a位
     * @return 是否被标记
     */
    public boolean visited(int a) {
      return ((state >> a) & 1) == 1;
    }

    public void tag(int x) {
      this.state |= (1 << x);
    }
  }
}
