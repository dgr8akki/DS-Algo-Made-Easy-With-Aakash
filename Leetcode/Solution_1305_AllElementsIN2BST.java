class Solution {        
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
     
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {  
        inOrder(root1,l1);
        inOrder(root2,l2);
        
        List<Integer> res = new ArrayList<>();
        res = mergeSort(l1,l2,res);
        
        return res;
    }
    
    public List<Integer> mergeSort(List<Integer> l1, List<Integer> l2, List<Integer> res){
        int i = 0, j = 0;
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) < l2.get(j)){
                res.add(l1.get(i));
                i++;
            }else{
                res.add(l2.get(j));
                j++;
            }
        }
        
        while(i < l1.size()){
            res.add(l1.get(i));
            i++;
        }
        while(j < l2.size()){
            res.add(l2.get(j));
            j++;
        }
        
        return res;
    }
    
    public void inOrder(TreeNode root,List<Integer> l){
        if(root == null){
            return;
        }
        inOrder(root.left,l);
        l.add(root.val);
        inOrder(root.right,l);
    }
}