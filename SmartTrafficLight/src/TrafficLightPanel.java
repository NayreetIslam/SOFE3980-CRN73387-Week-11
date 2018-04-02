package somePackage;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightPanel extends JPanel implements Runnable{

	//instance fields
	private TrafficLight light;
	private final int X=60, Y=50, WIDTH=50, HEIGHT=130;
	private final int DIAMETER=30;
	private final int X_OFFSET=10,Y_OFFSET=10;
	Thread traffic;
    int signalFlag;
    String signalName="";
    SmartTrafficInterval smart;
    int lane1Time;
    int lane2Time;
    String trafficCondition="";
    Bulb[] bulbs;
	
	
	//constructors 
	public TrafficLightPanel() {
		//setup a blank page and initialize variable
		light=new TrafficLight();
		signalName="Stop";
		lane1Time=10000;
		lane2Time=10000;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(280,220));
		signalName= new String();
		smart=new SmartTrafficInterval();
        signalFlag=1;
        traffic= new Thread(this);
        traffic.start();
        bulbs = new Bulb[3];
		bulbs = light.getLights();
		
	}
	
	//methods
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		//default to dark_gray
		page.setColor(Color.LIGHT_GRAY);
		page.fillRect(X, Y, WIDTH, HEIGHT);
		
		
		//draw the red light
		if(light.indexOfLitBulb()==0) {
			page.setColor(bulbs[0].getColor());
		}else {
			page.setColor(Color.DARK_GRAY);
		}
		page.fillOval(X+X_OFFSET, Y+Y_OFFSET, DIAMETER, DIAMETER);
		
		//draw the yellow light
		if(light.indexOfLitBulb()==1) {
			page.setColor(bulbs[1].getColor());
		}else {
			page.setColor(Color.DARK_GRAY);
		}
		page.fillOval(X+X_OFFSET, Y+DIAMETER+2*Y_OFFSET, DIAMETER, DIAMETER);
		
		//draw the green light
		if(light.indexOfLitBulb()==2) {
			page.setColor(bulbs[2].getColor());
		}else {
			page.setColor(Color.DARK_GRAY);
		}
		page.fillOval(X+X_OFFSET, Y+2*DIAMETER+3*Y_OFFSET, DIAMETER, DIAMETER);
		
		//print text messages
		page.setColor(Color.BLACK);
		page.drawString(signalName,135, 118);
		page.drawString("Lane1 Signal Time "+lane1Time,135, 138);
		page.drawString("Lane2 Signal Time "+lane2Time,135, 158);
		page.drawString(trafficCondition+" Traffic Predicted",135, 178);
		
	}//end of method
	
	
	public void run() {
       
		//System.out.println("Thread started");
		lane1Time=(int) (lane1Time+lane1Time*smart.getSmartSignalTime());
		if(lane1Time>15000) lane1Time=15000;
		lane2Time=20000-lane1Time;
		if(lane2Time<5000) lane2Time=5000;
		
		if(smart.getTrafficCondition()==1) {trafficCondition="Medium";}
		else if(smart.getTrafficCondition()==2) {trafficCondition="Light";}
		else {trafficCondition="Heavy";}
		
		//loop forever, redrawing things.
		while(true) {
			try {
				if(light.indexOfLitBulb()==0) {
					Thread.sleep(lane2Time);
					signalName="GO";
					
				}
				else if(light.indexOfLitBulb()==1) {
					Thread.sleep(1000);
					signalName="STOP";
				}	
				else if(light.indexOfLitBulb()==2) {
					Thread.sleep(lane1Time);
					signalName="SLOW";
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			light.nextState();
			repaint();	
		}
    }
	
	private class ChangeListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			light.nextState();
			repaint();
		}
		
	}
}//end of class
