import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class newSortingTester {
    /* This test is testing the basic functionality of the newSorting method. Given a very basic array with a fairly common
    size input does the method sort the array correctly. The test passed so the method works in very basic inputs
     */
    @Test
    public void newSortingTest1() {
        NewSorting ns = new NewSorting();
        int[] A = {4, 3, 6, 2, 7, 1, 5};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        ns.newSorting(A, 4);
        assertArrayEquals(expected,A);
    }

    /* This test is error checking. In the case that size is zero the code will never cut up the array enough to create zero
    arrays and then do a quite sort on an empty array. Therefore if the size is zero are anything less the code should still
    sort but just do merge sort. The test passed.
     */
    @Test
    public void newSortingTest2() {
        NewSorting ns = new NewSorting();
        int[] A = {4, 3, 6, 2, 7, 1, 5};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        ns.newSorting(A, 0);
        assertArrayEquals(expected,A);
    }

    /* This test is similar to the one above in that it is error checking. The code will not split up the array enough to
        get a negative size (this is impossible). Again the code should just do mergeSort. The test passed.
    */
    @Test
    public void newSortingTest3() {
        NewSorting ns = new NewSorting();
        int[] A = {4, 3, 6, 2, 7, 1, 5};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        ns.newSorting(A, -1);
        assertArrayEquals(expected,A);
    }
    /* This test is an edge case in that we are testing to see what happens when the user puts size equal to the size of
        the array. The code should still sort but this time just do quickSort. The test passed.
    */
    @Test
    public void newSortingTest4() {
        NewSorting ns = new NewSorting();
        int[] A = {4, 3, 6, 2, 7, 1, 5};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        ns.newSorting(A, 7);
        assertArrayEquals(expected,A);
    }
    /* This test is testing whether the method can handle duplicates and negatives. It test both positive and negative
        duplicates. The test passed.
    */
    @Test
    public void newSortingTest5() {
        NewSorting ns = new NewSorting();
        int[] A = {4, 4, 6, -2, 7, 1, 5, -6, -6};
        int[] expected = {-6, -6, -2, 1, 4, 4, 5, 6, 7};
        ns.newSorting(A, 4);
        assertArrayEquals(expected,A);
    }
}
