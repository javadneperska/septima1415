import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public final class UtilsLoading {
	public static final int[][] load(final String path) throws IOException {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		Scanner s = new Scanner(new FileInputStream(path), "UTF-8");
		while(s.hasNextInt())
			arr.add(s.nextInt());
		s.close();

		int l = (int)Math.sqrt(arr.size());
		int[][] m = new int[l][l];

		for(int x = 0; x < l; x++)
			for(int y = 0; y < l; y++)
				m[x][y] = arr.get(x * l + y);

		return m;
	}

	public static final void save(final String path, final int[][] m) throws IOException {
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
		int l = m.length;

		for(int x = 0; x < l; x++)
			for(int y = 0; y < l; y++)
				w.write(m[x][y] + " ");

		w.close();
	}
}