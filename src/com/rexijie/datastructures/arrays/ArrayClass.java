package com.rexijie.datastructures.arrays;


import java.util.Arrays;

class CustomArray {
    private int[] intArr;
    private int lastIndex = 0;

    CustomArray(int size) {
        this.intArr = new int[size];
    }

    private void fillExceptIndex(int[] ints, int index) {
        for (int i = 0; i < intArr.length; i++) {
            if (i == index) {
                continue;
            }
            if (i < index) {
                ints[i] = intArr[i];
            }
            if (i > index) {
                ints[i - 1] = intArr[i];
            }
        }
    }

    public void removeAt(int index) {
        int[] ints = new int[intArr.length - 1];
        int arrayLength = intArr.length;
        if (index <= intArr.length && index >= 0) {
            if (index == 0) {
                ints = Arrays.copyOfRange(intArr, 1, arrayLength); //to is exclusive
            } else if (index == lastIndex) {
                ints = Arrays.copyOfRange(intArr, 0, lastIndex - 1); //to is exclusive
            } else {
                fillExceptIndex(ints, index);
            }
            intArr = ints;
            this.lastIndex--;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Array index [" + index + "] out of bounds, last index is "+ (arrayLength - 1));
    }

    public void insert(int item) {
        if (lastIndex <= intArr.length - 1 && lastIndex >= 0) {
            intArr[lastIndex] = item;
            lastIndex++;
            return;
        }
        if (lastIndex > intArr.length - 1) {
            int[] ints = new int[intArr.length + 1];
            ints[ints.length - 1] = item;
            if (intArr.length - 1 >= 0)
                System.arraycopy(intArr, 0, ints, 0, intArr.length); // Copy Values To Array

            intArr = ints;
            lastIndex++;
        }
    }

    public int returnIndex(int value) {
        return Arrays.binarySearch(intArr, value);
    }

    public void print() {
        for (int number : intArr) {
            System.out.println(number);
        }
    }
}

public class ArrayClass {

    public static void main(String[] args) {
        CustomArray cArr = new CustomArray(4);
        cArr.insert(10);
        cArr.insert(20);
        cArr.insert(30);
        cArr.insert(40);
        cArr.insert(55);
        cArr.insert(60);
        cArr.insert(70);
        cArr.insert(80);
        cArr.removeAt(8);
        cArr.print();
    }
}
