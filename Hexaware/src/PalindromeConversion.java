public class PalindromeConversion {
    public static void main(String[] args) {
        int n=100;
        System.out.println(find(n));
    }
    public static boolean ispali(int n){
        String s = Integer.toString(n);
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private static int find(int n) {
        if (ispali(n + rev(n))) {
            return n + rev(n);
        }
        return find(n + rev(n));
    }

    private static int rev(int n){
        int rev=0;
        while(n>0){
            rev=(rev*10)+n%10;
            n/=10;
        }
        return rev;
    }
}
