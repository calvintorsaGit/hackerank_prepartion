package com.prep.strings;

/**
 * HackerRank: Strong Password
 * https://www.hackerrank.com/challenges/strong-password
 * Difficulty: Easy
 *
 * A strong password has: length >= 6, at least 1 digit, 1 lowercase,
 * 1 uppercase, and 1 special character (!@#$%^&*()-+).
 * Return minimum characters to add.
 *
 * Time: O(n)
 * Space: O(1)
 */
public class StrongPassword {

    public static int minimumNumber(int n, String password) {
        String specials = "!@#$%^&*()-+";
        int needDigit = 1, needLower = 1, needUpper = 1, needSpecial = 1;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c))
                needDigit = 0;
            else if (Character.isLowerCase(c))
                needLower = 0;
            else if (Character.isUpperCase(c))
                needUpper = 0;
            else if (specials.indexOf(c) >= 0)
                needSpecial = 0;
        }

        int missing = needDigit + needLower + needUpper + needSpecial;
        return Math.max(missing, 6 - n);
    }
}
