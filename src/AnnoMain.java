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
			// ��Ÿ�ӽÿ� ���� �ൿ�� ����...
		}
	}

}

// Target = ������ ��� : ������, �������, Ÿ��(Ŭ����), �Ķ���� �޼ҵ�
// Retention = �ֳ����̼� ������ �����ܰ�
// �ҽ��ڵ�, Ŭ����, ��Ÿ��...
// Documented = javadoc�� ����ȭ�Ǿ������ϴ� ������Ʈ
// Inherited = ��ӹ޴� �ֳ����̼�

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
	public String value() default "��";

	public String key();

}

// �ֳ����̼��� ����� ��ü�� �����ڴ� �ƴϴ�.
// �ַ� ������Ʈ �������̳�
// ���¼ҽ� �����ڵ���
// ���̺귯���� ���� �� ���� ����ϰ� �ϱ� ���ؼ� ���� �����Ѵ�.

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface GetConnection {
	public String url();

	public String id();

	public String pw();
}


@GetConnection(url = "�ּ�", id = "���̵�", pw = "��й�ȣ")
//@CustomAnnotation(key = "student")
class UseAnnotation {
	
	// 1. ������̼��� ����ϸ� �ҽ��ڵ带 ����ϴ� �ͺ���

	// 2.�ڵ忡 ���� ���� ó���� �ʿ�����ϱ�....
	// ������ �̸� ������ �ϱ����� ����ó���� �ȴ�...
	//
	public void process() {
		int a = 156;
		int b = 121313;
		int result = a + b / 1450;

		try {
			Connection con = DriverManager.getConnection("�ּ�", "���̵�", "�н�����");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("result:" + result);
		String array[] = { "a", "b", "c" };
		for (String item : array) {
			System.out.printf("������ %s�Դϴ�.", item);
		}
	}
}
