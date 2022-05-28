package com.sort.utils;

import com.sort.algorithm.constant.CountingConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountingConverter {

    CountingConstant counting = new CountingConstant();
    private Double exponent;
    private Integer min;
    private Boolean isDouble = false;

    public <T extends Number & Comparable> List<Integer> convertToInteger(List<T> list) {

        List<Integer> response = new ArrayList<>();
        List<Integer> listOfIntegers = list.stream().map(e -> e.intValue()).collect(Collectors.toList());
        min = Collections.min(listOfIntegers);

        if(list.get(0).getClass().getSimpleName().equals("Integer") && min.compareTo(0) < 0) {
            List<Integer> normalizedValues;
            normalizedValues = listOfIntegers.stream().map(e -> e - min).toList();
            response = normalizedValues;

        } else if (list.get(0).getClass().getSimpleName().equals("Double")){
            this.setDouble(true);

            List<Double> resultList = new ArrayList<>();
            List<String> listOfStrings = list.stream().map(Objects::toString).toList();

            List<Integer> listOfPower = listOfStrings
                    .stream()
                    .map( e -> e
                            .split("\\.")[counting.AFTER_COMMA]
                            .length())
                    .collect(Collectors.toList());

            exponent = Collections.max(listOfPower).doubleValue();
            List<Double> listToCalculate = Collections.nCopies(listOfPower.size(), Math.pow(counting.BASE, exponent));

            for(int i = 0; i < listToCalculate.size(); i++) {
                resultList.add(listToCalculate.get(i) * list.get(i).doubleValue());
            }
            response = this.convertToInteger(resultList.stream().map(e -> e.intValue()).toList());

        }

        return response;
    }

    public Double getExponent() {
        return exponent;
    }

    public Integer getMin() {
        return min;
    }

    public Boolean getDouble() {
        return isDouble;
    }

    public void setDouble(Boolean aDouble) {
        isDouble = aDouble;
    }

    public List<?> returnToOriginal(List<Integer> list) {
        List<Integer> valueList = list.stream().map(e -> e + getMin()).toList();
        return this.getDouble() ? valueList
                .stream()
                .map(e -> e/Math.pow(counting.BASE, getExponent()))
                .collect(Collectors
                        .toList())
                : valueList;
    }
}
