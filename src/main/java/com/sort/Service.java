package com.sort;

import com.sort.algorithm.contract.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

    public List<Double> toSortList;
    private Sort sortMethod;

    public Service(Sort sortMethod) {
        this.sortMethod = sortMethod;
    }

    public void toSort() {
        this.toSortList = new ArrayList<>(List.of(10.0, 6.0, 4.0, 17.0, 5.0, 12.0, -15.0, 0.0));
        //System.out.println(sortMethod.getClass().getSimpleName() +"\t:: ORIGINAL\t ::\t"+ this.toSortList);
        //System.out.println(sortMethod.getClass().getSimpleName() +"\t:: ORDERED\t ::\t"+ this.sortMethod.sort(toSortList));

        System.out.printf("%-10s :: ORIGINAL :: %s \n",sortMethod.getClass().getSimpleName(),this.toSortList);
        System.out.printf("%-10s :: ORDERED  :: %s \n",sortMethod.getClass().getSimpleName(),this.sortMethod.sort(toSortList));
    }
}
