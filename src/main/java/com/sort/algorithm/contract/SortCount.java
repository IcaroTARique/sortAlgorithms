package com.sort.algorithm.contract;

import java.util.List;

public interface SortCount{

    <T extends Number & Comparable<T>> List<?> sort(List<T> list);
}
