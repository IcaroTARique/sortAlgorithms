package com.sort.algorithm;

import com.sort.algorithm.contract.Sort;
import com.sort.algorithm.contract.Swap;

import java.util.List;

public class Selection implements Sort, Swap {
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        for(int i = 0; i < list.size(); i++) {
            int smallerElementIndex = i;
            for(int j = i; j < list.size(); j++){
                if(list.get(j).compareTo(list.get(smallerElementIndex)) < 0){
                    smallerElementIndex = j;
                }
            }
            this.swap(list, i, smallerElementIndex);
        }

        return list;
    }

}
