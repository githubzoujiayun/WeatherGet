package datastructure;

/**天气格式 */
public class WeatherInfo {
	
	private	String city,windForce,windDirection,suggest,updateTime;
	//温度，湿度
	private int temperature,humidity,pm2_5;
	private ForecastWeather foreweathers[];
	
	public WeatherInfo() {
		foreweathers=new ForecastWeather[7];
	}
	public String getCity(){return city;	}
	public void setCity(String city){this.city=city;}
	public String getUpdateTime(){return updateTime;}
	public void setUpdateTime(String updateTime){this.updateTime=updateTime;}
	public String getWindForce(){return windForce;}
	public void setWindForce(String windForce){this.windForce=windForce;}
	public String getWindDirection(){return windDirection;}
	public void setWindDirection(String windDirection ){this.windDirection=windDirection;}
	public String getSuggest(){return suggest;}
	public void setSuggest(String suggest){this.suggest=suggest;}
	public int getTemperature(){return temperature;}
	public void setTemperature(int temperature){this.temperature=temperature;}
	public int getHumidity(){return humidity;}
	public void setHumidity(int humidity){this.humidity=humidity;}
	public int getPM2_5(){return pm2_5;}
	public void setPM2_5(int pm2_5){this.pm2_5=pm2_5;}
	public int getForecastHigh(int aftertoday){return foreweathers[aftertoday].high; }
	public void setForecastHign(int aftertoday,int high){foreweathers[aftertoday].high=high;}
	public int getForecastLow(int aftertoday){return foreweathers[aftertoday].low; }
	public void setForecastLow(int aftertoday,int low){foreweathers[aftertoday].low=low;}
	public String getForecastDate(int aftertoday){return foreweathers[aftertoday].date;}
	public void setForecastDate(int aftertoday,String date){foreweathers[aftertoday].date=date;}
}
/**预报后几天的天气*/
class ForecastWeather{
	String date;
	int high,low;
}