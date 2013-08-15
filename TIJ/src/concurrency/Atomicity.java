//: concurrency/Atomicity.java
// {Exec: javap -c Atomicity}
package concurrency;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Atomicity {
	int i;

	void f1() {
		i++;
	}

	void f2() {
		i += 3;
	}

	public static void main(String[] args) {
		try {
			Process p = Runtime.getRuntime().exec("javap -c C:/Users/hanchensu/git/TIJ/TIJ/bin/concurrency/Atomicity.class");
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = inBr.readLine()) != null)
				System.out.println(lineStr);
			inBr.close();
			in.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
} /*
 * Output: (Sample) ... void f1(); Code: 0: aload_0 1: dup 2: getfield #2;
 * //Field i:I 5: iconst_1 6: iadd 7: putfield #2; //Field i:I 10: return
 * 
 * void f2(); Code: 0: aload_0 1: dup 2: getfield #2; //Field i:I 5: iconst_3 6:
 * iadd 7: putfield #2; //Field i:I 10: return
 */// :~
