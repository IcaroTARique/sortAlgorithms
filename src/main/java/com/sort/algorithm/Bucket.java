package com.sort.algorithm;

import com.sort.algorithm.contract.SortCount;
import com.sort.utils.Converter;

import java.util.*;

public class Bucket implements SortCount {

    private static final int DEFAULT_BUCKET_SIZE = 10;
    Converter converter = new Converter();
    Insertion insertion = new Insertion();

    @Override
    public <T extends Number & Comparable<T>> List<?> sort(List<T> list) {

        List<ArrayList<Integer>> buckets = new ArrayList<>();
        List <Integer> integerList = converter.convertToInteger(list);
        List<Integer> response = new ArrayList<>();

        Integer max = integerList.stream().max(Integer::compareTo).get();
        Integer min = integerList.stream().min(Integer::compareTo).get();

        Integer bucketCount = (max - min) / DEFAULT_BUCKET_SIZE + 1;

        for (int i = 0; i < bucketCount; i++){
            buckets.add(new ArrayList<>());
        }

        integerList.forEach(e -> buckets.get((e * DEFAULT_BUCKET_SIZE)/max).add(e));

        buckets.forEach(e -> response.addAll(insertion.sort(e)));

        return converter.returnToOriginal(response);
    }
}
