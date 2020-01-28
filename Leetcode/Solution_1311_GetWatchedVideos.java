class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        visited.add(id);
        queue.offer(id);
        for(int i = 0; i<level&&!queue.isEmpty(); i++) {
            int k=queue.size();
            while(k-->0) {
                for(int val:friends[queue.poll()]) {
                    if (!visited.contains(val)) {
                        visited.add(val);
                        queue.add(val);
                    }
                }
            }
        }
        
        Map<String,Integer> cnts=new HashMap<>();
        while(!queue.isEmpty()) {
            int val=queue.poll();
            for(String video:watchedVideos.get(val)) {
                cnts.put(video,cnts.getOrDefault(video,0)+1);
            }
        }
                
        return cnts.entrySet()
            .stream()
            .sorted((a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return a.getKey().compareTo(b.getKey());
                } else {
                    return a.getValue()-b.getValue();
                }
            })
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
            
    }
}