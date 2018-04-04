import java.awt.Color;

public class Bulb {

	private boolean on;
	private Color color;
	private String colorName;
	
	//constructor
	public Bulb(boolean on) {
		this.on = on;
	}
	
	public Bulb(boolean on,Color c, String cn) {
		this.on = on;
		color = c;
		colorName = cn;
	}
	// great job
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
		color = c;
	}
	// code seems to be pretty good
	public String getColorName() {
		return colorName;
	}
	
	public void setColorName(String cn) {
		colorName = cn;
	}
	// Good code 
	public void turnOn() {
		on = true;
	}
	
	public void turnOff() {
		on = false;
	}
	
	public String toString() {
		if(on) {
			return "The "+getColorName()+" light is on.";
		}
		else {
			return "The "+getColorName()+" light is off.";
		}
	}
	
	
}
