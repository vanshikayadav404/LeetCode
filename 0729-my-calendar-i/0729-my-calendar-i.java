class MyCalendar 
{
    TreeMap <Integer, Integer> map;
    public MyCalendar() 
    {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer prev = map.floorKey(startTime);
        if(prev != null && map.get(prev)>startTime)
        return false;
        
        Integer next = map.ceilingKey(startTime);
        if(next != null && next < endTime)
        return false;
        
        map.put(startTime, endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */