package test.club.sdll.datawhale.learn.task4; 

import club.sdll.datawhale.learn.task4.TwoSum;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* TwoSum Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2019</pre> 
* @version 1.0 
*/ 
public class TwoSumTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
*
* Method: twoSum(int[] nums, int target) 
* 
*/ 
@Test
public void testTwoSum() throws Exception {
    TwoSum twoSum = new TwoSum();
    int[] nums = {2, 7, 12, 15};
    int target = 9;
    int[] result = twoSum.twoSum(nums, target);
    System.out.println(result[0] + " " + result[1]);

} 


} 
