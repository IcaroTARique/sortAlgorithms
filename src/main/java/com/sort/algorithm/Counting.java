package com.sort.algorithm;

import com.sort.algorithm.contract.SortCount;
import com.sort.utils.CountingConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Counting extends CountingConverter implements SortCount {

    CountingConverter toListInteger = new CountingConverter();

    @Override
    public <T extends Number & Comparable> List<?> sort(List<T> list) {


        List<Integer> valuesToSort = toListInteger.convertToInteger(list);
        List<Integer> positions;
        List<Integer> response = new ArrayList<>(Collections.nCopies(list.size(), 0));

        Integer max = Collections.max(valuesToSort);
        Integer min = Collections.min(valuesToSort);

        positions = new ArrayList<>(Collections.nCopies(max - min + 1, 0));

        for(int i = 0; i < valuesToSort.size(); i++) {
            positions.set(valuesToSort.get(i), positions.get(valuesToSort.get(i)) + 1);
        }

        for(int i = 1; i < positions.size(); i++) {
            positions.set(i, positions.get(i) + positions.get(i-1));
        }

        for( int i = 0; i < list.size(); i++) {
            response.set(positions.get(valuesToSort.get(i))-1,valuesToSort.get(i));
            positions.set(valuesToSort.get(i), positions.get(valuesToSort.get(i))-1);
        }

        return toListInteger.returnToOriginal(response);
    }
}
