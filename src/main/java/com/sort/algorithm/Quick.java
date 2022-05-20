package com.sort.algorithm;

import com.sort.algorithm.contract.Sort;
import com.sort.algorithm.contract.Swap;

import java.util.List;

public class Quick implements Sort, Swap {
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) {

        if(list.size() <= 1){
            return list;
        }

        Integer pivot = Partition(list);
        this.sort(list.subList(0, pivot));
        this.sort(list.subList(pivot, list.size()));

        return list;
    }

    public <T extends Comparable<T>> Integer Partition(List<T> list){

        int pivot = list.size()-1;
        int i = 0;
        int j;

        for(j = 0; j < list.size()-1; j++){
            if(list.get(j).compareTo(list.get(pivot)) <= 0 ) {
                swap(list, i, j);
                i++;
            }
        }
        swap(list,i, pivot);

        return i;
    }
}

