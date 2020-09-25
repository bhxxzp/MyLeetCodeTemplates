package template;

// Rabin Karp
// Leetcode 28
public class strString {

    private static int BASE = 1000000;

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        
        int m = needle.length();
        if (m == 0) {
            return 0;
        }

        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }

        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + needle.charAt(i)) % BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < haystack.length(); i++) {
            hashCode = (hashCode * 31 + haystack.charAt(i)) % BASE;
            
            // 因为是先计算，所以 m - 1的时候已经计算了m次
            if (i < m - 1) {
                continue;
            }

            if (i >= m) {
                hashCode = hashCode - (haystack.charAt(i - m) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }

            if (hashCode == targetCode) {
                if (haystack.substring(i - m + 1, i + 1).equals(needle)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
		String a = "ba";
		String b = "a";
		System.out.println(strStr(a, b));
	}
}

