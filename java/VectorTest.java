package myTestUnits.simpleTest;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		Vector<String> v1 = new Vector<String>(2);
		
		v1.addElement("A1");
		v1.addElement("A2");
		v1.addElement("A3");
		v1.addElement("A4");
		
		Enumeration<String> e = v1.elements();
		
		while(e.hasMoreElements()) {
			System.out.println("e -> " + e.nextElement());
		}
		
		
		
	}

}
