package Leetcode;

import java.util.Set;
import java.util.HashSet;

class Solution_929_Emails {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for(String email : emails) {
          // String localName = email.split("@", 2)[0];
          // localName = localName.replaceAll("\\.", "");
          // localName = localName.split("\\+", 2)[0];
          emailSet
            .add(email
              .split("@", 2)[0]
              .replaceAll("\\.", "")
              .split("\\+", 2)[0]
              .concat("@")
              .concat(email.split("@", 2)[1])
            );
        }
        return emailSet.size();
    }
    public static void main(String[] args) {
      Solution sol = new Solution();
      String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
      System.out.print(sol.numUniqueEmails(emails));
  }
}