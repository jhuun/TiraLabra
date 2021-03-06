package util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juri Kuronen
 */
public class SetElementTest {

    @Test
    public void joiningTwoSetElements() {
        SetElement se1 = new SetElement(1);
        SetElement se2 = new SetElement(2);
        se1.joinTwoSets(se2);
        assertEquals(se1, se2.getRoot());
        assertEquals(1, se2.getId());
        assertEquals(2, se2.getNumOfElements());
    }

    @Test
    public void joiningMultipleSetElements() {
        SetElement[] elements = new SetElement[20];
        for (int i = 0; i < 20; i++) {
            elements[i] = new SetElement(i);
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 5; i++) {
                elements[j * 5].joinTwoSets(elements[j * 5 + i]);
            }
            assertEquals(elements[j * 5], elements[j * 5 + 4].getRoot());
            assertEquals(j * 5, elements[j * 5 + 4].getId());
            assertEquals(5, elements[j * 5 + 4].getNumOfElements());
        }
        elements[0].joinTwoSets(elements[5]);
        assertEquals(10, elements[5].getNumOfElements());
        elements[10].joinTwoSets(elements[15]);
        elements[5].joinTwoSets(elements[10]);
        assertEquals(20, elements[10].getNumOfElements());
        assertEquals(0, elements[10].getId());
    }

}
