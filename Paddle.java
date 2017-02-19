
public class Paddle {
	/**
	 * Name: David Klein
	 * Date: 11/25/2016
	 * Assignment: #07
	 * Summary: This program creates the paddles for the MyGame.java two player Pong game
	 * 			and moves the paddles up or down with methods if called
	 */
	
	
	//Variables for the player 1's paddle (left paddle) and player 2's paddle (right paddle)
	//And the paddle's x and y location
	//And the vertical velocity to give the paddles when they move
	float p1x;
	float p1y;
	float p2x;
	float p2y;
	float pyv;
	
	//Constructor sets variables equal to input from MyGame.java file and creates object
	public Paddle(float p1x, float p1y, float p2x, float p2y, float pyv) {
		this.p1x = p1x;
		this.p1y = p1y;
		this.p2x = p2x;
		this.p2y = p2y;
		this.pyv = pyv;
	}
	
	//Moves player 1's paddle up by subtracting the velocity to its y position
	//The other methods to similar functions for the other possible paddle movements
	public void moveP1Up() {
		this.p1y -= pyv;
		if (p1y <= 0) {
			this.p1y = 0;
		}
	}
	
	public void moveP1Down() {
		this.p1y += pyv;
		if (p1y >= 350) {
			this.p1y = 350;
		}
	}
	
	public void moveP2Up() {
		this.p2y -= pyv;
		if (p2y <= 0) {
			this.p2y = 0;
		}
	}
	
	public void moveP2Down() {
		this.p2y += pyv;
		if (p2y >= 350) {
			this.p2y = 350;
		}
	}
	
	
}
