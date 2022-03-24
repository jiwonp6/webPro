package singleton2;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();	//SingletonClass.getInstance()만 사라지지 않는 영역
		System.out.println("싱글톤 객체의 i값 : "+singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("싱글톤 객체의 i값(수정후) : "+singletonObject.getI());
	}	//생성자 사라짐 -> 하지만 INSTANCE에 수정된 i값 저장되어 있기때문에 i 값은 999로 그대로임
}
