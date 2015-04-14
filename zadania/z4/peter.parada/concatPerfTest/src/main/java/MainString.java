
public class MainString {

	public static void main(String[] args) {
		double time;
		time = System.currentTimeMillis();
		
		String chain = "";
		int iters = 10_000;
		
		for (int i = 0; i < iters; i++) {
			User user = new User("Peter", "Parada", "951226/8898");
			chain += user.uuid;
		}
		time = (System.currentTimeMillis() - time);
		System.out.println(time);
	}

}
