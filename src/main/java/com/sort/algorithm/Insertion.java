package com.sort.algorithm;

import com.sort.algorithm.contract.Sort;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Insertion implements Sort {

    @Override
    public <T extends Double> List<T> sort(List<T> list) {

        for(int i = 1; i < list.size(); i++){
            T unsortedElement = list.get(i);
            Integer smallerElementPosition = i;
            for(int j = i; j >= 0; j--) {
                if(unsortedElement.doubleValue() < list.get(j).doubleValue()){
                    smallerElementPosition = j;
                }
            }
            list.remove(i);
            list.add(smallerElementPosition,unsortedElement);
        }
        return list;
    }
}
