package com.sort.algorithm;

import com.sort.algorithm.contract.SortCount;
import com.sort.utils.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Radix implements SortCount {

    Converter converter = new Converter();
    Counting counting = new Counting();

    @Override
    public <T extends Number & Comparable<T>> List<?> sort(List<T> list) {

        List<Integer> integerList = this.converter.convertToInteger(list);
        List<Integer> response = new ArrayList<>();
        Integer maxElement = Collections.max(integerList);


        for(int exp = 1; maxElement/exp > 0; exp *= 10) {
            System.out.println("I > "+integerList);
            integerList = counting.countingSortForRadix(integerList, integerList.size() ,exp);
        }
        response = integerList;
        return converter.returnToOriginal(response);
    }
}
