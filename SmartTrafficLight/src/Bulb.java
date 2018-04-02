import java.awt.Color;

public class Bulb {

	private boolean on;
	private Color color;
	private String colorName;
	
	//constructor
	public Bulb(boolean on) {
		this.on=on;
	}
	public Bulb(boolean on,Color color, String colorName) {
		this.on=on;
		this.color=color;
		this.colorName=colorName;
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
	public void setColor(Color color) {
		this.color=color;
	}
	
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName=colorName;
	}
	
	
	public void turnOn() {
		on=true;
	}
	
	public void turnOff() {
		on=false;
	}
	
	public String toString() {
		String result;
		if(on) {
			result="The "+getColorName()+" light is on.";
		}
		else {
			result="The "+getColorName()+" light is off.";
		}
		return result;
	}
	
	
}
