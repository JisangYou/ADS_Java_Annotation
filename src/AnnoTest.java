import java.sql.DriverManager;
import java.sql.SQLException;

public class AnnoTest {
	
	@GetConnection(url = "�ּ�", id = "���̵�", pw = "��й�ȣ")
	// 1. ������̼��� ����ϸ� �ҽ��ڵ带 ����ϴ� �ͺ���
	
	// 3.�ڵ忡 ���� ���� ó���� �ʿ�����ϱ�....
	//������ �̸� ������ �ϱ����� ����ó���� �ȴ�...
	//
	public void process() {
		int a = 156;
		int b = 121313;
		int result = a + b / 1450;

		

		System.out.println("result:" + result);
		String array[] = { "a", "b", "c" };
		for (String item : array) {
			System.out.printf("������ %s�Դϴ�.", item);
		}
		
		try {
			DriverManager.getConnection("�ּ�", "���̵�", "�н�����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
