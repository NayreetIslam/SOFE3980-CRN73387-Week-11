import java.awt.Color;

public class TrafficLight {
	//instance fields
	private Bulb[] lights;
	
	
	//constructors
	public TrafficLight() {
		lights = new Bulb[3];
		lights[0]= new Bulb(true, Color.RED,"red");
		lights[1]= new Bulb(false, Color.YELLOW,"yellow");
		lights[2]= new Bulb(false, Color.GREEN,"green");
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
		for (int i =0;I<lights.length;i++) {
			if(lights[i].isOn()) {
				lights[i].turnOff();
				lights[((i==0) ? (lights.length -1 =):i-1))].turnOn();
				
			}
			
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
