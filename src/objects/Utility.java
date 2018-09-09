package objects;

public class Utility {

	static int randint(double start, double end) {
		return (int) (start + Math.random() * (end - start));
	}
}
