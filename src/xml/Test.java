package xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**    
*  
* @author liuweixin  
* @date 2019��4��28�� ����10:14:50  
*/
public class Test {
	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		//ѧ����Ϣ��
		Element childInfo = root.addElement("ChildInfo");
		Element childNum = childInfo.addElement("ChildNum");
		int cnum = 0;
		for(int i = 1; i <= 5; i++) {
			Element c1 = childInfo.addElement("Child" + i);
			c1.setText("ѧ��" + i);
			cnum++;
		}
		childNum.setText(String.valueOf(cnum));
		//��ʦ��Ϣ��
		Element teacherInfo = root.addElement("TeacherInfo");
		Element teacherNum = teacherInfo.addElement("TeacherNum");
		int tnum = 0;
		for(int i = 1; i <= 2; i++) {
			Element t1 = teacherInfo.addElement("Teacher" + i);
			t1.setText("��ʦ" + i);
			tnum++;
		}
		teacherNum.setText(String.valueOf(tnum));
		System.out.println(document.asXML());
	}
}
