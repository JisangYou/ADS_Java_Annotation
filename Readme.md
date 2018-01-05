# ADS04 Java 

## 수업 내용
- Annotation을 학습

## Code Review

```Java
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

```
- 어노테이션을 사용할 때 위치가 중요



## 보충설명

- 어노테이션(Annotation)은 Java 5부터 등장한 기능입니다. Annotation은 사전을 찾아보면 "주석"이라고 나오지만, 우리가 흔히 사용하는 "//, /**/" 등의 주석과는 차이가 있음
- 어노테이션은 설명 그 이상의 활동을 합니다. 어노테이션이 붙은 코드는 어노테이션의 구현된 정보에 따라 연결되는 방향이 결정됩니다. 따라서 전체 소스코드에서 비즈니스 로직에는 영향을 주지는 않지만 해당 타겟의 연결 방법이나 소스코드의 구조를 변경할 수 있습니다. 쉽게 말해서 "이 속성을 어떤 용도로 사용할까, 이 클래스에게 어떤 역할을 줄까?"를 결정해서 붙여준다고 볼 수 있습니다. 어노테이션은 소스코드에 메타데이터를 삽입하는 것이기 때문에 잘 이용하면 구독성 뿐 아니라 체계적인 소스코드를 구성하는데 도움을 줌.

- Custom Annotation

![CustomeAnnotation](http://www.nextree.co.kr/content/images/2016/09/eykim-20140205-annotation-01.jpg)

### 효율적인 사용의 예

![도메인 객체마다 그에 맞는 방법으로 저장](http://www.nextree.co.kr/content/images/2016/09/eykim-20140206-annotation-03.png)

- 도메인 객체마다 그에 맞는 방법으로 저장
- 가장 원초적인 방법으로 객체가 늘어날 때 마다 데이터 관리방법을 추가 지정해 주어야 함.

![특정 인터페이스를 상속한 도메인 객체들을 일관된 방법으로 저장](http://www.nextree.co.kr/content/images/2016/09/eykim-20140206-annotation-04.png)

- 특정 인터페이스를 상속한 도메인 객체들을 일관된 방법으로 저장
- 불필요한 인터페이스 상속받아야 함. 개발자는 자신이 구현하려는 비즈니스와 관련없이 데이터 저장방법을 위해서 소스코드에 상속을 추가해야 하는 불편함이 있음.

![@Annotation을 이용해서 저장](http://www.nextree.co.kr/content/images/2016/09/eykim-20140206-annotation-05.png)

- @Annotation을 이용해서 저장
- 사용하는 것이 낯설다는 단점을 제외하고는(주관적이지만) 위의 문제들을 해결하면서 통제가 쉬운 효율적인 방법


### built In Annotation

- @Override - 메소드가 오버라이드 됐는지 검증합니다. 만약 부모 클래스 또는 구현해야할 인터페이스에서 해당 메소드를 찾을 수 없다면 컴파일 오류가 납니다.
- @Deprecated - 메소드를 사용하지 말도록 유도합니다. 만약 사용한다면 컴파일 경고를 일으킵니다.
- @SuppressWarnings - 컴파일 경고를 무시하도록 합니다.
- @SafeVarargs - 제너릭 같은 가변인자 매개변수를 사용할 때 경고를 무시합니다. (자바7 이상)
- @FunctionalInterface - 람다 함수등을 위한 인터페이스를 지정합니다. 메소드가 없거나 두개 이상 되면 컴파일 오류가 납니다. (자바 8이상)

### Meta Annotation

- @Retention - 어노테이션의 범위(?)라고 할 수 있겠습니다. 어떤 시점까지 어노테이션이 영향을 미치는지 결정합니다.
- @Documented - 문서에도 어노테이션의 정보가 표현됩니다.
- @Target - 어노테이션이 적용할 위치를 결정합니다.
- @Inherited - 이 어노테이션을 선언하면 부모클래스에서 어노테이션을 상속 받을 수 있습니다.
- @Repeatable - 반복적으로 어노테이션을 선언할 수 있게 합니다.


#### [출처](http://jdm.kr/blog/216)
#### [nextree](http://www.nextree.co.kr/p5864/)

## TODO

- Annotation에 대한 자세한 기능및 사용방법은 추후에...

## Retrospect

- 어노테이션의 기능 및 용도를 보니 주니어 단계에서는 크게 고려?하지 않아도 될 것 같아 우선순위를 뒤로 미뤄둠(물론 나중에는 해야 하겠지만...)

## Output
- 생략