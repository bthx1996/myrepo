package reflect;

import java.lang.reflect.Field;

/**    
*  
* @author liuweixin  
* @date 2019年7月12日 下午3:26:39  
*/
public class Test {

	public static void main(String[] args) {
		
	}
	
	public static void testReflect(Object model) throws Exception{
		String str = null; 
		int i = -1;
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            String type = field.getGenericType().toString();
            name = name.substring(0, 1).toUpperCase()+name.substring(1);
            if(type.equals("class java.lang.String")) {
            	str = "entity.set"+name+"(str["+i+"]);";
            }else if(type.equals("class java.lang.Integer")){
            	str = "entity.set"+name+"(Integer.valueOf(str["+i+"]));";
            }else{
            	str = "entity.set"+name+"(new BigDecimal(str["+i+"]));";
            }           
            System.out.println(str);
            i++;
            }
    }
	
	public static void testReflect2(Object model) throws Exception{
		String str = null; 
		int i = -1;
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            String type = field.getGenericType().toString();
            String name2 = name.substring(0, 1).toUpperCase()+name.substring(1);
            String name3 = name.toLowerCase();
            if(type.equals("class java.lang.String")) {
            	str = "ri.set"+name2+"(str["+i+"]);";
            }else if(type.equals("class java.lang.Integer")){
            	str = "entity.set"+name2+"(Integer.valueOf(str["+i+"]));";
            }          
            System.out.println(str);
            i++;
            }
    }
}
