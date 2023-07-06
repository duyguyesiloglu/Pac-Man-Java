package packages;

public class Test {

	public static void main(String[] args){
		
		Pacman pacman = new Pacman();
		Ghost ghost = new Ghost();
		Cherry cherry = new Cherry();
		Banana banana = new Banana();
		Point point  = new Point();
		Strawberry strawberry = new Strawberry();
	    PlayGround playGround = new PlayGround(pacman, ghost, cherry, banana, point,strawberry);
		//PlayGround pg = new PlayGround();
	}
}
