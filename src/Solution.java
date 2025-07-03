import java.util.*;
public class Solution {
    // 1-> Kadane's Algorithm
    int maxSubarraySum(int[] arr) {
        // Your code here
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //2-> Array Duplicates
    public List<Integer> findDuplicates(int[] arr) {
        int n = arr.length;
        List<Integer> l = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i))
                l.add(i);
            set.add(i);
        }
        return l;
    }

    //3-> Union of Arrays with Duplicates
    public static int findUnion(int a[], int b[]) {
        Set<Integer> set = new HashSet<>();
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        while (i < n || j < m) {
            if (i < n)
                set.add(a[i++]);
            if (j < m)
                set.add(b[j++]);
        }
        return set.size();
    }

    //4->Palindrome String
    public boolean isPalindrome(String s) {
        // code here
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    //5->Two Sum - Pair with Given Sum
    public boolean twoSum(int arr[], int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target)
                return true;
            else if (sum < target)
                i++;
            else
                j--;
        }
        return false;
    }

    //6->Two Sum - Pair with Given Sum
    public List<Integer> frequencyCount(int[] arr) {
        int n = arr.length;
        int[] dig = new int[n + 1];
        for (int i : arr)
            dig[i]++;
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            l.add(dig[i]);
        return l;
    }

    //7->Longest Palindrome in a String
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 1)
            return "";
        int st = 0, en = 0;
        for (int i = 0; i < n; i++) {
            int len1 = idx(s, i, i);
            int len2 = idx(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > en - st) {
                st = i - (len - 1) / 2;
                en = i + len / 2;
            }
        }
        return s.substring(st, en + 1);
    }

    public static int idx(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    //8->Number of occurrence
    int countFreq(int[] arr, int target) {
        int c = 0;
        for (int i : arr) {
            if (i == target)
                c++;
        }
        return c;
    }

    //9->Spirally traversing a matrix
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> l = new ArrayList<>();
        int n = mat.length, m = mat[0].length;
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        for (int dir = 0; top <= bottom && left <= right; dir = (dir + 1) % 4) {
            if (dir == 0) {
                for (int i = left; i <= right; i++)
                    l.add(mat[top][i]);
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++)
                    l.add(mat[i][right]);
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--)
                    l.add(mat[bottom][i]);
                bottom--;
            } else {
                for (int i = bottom; i >= top; i--)
                    l.add(mat[i][left]);
                left++;
            }
        }
        return l;
    }

    //10->The Celebrity Problem
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int cel = 0;
        for (int i = 0; i < n; i++) {
            if (mat[cel][i] == 1)
                cel = i;
        }
        for (int i = 0; i < n; i++) {
            if (i != cel) {
                if (mat[cel][i] == 1 || mat[i][cel] == 0)
                    return -1;
            }
        }
        return cel;
    }

    //11->Permutations of a String
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> l = new ArrayList<>();
        helper(s.toCharArray(), l, s.length(), 0);
        return l;
    }

    public void helper(char[] ch, ArrayList<String> l, int n, int idx) {
        if (idx == n) {
            String s = new String(ch);
            if (!l.contains(s))
                l.add(new String(ch));
            return;
        }
        for (int i = idx; i < n; i++) {
            swap(ch, idx, i);
            helper(ch, l, n, idx + 1);
            swap(ch, idx, i);
        }
    }

    public void swap(char[] ch, int i, int j) {
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
    }

    //12->Merge Without Extra Space
    public void mergeArrays(int a[], int b[]) {
        int n = a.length, m = b.length;
        int i = n - 1, j = 0;
        while (i >= 0 && j < m && a[i] > b[j]) {
            int t = a[i];
            a[i--] = b[j];
            b[j++] = t;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    //13->Remove Duplicates Sorted Array
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1])
                arr[idx++] = arr[i];
        }
        return idx;
    }

    //14->Coin Change (Count Ways)
    public int count(int coins[], int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i : coins) {
            for (int j = i; j <= sum; j++)
                dp[j] += dp[j - i];

        }
        return dp[sum];
    }

    //15->Validate an IP Address
    public boolean isValid(String s) {
        String[] str = s.split("\\.");
        int n = str.length;
        if (n != 4)
            return false;
        for (String i : str) {
            if (!isIp(i))
                return false;
        }
        return true;
    }

    public boolean isIp(String s) {
        int n = s.length();
        if (n == 0)
            return false;
        if (s.charAt(0) == '0' && n != 1)
            return false;
        for (char i : s.toCharArray()) {
            if (i < '0' || i > '9')
                return false;
        }
        int val = Integer.valueOf(s);
        return val >= 0 && val <= 255;
    }

    //16->Rearrange Array Alternately
    public void rearrange(int arr[])
    {
        Arrays.sort(arr);
        int n=arr.length;
        int maxIdx=n-1 , minIdx=0;
        int max=arr[n-1] + 1;

        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                arr[i] += (arr[maxIdx] % max) * max;
                maxIdx--;
            }
            else
            {
                arr[i]
                        += (arr[minIdx] % max) * max;
                minIdx++;
            }
        }

        for(int i=0;i<n;i++)
            arr[i]/=max;
    }

    //17->Gas Station
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int tot = 0, st = 0, tank = 0;
        for (int i = 0; i < n; i++) {
            int bal = gas[i] - cost[i];
            tot += bal;
            tank += bal;

            if (tank < 0) {
                st = i + 1;
                tank = 0;
            }
        }
        return (tot < 0) ? -1 : st;
    }

    //18->Roman Number to Integer
    public int romanToDecimal(String s) {
        int n = s.length();
        int ans = 0, carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int value = value(s.charAt(i));
            if (value >= carry)
                ans += value;
            else
                ans -= value;

            carry = value;
        }
        return ans;
    }

    public int value(char c) {
        switch (c) {
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
    public int findExtra(int a[], int b[]) {
        int n = a.length, m = b.length;
        int min = Math.min(n, m);
        for (int i = 0; i < min; i++) {
            if (a[i] != b[i])
                return i;
        }
        return min;
    }

    //20->Word Break
    public boolean wordBreak(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && set.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    //21->Total Decoding Messages
    public int countWays(String digits) {
        int n = digits.length();
        if (n == 0 || digits.charAt(0) == '0')
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (digits.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            int twonum = Integer.valueOf(digits.substring(i - 2, i));
            if (twonum >= 10 && twonum <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    //22->Element with left side smaller and right side greater
    public int findElement(int[] arr) {
        int n = arr.length;
        int[] l = new int[n];
        int[] r = new int[n];

        l[0] = arr[0];
        for (int i = 1; i < n; i++)
            l[i] = Math.max(arr[i], l[i - 1]);

        r[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            r[i] = Math.min(arr[i], r[i + 1]);

        for (int i = 1; i < n - 1; i++) {
            if (l[i - 1] <= arr[i] && r[i + 1] >= arr[i])
                return arr[i];
        }
        return -1;
    }

    //23->Solve the Sudoku
    boolean f;

    public void solveSudoku(int[][] mat) {
        this.f = false;
        dfs(mat, 0, 0);
        return;
    }

    public void dfs(int[][] mat, int row, int col) {
        if (f)
            return;
        if (col == 9) {
            col = 0;
            row++;
        }
        if (row == 9) {
            this.f = true;
            return;
        }
        if (mat[row][col] != 0) {
            dfs(mat, row, col + 1);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (isvalid(mat, row, col, i)) {
                mat[row][col] = i;
                dfs(mat, row, col + 1);
                if (f)
                    return;
                mat[row][col] = 0;
            }
        }
    }

    public boolean isvalid(int[][] mat, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == val || mat[i][col] == val)
                return false;
        }
        int nrow = (row / 3) * 3;
        int ncol = (col / 3) * 3;
        for (int i = nrow; i < nrow + 3; i++) {
            for (int j = ncol; j < ncol + 3; j++) {
                if (mat[i][j] == val)
                    return false;
            }
        }
        return true;
    }

    //24->Check if frequencies can be equal
    public boolean sameFreq(String s) {
        int[] let = new int[26];
        for (char c : s.toCharArray())
            let[c - 'a']++;

        Set<Integer> baseset = new HashSet<>();
        for (int i : let) {
            if (i > 0)
                baseset.add(i);
        }
        if (baseset.size() == 1)
            return true;

        for (int i = 0; i < 26; i++) {
            if (let[i] == 0)
                continue;
            let[i]--;
            Set<Integer> set = new HashSet<>();
            for (int f : let) {
                if (f > 0)
                    set.add(f);
            }
            if (set.size() == 1)
                return true;
            let[i]++;
        }
        return false;
    }

    //25->Number of paths
    public int numberOfPaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
        return dp[m - 1][n - 1];
    }

    //26->Sum of two large numbers
    public String findSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        StringBuilder sb = new StringBuilder();
        int i = n - 1, j = m - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int num1 = (i >= 0) ? s1.charAt(i--) - '0' : 0;
            int num2 = (j >= 0) ? s2.charAt(j--) - '0' : 0;
            int sum = num1 + num2 + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        String ans = sb.toString();
        int k = 0;
        while (k < ans.length() - 1 && ans.charAt(k) == '0')
            k++;
        return ans.substring(k);
    }

    //27->Overlapping Intervals
    public List<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        mergeSort(arr, n);
        List<int[]> l = new ArrayList<>();
        int[] curr = arr[0];
        l.add(curr);
        for (int i = 1; i < n; i++) {
            int[] next = arr[i];
            if (curr[1] >= next[0])
                curr[1] = Math.max(curr[1], next[1]);
            else {
                curr = next;
                l.add(curr);
            }

        }
        return l;
    }

    public void mergeSort(int[][] arr, int n) {
        if (n > 1) {
            int m = n / 2;
            int[][] left = Arrays.copyOfRange(arr, 0, m);
            int[][] right = Arrays.copyOfRange(arr, m, n);
            int l = left.length, r = right.length;
            mergeSort(left, l);
            mergeSort(right, r);
            merge(arr, left, right, l, r);
        }
    }

    public void merge(int[][] arr, int[][] left, int[][] right, int l, int r) {
        int i = 0, j = 0, k = 0;
        while (i < l || j < r) {
            if (i < l && j < r)
                arr[k++] = (left[i][0] < right[j][0]) ? left[i++] : right[j++];
            else {
                if (i < l)
                    arr[k++] = left[i++];
                if (j < r)
                    arr[k++] = right[j++];
            }
        }
    }

    //28->Palindrome
    public boolean isPalindrome(int n) {
        int n1 = n;
        int res_val = 0;
        while (n > 0) {
            int dig = n % 10;
            res_val = (res_val * 10) + dig;
            n /= 10;
        }
        return res_val == n1;
    }

    //29->Find missing in second array
    public ArrayList<Integer> findMissing(int[] a, int[] b) {
        Arrays.sort(b);
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) {
            if (!binarySearch(b, i))
                l.add(i);
        }
        return l;
    }

    public boolean binarySearch(int[] arr, int target) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return false;
    }

    //30->Stock Buy and Sell – Max one Transaction Allowed
    public int maximumProfit(int prices[]) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i : prices) {
            if (i < buy)
                buy = i;
            else {
                int sell = i - buy;
                maxProfit = Math.max(sell, maxProfit);
            }
        }
        return maxProfit;
    }

    //31->Wildcard Pattern Matching
    public boolean wildCard(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        int i = 0, j = 0, starIdx = -1, iIdx = -1;
        while (i < n) {
            if (j < m && (txt.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < m && pat.charAt(j) == '*') {
                starIdx = j;
                j++;
                iIdx = i;
            } else if (starIdx != -1) {
                j = starIdx + 1;
                iIdx++;
                i = iIdx;
            } else
                return false;
        }
        while (j < m && pat.charAt(j) == '*')
            j++;
        return j == m;
    }

    //32->Find the string in grid
    int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public int[][] searchWord(char[][] grid, String word) {
        List<int[]> l = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    for (int d = 0; d < 8; d++) {
                        if (dfs(grid, word, n, m, dx[d], dy[d], i, j, 0)) {
                            l.add(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }
        return l.toArray(new int[0][]);
    }

    public boolean dfs(char[][] grid, String word, int n, int m, int xDir, int yDir, int i, int j, int idx) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != word.charAt(idx))
            return false;

        if (idx == word.length() - 1)
            return true;

        return dfs(grid, word, n, m, xDir, yDir, i + xDir, j + yDir, idx + 1);
    }

    //33->Leap Year
    public boolean isLeap(int N) {
        return (N % 4 == 0 && N % 100 != 0) || (N % 400 == 0);
    }

    //34->Remaining String
    public String printString(String s, char ch, int count) {
        int n = s.length();
        int idx = -1, c = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ch) {
                c++;
                if (c == count) {
                    idx = i;
                    break;
                }
            }
        }
        if (idx == -1 || idx == n - 1)
            return "";
        return s.substring(idx + 1);
    }

    //35->K-Pangrams
    public boolean kPangram(String str, int k) {
        int[] let = new int[26];
        int c = 0;
        for (char i : str.toCharArray()) {
            if (i != ' ') {
                let[i - 'a']++;
                c++;
            }
        }
        if (c < 26)
            return false;
        c = 0;
        for (int i : let) {
            if (i == 0)
                c++;
        }
        return c <= k;
    }

    //36->Run Length Encoding
    public String encode(String s) {
        int n = s.length();
        int dig = 1;
        char let = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == let)
                dig++;
            else {
                sb.append(let).append(dig);
                let = s.charAt(i);
                dig = 1;
            }
        }
        sb.append(let).append(dig);
        return sb.toString();
    }

    //37->Modify the Array
    public ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1] && arr[i] != 0) {
                arr[i - 1] = 2 * arr[i];
                arr[i] = 0;
            }
        }
        ArrayList<Integer> l = new ArrayList<>(n);
        for (int i : arr) {
            if (i != 0)
                l.add(i);
        }
        for (int i = l.size(); i < n; i++)
            l.add(0);
        return l;
    }

    //38->Check for subsequence
    public boolean isSubSequence(String A, String B) {
        int n = A.length(), m = B.length();
        int i = 0, j = 0;
        while (j < m) {
            if (i == n)
                return true;
            else if (A.charAt(i) == B.charAt(j))
                i++;
            j++;
        }
        return i == n;
    }

    //39->Rotate by 90 degree
    public void rotate(int mat[][]) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int t = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = t;
                l++;
                r--;
            }
        }
    }

    //40->Total count
    public int totalCount(int k, int[] arr) {
        int ans = 0;
        for (int i : arr) {
            int q = i / k;
            int r = (i % k == 0) ? 0 : 1;
            ans += q + r;
        }
        return ans;
    }

    //41->Snake and Ladder Problem
    public int minThrow(int N, int arr[]) {
        int[] board = new int[30];
        boolean[] vis = new boolean[30];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < 30; i++)
            board[i] = -1;
        for (int i = 0; i < 2 * N; i += 2) {
            int from = arr[i] - 1;
            int to = arr[i + 1] - 1;
            board[from] = to;
        }

        q.add(new Pair(0, 0));
        vis[0] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int cell = p.cell;
            int moves = p.moves;

            if (cell == 29)
                return moves;

            for (int d = 1; d <= 6; d++) {
                int next = cell + d;
                if (next < 30 && !vis[next]) {
                    int dest = (board[next] != -1) ? board[next] : next;
                    if (!vis[dest]) {
                        vis[dest] = true;
                        q.add(new Pair(dest, moves + 1));
                    }
                }
            }
        }
        return -1;
    }

    public class Pair {
        int cell;
        int moves;

        Pair(int c, int m) {
            this.cell = c;
            this.moves = m;
        }
    }

    //42->Remove character
    public String removeChars(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int[] let = new int[26];
        for (char i : str2.toCharArray())
            let[i - 'a']++;
        for (char i : str1.toCharArray()) {
            if (let[i - 'a'] == 0)
                sb.append(i);
        }
        return sb.toString();
    }

    //43->Reverse each word in a given string
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = str.length;
        for (int i = 0; i < n; i++) {
            sb.append(reverse(str[i].toCharArray()));
            if (i != n - 1)
                sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String reverse(char[] ch) {
        int i = 0, j = ch.length - 1;
        while (i < j) {
            char t = ch[i];
            ch[i++] = ch[j];
            ch[j--] = t;
        }
        return new String(ch);
    }

    //44->Unique rows in boolean matrix
    public ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < r; i++) {
            ArrayList<Integer> x = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                x.add(a[i][j]);
                sb.append(a[i][j]).append(",");
            }
            if (!set.contains(sb.toString())) {
                l.add(x);
                set.add(sb.toString());
            }
        }
        return l;
    }

    //45->Reversing the vowels
    public String modify(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        char[] ch = s.toCharArray();
        while (i <= j) {
            while (i < j && !isVowel(ch[i]))
                i++;
            while (i < j && !isVowel(ch[j]))
                j--;
            char t = ch[i];
            ch[i++] = ch[j];
            ch[j--] = t;
        }
        return new String(ch);
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    //46->Primes sum
    public String isSumOfTwo(int N) {
        for (int i = 2; i <= N / 2; i++) {
            if (isPrime(i) && isPrime(N - i))
                return "Yes";
        }
        return "No";
    }

    public boolean isPrime(int n)
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0 || n % 3 == 0)
            return false;
        for (int x = 5; x * x <= n; x += 6) {
            if (n % x == 0 || n % (x + 2) == 0)
                return false;
        }
        return true;
    }

    //47->Alternative Sorting
    public ArrayList<Integer> alternateSort(int[] arr) {
        ArrayList<Integer> l = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j) {
            l.add(arr[j--]);
            if (i <= j)
                l.add(arr[i++]);
        }
        return l;
    }

    //48->Look and Say Pattern
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        String prev = countAndSay(n - 1);
        //System.out.println(prev);
        int d = 1;
        char c = prev.charAt(0);
        for (int i = 1; i < prev.length(); i++) {
            if (c == prev.charAt(i))
                d++;
            else {
                sb.append(d);
                sb.append(c);
                c = prev.charAt(i);
                d = 1;
            }
        }
        sb.append(d);
        sb.append(c);
        return sb.toString();
    }

    //49->Sum Palindrome
    public int isSumPalindrome(int n) {
        if (ispali(n))
            return n;
        int t = 5;
        while (t-- > 0 && !ispali(n)) {
            n = n + reverse1(n);
            if (ispali(n))
                return n;
        }
        return ispali(n) ? n : -1;
    }

    public int reverse1(int n) {
        int val = 0;
        while (n > 0) {
            int dig = n % 10;
            val = (val * 10) + dig;
            n /= 10;
        }
        return val;
    }

    public boolean ispali(int n) {
        return n == reverse1(n);
    }

    //50->Check for Power
    public boolean isPowerOfAnother(int X, int Y) {
        if (X == 1)
            return Y == 1;
        if (Y == 1 || X == Y)
            return true;
        while (X < Y) {
            X *= X;
            if (Y == X)
                return true;
        }
        return false;
    }

    //51->Sort in specific order
    public void sortIt(Long arr[]) {
        int n = arr.length;
        Long[] even = new Long[n];
        Long[] odd = new Long[n];
        int oi = 0, ei = 0;
        for (Long i : arr) {
            if ((i & 1) == 1)
                odd[oi++] = i;
            else
                even[ei++] = i;
        }
        mergeSort(even, ei, true);
        mergeSort(odd, oi, false);
        for (int i = 0; i < oi; i++)
            arr[i] = odd[i];
        for (int i = 0; i < ei; i++)
            arr[i + oi] = even[i];
    }

    public void mergeSort(Long[] arr, int n, boolean isacc)
    {
        if (n > 1) {
            int m = n / 2;
            Long[] left = Arrays.copyOfRange(arr, 0, m);
            Long[] right = Arrays.copyOfRange(arr, m, n);
            int l = left.length, r = right.length;
            mergeSort(left, l, isacc);
            mergeSort(right, r, isacc);
            merge(arr, left, right, l, r, isacc);
        }
    }

    public void merge(Long[] arr, Long[] left, Long[] right, int l, int r, boolean isacc) {
        int i = 0, j = 0, k = 0;
        if (isacc) {
            while (i < l || j < r) {
                if (i < l && j < r)
                    arr[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
                else {
                    if (i < l)
                        arr[k++] = left[i++];
                    if (j < r)
                        arr[k++] = right[j++];
                }
            }
        } else {
            while (i < l || j < r) {
                if (i < l && j < r)
                    arr[k++] = (left[i] < right[j]) ? right[j++] : left[i++];
                else {
                    if (i < l)
                        arr[k++] = left[i++];
                    if (j < r)
                        arr[k++] = right[j++];
                }
            }
        }
    }

    //52->Longest Palindromic Substring
    public String longestPalindrome1(String s) {
        String sb = "" + s.charAt(0);
        int n = s.length();
        int st = 0, en = 0;
        for (int i = 0; i < n; i++) {
            int len1 = idx(s, i, i);
            int len2 = idx(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > en - st && sb.length() < len) {
                st = i - (len - 1) / 2;
                en = i + len / 2;
                sb = s.substring(st, en + 1);
            }
        }
        return sb;
    }

    public int idx1(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    //53->Count the characters
    public int getCount(String S, int N) {
        int n = S.length();
        long[] let = new long[26];
        char ch = S.charAt(0);
        let[ch - 'a']++;
        for (int i = 1; i < n; i++) {
            if (ch != S.charAt(i)) {
                let[S.charAt(i) - 'a']++;
                ch = S.charAt(i);
            }
        }
        int c = 0;
        for (long i : let) {
            if (i == N)
                c++;
        }
        return c;
    }

    //54->Sum of elements in a matrix
    public int sumOfMatrix(int N, int M, int[][] Grid) {
        int s = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                s += Grid[i][j];
        }
        return s;
    }

    //55->Return two prime numbers
    public List<Integer> primeDivision(int n) {
        List<Integer> l = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                l.add(i);
                l.add(n - i);
                return l;
            }
        }
        return l;
    }

    //56->Sum of two numbers represented as arrays
    public ArrayList<Integer> findSum(int arr1[], int arr2[])
    {
        int n = arr1.length, m = arr2.length;
        int i = n - 1, j = m - 1, carry = 0;
        ArrayList<Integer> l = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry > 0) {
            int val1 = (i >= 0) ? arr1[i--] : 0;
            int val2 = (j >= 0) ? arr2[j--] : 0;
            int sum = (val1 + val2 + carry);
            l.add(0, sum % 10);
            carry = sum / 10;
        }
        return l;
    }

    //57->Smallest greater elements in whole array
    public int[] greaterElement(int arr[], int n)
    {
        int[] b = arr.clone();
        int[] ans = new int[n];
        Arrays.sort(b);

        for (int i = 0; i < n; i++)
            ans[i] = bst(b, n, arr[i]);
        return ans;
    }

    public int bst(int[] arr, int n, int k)
    {
        int i = 0, j = n - 1, res = -10000000;
        while (i <= j) {
            int m = (i + j) / 2;
            if (arr[m] > k) {
                res = arr[m];
                j = m - 1;
            } else
                i = m + 1;
        }
        return res;
    }

    //58->Sum of primes
    public int primeSum(int n) {
        int sum = 0;
        while (n > 0) {
            int dig = n % 10;
            if (isPrime(dig))
                sum += dig;
            n /= 10;
        }
        return sum;
    }

    //59->3 Sum Closest
    public int closest3Sum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int closeSum = arr[0] + arr[1] + arr[2];
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target)
                    return sum;

                if (Math.abs(sum - target) == Math.abs(closeSum - target))
                    closeSum = Math.max(closeSum, sum);
                else if (Math.abs(sum - target) < Math.abs(closeSum - target))
                    closeSum = sum;

                if (sum < target)
                    l++;
                else
                    r--;
            }
        }
        return closeSum;
    }

    //60->Special array reversal
    public String reverse(String str) {
        char[] ch = str.toCharArray();
        int n = ch.length;
        int i = 0, j = n - 1;
        while (i <= j) {
            while (i < n && !isValid(ch[i]))
                i++;
            while (j >= 0 && !isValid(ch[j]))
                j--;
            if (i <= j) {
                char t = ch[i];
                ch[i++] = ch[j];
                ch[j--] = t;
            }
        }
        return new String(ch);
    }

    public boolean isValid(char c) {
        if (c >= 'a' && c <= 'z')
            return true;

        if (c >= 'A' && c <= 'Z')
            return true;

        if (c >= '0' && c <= '9')
            return true;

        return false;
    }

    //61->Distance between 2 points
    public int distance(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy));
    }

    //62->Is Square
    public String isSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        Set<Integer> set = new HashSet<>();
        set.add(isform(x1, y1, x2, y2));
        set.add(isform(x1, y1, x3, y3));
        set.add(isform(x1, y1, x4, y4));
        set.add(isform(x3, y3, x2, y2));
        set.add(isform(x4, y4, x2, y2));
        set.add(isform(x3, y3, x4, y4));
        return (!set.contains(0) && set.size() == 2) ? "Yes" : "No";
    }

    public int isform(int a, int b, int c, int d) {
        return ((a - c) * (a - c) + (b - d) * (b - d));
    }

    //63->Middle Pattern
    public void printPattern(String s) {
        int n = s.length();
        int m = n / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int idx = (m + i) % n;
            sb.append(s.charAt(idx));
            System.out.print(sb + "$ ");
        }
    }

    //64->Final Destination
    public int canReach(Long a, Long b, Long x) {
        Long min = Math.abs(a) + Math.abs(b);
        if (min <= x && (x - min) % 2 == 0)
            return 1;
        return 0;
    }

    //65->
    int s=0;
    public int[] common_digits(int[] nums)
    {
        boolean[]vis=new boolean[10];
        for(int i:nums)
            add(i,vis);
        int[]arr=new int[s];
        int idx=0;
        for(int i=0;i<10;i++)
        {
            if(vis[i])
                arr[idx++]=i;
        }
        return arr;
    }
    public void add(int n,boolean[] vis)
    {
        while(n > 0)
        {
            int d=n%10;
            if(!vis[d])
            {
                this.s++;
                vis[d]=true;
            }
            n/=10;

        }
    }

    //66->Twisted Prime Number
    public int isTwistedPrime(int N)
    {
        if(isPrime(N) && isPrime(reverse1(N)))
            return 1;
        return 0;
    }

    //67->Word Break (Trie)
    public int wordBreak(String A, ArrayList<String> B)
    {
        Set<String>set=new HashSet<>(B);
        int n=A.length();
        int[]dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                String word=A.substring(j,i);
                if(dp[j] == 1 && set.contains(word))
                {
                    dp[i]=1;
                    break;
                }
            }
        }
        return dp[n];
    }

    //68->Reverse a string with spaces intact
    public String reverseWithSpacesIntact(String S)
    {
        int n=S.length();
        char[]ch=S.toCharArray();
        int i=0,j=n-1;
        while(i<=j)
        {
            while(i<n && S.charAt(i) == ' ')
                i++;
            while(j>0 && S.charAt(j) == ' ')
                j--;
            if(i<=j)
            {
                char t=ch[i];
                ch[i++]=ch[j];
                ch[j--]=t;
            }
        }
        return new String(ch);
    }

    //69->Maximum number of characters between any two same character
    public int maxChars(String s)
    {
        int n=s.length();
        int[]fa=new int[26];
        int[]la=new int[26];
        int[]fA=new int[26];
        int[]lA=new int[26];
        for(int i=0;i<26;i++)
        {
            fa[i]=-1;
            fA[i]=-1;
        }
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) >= 'a' && s.charAt(i) <='z')
            {
                int d=s.charAt(i) - 'a';
                if(fa[d] == -1)
                    fa[d]=i;
                la[d]=i;
            }
            else
            {
                int d=s.charAt(i) - 'A';
                if(fA[d] == -1)
                    fA[d]=i;
                lA[d]=i;
            }

        }
        int max=-1;
        for(int i=0;i<26;i++)
        {
            if(fa[i]!=-1 && la[i] != fa[i])
                max=Math.max(max,la[i] - fa[i] - 1);
            if(fA[i] != -1 && lA[i] != fA[i])
                max=Math.max(max,lA[i] - fA[i] - 1);
        }
        return max;
    }

    //70->
    public long getNextEven(String x)
    {
        char[]ch=x.toCharArray();
        int n=ch.length;

        while(nextnum(ch,n))
        {
            if((ch[n-1] - '0')%2 == 0)
            {
                String num=new String(ch);
                if(isValid1(num))
                    return Long.valueOf(num);
                return -1;
            }
        }
        return -1;
    }
    public boolean isValid1(String s)
    {
        String num=String.valueOf(Long.MAX_VALUE);
        if(num.length() > s.length())
            return true;
        if(num.length() < s.length())
            return false;
        return s.compareTo(num) <= 0;
    }
    public boolean nextnum(char []ch,int n)
    {
        int i=n-2;
        while(i>=0 && ch[i] >= ch[i+1])
            i--;
        if(i==-1)
            return false;

        int j=n-1;
        while(ch[j] <= ch[i])
            j--;
        //swap(ch,i,j);
        rev(ch,i+1,n-1);
        return true;
    }
