import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Your task is to sort a given string. Each word in the String will contain a
 * single number. This number is the position the word should have in the result.
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * <p>
 * If the input String is empty, return an empty String. The words in the input
 * String will only contain valid consecutive numbers.
 * <p>
 * For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est"
 */
public class OrderTest {
    @Test
    public void test1() {
        assertThat(Order.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Test
    public void test2() {
        assertThat(Order.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Test
    public void test3() {
        assertThat("Empty input should return empty string", Order.order(""), equalTo(""));
    }
    @Test
    public void testLambda1() {
        assertThat(Order.orderLambda("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Test
    public void testLambda2() {
        assertThat(Order.orderLambda("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Test
    public void testLambda3() {
        assertThat("Empty input should return empty string", Order.orderLambda(""), equalTo(""));
    }
}