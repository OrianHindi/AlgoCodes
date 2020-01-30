import java.util.Arrays;

public class findMaxRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = new int[10][10];
		fillMat(mat);
		printMat(mat);
		System.out.println("****************");
		maxRec(mat);
	}

	public static int maxRec(int[][] mat) { //O(m^2*n)
		int row =0;
		int col =0;
		int max = 0;
		int n = mat.length;
		int m = mat[0].length;
		int[] help = new int[m];

		for(int i=0; i<n; i++) { //O(n*(m + m^2)) --> O(m*n + m^2*n) --> O(m^2*n)
			for(int j =0; j<m; j++) {  //O(m)
				if(mat[i][j]==1)
					help[j] = help[j] + 1;
				else
					help[j] = 0;
			}
			
			for(int j=0; j<m; j++) { //O(m^2)
				int max_local = local_max(help, j); //O(m)
				if(max_local>max) {
					max = max_local;
					row = i+1;
					col = j+1;
				}
			}
		}
		System.out.println("Max is starting from: row = "+ row +" , col = "+col+" , size = "+max);
		return max; 
	}
	
	public static int local_max(int[] help, int start) {
		if(help[start] == 0) return 0;
		int rec_right = help[start];
		int rec_left = help[start];
		boolean b = true;
		for(int i = start+1; i<help.length && b; i++) {
			if(help[i]>=help[start])
				rec_right += help[start];
			else
				b = false;
		}
		
		b = true;
		for(int i= start-1; i>=0 && b; i--) {
			if(help[i]>=help[start])
				rec_left += help[start];
			else
				b = false;
		}
		
		return rec_right+rec_left-help[start];
		
	}
	
	public static void printMat(int [][] mat) {
		for(int i =0; i<mat.length; i++)
			System.out.println(Arrays.toString(mat[i]));
	}
	
	public static void fillMat(int[][] mat) {
		for(int i =0; i<mat.length; i++)
			for(int j =0; j<mat[0].length; j++)
				mat[i][j] = (int)(Math.random()+0.8);
	}

}
