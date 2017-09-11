
public class A {

	public void process() {
		InterfaceC c = new C();
		c.getValue();
		InterfaceC d = new D();
		d.getValue();

	}
}

class D implements InterfaceC {
	@Override
	public String getValue() {
		return "d°ª";
	}

}

class C implements InterfaceC {
	@Override
	public String getValue() {
		return "c°ª";
	}

}

interface InterfaceC {
	public String getValue();
}