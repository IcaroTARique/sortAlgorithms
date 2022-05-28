package com.sort.algorithm.contract;

import java.util.List;

public interface SortCompare {

    <T extends Comparable<T>> List<T> sort(List<T> list);

}
