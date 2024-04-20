package pac_rabbit;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BlockLabel extends JLabel{
	public boolean isGone;
	public int rowNum; 
	public int colNum; 
	public int label_score;
	public BlockLabel(int rowNum, int colNum) {
		this.rowNum = rowNum;
		this.colNum = colNum;
	}
}
