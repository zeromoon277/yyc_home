package learn.yyc.design.designer.observer;

public class PoliceA implements PoliceObserver {

	@Override
	public void arrest(String suspects) {
		System.out.println("警察A抓捕" + suspects);
	}

}
