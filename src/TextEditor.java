/**
 * @author arronshentu
 */
public class TextEditor {

  // TextEditor() Initializes the object with empty text.

  StringBuilder stringBuilder;
  int cursor;

  public TextEditor() {
    stringBuilder = new StringBuilder();
    cursor = 0;
  }

  // void addText(string text) Appends text to where the cursor is. The cursor ends to the right of text.
  public void addText(String text) {
    stringBuilder.insert(cursor, text);
    cursor += text.length();
  }

  // int deleteText(int k) Deletes k characters to the left of the cursor. Returns the number of characters actually
  // deleted.
  public int deleteText(int k) {
    int tmp = cursor;
    cursor -= k;
    if (cursor < 0) {
      cursor = 0;
    }
    stringBuilder.delete(cursor, tmp);
    return tmp - cursor;
  }

  // string cursorLeft(int k) Moves the cursor to the left k times. Returns the last min(10, len) characters to the left
  // of the cursor, where len is the number of characters to the left of the cursor.
  public String cursorLeft(int k) {
    cursor -= k;
    if (cursor < 0) {
      cursor = 0;
    }
    if (cursor < 10) {
      return stringBuilder.substring(0, cursor);
    }
    return stringBuilder.substring(cursor - 10, cursor);
  }

  // string cursorRight(int k) Moves the cursor to the right k times. Returns the last min(10, len) characters to the
  // left of the cursor, where len is the number of characters to the left of the cursor.
  public String cursorRight(int k) {
    cursor += k;
    if (cursor > stringBuilder.length()) {
      cursor = stringBuilder.length();
    }
    if (cursor < 10) {
      return stringBuilder.substring(0, cursor);
    }
    return stringBuilder.substring(cursor - 10, cursor);
  }
}
