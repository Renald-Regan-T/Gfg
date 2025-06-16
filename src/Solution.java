import java.util.*;
public class Solution
{
    // 1-> Kadane's Algorithm
    int maxSubarraySum(int[] arr)
    {
        // Your code here
        int n=arr.length;
        int[]dp=new int[n];
        dp[0]=arr[0];
        int max=dp[0];
        for(int i=1;i<n;i++)
        {
            dp[i]=Math.max(arr[i],arr[i]+dp[i-1]);
            max=Math.max(dp[i],max);
        }
        return max;
    }

    //2-> Array Duplicates
    public List<Integer> findDuplicates(int[] arr)
    {
        int n=arr.length;
        List<Integer>l=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        for(int i:arr)
        {
            if(set.contains(i))
                l.add(i);
            set.add(i);
        }
        return l;
    }

    //3-> Union of Arrays with Duplicates
    public static int findUnion(int a[], int b[])
    {
        Set<Integer>set=new HashSet<>();
        int n=a.length , m=b.length;
        int i=0,j=0;
        while(i<n || j<m)
        {
            if(i<n)
                set.add(a[i++]);
            if(j<m)
                set.add(b[j++]);
        }
        return set.size();
    }

    //4->Palindrome String
    public boolean isPalindrome(String s)
    {
        // code here
        int n=s.length();
        int i=0,j=n-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    //5->Two Sum - Pair with Given Sum
    public boolean twoSum(int arr[], int target)
    {
        int n=arr.length;
        Arrays.sort(arr);
        int i=0,j=n-1;
        while(i<j)
        {
            int sum=arr[i] + arr[j];
            if(sum == target)
                return true;
            else if(sum<target)
                i++;
            else
                j--;
        }
        return false;
    }

    //6->Two Sum - Pair with Given Sum
    public List<Integer> frequencyCount(int[] arr)
    {
        int n=arr.length;
        int[]dig=new int[n+1];
        for(int i:arr)
            dig[i]++;
        List<Integer>l=new ArrayList<>();
        for(int i=1;i<=n;i++)
            l.add(dig[i]);
        return l;
    }

    //7->Longest Palindrome in a String
    public String longestPalindrome(String s)
    {
        int n=s.length();
        if(n<1)
            return "";
        int st=0,en=0;
        for(int i=0;i<n;i++)
        {
            int len1=idx(s,i,i);
            int len2=idx(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>en-st)
            {
                st=i-(len-1)/2;
                en=i+len/2;
            }
        }
        return s.substring(st,en+1);
    }
    public static int idx(String s,int l,int r)
    {
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r))
        {
            l--;
            r++;
        }
        return r-l-1;
    }

    //8->Number of occurrence
    int countFreq(int[] arr, int target)
    {
        int c=0;
        for(int i:arr)
        {
            if(i==target)
                c++;
        }
        return c;
    }
}
