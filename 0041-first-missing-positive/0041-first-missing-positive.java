class Solution {
    public int firstMissingPositive(int[] nums) 
    {
        HashSet <Integer> set=new HashSet<>();
        for(int i:nums)
        set.add(i);
        int i=1;
        while(true)
        {
            if(!set.contains(i))
            break;
            else i++;
        }
        return i;
    }
}   