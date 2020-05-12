package learn.yyc.design.designer.observer;

public class PoliceB implements PoliceObserver {

	@Override
	public void arrest(String suspects) {
		System.out.println("警察B抓捕" + suspects);
	}

}
