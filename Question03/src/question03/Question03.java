/*
 * Jaylon Norris
 * 11/17/2021
 * Sort the elements using merge sort   12 11 13 5 6 7 45 26 33 59 58
 * Reference:https://www.geeksforgeeks.org/merge-sort/
 */
package question03;

import java.util.*;

/**
 *
 * @author Jaylon
 */
public class Question03 {

    // Loop to print array elements
    static void printArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    static void merge(int a[], int start, int middle, int end) {
        int left, right, m;
        int n1 = middle - start + 1;
        int n2 = end - middle;

        //Temporary arrays for swap
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        //Copies onto array
        for (left = 0; left < n1; left++) {
            leftArray[left] = a[start + left];
        }
        for (right = 0; right < n2; right++) {
            rightArray[right] = a[middle + 1 + right];
        }

        //Indexs for left right and merged arrays
        left = 0;
        right = 0;
        m = start;

        //Change depending on size
        while (left < n1 && right < n2) {
            if (leftArray[left] <= rightArray[right]) {
                a[m] = leftArray[left];
                left++;
            } else {
                a[m] = rightArray[right];
                right++;
            }
            m++;
        }
        while (left < n1) {
            a[m] = leftArray[left];
            left++;
            m++;
        }

        while (right < n2) {
            a[m] = rightArray[right];
            right++;
            m++;
        }

    }

    //Start of recursive mergesort
    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            //sort elements
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }

    }

    public static void main(String[] args) {
        // Create array and put through quicksort before printing
        int[] array = {12, 11, 13, 5, 6, 7, 45, 26, 33, 59, 58};
        mergeSort(array, 0, array.length - 1);
        System.out.print("Merged sorted array is ");
        printArray(array, array.length);
    }

}
