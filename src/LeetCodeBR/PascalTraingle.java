package LeetCodeBR;
import java.util.*;

public class PascalTraingle {

	public static void main(String[] args) {
		System.out.println(generateLeetCode(5));

	}

	public static List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;	
	}
	
	public static List<List<Integer>> generateLeetCode(int numRows)
	{
		List<List<Integer>> triangle = new ArrayList();
		if(numRows == 0)
			return triangle;
		
		List<Integer> firstrow = new ArrayList();
		firstrow.add(1);
		triangle.add(firstrow);
		for(int i=1;i<numRows;i++) {
			List<Integer> prevrow = triangle.get(i-1);
			List<Integer> row = new ArrayList();
			row.add(1);
			for(int j=1;j<i;j++) {
				row.add(prevrow.get(j-1) + prevrow.get(j));
			}
			row.add(1);
			triangle.add(row);
			
		}
		
		return triangle;	
	}

}
