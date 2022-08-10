import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // 注意 hasNext 和 hasNextLine 的区别
    int t = in.nextInt();
    int[] a = new int[N];
    a[0] = 1;
    for (int i = 1; i < N; i++) {
      a[i] = a[i - 1] * i % mod;
    }
    while (t-- > 0) {
      int n = in.nextInt(), k = in.nextInt();
      System.out.println(inv(a[k - 1] * a[n] % mod) * (a[n + k - 1]) % mod);
    }
  }

  private static final int mod = (int)(1e9 + 7);
  private static final int N = 1200;

  private static int ksm(int a, int b) {
    if (b == 0) {
      return 1;
    }
    if (b == 1) {
      return a;
    }
    if ((b & 1) == 1) {
      return a * ksm(a * a % mod, b >> 1) % mod;
    }
    return ksm(a * a % mod, b >> 1) % mod;
  }

  private static int inv(int b) {
    return ksm(b, mod - 2);
  }

}
