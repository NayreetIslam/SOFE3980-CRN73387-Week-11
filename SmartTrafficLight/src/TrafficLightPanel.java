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
    
	//constructors 
	public TrafficLightPanel() {
		light=new TrafficLight();
		//JButton changeButton = new JButton("Change Light");
		//changeButton.addActionListener(new ChangeListener());
		//add(changeButton);
		signalName="Stop";
		//JLabel lable1= new JLabel(signalName);
		//add(lable1);
		lane1Time=10000;
		lane2Time=10000;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(280,220));
		signalName= new String();
		smart=new SmartTrafficInterval();
        signalFlag=1;
        //f= new Font("Arial",Font.BOLD,50);
        traffic= new Thread(this);
        traffic.start();
		
	}
	
	//methods
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.setColor(Color.LIGHT_GRAY);
		page.fillRect(X, Y, WIDTH, HEIGHT);
		//draw the red light
		
		switch(light.indexOfLitBulb()) {
		case 0:
			page.setColor(Color.RED);
			break;
		case 1:
			page.setColor(Color.YELLOW);
			break;
		case 2:
			page.setColor(Color.GREEN);
			break;
		default:
			page.setColor(Color.DARK_GRAY);
			break;
		}
		
		page.fillOval(X+X_OFFSET, Y+Y_OFFSET, DIAMETER, DIAMETER);
		page.fillOval(X+X_OFFSET, Y+DIAMETER+2*Y_OFFSET, DIAMETER, DIAMETER);
		page.fillOval(X+X_OFFSET, Y+2*DIAMETER+3*Y_OFFSET, DIAMETER, DIAMETER);
		
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
		
		
		for(;;) {
			try {
				
				switch(light.indexOfLitBulb()) {
				case 0:
					Thread.sleep(lane2Time);
					signalName="GO";
					break;
				case 1:
					Thread.sleep(1000);
					signalName="STOP";
					break;
				case 2:
					Thread.sleep(lane1Time);
					signalName="SLOW";
					break;
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
