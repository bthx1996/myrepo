package xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**    
*  
* @author liuweixin  
* @date 2019年4月28日 上午10:14:50  
*/
public class Test {
	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		//学生信息段
		Element childInfo = root.addElement("ChildInfo");
		Element childNum = childInfo.addElement("ChildNum");
		int cnum = 0;
		for(int i = 1; i <= 5; i++) {
			Element c1 = childInfo.addElement("Child" + i);
			c1.setText("学生" + i);
			cnum++;
		}
		childNum.setText(String.valueOf(cnum));
		//教师信息段
		Element teacherInfo = root.addElement("TeacherInfo");
		Element teacherNum = teacherInfo.addElement("TeacherNum");
		int tnum = 0;
		for(int i = 1; i <= 2; i++) {
			Element t1 = teacherInfo.addElement("Teacher" + i);
			t1.setText("教师" + i);
			tnum++;
		}
		teacherNum.setText(String.valueOf(tnum));
		System.out.println(document.asXML());
	}
}
