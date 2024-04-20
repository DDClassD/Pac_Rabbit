package pac_rabbit;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class GameFrame extends JFrame{ 
	public static final int FRAMEWIDTH=448+6;
	public static final int FRAMEHEIGHT=496+35+50+30; 
	
	public GameFrame(){ 
		this.setTitle("Pac_Rabbit");
		
		this.setSize(FRAMEWIDTH,FRAMEHEIGHT); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ScorePanel sPanel =new ScorePanel(); 
		this.add(sPanel,BorderLayout.CENTER); 
		GamePanel gPanel=new GamePanel(this,sPanel); 
		this.add(gPanel,BorderLayout.NORTH); 
		this.setResizable(false); 
		this.setLocationRelativeTo(null); 
		this.setVisible(true);
		
		gPanel.action();
		
		for(;;){
			if (gPanel.direction==-1)
				break;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}				
	}	
}