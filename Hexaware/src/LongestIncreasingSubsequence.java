import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int a[]={4,6,2,8};
        System.out.println(find(a));
        System.out.println(dpsol(a));
     //   System.out.println(binarysearch(a));
    }
    private static int find(int []a){
        return longest(0,-1,a);
    }
    private static int longest(int ind,int prev,int []a){
        if(ind==a.length){
            return 0;
        }
        //nottake
        int len= longest(ind + 1, prev, a);
        //take
        if(prev==-1||a[ind]>a[prev]){
            len=Math.max(len,1+longest(ind+1,ind,a));
        }
        return len;
    }
    private static int dpsol(int []a){
        int dp[][]= new int[a.length][a.length+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return longest2(0,-1,a,dp);
    }
    private static int longest2(int ind,int prev,int []a,int[][]dp){
        if(ind==a.length){
            return 0;
        }
        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        //nottake
        int nottake= longest2(ind + 1, prev, a,dp);
        //take
        int take=0;
        if(prev==-1||a[ind]>a[prev]){
            take=1+longest2(ind+1,ind,a,dp);
        }
        dp[ind][prev+1]=Math.max(take,nottake);
        return dp[ind][prev+1];
    }
}
