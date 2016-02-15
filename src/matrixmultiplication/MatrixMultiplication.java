package matrixmultiplication;

import java.util.Random;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 *

 */
public class MatrixMultiplication 
{



	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Dimension(2^x): ");

		//Taking input dimension from user.
		int dimension = sc.nextInt();
		Random rn = new Random();

		int[][] matrixA = new int[dimension][dimension];
		int[][] matrixB = new int[dimension][dimension];

		//random filling the matrices
		for(int i = 0;i< dimension;++i)
		{
			for(int y = 0; y < dimension; ++y)
			{
				matrixA[i][y] = rn.nextInt(50);
				matrixB[i][y] = rn.nextInt(50);
			}
		}
		//initializing matrices.
		Matrix mm = new Matrix(matrixA,matrixB);

		// Using standard algo for multiplication.
		int[][] result = mm.Standardmatrixmultiply(dimension,dimension,dimension);

		//Using strassen's algo for multpilication
		int[][] result2 = mm.Stressenmultiply(mm.matrixA,mm.matrixB);
		System.out.println("Using Standard Way: ");

		for(int i = 0;i< dimension;++i)
		{
			for(int y = 0; y < dimension; ++y)
			{
				System.out.print(result[i][y]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}  


		System.out.println("Using Stressen's Algo: ");
		for(int i = 0;i< dimension;++i)
		{
			for(int y = 0; y < dimension; ++y)
			{
				System.out.print(result2[i][y]);
				System.out.print(" ");
			}
			System.out.print("\n");
		} 
	}
}

