import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Project11a 
{

public static void main(String[] args) throws FileNotFoundException
{
   String fileName;
   Scanner keyboard = new Scanner(System.in);
   
   System.out.println("Enter the file name");
   fileName=keyboard.next();
   
   
   double data[]=readFile(fileName);
   int array[]=summarizeDataByHour(data);
   
   System.out.println("Usage Summary");
   for ( int i = 0; i < array.length; ++i)
   {
      if ( array[i]!=0)
      {
         System.out.println("From " + i+" to "+(i+1)+" there were " + array[i]+ " entries");
      }
   }
   
}

public static int countInRange(double[] data, int lower, int upper)
{  
   int count=0;
   for (int i = 0; i< data.length; ++i)
   {
      if(data[i]>=lower&&data[i]<upper)
      {
         count++;
      }
   }
   return count;

}

   public static double[] readFile(String fileName) throws FileNotFoundException
{
   // ArrayList<Double> data = new ArrayList <Double> ();
   Scanner input = new Scanner(new File(fileName));
  
  int size = input.nextInt(); 
    
  
   double[] array = new double[size];
   int i = 0;
   for (i=0; input.hasNextDouble();++i) 
   {
      array[i]=input.nextDouble();
   }
   input.close();
   return array;

}
   
public static int[] summarizeDataByHour(double[] data)

{
   int[] array = new int[24]; 
   
   for ( int i = 0 ; i < array.length ; ++i)
   {
      array [i] = countInRange(data, i, i+1);
      
   }
   
   return array;
} 
}
