public class Codec {
  static Map<String, String> urls = new HashMap<>();
  static Map<String, String> map = new HashMap<>();

  private static String makeid() {
    StringBuilder text = new StringBuilder();
    String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for (int i = 0; i < 5; i++)
      text.append(possible.charAt((int) Math.floor(Math.random() * possible.length())));

    if (!urls.containsKey(text.toString()))
      return text.toString();
    else
      return makeid();
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    if (map.containsKey(longUrl))
      return map.get(longUrl);
    String id = makeid();
    map.put(longUrl, id);
    urls.put(id, longUrl);
    return id;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    if (urls.containsKey(shortUrl))
      return urls.get(shortUrl);
    return "";
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
