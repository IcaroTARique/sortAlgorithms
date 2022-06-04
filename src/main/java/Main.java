import com.sort.Service;
import com.sort.algorithm.*;
import com.sort.algorithm.contract.SortCompare;
import com.sort.algorithm.contract.SortCount;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {

        List<Integer> toSortIntegerList = new ArrayList<>(List.of(10, 6, 4, 17, 5, 12, -15, 0, 8, 6, 0, 15, 80, 69, 32, 44, 93, 5, -65, -33));
        List<Double> toSortDoubleList = new ArrayList<>(List.of(10.0, 6.0, 4.0, 17.0, 5.0, 12.0, -15.0, 0.0));
        List<Double> toSortDoubleDecimalList = new ArrayList<>(List.of(14.4, 6.789, 4.9, 4.91,  17.15, 5.667, 12.564, -15.001, 0.3));
        List<String> toSortStringList = new ArrayList<>(List.of("Isaias", "Fernão", "Isabela","Alef", "Alan"));

        List<SortCompare> sortCompareList = new ArrayList<>(List.of(
                new Insertion(),
                new Selection(),
                new Merge(),
                new Quick()
        ));

        List<SortCount> sortCountList = new ArrayList<>(List.of(
                new Counting(),
                new Radix(),
                new Bucket()
        ));

        sortCompareList.forEach(e -> new Service(e).toSortCompare(new ArrayList<>(toSortDoubleDecimalList)));
        sortCountList.forEach(e -> new Service(e).toSortCount(new ArrayList<>(toSortDoubleDecimalList)));
    }
}
