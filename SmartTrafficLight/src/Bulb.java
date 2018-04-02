import java.awt.Color;

public class Bulb {

	private boolean on;
	private Color color;
	private String colorName;
	
	//constructor
	public Bulb(boolean on) {
		this.on=on;
	}
	public Bulb(boolean on,Color c, String name) {
		this.on=on;
		this.color=c;
		this.colorName=name;
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
		this.color=c;
	}
	
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String cn) {
		this.colorName=cn;
	}
	
	
	public void turnOn() {
		this.on=true;
	}
	
	public void turnOff() {
		this.on=false;
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
