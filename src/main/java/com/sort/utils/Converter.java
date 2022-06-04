package com.sort.utils;

import com.sort.algorithm.constant.CountingConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Converter {

    private Double exponent;
    private Integer min;
    private Boolean isDouble = false;

    public <T extends Number & Comparable<T>> List<Integer> convertToInteger(List<T> list) {

        List<Integer> response = new ArrayList<>();
        List<Integer> listOfIntegers = list.stream().map(Number::intValue).toList();
        this.min = Collections.min(listOfIntegers);

        if(list.get(0).getClass().getSimpleName().equals("Integer") && min.compareTo(0) < 0) {
            response = listOfIntegers.stream().map(e -> e - min).toList();

        } else if (list.get(0).getClass().getSimpleName().equals("Double")){

            this.isDouble = true;
            List<Double> resultList;
            List<String> listOfStrings = list.stream().map(Objects::toString).toList();

            List<Integer> listOfPower = listOfStrings
                    .stream()
                    .map( e -> e
                            .split("\\.")[CountingConstant.AFTER_COMMA]
                            .length())
                    .toList();

            this.exponent = Collections.max(listOfPower).doubleValue();
            List<Double> calculatedValuesList = Collections.nCopies(listOfPower.size(), Math.pow(CountingConstant.BASE, this.exponent));

            resultList = IntStream.range(0, calculatedValuesList.size()).mapToObj(i -> calculatedValuesList.get(i) * list.get(i).doubleValue()).toList();

            response = this.convertToInteger(resultList.stream().map(Number::intValue).toList());

        }

        return response;
    }

    public Double getExponent() {
        return exponent;
    }

    public List<?> returnToOriginal(List<Integer> list) {
        List<Integer> valueList = list.stream().map(e -> e + this.min).toList();
        return this.isDouble ? valueList
                .stream()
                .map(e -> e/Math.pow(CountingConstant.BASE, this.exponent))
                .collect(Collectors
                        .toList())
                : valueList;
    }
}
