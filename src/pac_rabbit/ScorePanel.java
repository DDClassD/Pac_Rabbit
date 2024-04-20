package pac_rabbit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
//得分面板
@SuppressWarnings("serial")
public class ScorePanel extends JPanel{
	public Image img=Toolkit.getDefaultToolkit().getImage("image/eater_0_l.png");
	public int life_count=5; 
	public int score;
	public ScorePanel(){
		rabbit.life=5;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("",Font.BOLD,20));
		setBackground(Color.GREEN);



		g.drawString("P2104712 VU CHI FEI",15 , 60);
		g.drawString("Lives:",15 , 30);
		for(int i=0;i<rabbit.life;i++){
			g.drawImage(img, 270+i*35,8, 30,30,null);
		}

	} 
	public void action(){
		repaint();
	}
}