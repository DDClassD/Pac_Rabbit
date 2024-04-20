package pac_rabbit;

import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Image;
import java.awt.Toolkit;

public class turtle extends MovingObject {
	public int count=0;
	public int rcd=0;
	public static boolean isEat=false;
	public static int time=0;
	public Image img_old;
	public boolean isDie=false;
	public turtle(Image img, int x, int y, int width, int height, int xStep, int yStep) {
		super(img, x, y, width, height, xStep, yStep);
		arrayX =15;
		arrayY =13;
	}
	
	public  void isEat(){
		if(time==1){
			img_old=img;
			xStep*=-1;yStep*=-1;
		}
		img=Toolkit.getDefaultToolkit().getImage("image/enemy_0.png");
	}
	
	public void randomChangeDirect(){
		arrayY = (this.x+this.width/2-GamePanel.LABEL_WIDTH/2)/GamePanel.LABEL_WIDTH;
		arrayX = (this.y+this.height/2-GamePanel.LABEL_HEIGHT/2)/GamePanel.LABEL_HEIGHT;	
		if(GamePanel.blocks[arrayX][arrayY]==3){
			if(rcd<2)
				rcd++;
			else{
				if(xStep!=0){
					if(xStep>0){
						if(GamePanel.blocks[arrayX][arrayY+1]!=0){
							xStep=2-(int)(Math.random()*2)*2;
						}else xStep=0;
					}else if(xStep<0){
						if(GamePanel.blocks[arrayX][arrayY-1]!=0){
							xStep=-2+(int)(Math.random()*2)*2;
						}else xStep=0;
					}
					if(xStep==0){
						if(GamePanel.blocks[arrayX-1][arrayY]!=0 && GamePanel.blocks[arrayX+1][arrayY]!=0)
							yStep=-2+(int)(Math.random()*2)*4;
						else if(GamePanel.blocks[arrayX-1][arrayY]==0)
							yStep=2;
						else yStep=-2;
					}
				}else if(yStep!=0){
					if(yStep>0){
						if(GamePanel.blocks[arrayX+1][arrayY]!=0){
							yStep=2-(int)(Math.random()*2)*2;
						}else yStep=0;
					}else if(yStep<0){
						if(GamePanel.blocks[arrayX-1][arrayY]!=0){
							yStep=-2+(int)(Math.random()*2)*2;
						}else yStep=0;
					}
					if(yStep==0){
						if(GamePanel.blocks[arrayX][arrayY-1]!=0 && GamePanel.blocks[arrayX][arrayY+1]!=0)
							xStep=-2+(int)(Math.random()*2)*4;
						else if(GamePanel.blocks[arrayX][arrayY+1]==0)
							xStep=-2;
						else xStep=2;
					}
				}
			}
		}
	}
}