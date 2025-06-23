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

    //9->Spirally traversing a matrix
    public ArrayList<Integer> spirallyTraverse(int mat[][])
    {
        ArrayList<Integer>l=new ArrayList<>();
        int n=mat.length , m=mat[0].length;
        int top=0,bottom=n-1;
        int left=0,right=m-1;
        for(int dir=0;top<=bottom && left<=right;dir=(dir+1)%4)
        {
            if(dir==0)
            {
                for(int i=left;i<=right;i++)
                    l.add(mat[top][i]);
                top++;
            }
            else if(dir==1)
            {
                for(int i=top;i<=bottom;i++)
                    l.add(mat[i][right]);
                right--;
            }
            else if(dir==2)
            {
                for(int i=right;i>=left;i--)
                    l.add(mat[bottom][i]);
                bottom--;
            }
            else
            {
                for(int i=bottom;i>=top;i--)
                    l.add(mat[i][left]);
                left++;
            }
        }
        return l;
    }

    //10->The Celebrity Problem
    public int celebrity(int mat[][])
    {
        int n=mat.length;
        int cel=0;
        for(int i=0;i<n;i++)
        {
            if(mat[cel][i] == 1)
                cel=i;
        }
        for(int i=0;i<n;i++)
        {
            if(i!=cel)
            {
                if(mat[cel][i] == 1 || mat[i][cel] == 0)
                    return -1;
            }
        }
        return cel;
    }

    //11->Permutations of a String
    public ArrayList<String> findPermutation(String s)
    {
        ArrayList<String>l=new ArrayList<>();
        helper(s.toCharArray(),l,s.length(),0);
        return l;
    }
    public void helper(char[]ch,ArrayList<String>l,int n,int idx)
    {
        if(idx==n)
        {
            String s=new String(ch);
            if(!l.contains(s))
                l.add(new String(ch));
            return;
        }
        for(int i=idx;i<n;i++)
        {
            swap(ch,idx,i);
            helper(ch,l,n,idx+1);
            swap(ch,idx,i);
        }
    }
    public void swap(char[]ch,int i,int j)
    {
        char t=ch[i];
        ch[i]=ch[j];
        ch[j]=t;
    }

    //12->Merge Without Extra Space
    public void mergeArrays(int a[], int b[])
    {
        int n=a.length , m=b.length;
        int i=n-1 , j=0;
        while(i>=0 && j<m && a[i] > b[j])
        {
            int t=a[i];
            a[i--]=b[j];
            b[j++]=t;
        }
        Arrays.sort(a); Arrays.sort(b);
    }

    //13->Remove Duplicates Sorted Array
    public int removeDuplicates(int[] arr)
    {
        int n=arr.length;
        if(n==0)return 0;
        int idx=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i] != arr[i-1])
                arr[idx++]=arr[i];
        }
        return idx;
    }

    //14->Coin Change (Count Ways)
    public int count(int coins[], int sum)
    {
        int n=coins.length;
        int[]dp=new int[sum+1];
        dp[0]=1;
        for(int i:coins)
        {
            for(int j=i;j<=sum;j++)
                dp[j]+=dp[j - i];

        }
        return dp[sum];
    }

    //15->Validate an IP Address
    public boolean isValid(String s)
    {
        String[]str=s.split("\\.");
        int n=str.length;
        if(n!=4)
            return false;
        for(String i:str)
        {
            if(!isIp(i))
                return false;
        }
        return true;
    }
    public boolean isIp(String s)
    {
        int n=s.length();
        if(n==0)
            return false;
        if(s.charAt(0) == '0'  && n!=1)
            return false;
        for(char i:s.toCharArray())
        {
            if(i<'0' || i>'9')
                return false;
        }
        int val=Integer.valueOf(s);
        return val>=0 && val<=255 ;
    }

    //16->Rearrange Array Alternately
    public static void rearrange(int arr[])
    {
        Arrays.sort(arr);
        int t=arr.length;
        int m=t/2;
        int[]left=Arrays.copyOfRange(arr,0,m);
        int[]right=Arrays.copyOfRange(arr,m,t);
        int l=left.length , r=right.length;
        int i=0, j=r-1 ,k=0;
        while(i<l || j>=0)
        {
            if(j>=0)
                arr[k++]=right[j--];
            if(i<l)
                arr[k++]=left[i++];
        }
    }

    //17->Gas Station
    public int startStation(int[] gas, int[] cost)
    {
        int n=gas.length;
        int tot=0 , st=0 , tank=0;
        for(int i=0;i<n;i++)
        {
            int bal=gas[i] - cost[i];
            tot+=bal;
            tank+=bal;

            if(tank < 0)
            {
                st=i+1;
                tank=0;
            }
        }
        return (tot < 0)?-1:st;
    }

    //18->Roman Number to Integer
    public int romanToDecimal(String s)
    {
        int n=s.length();
        int ans=0 , carry=0;
        for(int i=n-1;i>=0;i--)
        {
            int value=value(s.charAt(i));
            if(value >= carry)
                ans+=value;
            else
                ans-=value;

            carry=value;
        }
        return ans;
    }
    public int value(char c)
    {
        switch(c)
        {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;

        }
    }

    //19->Index of an Extra Element
    public int findExtra(int a[], int b[])
    {
        int n=a.length , m=b.length;
        int min=Math.min(n,m);
        for(int i=0;i<min;i++)
        {
            if(a[i]!=b[i])
                return i;
        }
        return min;
    }

    //20->Word Break
    public boolean wordBreak(String s, String[] dictionary)
    {
        Set<String>set=new HashSet<>(Arrays.asList(dictionary));
        int n=s.length();
        boolean[]dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                String word=s.substring(j,i);
                if(dp[j] && set.contains(word))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }

    //21->Total Decoding Messages
    public int countWays(String digits)
    {
        int n=digits.length();
        if(n==0 || digits.charAt(0) == '0')
            return 0;
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            if(digits.charAt(i-1) != '0')
                dp[i] +=dp[i-1];
            int twonum=Integer.valueOf(digits.substring(i-2,i));
            if(twonum >= 10 && twonum <= 26)
                dp[i] +=dp[i-2];
        }
        return dp[n];
    }

    //22->Element with left side smaller and right side greater
    public int findElement(int[] arr)
    {
        int n=arr.length;
        int[]l=new int[n];
        int[]r=new int[n];

        l[0]=arr[0];
        for(int i=1;i<n;i++)
            l[i]=Math.max(arr[i] , l[i-1]);

        r[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            r[i]=Math.min(arr[i] , r[i+1]);

        for(int i=1;i<n-1;i++)
        {
            if(l[i-1] <= arr[i]  &&  r[i+1] >= arr[i])
                return arr[i];
        }
        return -1;
    }

    //23->Solve the Sudoku
    boolean f;
    public  void solveSudoku(int[][] mat)
    {
        this.f=false;
        dfs(mat,0,0);
        return;
    }
    public void dfs(int[][]mat,int row,int col)
    {
        if(f)
            return;
        if(col==9)
        {
            col=0;
            row++;
        }
        if(row==9)
        {
            this.f=true;
            return;
        }
        if(mat[row][col]!=0)
        {
            dfs(mat,row,col+1);
            return;
        }
        for(int i=1;i<=9;i++)
        {
            if(isvalid(mat,row,col,i))
            {
                mat[row][col]=i;
                dfs(mat,row,col+1);
                if(f)
                    return;
                mat[row][col]=0;
            }
        }
    }
    public boolean isvalid(int[][]mat,int row,int col,int val)
    {
        for(int i=0;i<9;i++)
        {
            if(mat[row][i] == val || mat[i][col] == val)
                return false;
        }
        int nrow=(row/3)*3;
        int ncol=(col/3)*3;
        for(int i=nrow;i<nrow+3;i++)
        {
            for(int j=ncol;j<ncol+3;j++)
            {
                if(mat[i][j]==val)
                    return false;
            }
        }
        return true;
    }

    //24->Check if frequencies can be equal
    public boolean sameFreq(String s)
    {
        int[]let=new int[26];
        for(char c:s.toCharArray())
            let[c - 'a']++;

        Set<Integer>baseset=new HashSet<>();
        for(int i:let)
        {
            if(i > 0)
                baseset.add(i);
        }
        if(baseset.size() == 1)
            return true;

        for(int i=0;i<26;i++)
        {
            if(let[i] == 0)
                continue;
            let[i]--;
            Set<Integer>set=new HashSet<>();
            for(int f : let)
            {
                if(f > 0)
                    set.add(f);
            }
            if(set.size() == 1)
                return true;
            let[i]++;
        }
        return false;
    }

    //25->Number of paths
    public int numberOfPaths(int m, int n)
    {
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int j=0;j<n;j++)
            dp[0][j]=1;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
                dp[i][j]=dp[i][j-1] + dp[i-1][j];
        }
        return dp[m-1][n-1];
    }

    //26->Sum of two large numbers
    public String findSum(String s1, String s2)
    {
        int n=s1.length() , m=s2.length();
        StringBuilder sb=new StringBuilder();
        int i=n-1 , j=m-1 , carry=0;
        while(i>=0 || j>=0 || carry>0)
        {
            int num1=(i>=0) ? s1.charAt(i--) - '0' : 0;
            int num2=(j>=0) ? s2.charAt(j--) - '0' : 0;
            int sum=num1 + num2 + carry;
            sb.insert(0,sum%10);
            carry=sum/10;
        }
        String ans=sb.toString();
        int k=0;
        while(k < ans.length() - 1 && ans.charAt(k) == '0')
            k++;
        return ans.substring(k);
    }

    //27->Overlapping Intervals
    public List<int[]> mergeOverlap(int[][] arr)
    {
        int n=arr.length;
        mergeSort(arr,n);
        List<int[]>l=new ArrayList<>();
        int[]curr=arr[0];
        l.add(curr);
        for(int i=1;i<n;i++)
        {
            int[]next=arr[i];
            if(curr[1] >= next[0])
                curr[1]=Math.max(curr[1],next[1]);
            else
            {
                curr=next;
                l.add(curr);
            }

        }
        return l;
    }
    public void mergeSort(int[][]arr,int n)
    {
        if(n>1)
        {
            int m=n/2;
            int[][]left=Arrays.copyOfRange(arr,0,m);
            int[][]right=Arrays.copyOfRange(arr,m,n);
            int l=left.length , r=right.length;
            mergeSort(left,l); mergeSort(right,r);
            merge(arr,left,right,l,r);
        }
    }
    public void merge(int[][]arr,int[][]left,int[][]right,int l,int r)
    {
        int i=0 ,j=0 ,k=0;
        while(i<l || j<r)
        {
            if(i<l && j<r)
                arr[k++]=(left[i][0] < right[j][0]) ? left[i++] : right[j++];
            else
            {
                if(i<l)
                    arr[k++]=left[i++];
                if(j<r)
                    arr[k++]=right[j++];
            }
        }
    }

    //28->Palindrome
    public boolean isPalindrome(int n)
    {
        int n1=n;
        int res_val=0;
        while(n > 0)
        {
            int dig=n%10;
            res_val=(res_val*10) + dig;
            n/=10;
        }
        return res_val == n1;
    }

    //29->Find missing in second array
    public ArrayList<Integer> findMissing(int[] a, int[] b)
    {
        Arrays.sort(b);
        ArrayList<Integer>l=new ArrayList<>();
        for(int i:a)
        {
            if(!binarySearch(b,i))
                l.add(i);
        }
        return l;
    }
    public boolean binarySearch(int[]arr,int target)
    {
        int n=arr.length;
        int i=0, j=n-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(arr[mid]==target)
                return true;
            else if(arr[mid] < target)
                i=mid+1;
            else
                j=mid-1;
        }
        return false;
    }

    //30->Stock Buy and Sell – Max one Transaction Allowed
    public int maximumProfit(int prices[])
    {
        int buy=prices[0];
        int maxProfit=0;
        for(int i:prices)
        {
            if(i<buy)
                buy=i;
            else
            {
                int sell=i-buy;
                maxProfit=Math.max(sell,maxProfit);
            }
        }
        return maxProfit;
    }

    //31->Wildcard Pattern Matching
    public boolean wildCard(String txt, String pat)
    {
        int n=txt.length() , m=pat.length();
        int i=0 , j=0 , starIdx=-1 , iIdx=-1;
        while(i < n)
        {
            if(j<m && (txt.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?'))
            {
                i++;
                j++;
            }
            else if(j<m && pat.charAt(j) == '*')
            {
                starIdx=j;
                j++;
                iIdx=i;
            }
            else if(starIdx != -1)
            {
                j=starIdx+1;
                iIdx++;
                i=iIdx;
            }
            else
                return false;
        }
        while(j<m && pat.charAt(j) == '*')
            j++;
        return j==m;
    }

    //32->Find the string in grid
    int[]dx={1,-1,0,0,1,-1,1,-1};
    int[]dy={0,0,1,-1,1,-1,-1,1};
    public int[][] searchWord(char[][] grid, String word)
    {
        List<int[]>l=new ArrayList<>();
        int n=grid.length , m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == word.charAt(0))
                {
                    for(int d=0;d<8;d++)
                    {
                        if(dfs(grid,word,n,m,dx[d],dy[d],i,j,0))
                        {
                            l.add(new int[]{i,j});
                            break;
                        }
                    }
                }
            }
        }
        return l.toArray(new int[0][]);
    }
    public boolean dfs(char[][]grid,String word,int n,int m,int xDir,int yDir,int i,int j,int idx)
    {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!=word.charAt(idx))
            return false;

        if(idx == word.length() - 1)
            return true;

        return dfs(grid,word,n,m,xDir,yDir,i+xDir,j+yDir,idx+1);
    }
}
