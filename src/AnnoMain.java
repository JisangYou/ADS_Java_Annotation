import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AnnoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UseAnnotation use = new UseAnnotation();
		String key = use.getClass().getAnnotation(CustomAnnotation.class).key();
		if (key.equals("student")) {
			// 런타임시에 해줄 행동을 정의...
		}
	}

}

// Target = 적용할 대상 : 생성자, 멤버변수, 타입(클래스), 파라미터 메소드
// Retention = 애너테이션 정보의 유지단계
// 소스코드, 클래스, 런타임...
// Documented = javadoc에 문서화되어져야하는 엘리먼트
// Inherited = 상속받는 애너테이션

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
	public String value() default "값";

	public String key();

}

// 애너테이션은 만드는 주체가 개발자는 아니다.
// 주로 공통파트 개발팀이나
// 오픈소스 개발자들이
// 라이브러리를 조금 더 쉽게 사용하게 하기 위해서 만들어서 제공한다.

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface GetConnection {
	public String url();

	public String id();

	public String pw();
}


@GetConnection(url = "주소", id = "아이디", pw = "비밀번호")
//@CustomAnnotation(key = "student")
class UseAnnotation {
	
	// 1. 어노테이션을 사용하면 소스코드를 사용하는 것보다

	// 2.코드에 대한 예외 처리가 필요없으니까....
	// 사전에 미리 컴파일 하기전에 에러처리가 된다...
	//
	public void process() {
		int a = 156;
		int b = 121313;
		int result = a + b / 1450;

		try {
			Connection con = DriverManager.getConnection("주소", "아이디", "패스워드");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("result:" + result);
		String array[] = { "a", "b", "c" };
		for (String item : array) {
			System.out.printf("내용은 %s입니다.", item);
		}
	}
}
