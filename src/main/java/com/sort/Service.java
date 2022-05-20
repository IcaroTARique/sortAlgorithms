package com.sort;

import com.sort.algorithm.contract.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

    public List<Integer> toSortList;
    //public List<String> toSortList;

    private final Sort sortMethod;

    public Service(Sort sortMethod) {
        this.sortMethod = sortMethod;
    }

    public void toSort() {
        //this.toSortList = new ArrayList<>(List.of(10.0, 6.0, 4.0, 17.0, 5.0, 12.0, -15.0, 0.0));
        this.toSortList = new ArrayList<>(List.of(10, 6, 4, 17, 5, 12, -15, 0, 8, 6, 0, 15, 80, 69, 32, 44, 93, 5, -65, -33));
        //this.toSortList = new ArrayList<>(List.of("Isaias", "Fernão", "Isabela","Alef", "Alan"));

        System.out.printf("%-10s :: ORIGINAL :: %s \n",sortMethod.getClass().getSimpleName(),this.toSortList);
        System.out.printf("%-10s :: ORDERED  :: %s \n",sortMethod.getClass().getSimpleName(),this.sortMethod.sort(toSortList));
    }
}
