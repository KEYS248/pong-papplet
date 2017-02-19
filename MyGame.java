import processing.core.PApplet;

public class MyGame extends PApplet {
	
	/**
	 * Name: David Klein
	 * Date: 11/25/2016
	 * Assignment: #07
	 * Summary: This program creates a two player Pong game using PApplet and uses two other classes
	 * 		Paddle.java to create the player paddles and Projectile.java to create the ball
	 * 		Furthermore, due to the nature of PApplet it can only recognize a single key being pushed at once
	 * 			so only one paddle can move at a time.
	 * 
	 * 		Controls:
	 * 			Left hand paddle moves up using key: A
	 * 			Left hand paddle moves down using key: Z
	 * 			Right hand paddle moves up using key: K
	 * 			Right hand paddle moves down using key: M
	 * 			Manual reset of program using key: R
	 */
	
	//Initialize the ball object and both paddles in a single object from their respective classes
	Projectile ball;
	Paddle paddles;
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"MyGame"});
	}
	
	public void setup() {
		size(600, 400);
		frameRate(30);
		noStroke();
		reset();
		
	}
	
	//Draws the shapes in the program and background(0) continuously updates their locations
	//Collision is used to recognize if a paddle-ball collision has taken place
	//		and deals with it accordingly
	//If the ball reaches either the left or right end without hitting a paddle the game will reset 
	//		or if the player presses the R key
	public void draw() {
		background(0);
		drawCourt();
		drawBall();
		drawPaddles();
		collision();
		
		if (ball.x - 5 <= 0 || ball.x + 5 >= 600 || key == 'r') {
			reset();
		}
	}
	
	//Creates shapes in the middle to define the median
	//		and shapes on the top and bottom as the walls for ball to bounce off
	public void drawCourt() {
		fill(255);
	    noStroke();
	    rect(298, 10, 4, 15);
	    rect(298, 40, 4, 15);
	    rect(298, 70, 4, 15);
	    rect(298, 100, 4, 15);
	    rect(298, 130, 4, 15);
	    rect(298, 160, 4, 15);
	    rect(298, 190, 4, 15);
	    rect(298, 220, 4, 15);
	    rect(298, 250, 4, 15);
	    rect(298, 280, 4, 15);
	    rect(298, 310, 4, 15);
	    rect(298, 340, 4, 15);
	    rect(298, 370, 4, 15);
	    
	    stroke(0);
		rect(0, 0, 600, 1);
		stroke(0);
		rect(0, 399, 600, 1);
	}	
	
	//Creates the paddles using their object's variables to keep track of their real-time location
	//Calls the keyPressed method to see if the paddles should move
	public void drawPaddles() {
		stroke(255);
	    rect(paddles.p1x, paddles.p1y, 10, 50);
	    stroke(255);
	    rect(paddles.p2x, paddles.p2y, 10, 50);
	    keyPressed();
	}
	
	//Creates the ball using its object's variables to keep track of its real-time location
	//Balls method to create ball movement
	public void drawBall() {
		fill(255);
		ellipse(ball.x, ball.y, 10, 10);
		ball.moveBall();
	}
	
	//Recognizes if the ball and paddle make contact
	//		by seeing the ball's x and y position compared to the paddle's x and y location
	//		with the ball's diameter and the paddle's length taken into account 
	//Then has the ball move in the opposite direction if contact was made
	public void collision() {
		if (ball.x - 15 <= 0 && (ball.y <= paddles.p1y + 50 && ball.y >= paddles.p1y)) {
			ball.x = 15;
			ball.xSpeed *= -1;
		}
		else if (ball.x + 15 >= 600 && (ball.y <= paddles.p2y + 50 && ball.y >= paddles.p2y)) {
			ball.x = 585;
			ball.xSpeed *= -1;
		}
	}
	
	//Recognizes if the certain keys for moving both paddles up or down are pressed
	//		then calls their object function to move that paddle up or down accordingly
	public void keyPressed() {
		if (key == 'a') {
			paddles.moveP1Up();
		}
		if (key == 'z') {
			paddles.moveP1Down();
		}if (key == 'k') {
			paddles.moveP2Up();
		}
		if (key == 'm') {
			paddles.moveP2Down();
		}
	}
	
	//Resets the program
	//Giving the ball one of four possible starting directions
	//Recreates the ball and paddle's objects to reset them
	public void reset() {
		int sign1 = 1;
		if ((int) (Math.random() * 2) % 2 == 0) {
			sign1 = -1;
		}
		int sign2 = 1;
		if ((int) (Math.random() * 2) % 2 == 0) {
			sign2 = -1;
		}
		ball = new Projectile(300, 200, 10, 8 * sign1, 2 * sign2);
		paddles = new Paddle(0, 175, 590, 175, 6);
	}
}
