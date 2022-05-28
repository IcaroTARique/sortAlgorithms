package com.sort;

import com.sort.algorithm.contract.SortCompare;
import com.sort.algorithm.contract.SortCount;

import java.util.List;

public class Service {

    private SortCompare sortCompareMethod;
    private SortCount sortCountMethod;

    public Service(SortCompare sortCompareMethod) {
        this.sortCompareMethod = sortCompareMethod;
    }

    public Service(SortCount sortCountMethod) {
        this.sortCountMethod = sortCountMethod;
    }

    public <T extends Comparable<T>> void toSortCompare(List<T> toSortList) {

        System.out.printf("%-10s :: ORIGINAL :: %s \n",sortCompareMethod.getClass().getSimpleName(), toSortList);
        System.out.printf("%-10s :: ORDERED  :: %s \n",sortCompareMethod.getClass().getSimpleName(), this.sortCompareMethod.sort(toSortList));

    }

    public void toTest(List<Integer> toSortList) {

        System.out.printf("%-10s :: ORIGINAL :: %s \n",sortCountMethod.getClass().getSimpleName(),toSortList);
        System.out.printf("%-10s :: ORDERED  :: %s \n",sortCountMethod.getClass().getSimpleName(),this.sortCountMethod.sort(toSortList));
    }

    public <T extends Number & Comparable> void toSortCount(List<T> toSortList) {

        System.out.printf("%-10s :: ORIGINAL :: %s \n",sortCountMethod.getClass().getSimpleName(),toSortList);
        System.out.printf("%-10s :: ORDERED  :: %s \n",
                sortCountMethod.getClass().getSimpleName(),
                this.sortCountMethod.sort(toSortList));
    }
}
