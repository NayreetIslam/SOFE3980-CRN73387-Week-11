package somePackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class SmartTrafficInterval {
	
	
	public int predictrafficCondition=1;
	
	public float getSmartSignalTime() {
		
		
		float currentTrafficAverage,totalTrafficAverage;
		
		float lane1=0,lane2=0,sumOfLane1=0,sumOfLane2=0;
		float average=0;
		int count=0,totalNumberOfSignals=0;
		float vehicleNumber=0;
		try {
			//Grab input from input from text and parse it.
            File f = new File("input.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
            	String[] currentLine = readLine.split("\\s+");   
            	
            	if(totalNumberOfSignals!=0) {
            		vehicleNumber+=Float.parseFloat(currentLine[3]);
                	vehicleNumber+=Float.parseFloat(currentLine[4]);
            	}
            	totalNumberOfSignals++;
            	
            	if(currentLine[1].equalsIgnoreCase(getCurrentDay())) {
            		if( getCurrentTimeInterval(currentLine[2]) == getCurrentTimeInterval()) {
            			sumOfLane1+=lane1=Float.parseFloat(currentLine[3]);
            			sumOfLane2+=lane2=Float.parseFloat(currentLine[4]);
            				++count;
            				average+=((lane1/lane2)-1);
            				System.out.println(average+" "+sumOfLane1+" "+sumOfLane2);
            		}
            	}	
            }
            
            System.out.println(average/count+" "+(sumOfLane1+sumOfLane2)/count+" "+vehicleNumber/totalNumberOfSignals);
            currentTrafficAverage=(sumOfLane1+sumOfLane2)/count;
            totalTrafficAverage=vehicleNumber/totalNumberOfSignals;
            
            if(Math.abs(currentTrafficAverage-totalTrafficAverage)<=4) {
            	predictrafficCondition=1;
    		}
    		else if(totalTrafficAverage>=currentTrafficAverage) {
    			predictrafficCondition=2;
    		}
    		else {
    			predictrafficCondition=3;
    		}
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return average/count;
	}
	
	public String getCurrentDay() {
		int day;
		Date today = Calendar.getInstance().getTime();
		day=today.getDay();
		String Name="";
		if (day==0) Name="Sunday";
		else if (day==1) Name="Monday";
		else if (day==2) Name="Tuesday";
		else if (day==3) Name="Wednesday";
		else if (day==4) Name="Thursday";
		else if (day==5) Name="Friday";
		else if (day==6) Name="Saturday";
		return Name;
	}
	
	public int getCurrentTimeInterval() {
		int currentHour,interval=0;
		Date today = Calendar.getInstance().getTime();
		currentHour=today.getHours();
		if (currentHour>=0 && currentHour<=2) interval=1;
		else if (currentHour>= 3 && currentHour<=5) interval=2;
		else if (currentHour>= 6 && currentHour<=8) interval=3;
		else if (currentHour>= 9 && currentHour<=11) interval=4;
		else if (currentHour>= 12 && currentHour<=14) interval=5;
		else if (currentHour>= 15 && currentHour<=17) interval=6;
		else if (currentHour>= 18 && currentHour<=20) interval=7;
		else if (currentHour>= 21 && currentHour<=23) interval=8;
		//System.out.println(currentHour);
		return interval;
	}
	
	
	public int getCurrentTimeInterval(String Hour) {
		int currentHour,interval=0;
		String Time = Hour.substring(0, 2);  
		currentHour=Integer.parseInt(Time);
		if (currentHour>=0 && currentHour<=2) interval=1;
		else if (currentHour>= 3 && currentHour<=5) interval=2;
		else if (currentHour>= 6 && currentHour<=8) interval=3;
		else if (currentHour>= 9 && currentHour<=11) interval=4;
		else if (currentHour>= 12 && currentHour<=14) interval=5;
		else if (currentHour>= 15 && currentHour<=17) interval=6;
		else if (currentHour>= 18 && currentHour<=20) interval=7;
		else if (currentHour>= 21 && currentHour<=23) interval=8;
		//System.out.println(currentHour);
		return interval;
	}
	
	public int getTrafficCondition() {
		
		return predictrafficCondition;
		
	}
	
	

}