//    public void swap(char[]ch,int i,int j)
//    {
//        char t=ch[i];
//        ch[i]=ch[j];
//        ch[j]=t;
//    }
    public void rev(char[]ch,int st,int en)
    {
        while(st<en)
        {
            swap(ch,st,en);
            st++;
            en--;
        }
    }

    //71->Cross character
    public String crossPattern(String s)
    {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j || i+j==n-1)
                {
                    // System.out.print(s.charAt(j))
                    sb.append(s.charAt(j));
                }
                else
                {
                    // System.out.print(" ");
                    sb.append(" ");
                }
            }
            // System.out.println();
        }
        return sb.toString();
    }

    //72->Find number of days between two given dates
    public int noOfDays(int d1, int m1, int y1, int d2, int m2, int y2)
    {
        m1=(m1+9)%12;
        m2=(m2+9)%12;
        y1=y1-m1/10;
        y2=y2-m2/10;
        return Math.abs(days(y1,m1,d1) - days(y2,m2,d2));
    }
    public int days(int year,int month,int day)
    {
        return year*365 + year/4 - year/100 + year/400 + (month*306+5)/10 + (day - 1);
    }

    //73->Let's Play!!!
    public int isSuperSimilar(int n, int m, int mat[][], int x)
    {
        int[][]rot=new int[n][m];
        for(int i=0;i<n;i++)
        {
            rot[i]=mat[i].clone();
            int k=x%m;
            if(i%2 == 0)
                leftrot(rot[i],k);
            else
                rigrot(rot[i],k);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]!=rot[i][j])
                    return 0;
            }
        }
        return 1;
    }
    public void revs(int[]arr,int i,int j)
    {
        while(i<j)
        {
            int t=arr[i];
            arr[i++]=arr[j];
            arr[j--]=t;
        }
    }
    public void leftrot(int[]arr,int k)
    {
        int n=arr.length;
        revs(arr,0,k-1);
        revs(arr,k,n-1);
        revs(arr,0,n-1);
    }
    public void rigrot(int[]arr,int k)
    {
        int n=arr.length;
        revs(arr,0,n-1);
        revs(arr,0,k-1);
        revs(arr,k,n-1);
    }
}