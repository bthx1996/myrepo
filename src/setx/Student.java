package setx;
/**    
*  
* @author liuweixin  
* @date 2019年5月20日 上午9:56:40  
*/
public class Student {

	private String name;
	private String birth;
	private Integer age;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", birth=" + birth + ", age=" + age + "]";
	}
	
	
}
