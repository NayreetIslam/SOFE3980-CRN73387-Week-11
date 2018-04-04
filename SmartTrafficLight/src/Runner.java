import javax.swing.*;

public class Runner {

	public static void main(String[] args) {

		// Creating a frame for the traffic light
		JFrame frame=new JFrame("Traffic Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TrafficLightPanel panel= new TrafficLightPanel();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		//smart.readDataFromFile();
	}
}
