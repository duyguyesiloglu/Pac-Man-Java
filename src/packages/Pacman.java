package packages;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pacman {
	private String Img;
	private String pacmanLeftImg;
	private String pacmanRightImg;
	private String pacmanUpImg;
	private String pacmanDownImg;
	private double x;
    private double y;
   // private String direction;
    
    public Pacman() {
    	x=0.15;
    	y=0.15;
    	pacmanRightImg="src\\pacmanright.png";
    	pacmanLeftImg = "src\\pacmanleft.png";
    	pacmanDownImg = "src\\pacmandown.png";
    	pacmanUpImg = "src\\pacmanup.png";
    	Img = pacmanRightImg;
    }
    public String getImg() {
    	return pacmanRightImg;
    }
    public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
        return x;
    }

    public double getY() {;
        return y;
    }
    
    
    public void Move(String direction){
        if(direction == "right"){
            if(x <= 0.8)
                x = x + 0.05;
            else if(x>=0.8 &&  y<=0.55 && y>=0.45) {
            	x=0.15;
            }
            Img = pacmanRightImg;
        }
        else if (direction == "left"){
            if(x > 0.15)
                x = x - 0.05;
            else if(x<=0.15 && y<=0.55 && y>=0.45) {
            	x=0.85;
            }
            Img = pacmanLeftImg;
        }
        else if(direction == "up") {
            if(y <= 0.8)
                y = y + 0.05;
            else if(y>=0.8 && x>=0.45 && x<=0.55) {
            	y=0.15;
            }
            Img = pacmanUpImg;
        }
        else if (direction == "down") {
            if(y > 0.15)
                y = y - 0.05;
            else if(y<=0.15 && x>=0.45 && x<=0.55) {
            	y=0.85;
            }
            Img = pacmanDownImg;
        }

        BigDecimal bd_x = new BigDecimal(x).setScale(2, RoundingMode.HALF_UP);
        x = bd_x.doubleValue();
        BigDecimal bd_y = new BigDecimal(y).setScale(2, RoundingMode.HALF_UP);
        y = bd_y.doubleValue();
        show();
    }
    
	public void show() {
		StdDraw.picture(x, y, Img, 0.05, 0.05);
	}

	


}
