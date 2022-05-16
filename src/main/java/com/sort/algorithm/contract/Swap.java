package com.sort.algorithm.contract;

import java.util.List;

public interface Swap {

    <E> List<E> swap(List<E> list, Integer i, Integer j);
}
