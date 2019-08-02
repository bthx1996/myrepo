package annotation;

@ZdyAnnotation("valueµÄÖµ")
public class AnnotationTest {
	public static void main(String[] args) {
		ZdyAnnotation zdy = AnnotationTest.class.getAnnotation(ZdyAnnotation.class);
		System.out.println(zdy.str());
		System.out.println(zdy.value());
	}
}
