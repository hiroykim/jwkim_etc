package myTestUnits.simpleTest;

public class Parents {
	public String msg ="부모메시지";
    public int x=100;
	
	Parents(){
		System.out.println("부모 생성자 실행");
	}

	public void printMsg(){
		System.out.println("msg : " + this.msg);
	}
	
	public void printPtest(){
		System.out.println("부모 함수 호출 테스트");
	}
}
