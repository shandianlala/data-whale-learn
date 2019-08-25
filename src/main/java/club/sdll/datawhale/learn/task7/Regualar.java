package club.sdll.datawhale.learn.task7;

/**
 * @author shandianlala@gmail.com
 * @description TODO
 * @since 2019-08-25 20:38
 */
public class Regualar {

    /**
     *
     * @param s string
     * @param p pattern
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        // second char is '*'
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p);
            }
            return false;
        } else {
            // second char is not '*'
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }

    }
}