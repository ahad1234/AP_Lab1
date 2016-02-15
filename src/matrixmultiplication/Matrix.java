/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiplication;

/**
 *

 */
public class Matrix 
{
	public static int[][] matrixA;
	public static int[][] matrixB;

	public  Matrix(int[][] a,int[][] b)
	{
		matrixA = a;
		matrixB = b;
	}

	public static int[][] Standardmatrixmultiply(int drA,int dcA,int dcB)
	{
		int[][] result = new int[drA][dcB];
		int sum = 0;
		for (int i = 0 ; i < drA ; i++ )
		{
			for (int j = 0 ; j < dcB ; j++ )
			{   
				for (int k = 0 ; k < dcA ; k++ )
				{
					sum = sum + matrixA[i][k]*matrixB[k][j];
				}

				result[i][j] = sum;
				sum = 0;
			}
		}

		return result;
	}

	public static int[][] Stressenmultiply(int[][] A, int[][] B)
	{        
		int n = A.length;
		int[][] R = new int[n][n];
		/** base case **/
		if (n == 1)
			R[0][0] = A[0][0] * B[0][0];
		else
		{
			int[][] A11 = new int[n/2][n/2];
			int[][] A12 = new int[n/2][n/2];
			int[][] A21 = new int[n/2][n/2];
			int[][] A22 = new int[n/2][n/2];
			int[][] B11 = new int[n/2][n/2];
			int[][] B12 = new int[n/2][n/2];
			int[][] B21 = new int[n/2][n/2];
			int[][] B22 = new int[n/2][n/2];


			split(A, A11, 0 , 0);
			split(A, A12, 0 , n/2);
			split(A, A21, n/2, 0);
			split(A, A22, n/2, n/2);

			split(B, B11, 0 , 0);
			split(B, B12, 0 , n/2);
			split(B, B21, n/2, 0);
			split(B, B22, n/2, n/2);



			int [][] M1 = Stressenmultiply(add(A11, A22), add(B11, B22));
			int [][] M2 = Stressenmultiply(add(A21, A22), B11);
			int [][] M3 = Stressenmultiply(A11, sub(B12, B22));
			int [][] M4 = Stressenmultiply(A22, sub(B21, B11));
			int [][] M5 = Stressenmultiply(add(A11, A12), B22);
			int [][] M6 = Stressenmultiply(sub(A21, A11), add(B11, B12));
			int [][] M7 = Stressenmultiply(sub(A12, A22), add(B21, B22));


			int [][] C11 = add(sub(add(M1, M4), M5), M7);
			int [][] C12 = add(M3, M5);
			int [][] C21 = add(M2, M4);
			int [][] C22 = add(sub(add(M1, M3), M2), M6);


			join(C11, R, 0 , 0);
			join(C12, R, 0 , n/2);
			join(C21, R, n/2, 0);
			join(C22, R, n/2, n/2);
		}

		return R;
	}

	public static int[][] sub(int[][] A, int[][] B)
	{
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				C[i][j] = A[i][j] - B[i][j];
		return C;
	}

	public static int[][] add(int[][] A, int[][] B)
	{
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				C[i][j] = A[i][j] + B[i][j];
		return C;
	}

	public static void split(int[][] P, int[][] C, int iB, int jB) 
	{
		for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
			for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
				C[i1][j1] = P[i2][j2];
	}

	public static void join(int[][] C, int[][] P, int iB, int jB) 
	{
		for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
			for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
				P[i2][j2] = C[i1][j1];
	}

}
