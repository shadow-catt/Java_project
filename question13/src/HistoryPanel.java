import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HistoryPanel extends JPanel implements Serializable{
	//variable
	private Bank m;
	
	//Panel
	public HistoryPanel(Bank m) {
		this.m=m;
	}
	
	//method get the max
	public int historyMax(ArrayList<Integer> history) {
		int max;
		max = history.get(0);
		for(Integer i : history) {
			if(i>max) {
				max=i;
			}
		}
		return max;
	}
	//method get the min
	public int historyMin(ArrayList<Integer> history) {
		int min;
		min = history.get(0);
		for(Integer i : history) {
			if(i<min) {
				min=i;
			}
		}
		return min;
	}
	
	//method get the range
	public int historyRange(ArrayList<Integer> history) {
		int range;
		range=historyMax(history)-historyMin(history);
		if(range<100) {
			range=100;
		}
		return range;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//initial value
		int min = historyMin(m.getHistory());
		int range = historyRange(m.getHistory());
		int maxX = getWidth() - 1;
		int maxY = getHeight() - 1;
		int zero = maxY + min * maxY / range;
		int x0=0;
		int x1=0;
		int y0=0;
		int y1=0;
		
		//draw a zero axis
		g.setColor(Color.BLUE);
		g.drawLine(0, zero, maxX, zero);
		
		//draw the graph
		g.setColor(Color.RED);
		for(int i=0;i<m.getHistory().size();i++) {
			//initial value
			x0=x1;
			x1=10*i;
			y0=y1;
			y1=zero-m.getHistory().get(i)*maxY/historyRange(m.getHistory());
			
			//draw line
			if(i==0) {
				g.drawRect(x1,y1,1,1);
			}
			else
				g.drawLine(x0,y0,x1,y1);
		}
	}
}
