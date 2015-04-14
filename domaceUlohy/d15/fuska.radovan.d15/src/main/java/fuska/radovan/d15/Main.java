package fuska.radovan.d15;

import java.util.UUID;

public class Main {

	static final int COUNT = 5000000;
	//static final int AVERAGE = 10;

	public static void main(String[] args) {
		User[] list = new User[COUNT];
		String string;
		StringBuffer buffer;

		for(int i = 0; i < COUNT; i++)
			list[i] = new User(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());

		System.out.format("Array size: %d\r\n", COUNT);

		string = "";
		long start = System.nanoTime();
		//for(int a = 0; a < AVERAGE; a++) {
		for(int i = 0; i < COUNT; i++)
			string += list[i];
		//}
		long end = System.nanoTime();
		System.out.format("String:       %fs\r\n", (float)(end - start) / 1000000f);

		buffer = new StringBuffer();
		start = System.nanoTime();
		//for(int a = 0; a < AVERAGE; a++) {
		for(int i = 0; i < COUNT; i++)
			buffer.append(list[i]);
		//}
		end = System.nanoTime();
		System.out.format("StringBuffer: %fs\r\n", (float)(end - start) / 1000000f);
	}
}