/**
 * InsertionSort class is the first sorting algorithm benchmarking
 * classes to be run as it includes the header row
 * Author : Marco Men
 * Computational Thinking & Algorithm Analysis Final Project
 * Last Changed : 07 - October - 2019
 */


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.DecimalFormat;


// This is the first method to be called

public class InsertionSort {

      /*
       * From lecture slides
      */

    public static int[] getRandomArray(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        return numbers;
    }


    /*
     * Method to Sort String array using insertion sort in Java.
     * This can also sort any object array which implements
     * Comparable interface.
   */

    public static void insertionSort(int a[] ) {
        // insertion sort starts from second element
        for (int i = 1; i < a.length; i++) {
            int key = a[i];

            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;

        }
    }

    private static final int WARMUP = 10;

    private static int ITERATIONS = 10;

    // method called in  Bchmark main method

    static void insert() {

        // Create an output stream to Output.txt
        System.out.println("The Outputs from my benchmark application have been stored in Output.txt");



        try {
            // FileOutputStream = append: true as oppose to File(NO APPEND)
            PrintStream myconsole = new PrintStream( new FileOutputStream( "Output.txt",true) );
            System.setOut( myconsole );
        }

        catch (FileNotFoundException e) {

            System.out.println( e.toString() );

        }



        int size[] = new int[] {10, 50, 100, 250, 500, 1000, 2000, 3500, 7000, 10000, 15000, 20000, 25000 };




        Timestamp ts = new Timestamp( System.currentTimeMillis() ) ;




        System.out.println("\n\nCurrent TimeStamp is:  " + ts + "\n\n");
        // a few blank lines

        System.out.println( "Average Times In Milliseconds\n" );



        System.out.println( "Size\t" + "\t\t10\t\t50\t\t100\t\t250\t\t500\t\t1000\t2000\t3500\t7000\t10000" +
                "\t15000\t20000\t25000");

        System.out.print( "InsertionSort\t" );



        /**
         *    iterations on size array indices
         *
         *    change the length to 10,100,250,500,1000,2000,3500,7000,10000,15000,20000,25000
         */


        for (int j=0; j <size.length; j++) {
            int width = size[j];


            /**
             *    Adapted from: " https://stackoverflow.com/questions/8378453/java-compute-average-execution-time "
             *
             *    Warm Up test with no timing
             */



            for (int i = 0; i < WARMUP; ++i) {

                InsertionSort ob = new InsertionSort();
                ob.insertionSort( getRandomArray( width ) );
            }

            // The real test


            long startTime = System.nanoTime();

            for (int i = 0; i < ITERATIONS; i++) {


                // sorting array using insertion sort in Java
                InsertionSort ob = new InsertionSort();
                ob.insertionSort( getRandomArray( width ) );

            }


            long endTime = System.nanoTime();


            long elapsedTimeNanos = endTime - startTime;


            double timeElapsedMillis = elapsedTimeNanos / 1000000.0;


            double average = timeElapsedMillis / ITERATIONS;

            // average doubles converted into string - Now separate each element with a tab

            // Format String to 3 decimal places - "https://stackoverflow.com/questions/2538787/how-to-display
            // -an-output-of-float-data-with-2-decimal-places-in-java"

            DecimalFormat df = new DecimalFormat( "0.00#" );

            String str = df.format( average );

            String averages = new StringBuilder(  ).append( str ).toString();




            System.out.print( (averages + "\t") );

        }


    }


}
