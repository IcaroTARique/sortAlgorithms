import com.sort.algorithm.Insertion;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionTest extends Insertion {

    @Test
    public void testAssertList() {

        List<Double> expectedList = new ArrayList<>(Arrays.asList(-15.0, 0.0, 4.0, 5.0, 6.0, 10.0, 12.0, 17.0));

        List<Double> resultList = super.sort(new ArrayList<>(Arrays.asList(10.0, 6.0, 4.0, 17.0, 5.0, 12.0, -15.0, 0.0)));


        Assert.assertEquals(expectedList, resultList);
    }

}
