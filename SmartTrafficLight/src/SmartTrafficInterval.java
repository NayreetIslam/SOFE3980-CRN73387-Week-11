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
            File f = new File("input.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
            	String[] currencies = readLine.split("\\s+");   
            	
            	if(totalNumberOfSignals!=0) {
            		vehicleNumber+=Float.parseFloat(currencies[3]);
                	vehicleNumber+=Float.parseFloat(currencies[4]);
            	}
            	totalNumberOfSignals++;
            	
            	if(currencies[1].equalsIgnoreCase(getCurrentDay())) {
            		if( getCurrentTimeInterval(currencies[2]) == getCurrentTimeInterval()) {
            			sumOfLane1+=lane1=Float.parseFloat(currencies[3]);
            			sumOfLane2+=lane2=Float.parseFloat(currencies[4]);
            				++count;
            				average+=((lane1/lane2)-1);
            				System.out.println(average+" "+sumOfLane1+" "+sumOfLane2);
            		}
            	}
            	b.close();
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
		Calendar today = Calendar.getInstance();
		day=today.get(Calendar.DAY_OF_WEEK);
		String Name="";
		switch(day){
		case 0: Name="Sunday";
				break;
		case 1:	Name="Monday";
				break;
		case 2: Name = "Tuesday";
				break;
		case 3: Name = "Wednesday";
				break;
		case 4: Name = "Thursday";
				break;
		case 5: Name = "Friday";
				break;
		case 6: Name = "Saturday";
				break;
		default: Name = "invalid day";
				break;
		}
		return Name;
}

	
	public int getCurrentTimeInterval() {
		int currentHour,interval=0;
		Calendar today = Calendar.getInstance();
		currentHour=today.get(Calendar.HOUR_OF_DAY);
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
