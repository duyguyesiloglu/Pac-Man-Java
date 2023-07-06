package packages;
public class Point {

	private double arrx[][] = new double[15][15];
	private double arry[][]	= new double[15][15];
	private String Img;
	public Point(){
		Img = "C:\\Users\\User\\eclipse-workspace\\Pac\\src\\point.png";
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				arrx[i][j]=0;
				arry[i][j]=0;
			}
		}
	}
	
	public void setArrX(int i,int j,double coordinateX) {
		arrx[i][j]=coordinateX;
	}
	public double getArrX(int i,int j) {
		return arrx[i][j];
	}
	public void setArrY(int i,int j,double coordinateY) {
		arry[i][j]=coordinateY;
	}
	public double getArrY(int i,int j) {
		return arry[i][j];
	}
	public void show(int i,int j) {
		StdDraw.picture(arrx[i][j],arry[i][j],Img, 0.022, 0.022);
		}
	public boolean isPassed(int i,int j) {
		if(arrx[i][j] == -1 && arry[i][j] == -1) {
			return true;
		}
		return false;
	}
}
