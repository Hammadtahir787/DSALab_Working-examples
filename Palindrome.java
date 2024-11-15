public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
      
        System.out.println(isPalindrome("Madam"));
        System.out.println(isPalindrome("Racecar"));
        System.out.println(isPalindrome("A man, a plan, a canal, Panama")); 
    }
}
