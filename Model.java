package y2020_loghashankar_ashvin_period_1_individual_project;

import java.util.ArrayList;

public class Model{
	
	private int[][] grid;
	
	public Model(){
		resetGrid();
	}
	
	public void resetGrid() {
		grid = new int[4][4];
		int i = (int)(Math.random() * 4);
		int j = (int)(Math.random() * 4);
		grid[i][j] = 2;
	}
	
	public int getValue(int row, int col) {
		return grid[row][col];
	}
	
	public void setValue(int row, int col, int value) {
		grid[row][col] = value;
	}
	
	public void moveLeft() {
		for(int i = 0; i<grid.length; i++) {
			ArrayList<Integer> values = new ArrayList<Integer>();
			for(int j = 0; j<grid[0].length; j++) {
				if(!isZero(i,j)) values.add(getValue(i,j));
				setValue(i,j,0);
			}
			for(int j=0; j<values.size(); j++) {
				setValue(i,j,values.get(j));
			}
			int j = 0;
			while(j<grid[0].length-1) {
				boolean moved = false;
				if(getValue(i,j) == getValue(i,j+1)) {
					moved = true;
					setValue(i,j,2*getValue(i,j));
					for(int k = j+1; k<grid[0].length-1; k++) {
						setValue(i,k,getValue(i,k+1));
					}
					setValue(i,grid[0].length-1,0);
				}
				if(moved) j+=2;
				else j++;
			}
		}
		addRandomValue();
	}
	
	public void moveRight() {
		for(int i = 0; i<grid.length; i++) {
			ArrayList<Integer> values = new ArrayList<Integer>();
			for(int j = grid[0].length-1; j>=0; j--) {
				if(!isZero(i,j)) {
					values.add(getValue(i,j));
				}
				setValue(i,j,0);
			}
			for(int j = 1; j<= values.size(); j++) {
				setValue(i,grid[0].length-j, values.get(j-1));
			}
			
			int j = grid[0].length-1;
			while(j>0) {
				boolean moved = false;
				if(getValue(i,j) == getValue(i,j-1)) {
					moved = true;
					setValue(i,j,2*getValue(i,j));
					for(int k = j-1; k>0; k--) {
						setValue(i,k,getValue(i,k-1));
					}
					setValue(i,0,0);
				}
				if(moved) j-=2;
				else j--;
			}
		}
		addRandomValue();
	}
	
	public void moveDown() {
		for(int j = 0; j<grid[0].length; j++) {
			ArrayList<Integer> values = new ArrayList<Integer>();
			for(int i = grid.length-1; i>=0; i--) {
				if(!isZero(i,j)) values.add(getValue(i,j));
				setValue(i,j,0);
			}
			for(int i = 1; i<=values.size(); i++) {
				setValue(grid.length-i,j,values.get(i-1));
			}
			
			int i = grid.length-1;
			while(i>0) {
				boolean moved = false;
				if(getValue(i,j) == getValue(i-1,j)) {
					moved = true;
					setValue(i,j,2*getValue(i,j));
					for(int k = i-1; k>0; k--) {
						setValue(k,j,getValue(k-1,j));
					}
					setValue(0,j,0);
				}
				if(moved) i-=2;
				else i--;
			}
		}
		addRandomValue();
	}
	
	public void moveUp() {
		for(int j =  0; j<grid[0].length; j++) {
			//moving:
			ArrayList<Integer> values = new ArrayList<Integer>();
			for(int i = 0; i<grid.length; i++) {
				if(!isZero(i,j)) values.add(getValue(i,j));
				setValue(i,j,0);
			}
			for(int i = 0; i<values.size(); i++) {
				setValue(i,j,values.get(i));
			}
			//addition:
			int i = 0;
			while(i<grid.length-1) {
				boolean moved = false;
				if(getValue(i,j) == getValue(i+1,j)) {
					moved = true;
					setValue(i,j,2*getValue(i,j));
					for(int k = i+1; k<grid.length-1; k++) {
						setValue(k,j,getValue(k+1,j));
					}
					setValue(grid.length-1,j,0);
				}
				
				if(moved) i+=2;
				else i++;
			}
		}
		addRandomValue();
	}
	
	private boolean isZero(int row, int col) {
		return grid[row][col] == 0;
	}
	
	public void addRandomValue() {
		int rand = 2;
		if(Math.random() > 0.9) {
			rand = 4;
		}
		ArrayList<Point> values = new ArrayList<Point>();
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid.length; j++) {
				if(isZero(i,j)) {
					Point p = new Point(i,j);
					values.add(p);
				}
			}
		}
		int a = (int)(Math.random() * values.size());
		setValue(values.get(a).x,values.get(a).y,rand);
	}
	
	public boolean isGameOver() {
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid[0].length; j++) {
				if(getValue(i,j) == 0) return false;
				if(getValue(i,j) == 2048) return true;
			}
		}
		return true;
	}
		
	private class Point{
		int x;
		int y;
		Point(int a, int b){
			x = a;
			y = b;
		}
	}
	
	public int calculateScore() {
		int sum = 0;
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid[0].length; j++) {
				sum += getValue(i,j);
			}
		}
		return sum;
	}
	
//	//returns -1 if none
//	private int firstZeroInRow(int row) {
//		for(int i = 0; i<grid[0].length; i++) {
//			if(grid[row][i] == 0) return i;
//		}
//		return -1;
//	}
//	
//	private int firstZeroInCol(int col) {
//		for(int i = 0; i<grid.length; i++) {
//			if(grid[i][col] == 0) return i;
//		}
//		return -1;
//	}
//	
//	private int lastZeroInRow(int row) {
//		for(int i = grid[0].length; i>=0; i--) {
//			if(grid[row][i] == 0) return i;
//		}
//		return -1;
//	}
//	
//	private int lastZeroInCol(int col) {
//		for(int i = grid.length; i>=0; i--) {
//			if(grid[i][col] == 0) return i;
//		}
//		return -1;
//	}
//	
//	private int numZeroesInCol(int col) {
//		int num = 0;
//		for(int i = 0; i<grid[col].length; i++) {
//			if(grid[i][col] == 0) num++;
//		}
//		return num;
//	}
//	
//	private int numZeroesInRow(int row) {
//		int num = 0;
//		for(int i = 0; i<grid.length; i++) {
//			if(grid[row][i] == 0) num++;
//		}
//		return num;
//	}
}
