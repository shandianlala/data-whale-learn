package club.sdll.datawhale.learn.task2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesesTest {

    @Test
    public void isValid() {
        ValidParentheses validParentheses = new ValidParentheses();
        String input = "()[]{}";
        Assert.assertTrue("验证失败！", true == validParentheses.isValid(input));

        String input2 = "(]";
        Assert.assertTrue("验证失败！", false == validParentheses.isValid(input2));

        String input3 = "([)]";
        Assert.assertTrue("验证失败！", false == validParentheses.isValid(input3));

        String input4 = "{[]}";
        Assert.assertTrue("验证失败！", true == validParentheses.isValid(input4));

    }
}