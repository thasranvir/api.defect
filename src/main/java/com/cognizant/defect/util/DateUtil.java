package com.cognizant.defect.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>Date Utility class</h1>
 * 
 * Responsible for date related various operations like time difference, date
 * conversion etc
 * 
 * 
 * @author Cognizant
 * @version 1.0
 */
public final class DateUtil {

	private DateUtil(){
		
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * This method calculates date difference of given two dates returns the difference in minute
	 * 
	 * @param date1 of type java.util.Date
	 * @param date2 of type java.util.Date
	 * @return diffMinutes of type long - time difference
	 * 
	 * 
	 */

	public static long timeDifference(Date date1, Date date2) {
		LOGGER.info("Entering into DateUtil.timeDifference() to calculate date difference in minutes for given dates: "+date1+" and "+date2);
		SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		dt.format(date1);
		dt.format(date2);
		long diff = date2.getTime() - date1.getTime();
		long diffMinutes = diff / (60 * 1000);
		LOGGER.info("DateUtil.timeDifference() - Difference in minutes: " + diffMinutes+ " minutes.");
		LOGGER.info("DateUtil.timeDifference() executed successfully");
		return diffMinutes;

	}

	/**
	 * Converts UTC date to Util date and then converts util date to
	 * java.sql.Timestamp
	 * 
	 * @param utcDate String UTC date received in request
	 * @return dbtimestamp Timestamp converted java.sql.Timestamp
	 * 
	 */
	public static Timestamp convertUtcToTimestamp(String utcDate) {
		LOGGER
				.info("Entering into DateUtil.convertUtcToTimestamp() to convert UTC date to java.sql.Timestamp");
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Timestamp dbtimestamp = null;
		try {
			Date utilDate = sdf.parse(utcDate);
			LOGGER.info("DateUtil.convertUtcToTimestamp() UTC date parsed to Util Date - "+ utcDate + " --> " + utilDate);
			dbtimestamp = new Timestamp(utilDate.getTime());
			LOGGER.info("DateUtil.convertUtcToTimestamp() Util date parsed to java.sql.Timestamp - "+ utilDate + " --> " + dbtimestamp);
		} catch (ParseException pe) {
			LOGGER.info("DateUtil.convertUtcToTimestamp() Unable to Parse UTC date");
			LOGGER.info("DateUtil.convertUtcToTimestamp() error message {} "+ pe.getMessage());
		}
		LOGGER.info("DateUtil.convertUtcToTimestamp() successfully executed");
		return dbtimestamp;
	}

	/**
	 * Converts long date to java.sql.Timestamp
	 * 
	 * @param utcDate String UTC date received in request
	 * @return dbtimestamp Timestamp converted java.sql.Timestamp
	 * 
	 * 
	 */
	public static Timestamp convertLongDateToTimestamp(String longDate) {
		return DateUtil.convertLongDateToTimestamp(Long.parseLong(longDate));
	}
	public static Timestamp convertLongDateToTimestamp(Long l) {
		LOGGER.info("Entering into DateUtil.convertUtcToTimestamp() to convert long date to java.sql.Timestamp");
		Timestamp dbtimestamp = null;
		try {
			dbtimestamp = new Timestamp(l);
			LOGGER.info("DateUtil.convertLongDateToTimestamp() --> Long : "
							+ l
							+ " converted to java.sql.Timestamp: "
							+ dbtimestamp);
		} catch (NumberFormatException ne) {
			LOGGER.info("DateUtil.convertLongDateToTimestamp() Unable to Parse Long date. Format not currect");
			LOGGER.info("DateUtil.convertLongDateToTimestamp() error message {} "+ ne.getMessage());
		}
		LOGGER.info("DateUtil.convertLongDateToTimestamp() successfully executed");
		return dbtimestamp;
	}

	/**
	 * Converts date to Util date and then converts util date to
	 * java.sql.Timestamp
	 * 
	 * @param date String UTC date received in request
	 * @return dbtimestamp Timestamp converted java.sql.Timestamp
	 * 
	 * 
	 */
	public static Timestamp convertDateToTimestamp(Date utilDate) {
		LOGGER.info("Entering into DateUtil.convertDateToTimestamp() to convert Util date to java.sql.Timestamp");
		Timestamp dbtimestamp = null;

		dbtimestamp = new Timestamp(utilDate.getTime());
		LOGGER.info("DateUtil.convertDateToTimestamp() Util date parsed to java.sql.Timestamp - "+ utilDate + " --> " + dbtimestamp);
		LOGGER.info("DateUtil.convertDateToTimestamp() successfully executed");
		return dbtimestamp;
	}
	
	
	/**
	 * returns current timestamp [java.sql.Timestamp]
	 * 
	 * @return Timestamp [java.sql.Timestamp]
	 * 
	 */
	public static Timestamp getCurrentTimestamp(){
		Calendar calendar = Calendar.getInstance();
		return new java.sql.Timestamp(calendar.getTime().getTime());
	}
	
	/**
	 * returns date in MM/dd/yyyy format
	 * 
	 * @param date java.util.Date
	 * @return String date in MM/dd/yyyy format
	 * 
	 */
	public static String dateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(date);
	}
	
