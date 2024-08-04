package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> right = new AListNoResizing<>();
        BuggyAList<Integer> wrong = new BuggyAList<>();

        right.addLast(4);
        right.addLast(5);
        right.addLast(6);
        wrong.addLast(4);
        wrong.addLast(5);
        wrong.addLast(6);

        assertEquals(right.removeLast(), wrong.removeLast());
        assertEquals(right.removeLast(), wrong.removeLast());
        assertEquals(right.removeLast(), wrong.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = correct.size();
                int size2 = broken.size();
                System.out.println("size in AListNoResizing: " + size1);
                System.out.println("size in BuggyAList: " + size2);
            } else if (operationNumber == 2) {
                // getLast
                if (correct.size() > 0) {
                    int lastVal1 = correct.getLast();
                    System.out.println("last element in AListNoResizing: " + lastVal1);
                }
                if (broken.size() > 0) {
                    int lastVal2 = broken.getLast();
                    System.out.println("last element in BuggyAList: " + lastVal2);
                }
            } else if (operationNumber == 3) {
                //removeLast
                if (correct.size() > 0) {
                    int removeVal1 = correct.removeLast();
                    System.out.println("removeLast in AListNoResizing: " + removeVal1);
                }
                if (broken.size() > 0) {
                    int removeVal2 = broken.removeLast();
                    System.out.println("removeLast in BuggyAList: " + removeVal2);
                }
            }
        }
    }
}