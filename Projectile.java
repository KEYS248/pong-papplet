
public class Projectile {
	/**
	 * Name: David Klein
	 * Date: 11/25/2016
	 * Assignment: #07
	 * Summary: This program creates the ball for the MyGame.java two player Pong game
	 * 			and creates the physics for the ball's movement
	 * 			including its collision and bouncing off of edges of the program's frame
	 */
	
	//Variables for the ball's x and y position
	//The ball's width
	//And the ball's x and y velocity/movement
	float x;
	float y;
	float width;
	float xSpeed;
	float ySpeed;
	
	//Constructor sets variables equal to input from MyGame.java file and creates object
	public Projectile(float x, float y, float width, float xSpeed, float ySpeed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	//Creates the physics for the ball, continually adding/subtracting x velocity to x position
	//		and y velocity to the y position
	//If the ball reaches any end of the frame of the program it will invert that dimensional velocity
	//		so it can move in the opposite direction after the collision
    public void moveBall() {
        this.x += this.xSpeed;
        if (this.x >= 595) {
          this.x = 595;
          this.xSpeed *= -1;
        }
        if (this.x < 5) {
          this.x = 5;
          this.xSpeed *= -1;
        }
        this.y += this.ySpeed;
        if (this.y > 395) {
          this.y = 395;
          this.ySpeed *= -1;
        }
        if (this.y < 5) {
          this.y = 5;
          this.ySpeed *= -1;
        }
      }

}
