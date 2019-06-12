/**
 * Java class to integrate all the sorting algorithms benchmarking
 * classes into one file
 * Author : Marco Men
 * Computational Thinking & Algorithm Analysis Final Project
 * Last Changed : 07 - October - 2019
 */

public class Benchmark {

    public static void main ( String args[] ) {

        InsertionSort.insert();

        Selection.select();

        BucketSort.bucket();

        ShellSort.shell();

        HeapSort.heap();

    }

}