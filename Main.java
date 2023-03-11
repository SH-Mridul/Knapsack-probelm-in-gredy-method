package KnapSackGredyMethod;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n value:");
		int n = input.nextInt();
		System.out.print("Enter weight value:");
		int wt = input.nextInt();
		
		int w[] = new int[n];
		int p[] = new int[n];
		
		System.out.println("-----------------------------getting input---------------------------------------");
		for(int i = 0; i<n; i++)
		{
			System.out.print("Enter weight for "+(i+1)+":");
			w[i] = input.nextInt();
			
			System.out.print("Enter profit for "+w[i]+":");
			p[i] = input.nextInt();
		}
		
		System.out.println("-----------------------------end---------------------------------------");
		
		double profitPerWeight[] = new double[n];
		
		for(int i = 0; i<n; i++)
		{
			profitPerWeight[i] = (double)p[i]/w[i];
		}
		
		System.out.println("max profit:"+knapsack(wt,p,w,profitPerWeight,0));
		
		input.close();

	}
	
	
	public static double knapsack(int weight,int[] p, int[] w,double[] PpW,double profit)
	{
		if(weight == 0)
		{
			return profit;
		}
		
		int index =  maxIndex(PpW);
		
		if(weight>w[index])
		{
			profit += p[index]; 
			weight -= w[index];
			PpW[index] = 0;
			
		}else {
			profit += (double)(weight*PpW[index]);
			weight = 0; 
		}
		
		return knapsack(weight,p,w,PpW,profit);
	}
	
	
	public static int maxIndex(double[] PpW)
	{
		double max = PpW[0];
		int index = 0;
		
		for(int i = 1; i<PpW.length; i++)
		{
			if(max<PpW[i])
			{
				max = PpW[i];
				index = i;
			}
		}
		
		return index;
	}

}
