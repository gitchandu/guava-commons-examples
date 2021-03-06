package com.chandu.template;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Chandrasekhar Thotakura
 */
public class GoogleCodeJamTemplate {
    
    private static Scanner in = null;
    private static PrintWriter out = null;
    
    private static final String fileName = "files/A-sample";
    private static final String inExt = ".in";
    private static final String outExt = ".out";
    
    private static final String caseNum = "Case #";
    private static final String colon = ": ";
    
    private static long T = 0L;
    private static long lines = 0L;
    
    /*
     * This is the solution
     */
    private static void solve() {
        T = in.nextInt();
        for (long t = 0L; t < T; t += 1) {
            // main logic here
            printResult(t, Long.toString(t));
        }
    }
    
    /*
     * Print the test case result
     */
    private static void printResult(final long testCase, final String result) {
        lines += 1;
        out.println(caseNum + (testCase + 1) + colon + result);
    }
    
    /*
     * Just change the fileName and run the program
     */
    public static void main(final String[] tcs) {
        final String inFileName = fileName + inExt;
        final String outFileName = fileName + outExt;
        
        try {
            
            in = new Scanner(new BufferedReader(new FileReader(inFileName)));
            out = new PrintWriter(new BufferedWriter(new FileWriter(outFileName)));
            
            solve();
            
        } catch (FileNotFoundException ex) {
            System.err.println("[FileNotFoundException] >> " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("[IOException] >> " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("[Exception] >> " + ex.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        if (lines != T) {
            System.err.println("Something went wrong.");
            System.err.println("Lines printed should be equal to the number of test case.");
            System.exit(1);
        } else {
            System.out.println("Program executed successfully.");
            System.out.println("Please check the output file [" + outFileName + "].");
            System.exit(0);
        }
    }
}
