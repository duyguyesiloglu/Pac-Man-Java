package packages;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PlayGround{

	
	private int score;
	private int health;
	private Pacman pacman;
	private Ghost ghost;
	private Cherry cherry;
	private Banana banana;
	private Point point;
	private Strawberry strawberry;
	    
	private double top = 0.9;
	private double bottom = 0.1;
	private double left = 0.1;
	private double right = 0.9;  
	 
	private String direction;
	private String heartImg = "src\\heart.png";
	
	public PlayGround(Pacman pacman, Ghost ghost, Cherry cherry, Banana banana,Point point,Strawberry strawberry) {
	        this.pacman = pacman;
	        this.ghost = ghost;
	        this.cherry = cherry;
	        this.banana = banana;
	        this.point = point;
	        this.strawberry = strawberry;
	        score=0;
	        health=3;
	        direction="";
	        while(true) {
	        	startScreen();
		        play();	
	        }      
	}
	public void startScreen(){
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledRectangle(0.5, 0.5, 0.5,0.5);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.text(0.5,0.9, "WELCOME TO PACMAN!");
        StdDraw.text(0.5,0.8, "You can move with using the arrow keys.");
        StdDraw.text(0.5,0.7, "You need to take 300 score to win.");
        StdDraw.text(0.5,0.6, "Cherry has 10 score point.");
        StdDraw.text(0.5,0.5, "Banana has 25 score point.");
        StdDraw.text(0.5,0.4, "Strawberry has 50 score point.");
        StdDraw.text(0.5,0.3, "Press Space key to start.");

        StdDraw.text(0.1,0.1, "Cherry:");
        StdDraw.picture(0.18, 0.1, cherry.getImg());
        StdDraw.text(0.31,0.1, "Strawberry:");
        StdDraw.picture(0.42, 0.1, strawberry.getImg());
        StdDraw.text(0.52,0.1, "Banana:");
        StdDraw.picture(0.62, 0.1, banana.getImg());
        StdDraw.text(0.7,0.1, "Ghost:");
        StdDraw.picture(0.8, 0.1, ghost.getImg());
        while (true){
            if(StdDraw.isKeyPressed(32)){
                draw();
                break;
            }
        }
    }

	public void draw(){
	
		 //Drawing border
        	StdDraw.setPenColor(StdDraw.YELLOW);
        	StdDraw.filledRectangle(0.5, 0.5,0.5,0.5);
        	StdDraw.setPenColor(StdDraw.BLACK);
        	StdDraw.filledRectangle((top + bottom)/2, (right + left)/2, (top-bottom)/2, (right-left)/2);
		 	StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		 	StdDraw.setPenRadius(0.01);
        	StdDraw.rectangle((top + bottom)/2, (right + left)/2, (top-bottom)/2, (right-left)/2);
        	
	    	//StdDraw.rectangle(0.5, 0.55, 0.45, 0.40);
	    	StdDraw.text(0.1, 0.05, "Score :");
	    	StdDraw.text(0.65, 0.05, "Health :");
	    	
	    	if(score >= 0) {
	    		String temp = "0";
	    		temp = String.valueOf(score);
	    		StdDraw.text(0.18 , 0.05, temp);
	    	}
	    	if(score>=300) { 
	        	 StdDraw.clear();
	             StdDraw.setPenColor(StdDraw.YELLOW);
	             StdDraw.filledRectangle(0.5, 0.5, 0.5,0.5);
	             StdDraw.setPenColor(StdDraw.BOOK_BLUE);
	             StdDraw.text(0.5, 0.5, "YOU WON THE GAME!");
	             StdDraw.show();
	             draw();
	         }
	       	//Health Section
	        if(health <= 0 ) { 
	           	 StdDraw.clear();
	             StdDraw.setPenColor(StdDraw.CYAN);
	             StdDraw.filledRectangle(0.5, 0.5, 0.5,0.5);
	             StdDraw.setPenColor(StdDraw.BOOK_BLUE);
	             StdDraw.text(0.5, 0.5, "YOU LOSE!");
	             StdDraw.text(0.5,0.4,"Score : " + String.valueOf(score));
	             StdDraw.show();
	             draw();
	       	} 
	    	if(health ==1) {
	    		StdDraw.picture(0.75,0.055,heartImg);
	    	}else if(health == 2) {
	    		StdDraw.picture(0.75,0.055,heartImg);
	    		StdDraw.picture(0.8,0.055,heartImg);
	    	}
	    	else if(health == 3){
	    		StdDraw.picture(0.75,0.055,heartImg);
	    		StdDraw.picture(0.8,0.055,heartImg);
	    		StdDraw.picture(0.85,0.055,heartImg);
	    	}

	    	
	    	
	    	//SETTING AND CHECKING POINTS
	    	int a = 0;
	    	double temp1,temp2;
	    	for(double i=bottom+0.05;i<=top;i+=0.05,a++) {
	    		int b=0;
	    		for(double j=left+0.05;j<right;j+=0.05,b++) {
	    			if(!point.isPassed(a,b)){
	    				point.show(a, b);
	    				BigDecimal bd_x = new BigDecimal(i).setScale(2, RoundingMode.HALF_UP);
	    	            temp1 = bd_x.doubleValue();
	    				BigDecimal bd_y = new BigDecimal(j).setScale(2, RoundingMode.HALF_UP);
		    	        temp2 = bd_y.doubleValue();
	    				point.setArrX(a, b, temp2);
		    			point.setArrY(a, b, temp1);
	    			}
	    		}
	    	}
	         StdDraw.setPenColor(StdDraw.BOOK_BLUE);
	         //Teleport leftside
	         StdDraw.filledRectangle(left/2, (top-bottom) / 2+bottom, 0.05, 0.07);
	         //Teleport rightside
	         StdDraw.filledRectangle(1-left/2, (top-bottom) / 2+bottom, 0.05, 0.07);
	         //Teleport bottomside
	         StdDraw.filledRectangle((right-left)/2 + left, bottom/2,0.07, 0.05 );
	         //Teleport topside
	         StdDraw.filledRectangle((right-left)/2 + left, 0.95, 0.07, 0.05);
	         
	         
	}
	 
	 public void play() {
		 
		 StdDraw.enableDoubleBuffering();
	
    	 while (true) {
             if (StdDraw.isKeyPressed(39))
                 direction="right";
             else if (StdDraw.isKeyPressed(37))
                 direction="left";
             else if (StdDraw.isKeyPressed(38))
                 direction="up";
             else if (StdDraw.isKeyPressed(40))
                 direction="down";
                       
             StdDraw.clear();
             draw();
             StdDraw.pause(50);
             
             strawberry.show();
             cherry.show();
             banana.show();	
             ghost.show();
           
             pacman.Move(direction);
             StdDraw.show();
             StdDraw.pause(180);
             StdDraw.clear();
 	    	
             //If ghost was damaged pacman
             if((ghost.getX() == pacman.getX() && ghost.getY()==pacman.getY())) {
            	 health--;
            	 pacman.setX((top-bottom)/2);
            	 pacman.setY((right-left)/2);
            	 if(health == 0) {
            		 break;
            	 }
             }
          
             //If cherry and banana has the same spot
             cherry.checkPos(banana.getX(), banana.getY());
             //If banana and strawberry has the same spot
             banana.checkPos(strawberry.getX(), strawberry.getY());
             //If pacman ate cherry
             if(cherry.getX() == pacman.getX() && cherry.getY()==pacman.getY()) {
            	 score+=10;
            	 cherry.randPos();
             }
             //If pacman ate banana
             if(banana.getX() == pacman.getX() && banana.getY()==pacman.getY()) {
            	 score+=25;
            	 banana.randPos();
             }
             if(strawberry.getX() == pacman.getX() && strawberry.getY() == pacman.getY()) {
            	 strawberry.randPos();
            	score+=50;
             }
             
            //If pacman took the score 
             for(int i=0;i<15;i++) { // IF POINT WAS EATED FROM PACMAN
				 for(int j=0;j<15;j++) {
					 if(( point.getArrX(i, j) == pacman.getX() ) 
							 && ( point.getArrY(i, j) == pacman.getY())) {
						 point.setArrX(i, j, -1);
						 point.setArrY(i, j, -1);
						 score++;	 
					 }
				 }
			 }
             draw();
         }
	 }  	    
}
