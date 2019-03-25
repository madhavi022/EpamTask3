package epamtask;
import java.util.*;
/*@ author madhavi*/
/* Question:A young mischievous boy Harsh, got into a trouble when his mechanical workshop teacher told him to cut Iron rods. The rod cutting algorithm is as follows:

Step 1. If the rod can be divided into two equal parts, cut it and choose any one of them.

Step 2. Else cut the rod into two parts having non-zero integral lengths such that the difference between the lengths of the two pieces is minimized, and then choose the piece having smaller length.

Step 3. Repeat the above algorithm with the currently chosen piece. If the length of the currently chosen piece becomes 1 , stop the algorithm.

There can be special rods which require Step 2 in every step of its cutting. Harsh want to find out the number of such special rods. Help Harsh to find out the answer.*/
public class SpecialRod {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
        //scanning testcases
	       int testcases=s.nextInt();
	       
	       CalculateSpecialRod cal=new CalculateSpecialRod(testcases);
	       
	}

}
class CalculateSpecialRod
{
	int t;
	Scanner sc=new Scanner(System.in);
	 CalculateSpecialRod(int testcases)
	 {
		 this.t=testcases;
	 
	 
	 for(int i=0;i<t;i++)
     {
          int count_specialrods=0;
          //3 is the first special rod
          int r=3;
          int range_of_rod=sc.nextInt();
          //calculating special rods in given range of rods
            while(r<=range_of_rod)
             {
            	count_specialrods++;
                r=2*r+1;
               }//while
           
         System.out.println(count_specialrods);
       }
	 }

}
