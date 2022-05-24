import java.util.Arrays;

/**
 * @author arronshentu
 */
public class Weekly {
  public static void main(String[] args) {
    Weekly weekly = new Weekly();
    // int b = weekly.minimumLines(new int[][] {{1, 3}, {2, 3}, {3, 3}});
    // System.out.println(b);
  }

  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    int n = capacity.length;
    for (int i = 0; i < n; i++) {
      capacity[i] = capacity[i] - rocks[i];
    }
    Arrays.sort(capacity);
    int count = 0;
    // int tmp = 0;
    for (int i = 0; i < n && additionalRocks > 0; i++) {
      if (additionalRocks >= capacity[i]) {
        additionalRocks -= capacity[i];
        count++;
      } else {
        break;
      }
    }
    return count;
  }

  public int minimumLines(int[][] a) {
    int n = a.length;
    int ans = n - 1;
    Arrays.sort(a, (x, y) -> {
      if (x[0] != y[0]) {
        return x[0] - y[0];
      }
      return (x[1] - y[1]);
    });

    for (int i = 1; i < n - 1; i++) {
      if (ccw(a[i - 1], a[i], a[i + 1]) == 0) {
        ans--;
      }
    }
    return ans;
  }

  /**
   * 向量积 共线为0
   *
   * @param a
   * @param b
   * @param t
   * @return
   */
  public int ccw(int[] a, int[] b, int[] t) {
    return Long.signum((long)(t[0] - a[0]) * (b[1] - a[1]) - (long)(b[0] - a[0]) * (t[1] - a[1]));
  }

  class Solution {
    public int totalStrength(int[] a) {
      final int mod = 1000000007;
      int n = a.length;

      long[] cum = new long[n + 1];
      for (int i = 0; i < n; i++) {
        cum[i + 1] = cum[i] + a[i];
        cum[i + 1] %= mod;
      }

      long[] cum2 = new long[n + 2];
      for (int i = 0; i <= n; i++) {
        cum2[i + 1] = cum2[i] + cum[i];
        cum2[i + 1] %= mod;
      }

      long[] sum = {0L, 0L};
      ContourStack cs = new ContourStack(false, (l, r, v) -> {
        sum[0] += (cum2[r] - cum2[l] + mod) % mod * v;
        sum[0] %= mod;
        sum[1] += (r - l) * v;
        sum[1] %= mod;
      });
      long ans = 0;
      int p = 0;
      for (int v : a) {
        cs.add(v);
        p++;
        ans += sum[1] * cum[p] - sum[0];
        ans %= mod;
      }
      if (ans < 0) {
        ans += mod;
      }
      return (int)ans;
    }

    public class ContourStack {
      public int p, sp;
      public int[] stack;
      public long[] a;
      public boolean max;
      public WRangeConsumer cons;

      @FunctionalInterface
      public interface WRangeConsumer {
        void f(int l, int r, long v);
      }

      public ContourStack(boolean max, WRangeConsumer cons) {
        this.max = max;
        this.cons = cons;
        a = new long[1];
        stack = new int[1];
        p = sp = 0;
      }

      public void add(long v) {
        while (sp > 0 && (max ? a[sp - 1] <= v : a[sp - 1] >= v)) {
          cons.f(sp - 2 >= 0 ? stack[sp - 2] + 1 : 0, stack[sp - 1] + 1, -a[sp - 1]);
          sp--;
        }

        if (sp == stack.length) {
          stack = Arrays.copyOf(stack, sp * 2);
          a = Arrays.copyOf(a, sp * 2);
        }
        stack[sp] = p;
        a[sp++] = v;
        cons.f(sp - 2 >= 0 ? stack[sp - 2] + 1 : 0, p + 1, v);
        p++;
      }

      @Override
      public String toString() {
        return "MaxStack{" + "p=" + p + ", sp=" + sp + ", a=" + Arrays.toString(Arrays.copyOf(a, sp)) + ", stack="
          + Arrays.toString(Arrays.copyOf(stack, sp)) + '}';
      }
    }
  }

}
