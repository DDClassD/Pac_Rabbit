package pac_rabbit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener{
	public static final int LABEL_WIDTH=16;
	public static final int LABEL_HEIGHT=16;
	public static final int TOTAL_ROWS=31; 
	public static final int TOTAL_COLS=28; 
	public static final int GAMEPANEL_WIDTH=448;
	public static final int GAMEPANEL_HEIGHT=496;
	public static int TURTLE_COUNT=3;
	public static int size_x=26;
	public static int size_y=26;
	public Vector<turtle> turtles=new Vector<turtle>();
	public Image back_img=Toolkit.getDefaultToolkit().getImage("image/background.png");
	public BlockLabel[][] blockLabels=new BlockLabel[TOTAL_ROWS][TOTAL_COLS];
	public rabbit rabbiit;
	boolean flag=false; 
	boolean rabbit_isHitted=false; 
	public ScorePanel sPanel;
	public boolean isGameOver=false; 
	public boolean isWin=false; 
	public boolean egg,egg_0,egg_1,egg_2=false;
	public int direction = 0;
	public static int blocks[][]={
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,3,2,2,2,2,2,2,2,3,2,2,3,2,2,3,2,2,3,2,2,2,2,2,2,2,3,0},
			{0,2,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,2,0},
			{0,5,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,5,0},
			{0,2,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,2,0},
			{0,2,0,0,0,0,0,0,0,2,0,0,3,2,2,3,0,0,2,0,0,0,0,0,0,0,2,0},
			{0,2,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,2,0},
			{0,2,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,2,0},
			{0,3,2,2,2,2,3,2,2,3,0,0,2,0,0,2,0,0,3,2,2,3,2,2,2,2,3,0},
			{0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,3,2,2,3,3,3,3,2,2,3,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,0,0,1,1,0,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,3,3,3,3,3,3,0,2,0,0,2,0,0,0,0,0,0},
			{1,1,1,1,1,1,3,2,2,3,0,3,1,1,1,1,3,0,3,2,2,3,1,1,1,1,1,1},
			{0,0,0,0,0,0,2,0,0,2,0,3,3,3,3,3,3,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,3,2,2,2,2,2,2,2,2,3,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0},
			{0,3,2,2,2,2,3,2,2,3,2,2,3,0,0,3,2,2,3,2,2,3,2,2,2,2,3,0},
			{0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
			{0,2,0,0,0,0,2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,2,0,0,0,0,2,0},
			{0,3,5,3,2,2,3,2,2,2,2,2,3,2,2,3,2,2,2,2,2,3,2,2,3,5,3,0},
			{0,2,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,2,0},
			{0,2,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,2,0},
			{0,3,2,3,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,3,2,3,0},
			{0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0},
			{0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0},
			{0,3,2,2,2,2,2,2,2,2,2,2,3,2,2,3,2,2,2,2,2,2,2,2,2,2,3,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	}; 

	public GamePanel(GameFrame gameFrame,ScorePanel sPanel){
		blocks[3][1]=5;blocks[3][26]=5;blocks[23][2]=5;blocks[23][25]=5;
		this.sPanel=sPanel;
		this.setLayout(new GridLayout(TOTAL_ROWS,TOTAL_COLS)); 
		assign(blocks);
		rabbiit = new rabbit(Toolkit.getDefaultToolkit().getImage("image/eater_0_r.png"), LABEL_HEIGHT+LABEL_HEIGHT/2-size_x/2,LABEL_HEIGHT+LABEL_HEIGHT/2-size_y/2, size_x, size_y, 0, 0);
		for (int i = 1; i <= TURTLE_COUNT; i++) {
			turtles.add(new turtle(Toolkit.getDefaultToolkit().getImage("image/enemy0"+i+".png"), LABEL_HEIGHT*13+LABEL_HEIGHT/2-size_x/2, LABEL_HEIGHT*15+LABEL_HEIGHT/2-size_x/2, size_x, size_y, 0, -1));
		}
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(back_img, 0,0,448, 496, this);
		rabbiit.draw(g);
		for (int i = 0; i < turtles.size(); i++) {
			turtles.get(i).draw(g);
		}

		if(flag&&!isGameOver){
			g.setColor(Color.WHITE);
			g.setFont(new Font("",Font.BOLD,30));
			g.drawString("ready!",180 , 240);
			flag=false;
		}

		if(isGameOver){
			g.setColor(Color.WHITE);
			g.setFont(new Font("",Font.BOLD,60));
			g.drawString("GAME OVER", GAMEPANEL_WIDTH/2-180, GAMEPANEL_HEIGHT/2);
		}

		if(isWin){
			g.setColor(Color.WHITE);
			g.setFont(new Font("",Font.BOLD,60));
			g.drawString("SUCCESS", GAMEPANEL_WIDTH/2-145, GAMEPANEL_HEIGHT/2);
		}
		

	}
	public void action(){
		while(!isGameOver && !isWin){
			if((rabbiit.x+rabbiit.width/2-LABEL_WIDTH/2)%LABEL_WIDTH == 0 && (rabbiit.y+rabbiit.height/2-LABEL_HEIGHT/2)%LABEL_HEIGHT == 0){
				rabbiit.last_xStep=rabbiit.xStep;
				rabbiit.last_yStep=rabbiit.yStep;
				changeDirect(direction);
				rabbiit.preventOutOfWall(blockLabels,LABEL_WIDTH,LABEL_HEIGHT);
				rabbiit.preventOutOfWall(blockLabels,LABEL_WIDTH,LABEL_HEIGHT);
				sPanel.score += rabbiit.getScore(blockLabels,LABEL_WIDTH,LABEL_HEIGHT);
				sPanel.action();
			}
			rabbiit.move();
			if(turtle.isEat){
				if(turtle.time>300){
					turtle.isEat=false;
					turtle.time=0;
				}
				else {turtle.time++;
					for (int i = 0; i < turtles.size(); i++) { 
						turtles.get(i).isEat();					
						if(turtle.time>=300 || turtles.get(i).isDie){
							turtles.get(i).img=turtles.get(i).img_old;
						}
					}
				}
			}
			
			for (int i = 0; i < turtles.size(); i++) { 
				if((turtles.get(i).x+turtles.get(i).width/2-LABEL_WIDTH/2)%LABEL_WIDTH == 0 && (turtles.get(i).y+turtles.get(i).height/2-LABEL_HEIGHT/2)%LABEL_HEIGHT == 0){
					turtles.get(i).randomChangeDirect();
					turtles.get(i).preventOutOfWall(blockLabels,LABEL_WIDTH,LABEL_HEIGHT);
					turtles.get(i).preventOutOfWall(blockLabels,LABEL_WIDTH,LABEL_HEIGHT);
				}
				turtles.get(i).move();
			}

			for(int i=0;i<turtles.size();i++){
				turtle enemy=turtles.get(i);
				
				if(rabbiit.hittedByTurtle(enemy) && !isGameOver &&!isWin){ 
				if(turtle.isEat){
						enemy.img=enemy.img_old;
						enemy.isDie=true;
						enemy.x=LABEL_HEIGHT*13+LABEL_HEIGHT/2-size_x/2;
						enemy.y=LABEL_HEIGHT*15+LABEL_HEIGHT/2-size_x/2;
						
					}else
						rabbit_isHitted=true;
				}
				if(rabbit_isHitted){
					rabbit.life--; 
					rabbiit.x=LABEL_HEIGHT+LABEL_HEIGHT/2-size_x/2;
					rabbiit.y=LABEL_HEIGHT+LABEL_HEIGHT/2-size_y/2;
					if(rabbit.life==0){
						isGameOver=true; 
						rabbiit.y=-100;
						rabbiit.yStep=0;
						

					}else{
						
					}
					rabbit_isHitted=false;
					flag=true; 
					sPanel.action(); 
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					turtles.clear();
					for (int j = 1; j <= TURTLE_COUNT; j++) {
						turtles.add(new turtle(Toolkit.getDefaultToolkit().getImage("image/enemy0"+j+".png"), LABEL_HEIGHT*13+LABEL_HEIGHT/2-size_x/2, LABEL_HEIGHT*15+LABEL_HEIGHT/2-size_x/2, size_x, size_y, 0, -1));
					}
					repaint();

					

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
			}

			if(sPanel.score==2680+10){
				isWin=true;
				
			}
			
			if(rabbiit.x==251 && rabbiit.y==203){
				egg_0=true;
			}
			if(egg_0 && rabbiit.x==251 && rabbiit.y==235 ){
				egg_0=false;
				egg_1=true;
			}
			if(egg_1 && rabbiit.x==171 && rabbiit.y==235){
				egg_2=true;
				egg_1=false;
			}
			if(egg_2 && rabbiit.x==171 && rabbiit.y==203){
				egg=true;
				egg_2=false;
				repaint();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {						
					e.printStackTrace();
				}
			}
			egg=false;
			repaint();
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void assign(int[][] blocks){
		for(int i=0;i<TOTAL_ROWS;i++){
			for(int j=0;j<TOTAL_COLS;j++){
				blockLabels[i][j]=new BlockLabel(i,j);
				if(blocks[i][j]==0){
					blockLabels[i][j].setIcon(new ImageIcon("image/blank.png"));
					blockLabels[i][j].isGone = false;
					blockLabels[i][j].label_score=0;
				}else if(blocks[i][j]==2){
					blockLabels[i][j].setIcon(new ImageIcon("image/food.png"));
					blockLabels[i][j].isGone = true;
					blockLabels[i][j].label_score=10;
				}
				else if(blocks[i][j]==1){
					blockLabels[i][j].isGone = true;
					blockLabels[i][j].label_score=0;
				}
				else if(blocks[i][j]==3){
					blockLabels[i][j].setIcon(new ImageIcon("image/food.png"));
					blockLabels[i][j].isGone = true;
					blockLabels[i][j].label_score=10;
				}else if(blocks[i][j]==5){
					blockLabels[i][j].setIcon(new ImageIcon("image/food_B.png"));
					blockLabels[i][j].isGone = true;
					blockLabels[i][j].label_score=10;
				}
				this.add(blockLabels[i][j]);

			}
		}
	}

	public void changeDirect(int direction){
		switch(direction){
		case 0:
			rabbiit.xStep=0;
			rabbiit.yStep=0;
			break;
		case 1:
			rabbiit.xStep=0;
			rabbiit.yStep=-2;
			rabbiit.udlr='u';
			break;
		case 2:
			rabbiit.xStep=0;
			rabbiit.yStep=2;
			rabbiit.udlr='d';
			break;
		case 3:
			rabbiit.xStep=-2;
			rabbiit.yStep=0;
			rabbiit.udlr='l';
			break;
		case 4:
			rabbiit.xStep=2;
			rabbiit.yStep=0;
			rabbiit.udlr='r';
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!isWin && !isGameOver){
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				direction = 1;
				break;
			case KeyEvent.VK_DOWN:
				direction = 2;
				break;
			case KeyEvent.VK_LEFT:
				direction = 3;
				break;
			case KeyEvent.VK_RIGHT:
				direction = 4;
				break;
			case KeyEvent.VK_W:
				direction = 1;
				break;
			case KeyEvent.VK_S:
				direction = 2;
				break;
			case KeyEvent.VK_A:
				direction = 3;
				break;
			case KeyEvent.VK_D:
				direction = 4;
				break;

			}
		}else{
			switch(e.getKeyCode()){
			case KeyEvent.VK_SPACE:
				direction = -1;
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}


}