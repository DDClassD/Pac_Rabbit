package pac_rabbit;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;

public class rabbit extends MovingObject{
	public static int life=3;
	public int time=0;
	public char udlr='r';
	public int restart_delay_count=0;

	public rabbit(Image img, int x, int y, int width, int height, int xStep, int yStep) {
		super(img, x, y, width, height, xStep, yStep);
		
	}
	public void draw(Graphics g){ 
		switch (time%12) {
		case 0:
			this.img=Toolkit.getDefaultToolkit().getImage("image/eater_0_"+udlr+".png");
			break;
		case 4:
			this.img=Toolkit.getDefaultToolkit().getImage("image/eater_1_"+udlr+".png");
			break;
		
		default:
			break;
		}
		time++;
		g.drawImage(this.img,this.x,this.y,this.width,this.height,null);
	}
	
	public boolean hittedByTurtle(turtle enemy) {
		return (this.x-enemy.x>=-this.width+4 && this.x-enemy.x<=enemy.width-4 &&
				   this.y-enemy.y>=-this.height+4 && this.y-enemy.y<=enemy.height-4 );
	}
	
	public int getScore(BlockLabel[][] blockLabels, int w, int h){
		int y = (this.x+this.width/2-w/2)/w;
		int x = (this.y+this.height/2-h/2)/h;
		blockLabels[x][y].setIcon(new ImageIcon("image/blank.png"));
		int score = blockLabels[x][y].label_score;
		blockLabels[x][y].label_score=0;
		
		if(GamePanel.blocks[x][y]==5){
			turtle.isEat=true;
			GamePanel.blocks[x][y]=1;
		}
		return score;
	}
	
}
