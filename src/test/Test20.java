package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author liuweixin
 * @date 2019年7月8日 上午10:46:09
 */
public class Test20 {
	public static void main(String[] args) {
		// System.out.println((long)Math.ceil((double)26/25));
		Calendar call = Calendar.getInstance();
		System.out.println(getLastMonthDay("20190120"));
	}
	
	public static String getLastMonthDay(String str) {//根据本月第一天获取上个月的最后一天
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		try {
			calendar.setTime(df.parse(str));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.set(Calendar.DAY_OF_MONTH, 1); 
		calendar.add(Calendar.DATE, -1);
		return df.format(calendar.getTime());
	}
}
