package org.gks.problems.string;

/*
 * Input : ghiabcdefhelloadamhelloabcdefghi Output : 7
 * (ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)
 *
 * Input : merchant Output : 1 (merchant)
 *
 * Input : antaprezatepzapreanta Output : 11 (a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)
 *
 * Input : geeksforgeeks Output : 3 (geeks)(for)(geeks)
 *
 */
// https://www.geeksforgeeks.org/longest-possible-chunked-palindrome/
public class LongestChunkedPalindrom {

  private static int LPC(String curr, int count, int len, String original) {
    if (curr == null || curr.isEmpty()) {
      return 0;
    }

    //
    // if a single letter is left out
    if (curr.length() <= 1) {
      if (count != 0 && original.length() - len <= 1)
        return count + 1;
      else
        return 1;
    }


    // for each length of substring chunk in string
    int n = curr.length();
    for (int i = 0; i < n / 2; i++) {
      // if left side chunk and right side chunk
      // are same
      if (curr.substring(0, i + 1).equals(curr.substring(n - 1 - i, n))) {
        // Call LCP for the part between the
        // chunks and add 2 to the result.
        // Length of string evaluated till
        // now is increased by (i+1)*2
        return LPC(curr.substring(i + 1, n - 1 - i), count + 2, len + (i + 1) * 2, original);
      }
    }

    return count + 1;
  }

  public static int LPC(String str) {
    return LPC(str, 0, 0, str);
  }

  public static void main(String[] args) {
    System.out.println("V : " + LPC("V"));
    System.out.println("VOLVO : " + LPC("VOLVO"));
    System.out.println("VOLVOV : " + LPC("VOLVOV"));
    System.out
        .println("ghiabcdefhelloadamhelloabcdefghi : " + LPC("ghiabcdefhelloadamhelloabcdefghi"));

    System.out
        .println("ghiabcdefhelloadamhelloabcdefghik : " + LPC("ghiabcdefhelloadamhelloabcdefghik"));

    System.out.println("antaprezatepzapreanta : " + LPC("antaprezatepzapreanta"));
  }
}

