package com.sort.algorithm.contract;

import java.util.List;

public interface Swap {

    default <E> List<E> swap(List<E> list, Integer i, Integer j) {

        E aux = list.get(i);
        list.set(i, list.get(j));
        list.set(j, aux);

        return list;
    };
}
