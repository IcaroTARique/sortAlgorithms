package com.sort.algorithm;

import com.sort.algorithm.contract.SortCount;
import com.sort.utils.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Counting extends Converter implements SortCount {

    Converter toListInteger = new Converter();

    @Override
    public <T extends Number & Comparable<T>> List<?> sort(List<T> list) {

        List<Integer> valuesToSort = toListInteger.convertToInteger(list);
        List<Integer> positions;
        List<Integer> response = new ArrayList<>(Collections.nCopies(list.size(), 0));

        Integer max = Collections.max(valuesToSort);
        Integer min = Collections.min(valuesToSort);

        positions = new ArrayList<>(Collections.nCopies(max - min + 1, 0));

        for (Integer integer : valuesToSort) {
            positions.set(integer, positions.get(integer) + 1);
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

    public List<Integer> countingSortForRadix(List<Integer> valuesToSort, Integer n, Integer k){

        List<Integer> positions = new ArrayList<>(Collections.nCopies(10, 0));
        List<Integer> response = new ArrayList<>(Collections.nCopies(n, 0));

        for(int i = 0; i < n; i++) {
            positions.set((valuesToSort.get(i)/k % 10), positions.get((valuesToSort.get(i)/k % 10)) + 1);
        }

        for(int i = 1; i < positions.size(); i++) {
            positions.set(i, positions.get(i) + positions.get(i-1));
        }

        /**
         * The inverted sequence, in the next for, is made that way because when we try to access an element of list to
         * be sorted (valuesToSort) in which exists another element of the same value, this access made through the position
         * list, assures that we are going to work with the first (and consequently smaller) element in the array to be sorted.
         */
        for(int i = response.size()-1; i >= 0; i--) {
            response.set(positions.get((valuesToSort.get(i)/k % 10))-1,valuesToSort.get(i));
            positions.set((valuesToSort.get(i)/k % 10), positions.get((valuesToSort.get(i)/k % 10))-1);
        }

        return response;
    }
}
