import java.lang.reflect.Field;

public class Purity {
  class MyInteger {
    int i;

    public MyInteger(int x) {
      i = x;
    }

    public int getInt() {
      return i;
    }

    public void setInt(int x) {
      i = x;
    }
  }

  public int getNext(MyInteger x) {
    int x1 = x.getInt() + 1;
    x.setInt(x1);
    return x1;
  }

  public int getNext(Integer x) throws Exception {
    int result = x + 1;
    Field f = x.getClass().getDeclaredField("value");
    f.set(x, result);
    return result;
  }

  public int getNext(int x) {
    x = x + 1;
    return x;
  }

  public static void main(String[] args) {
    // What’s happening here? is x updated or what?
    // Or here?
    // What about here?
    Purity n = new Purity();
    int i1 = 0;
    testPurity(n.getNext(i1) == n.getNext(i1), "getNext(int)");
    MyInteger myInteger = n.new MyInteger(0);
    testPurity(n.getNext(myInteger) == n.getNext(myInteger), "getNext(MyInteger)");
    Integer i3 = 0;
    try {
      testPurity(n.getNext(i3) == n.getNext(i3), "getNext(Integer)");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testPurity(boolean b, String message) {
    if (b) {
      System.out.println(message + " is pure");
    } else {
      System.out.println(message + " is not pure");
    }
  }
}
