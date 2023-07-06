package packages;
import java.util.Random;

public class Fruit {

	private String Img ;
    private double x;
    private double y;

    public Fruit() {
    	Img = "";
    	randPos();
    	//x=0.2;
    	//y=0.6;
    }
    public void setImg(String img) { Img = img; }
    
    public String getImg() { return Img; }
    
    public void randPos() {
    	Random random = new Random();
    	int randoomx = random.nextInt(6) + 2;
    	int randoomy = random.nextInt(6) + 2;
        int randx = random.nextInt(2);
        int randy = random.nextInt(2);
        if(randoomx == 2) {
        	if(randx ==0) {
        		x=0.20;
        	}else {
        		x=0.25;
        	}
        }else if(randoomx == 3){
        	if(randx ==0) {
        		x=0.30;
        	}else {
        		x=0.35;
        	}
        }else if(randoomx == 4){
        	if(randx ==0) {
        		x=0.40;
        	}else {
        		x=0.45;
        	}
        }else if(randoomx == 5){
        	if(randx ==0) {
        		x=0.50;
        	}else {
        		x=0.55;
        	}
        }else if(randoomx == 6){
        	if(randx ==0) {
        		x=0.60;
        	}else {
        		x=0.65;
        	}
        }else if(randoomx == 7){
        	if(randx ==0) {
        		x=0.70;
        	}else {
        		x=0.75;
        	}
        }
        if(randoomy == 2) {
        	if(randy ==0) {
        		y=0.20;
        	}else {
        		y=0.25;
        	}
        }else if(randoomy == 3){
        	if(randy ==0) {
        		y=0.30;
        	}else {
        		y=0.35;
        	}
        }else if(randoomy == 4){
        	if(randy ==0) {
        		y=0.40;
        	}else {
        		y=0.45;
        	}
        }else if(randoomy == 5){
        	if(randy ==0) {
        		y=0.50;
        	}else {
        		y=0.55;
        	}
        }else if(randoomy == 6){
        	if(randy ==0) {
        		y=0.60;
        	}else {
        		y=0.65;
        	}
        }else if(randoomy == 7){
        	if(randy ==0) {
        		y=0.70;
        	}else {
        		y=0.75;
        	}
        }
        if(x>=0.75 || y>=0.75) {
        	randPos();
        }else if(x<=0.15 || y<=0.15) {
        	randPos();
        }

    }
    public void checkPos(double a,double b) {
    	
    	if(a == x && b == y) {
    		randPos();
    	}
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
	public void show() {
		StdDraw.picture(x, y, Img);
	}

}
