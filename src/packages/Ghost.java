package packages;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ghost {
	private String ghostImg;
	private String Img;
	private double x;
	private double y;
	
	public Ghost() {
		x=0.6;
		y=0.6;
		ghostImg = "src\\ghost.png";
		Img = ghostImg;
	}

	public void Move() {
		Random random = new Random();
    	int rand = random.nextInt(4);
    	if(rand == 0) {
    		x+=0.05;
    	}else if(rand == 1) {
    		x-=0.05;
    	}else if(rand == 2) {
    		y+=0.05;
    	}else if(rand == 3){
    		y-=0.05;
    	}
    	
    	if((x<=0.15 || y<=0.15) || (x >= 0.75 || y >= 0.75)) {
        	 if(rand == 0) {
        		 x-=0.05;
        	 }else if(rand == 1) {
        		 x+=0.05;
        	 }else if(rand == 2) {
        		 y-=0.05;
        	 }else if(rand == 3) {
        		 y+=0.05;
        	 }
        }
    	BigDecimal bd_x = new BigDecimal(x).setScale(2, RoundingMode.HALF_UP);
        x = bd_x.doubleValue();
        BigDecimal bd_y = new BigDecimal(y).setScale(2, RoundingMode.HALF_UP);
        y = bd_y.doubleValue();
	}

	public String getImg() {
		return ghostImg;
	}
	public void setImage(String image) {
		this.ghostImg = image;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void show(){
		Move();
		StdDraw.picture(x, y,Img);
    }
}
