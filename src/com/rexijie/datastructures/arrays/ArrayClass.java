package com.rexijie.datastructures.arrays;


import java.util.Arrays;

class CustomArray {
    private int[] intArr;
    private int lastIndex = 0;

    CustomArray(int size) {
        this.intArr = new int[size];
    }

    public void removeAt(int index)  {
        int[] ints;
        int arrayLength = intArr.length;
        if (index == 0) {
            ints = Arrays.copyOfRange(intArr, 1, arrayLength); //to is exclusive
        } else if (index == lastIndex) {
            ints = Arrays.copyOfRange(intArr, 0, arrayLength - 1); //to is exclusive
        } else if ( index >= intArr.length || index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Index " +index+ " out of bounds");
        } else {
            ints = new int[intArr.length - 1];
            for (int i = 0; i < intArr.length; i++) {
                if (i == index) {
                    // do nothing
                }
                if (i < index) {
                    ints[i] = intArr[i];
                }
                if (i > index) {
                    ints[i - 1] = intArr[i];
                }
            }
        }
        intArr = ints;
        this.lastIndex--;
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
        cArr.removeAt(0);
        cArr.print();
    }
}
