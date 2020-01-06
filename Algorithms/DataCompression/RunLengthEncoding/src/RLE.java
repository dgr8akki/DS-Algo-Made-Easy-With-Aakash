package Algorithms.DataCompression.RunLengthEncoding.src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RLE {
  private final int TEXT_LENGTH;
  private String text;

  RLE(String text) {
    this.text = text;
    this.TEXT_LENGTH = text.length();
  }

  String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  String encode() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int index = 0; index < TEXT_LENGTH - 1; index++) {
      int currentCharacterCount = 1;

      while (index + 1 < TEXT_LENGTH && (text.charAt(index) == text.charAt(index + 1))) {
        currentCharacterCount++;
        index++;
      }
      stringBuilder.append(currentCharacterCount);
      stringBuilder.append(text.charAt(index));
    }
    setText(stringBuilder.toString());
    return stringBuilder.toString();
  }

  String decode() {
    StringBuilder stringBuilder = new StringBuilder();
    Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      int runLength = Integer.parseInt(matcher.group());
      matcher.find();

      while (runLength-- != 0)
        stringBuilder.append(matcher.group());
    }

    setText(stringBuilder.toString());
    return stringBuilder.toString();
  }
}
