package com.sort.algorithm;

import com.sort.algorithm.contract.Sort;
import com.sort.algorithm.contract.Swap;

import java.util.ArrayList;
import java.util.List;

public class Merge implements Sort {

    @Override
    public <T extends Double> List<T> sort(List<T> list) {
        System.out.println(list);
        if(list.size() < 2) {
            return list;
        }
        List<T> leftList = this.sort(list.subList(0, (list.size()) / 2));
        List<T> rightList = this.sort(list.subList(list.size()/2, list.size()));

        List<T> mergeList = this.merge(leftList, rightList);

        return mergeList;
    }

    private <T extends Double> List<T> merge(List<T> leftList, List<T> rightList) {
        List<T> aux = new ArrayList<>();

        for(int i = 0; i < leftList.size(); i++ ){
            for (int j = 0; j < rightList.size(); j++){
                if( leftList.get(i).doubleValue() < rightList.get(j).doubleValue()){
                    aux.add(leftList.get(i));
                } else {
                    aux.add(rightList.get(j));
                }
            }
        }
        return aux;
    }
}
