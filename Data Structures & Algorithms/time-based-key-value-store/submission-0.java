class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);       
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = map.get(key);
        Integer floorKey = timestamps.floorKey(timestamp);
        return (floorKey == null) ? "" : timestamps.get(floorKey);
    }
}
