
public class Matrix {
	
	private double [][] element;
	public int row ; 
	public int col ;
	public double[][] getElement() {
		return element;
		
	}

	public void setElement(double[][] element) {
		this.element = element;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Matrix(int row, int col) {
		element = new double [row][col];
		this.row = row;
		this.col = col;
	}
 
    public static void main(String[] args) {
    
    	// Customize your matrix
    	double[][] d1 = {{1,2,1},
    					 {0,0,2},
    					 {2,1,0}};
    	
    	double[][] d2 = {{1,2,2},
				 		 {1,0,1},
				 		 {0,2,0}};
   
    	Matrix m1 = new Matrix(d1.length,d1[0].length);
    	Matrix m2 = new Matrix(d2.length,d2[0].length);
    	
    	//fills m1 with d1
    	for(int r=0; r < d1.length;r++) {
    		for(int c=0; c < d1[0].length;c++){
    			m1.set(r, c, d1[r][c]);
    		}
    	}
    	//fills m2 with d2
    	for(int r=0; r < d2.length;r++) {
    		for(int c=0; c < d2[0].length;c++){
    			m2.set(r, c, d2[r][c]);
    		}
    	}
    	
    	System.out.println("matrix1:");
    	System.out.println(m1 +"\n");
    	
    	System.out.println("matrix2:");
    	System.out.println(m2 +"\n");
    	
    	System.out.println("matrix1 + matrix2:");
    	System.out.println(m1.add(m2) +"\n");
    	
    	System.out.println("matrix1 * matrix2:");
    	System.out.println(m1.multiply(m2) +"\n");
    }
    
    
    public String toString() {
    	boolean first = true;
    	String s = "";
    	for(int r=0; r < element.length;r++) {
    		
    		if(first)
    			first=false;
    		else
    			s += "\n";
    		
    		for(int c=0; c < element[0].length;c++){
    			s += "\t" + element[r][c];
    		}
    	}
    	return s;
    }
    public void set(int r,int c ,double val) {
    	element[r][c] = val;
    }
    public double get(int r,int c) {
    	return element[r][c];
    }
    

    public Matrix add(Matrix m) {
    	
    	if(element.length != m.element.length || element[0].length != m.element[0].length) {
    		System.out.println("incompatible matrix");
    		return null;
    	}
    	
    	Matrix sum = new Matrix(element.length, element[0].length);
    	for(int r=0; r < element.length;r++) {
    		for(int c=0; c < element[0].length;c++){
    			
    			double s = m.get(r, c)+this.get(r, c);
    			sum.set(r, c, s);
    		}
    	}
		return sum;
    }
    
    
    // this * m
    public Matrix multiply(Matrix m) {
    	
    	int r1=this.element.length, c1=this.element[0].length;
    	int r2=m.element.length, c2=m.element[0].length;
    	
    	if(r1 != c2 || r2 != c1) {
    		System.out.println("incompatible matrix");
    		return null;
    	}
    	
    	Matrix product = new Matrix(element.length, m.element[0].length);
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
            	int sum =0;
                for (int k = 0; k < c1; k++) {
                    sum += this.get(i, k) * m.get(k, j);
                }
                product.set(i, j, sum);
            }
        }

        return product;
    }
    
}