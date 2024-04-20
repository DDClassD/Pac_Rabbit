package pac_rabbit;

import java.awt.Graphics;
import java.awt.Image;

public class MovingObject {
	public Image img; 
	public int x; 
	public int y; 
	public int width;
	public int height; 
	public int xStep; 
	public int yStep;
	public int arrayX,arrayY;
	public int last_xStep;
	public int last_yStep;
	public MovingObject(Image img, int x, int y, int width, int height, int xStep, int yStep) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.xStep = xStep;
		this.yStep = yStep;
	}
	public void draw(Graphics g){ 
		g.drawImage(this.img,this.x,this.y,this.width,this.height,null);
	}

	public  void move(){
		if(this.x > GamePanel.LABEL_WIDTH*GamePanel.TOTAL_COLS-this.width  && this.xStep > 0)
			this.x=0-this.width/2+GamePanel.LABEL_WIDTH/2;
		else if(this.x <= 0 && this.xStep < 0)
			this.x=GamePanel.LABEL_WIDTH*GamePanel.TOTAL_COLS-GamePanel.LABEL_WIDTH/2-this.width/2;
		if(this.y > GamePanel.LABEL_HEIGHT*GamePanel.TOTAL_ROWS-this.height && this.yStep > 0)
			this.y=0-this.height/2+GamePanel.LABEL_HEIGHT/2;
		else if(this.y<=0 && this.yStep < 0)
			this.y=GamePanel.LABEL_HEIGHT*GamePanel.TOTAL_ROWS-GamePanel.LABEL_HEIGHT/2-this.height/2;
		this.x += xStep;
		this.y += yStep;
	}

	public void preventOutOfWall(BlockLabel[][] blockLabels,int w,int h){
		int y = (this.x+this.width/2-w/2)/w;
		int x = (this.y+this.height/2-h/2)/h;
		if(this.xStep < 0){
			y--;
			if(! blockLabels[x][y].isGone){
				this.xStep=0;
				this.yStep=last_yStep;			
			}
		}
		else if(this.xStep > 0){
			y++;
			if(! blockLabels[x][y].isGone){
				this.xStep=0;
				this.yStep=last_yStep;
			}
		}
		else if(this.yStep < 0){
			x--;
			if(! blockLabels[x][y].isGone){
				this.yStep=0;
				this.xStep=last_xStep;
			}
		}
		else if(this.yStep > 0){
			x++;
			if(! blockLabels[x][y].isGone){
				this.yStep=0;
				this.xStep=last_xStep;

			}
		}
	}
}