public class Solution {
  public List<List<String>> accountsMerge(List<List<String>> acts) {
    Map<String, String> owners = new HashMap<>();
    Map<String, String> parents = new HashMap<>();
    Map<String, TreeSet<String>> unions = new HashMap<>();

    for (List<String> list : acts) {
      for (int i = 0; i < list.size(); i++) {
        parents.put(list.get(i), list.get(i));
        owners.put(list.get(i), list.get(0));
      }
    }
    for (List<String> list : acts) {
      String parent = find(list.get(1), parents);
      for (int i = 2; i < list.size(); i++)
        parents.put(find(list.get(i), parents), parent);
    }
    for (List<String> account : acts) {
      String parent = find(account.get(1), parents);
      if (!unions.containsKey(parent))
        unions.put(parent, new TreeSet<>());
      for (int i = 1; i < account.size(); i++)
        unions.get(parent).add(account.get(i));
    }

    List<List<String>> res = new ArrayList<>();
    for (String p : unions.keySet()) {
      List<String> emails = new ArrayList(unions.get(p));
      emails.add(0, owners.get(p));
      res.add(emails);
    }
    return res;
  }

  private String find(String s, Map<String, String> p) {
    return p.get(s) == s ? s : find(p.get(s), p);
  }
}
