package epamtask;
import java.util.*;
//@ madhavi
/*Question:You have been given an array A of size N and an integer K. This array consists of N integers ranging from 1 to10^7 . Each element in this array is said to have a Special Weight. The special weight of an element a[i] is a[i]%k.

You now need to sort this array in Non-Increasing order of the weight of each element, i.e the element with the highest weight should appear first, then the element with the second highest weight and so on. In case two elements have the same weight, the one with the lower value should appear in the output first.*/
/* Descending weights class takes input and print output*/
public class DescendingWeights {
	public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        /* @parameter n is size of array
         * @parameter k is integer
         *
         */
        int arr_size=sc.nextInt();
        int k=sc.nextInt();
        int[] array=new int[arr_size];
        for(int arr_ele=0;arr_ele<arr_size;arr_ele++)
        {
            array[arr_ele]=sc.nextInt();
        }
        StoreWeights d=new StoreWeights();
             d.store(array,arr_size,k);
             
    }
}
	 class  StoreWeights
	{
	    void store(int a[],int n, int k)
	    {
	        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
	        ArrayList<Integer>  al=new ArrayList<Integer>();
	        /* a[j]%k is special weight for each element of array*/
	        for(int j=0;j<n;j++)
	        {
	        	/* pushing array elements and special weights into hash map*/
	            m.put(a[j],a[j]%k);
	            al.add(a[j]);
	        }
	        SortWeights sort=new SortWeights(m);
	        Collections.sort(al,sort);
	        for(int result:al)
	        {
	            System.out.print(result+" ");
	        }
	        
	    }
	}


class SortWeights   implements Comparator<Integer>
{
       private final Map<Integer,Integer> fm;
       SortWeights(Map<Integer,Integer> m)
       {
           fm=m;
       }
       public int compare(Integer k1,Integer k2)
       {
             int specialweights=fm.get(k2).compareTo(fm.get(k1));
             int weights=k1.compareTo(k2);
             if(specialweights==0)
                return weights;
             else
                 return specialweights;
       }             
       
}
