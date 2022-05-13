package com.sort.algorithm;

import com.sort.algorithm.contract.Sort;
import com.sort.algorithm.contract.Swap;

import java.util.List;

public class Selection implements Sort, Swap {
    @Override
    public <T extends Double> List<T> sort(List<T> list) {
        for(int i = 0; i < list.size(); i++) {
            Integer smallerElementIndex = i;
            for(int j = i; j < list.size(); j++){
                if(list.get(j).doubleValue() < list.get(smallerElementIndex).doubleValue()){
                    smallerElementIndex = j;
                }
            }
            this.swap(list, i, smallerElementIndex);
        }

        return list;
    }

    @Override
    public <E extends Double> List<E> swap(List<E> list, Integer i, Integer j){

        E aux = list.get(i);
        list.set(i, list.get(j));
        list.set(j, aux);

        return list;
    }
}
