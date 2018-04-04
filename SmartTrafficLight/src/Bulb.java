import java.awt.Color;

public class Bulb {

	private boolean on;
	private Color color;
	private String colorName;
	
	//constructor
	public Bulb(boolean on) {
		this.on=on;
	}
	public Bulb(boolean on,Color c, String cn) {
		this.on=on;
		color=c;
		colorName=cn;
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
	
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String cn) {
		colorName=cn;
	}
	
	
	public void turnOn() {
		on=true;
	}
	
	public void turnOff() {
		on=false;
	}
	
	public String toString() {
		return "The "+getColorName()+((on) ? " light is on.":" light is off.");
		
	}
	
	
}
