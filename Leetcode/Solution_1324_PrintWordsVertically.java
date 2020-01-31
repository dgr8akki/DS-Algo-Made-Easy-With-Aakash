class Solution {
    public List<String> printVertically(String s) {
        if(s == null || s.length() == 0)
            return new ArrayList<>();
        String[] strs = s.split(" ");
        int maxLength = 0;
        for(int i=0;i<strs.length;i++) {
            maxLength = Math.max(maxLength,strs[i].length());
        }
        int[] maxIndexAtEachLength= new int[maxLength];
        for(int j=0;j<strs.length;j++) {
            for(int i=0;i<strs[j].length();i++)
                maxIndexAtEachLength[i] = j;
        }

        List<String> result = new ArrayList<>();
        for(int i=0;i<maxIndexAtEachLength.length;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<strs.length;j++) {
                if(strs[j].length() > i)
                    sb.append(strs[j].charAt(i));
                else if(j <= maxIndexAtEachLength[i])
                    sb.append(" ");
            }
            result.add(sb.toString());
        }
    return result;
    }
}