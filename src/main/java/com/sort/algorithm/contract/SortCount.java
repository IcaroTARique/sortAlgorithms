package com.sort.algorithm.contract;

import java.util.List;

public interface SortCount{

    <T extends Number & Comparable> List<?> sort(List<T> list);
}
