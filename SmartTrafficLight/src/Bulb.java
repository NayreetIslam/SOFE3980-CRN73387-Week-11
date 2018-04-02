import java.awt.Color;

public class Bulb {

	private boolean on;
	private Color color;
	
	//constructor
	public Bulb(boolean on) {
		this.on=on;
	}
	public Bulb(boolean on,Color c) {
		this.on=on;
		color=c;
	}
	
	
	public boolean isOn(){
		return on;
	}
	
	public boolean isOff(){
		return !on;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color c) {
		color=c;
	}
	
	public void turnOn() {
		on=true;
	}
	
	public void turnOff() {
		on=false;
	}
	
}
