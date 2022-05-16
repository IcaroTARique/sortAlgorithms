package com.sort.algorithm;

import com.sort.algorithm.contract.Sort;

import java.util.ArrayList;
import java.util.List;

public class Merge implements Sort {

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) {

        if(list.size() <= 1) {
            return list;
        }

        List<T> leftList = this.sort(list.subList(0, (list.size()/2)));
        List<T> rightList = this.sort(list.subList(list.size()/2, list.size()));

        List<T> mergeList = this.merge(leftList, rightList);

        return mergeList;
    }

    private <T extends Comparable> List<T> merge(List<T> leftList, List<T> rightList) {
        List<T> aux = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < leftList.size() && j < rightList.size()) {
            if(leftList.get(i).compareTo(rightList.get(j)) < 0){
                aux.add(leftList.get(i));
                i++;
            } else {
                aux.add(rightList.get(j));
                j++;
            }
        }
        while (i < leftList.size()){
            aux.add(leftList.get(i));
            i++;
        }
        while (j < rightList.size()){
            aux.add(rightList.get(j));
            j++;
        }

        return aux;
    }
}
