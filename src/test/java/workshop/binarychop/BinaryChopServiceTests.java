package workshop.binarychop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryChopServiceTests {

    BinaryChopService bcs = new BinaryChopService();

    @Test
    public void findIndexWithCustomBuiltMethod_ShouldReturnIndexOfGivenNumber(){
        bcs.setNumber("9");
        bcs.setValues(List.of("1", "2", "3", "5", "7", "9"));
        assertEquals(5, bcs.findIndexWithCustomBuiltMethod());
    }

    @Test
    public void findIndexWithCustomBuiltMethod_ShouldNegOneWhenNumberNotContainedInList(){
        bcs.setNumber("21");
        bcs.setValues(List.of("1", "2", "3", "5", "7", "9"));
        assertEquals(-1, bcs.findIndexWithCustomBuiltMethod());
    }

    @Test
    public void findIndexWithCustomBuiltMethod_ShouldReturnIndexWhenListIsOdd(){
        bcs.setNumber("2");
        bcs.setValues(List.of("1", "2", "3", "5", "7", "9", "11"));
        assertEquals(1, bcs.findIndexWithCustomBuiltMethod());
    }
}
