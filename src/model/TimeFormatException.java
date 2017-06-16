package model;

// define a user exception class for SensorTime
public class TimeFormatException extends RuntimeException
{
	public TimeFormatException(String message) {
		super(message);
	}
}