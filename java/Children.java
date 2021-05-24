package myTestUnits.simpleTest;

public class Children extends Parents {
	public String msg = "자식메세지";
	public int x=1000;
	
	public void printMsg(){
		System.out.println("오버라이드 자식 msg : " + this.msg);
	}
	
	public void printCtest(){
		System.out.println("자식 함수 호출 테스트");
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Children ch = new Children();
		
		ch.printMsg();
		ch.printCtest();
		ch.printPtest();
		
		System.out.println("Children ch.x : "  + ch.x);
		System.out.println("Children ch.msg : "  + ch.msg);
		System.out.println("Children ch : "  + ch.getClass());
		System.out.println("Children ch : "  + ch.toString());
		
		//업 캐스트
		Parents p = new Children();
		p.printMsg();
		//다운 캐스트
		((Children)p).printCtest();
		p.printPtest();
		
		System.out.println("Parents p.x : "  + p.x);
		System.out.println("Parents p.msg : "  + p.msg);
		System.out.println("Parents p : "  + p.getClass());
		System.out.println("Parents p : " + p.toString());
	}
}