	/**
	 * returns date in MM/dd/yyyy format
	 * 
	 * @param date java.util.Date
	 * @return String date in MM/dd/yyyy format
	 * 
	 */
	public static String convertToEbaoDateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ssZ");
		return sdf.format(date);
	}

	/**
	 * Converts String to date and then 
	 * 
	 * 
	 * @param  String date received in request
	 * @return java.util.date
	 * 
	 * @throws ParseException
	 * 
	 */
	public static Date convertStringToDate(String dateString)
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			date= sdf.parse(dateString);
		} catch (ParseException e) {
			LOGGER.error("ParseException occured in convertStringToDate() "+e.getMessage());
		}
		return date;
	}
	
	/**
	 * Converts String to date and then 
	 * 
	 * 
	 * @param  String date received in request
	 * @return java.util.date
	 * 
	 * @throws ParseException
	 * 
	 */
	public static Date convertDateFromEbaoString(String dateString)
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ssZ");
		try {
			date= sdf.parse(dateString);
		} catch (ParseException e) {
			LOGGER.error("ParseException occured in convertStringToDate() "+e.getMessage());
		}
		return date;
	}
	
	public static String dateString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		LOGGER.info("Date: "+dateStr);
		return dateStr;
	}
	
	/**
     * Converts a given time in milliseconds into a {@link XMLGregorianCalendar} object.
     * <p>
     * The input milliseconds value represents the specified number of milliseconds since the standard base time known
     * as "the epoch", namely January 1, 1970, 00:00:00 GMT.
     *
     * @param date
     *            A given time corresponding to the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return A new instance of <code>XMLGregorianCalendar</code> representing the input time
     */
    public static XMLGregorianCalendar toXmlGregorianCalendar(long date) {
    	 XMLGregorianCalendar xmlGregorianCalendar = null;
    	 
        try {
            final GregorianCalendar calendar = new GregorianCalendar();
            //TODO: as discussed with device time they will be sending SECOND from device for GROUP 2 
            // what we will convert to milli second
            calendar.setTimeInMillis(date * DefectTracker.THOUSAND);
            /*calendar.setTimeInMillis(date );*/
            xmlGregorianCalendar= DatatypeFactory.newInstance().newXMLGregorianCalendar(
                calendar);
            LOGGER.info("toXmlGregorianCalendar() date in gregorian calender {}", xmlGregorianCalendar.toString());
        }
        catch (final DatatypeConfigurationException ex) {
        	LOGGER.error("Unable to convert date '%s' to an XMLGregorianCalendar object");
        }
        return xmlGregorianCalendar;
    }

	/**
     * Converts a given time in milliseconds into a {@link XMLGregorianCalendar} object.
     * <p>
     * The input milliseconds value represents the specified number of milliseconds since the standard base time known
     * as "the epoch", namely January 1, 1970, 00:00:00 GMT.
     *
     * @param date
     *            A given time corresponding to the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return A new instance of <code>XMLGregorianCalendar</code> representing the input time
     */
   /* public static XMLGregorianCalendar toXmlGregorianCalendar(String date) {
    	
        return DateUtil.toXmlGregorianCalendar(Long.valueOf(date));
    }*/
    
	/**
     * Converts a given time in milliseconds into a {@link XMLGregorianCalendar} object.
     * <p>
     * The input milliseconds value represents the specified number of milliseconds since the standard base time known
     * as "the epoch", namely January 1, 1970, 00:00:00 GMT.
     *
     * @param date
     *            A given time corresponding to the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return A new instance of <code>XMLGregorianCalendar</code> representing the input time
     */
   /* public static Timestamp toDateFromXmlGregorianCalendar(XMLGregorianCalendar calender) {
    	return DateUtil.convertLongDateToTimestamp(calender.toGregorianCalendar().getTimeInMillis()/EsmartConstant.THOUSAND);
    	return DateUtil.convertLongDateToTimestamp(calender.toGregorianCalendar().getTimeInMillis());
    }*/

    /**
     * Converts a given time in milliseconds into a {@link XMLGregorianCalendar} object.
     * <p>
     * The input milliseconds value represents the specified number of milliseconds since the standard base time known
     * as "the epoch", namely January 1, 1970, 00:00:00 GMT.
     *
     * @param date
     *            A given time corresponding to the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return A new instance of <code>XMLGregorianCalendar</code> representing the input time
     */
    public static Timestamp toTimestampFromXmlGregorianCalendar(XMLGregorianCalendar calender) {
    	return DateUtil.convertLongDateToTimestamp(calender.toGregorianCalendar().getTimeInMillis()/DefectTracker.THOUSAND);
    }
    
    public static Timestamp toTimestampFromEbaoDate(String date) {
    	return convertLongDateToTimestamp(convertDateFromEbaoString(date).getTime()/DefectTracker.THOUSAND );
    }
    
	/**
	 * Converts a Timestamp to formatted date string   
	 * 
	 * @param Timestamp
	 * @return Formatted Date String
	 * 
	 */
	public static String convertTimestampToEBAOFormattedDate(Long timestamp) {
		LOGGER.info("Entering into DateUtil.convertTimestampToFormattedDate() to convert Long date to java.sql.Timestamp");
		Date date = new Date(timestamp * DefectTracker.THOUSAND);
		return convertToEbaoDateFormat(date);
	}
}
