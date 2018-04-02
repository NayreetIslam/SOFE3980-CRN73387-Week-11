import java.awt.Color;

public class TrafficLight {
	//instance fields
	private Bulb[] lights;
	
	
	//constructors
	public TrafficLight() {
		lights = new Bulb[]{new Bulb(true, Color.RED,"red"), new Bulb(false, Color.YELLOW,"yellow"), new Bulb(false, Color.GREEN,"green")};	
	}
	
	//asscessors and mutators
	
	public Bulb[] getLights() {
		return lights;
	}
	public void setLights(Bulb[] lights) {
		this.lights=lights;
	}
	
	//algorithm for changing the traffic lights
	
	public void nextState() {
		// red to green
		if(lights[0].isOn()) {
			lights[0].turnOff();
			lights[2].turnOn();
		}
		// green to yellow
		else if(lights[2].isOn()) {
			lights[2].turnOff();
			lights[1].turnOn();
		}
		//yellow to red
		else if(lights[1].isOn()) {
			lights[1].turnOff();
			lights[0].turnOn();
		}
	}
	
	//index of bulb that is lit
	public int indexOfLitBulb() {
		int i=0;
		while(i < lights.length && lights[i].isOff()) {
			i++;
		}
		return i;
	}
	
	public String toString() {
		String result="";
		for(int i=0;i<lights.length;i++) {
			result+="Bulb "+(i+1)+" is "+lights[i].getColorName()+" and "
					+ lights[i].toString().toLowerCase()+"\n";
		}
		return result;
	}
}
