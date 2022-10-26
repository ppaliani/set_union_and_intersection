import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Part_1 {

  public static void main(String[] args) throws Exception {

    // Declaring File objects
    File file = null;
    File outputFile = null;

    // File input and output names
    file = new File("C:\\Users\\Paul\\Desktop\\Program1\\Part1\\file1.txt");
    outputFile = new File("C:\\Users\\Paul\\Desktop\\Program1\\Part1\\Output.txt");

    // Declaring input and output objects
    FileWriter fw = null;
    PrintWriter pw = null;

    FileInputStream fis = null;

    try {
      fw = new FileWriter(outputFile);
    } catch (IOException e1) {
      System.out.println("Could not find file");
      e1.printStackTrace();
    }

    pw = new PrintWriter(fw);


    try {
      fis = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      System.out.println("Could not find file");
      e.printStackTrace();
    }

    Scanner input = new Scanner(fis);

    // m is the length of set 1 and x is size m
    int m = input.nextInt();
    Integer[] x = new Integer[m];

    // Enter values of set 1 into array x
    for (int i = 0; i < x.length; i++) {
      x[i] = input.nextInt();
    }

    // n is the length of set 2 and y is size n
    int n = input.nextInt();
    Integer[] y = new Integer[n];

    // Enter values of set 2 into array y
    for (int i = 0; i < y.length; i++) {
      y[i] = input.nextInt();
    }

    // ====================Union====================

    // HashSet to produce union between arrays
    HashSet<Integer> union = new HashSet<>();

    // Add arrays x and y to hash union
    union.addAll(Arrays.asList(x));
    union.addAll(Arrays.asList(y));

    // Print number of values in u
    int p = union.size();
    pw.println("p: " + p);

    // Return the union set
    pw.print("Union: ");
    pw.print(union);

    // Convert hash union to array u
    Integer[] u = {};
    u = union.toArray(u);


    // ====================Intersection====================

    // HashSet to produce intersection between arrays
    HashSet<Integer> intersect = new HashSet<>();

    // Add arrays x and y to hash intersect
    intersect.addAll(Arrays.asList(x));
    intersect.retainAll(Arrays.asList(y));

    // formatting
    pw.println();
    pw.println();

    // Convert hash intersect to array v
    Integer[] v = {};
    v = intersect.toArray(v);

    // Print number of values in v
    int q = intersect.size();

    // Return the intersection set
    pw.println("q: " + q);
    pw.print("Intersection: " + Arrays.toString(v));

    input.close();
    pw.close();
  }
}
