package test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.set.SynchronizedSet;

/**    
*  
* @author liuweixin  
* @date 2019年7月4日 下午5:19:53  
*/
public class Test19 {
	
	public static void main(String[] args) throws ParseException {
		//System.out.println(isLastDayOfMonth(new SimpleDateFormat("yyyyMMdd").parse("20180931")));
		//System.out.println("20190910".compareTo("20190909"));
		//System.out.println(new BigDecimal("1").scale());
		//Pattern p = Pattern.compile("[a-zA-Z0-9]{17}");
		//Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5}$");
		Pattern p = Pattern.compile("^[0-9]+$");
		Matcher m = p.matcher("14312a3241321");
		System.out.println(m.matches());
	}
	
	public static boolean isYYYYMMDD(String str) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			df.parse(str);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	public static boolean isLastDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH) == calendar
				.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
