package matrixmultiplication;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class testMatrix {


	    
	    @Test
	    public void testStandardmatrixmultiply() {
	        int drA = 2;
	        int dcA = 2;
	        int dcB = 2;
	        int[][] matrixA = {{1,1},{1,1}};
	        int[][] matrixB = {{1,1},{1,1}};
	     
	        int[][] expResult = {{2,2},{2,2}};
	        Matrix m1 = new Matrix(matrixA,matrixB);
	        int[][] result = m1.Standardmatrixmultiply(drA, dcA, dcB);
	        assertArrayEquals(expResult, result);
	        
	        
	    }

	    /**
	     * Test of multiply method, of class Matrix.
	     */
	    @Test
	    public void testStressenMultiply() {
	        int[][] matrixA = {{1,1},{1,1}};
	        int[][] matrixB = {{1,1},{1,1}};
	        int[][] expResult = {{2,2},{2,2}};
	        
	        Matrix m1 = new Matrix(matrixA,matrixB);
	        int[][] result = m1.Stressenmultiply(m1.matrixA,m1.matrixB);
	        assertArrayEquals(expResult, result);
	    }

	    /**
	     * Test of sub method, of class Matrix.
	     */
	   
}
