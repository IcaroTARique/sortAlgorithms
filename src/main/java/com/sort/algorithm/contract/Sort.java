package com.sort.algorithm.contract;

import java.util.List;

public interface Sort {

    <T extends Double> List<T> sort(List<T> list);

}
