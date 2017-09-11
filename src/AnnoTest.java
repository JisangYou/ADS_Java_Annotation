import java.sql.DriverManager;
import java.sql.SQLException;

public class AnnoTest {
	
	@GetConnection(url = "주소", id = "아이디", pw = "비밀번호")
	// 1. 어노테이션을 사용하면 소스코드를 사용하는 것보다
	
	// 3.코드에 대한 예외 처리가 필요없으니까....
	//사전에 미리 컴파일 하기전에 에러처리가 된다...
	//
	public void process() {
		int a = 156;
		int b = 121313;
		int result = a + b / 1450;

		

		System.out.println("result:" + result);
		String array[] = { "a", "b", "c" };
		for (String item : array) {
			System.out.printf("내용은 %s입니다.", item);
		}
		
		try {
			DriverManager.getConnection("주소", "아이디", "패스워드");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
