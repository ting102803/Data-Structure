
public class ExponentialRandom extends java.util.Random {
	private double mean;

	public ExponentialRandom(double mean) {
		super(System.currentTimeMillis());// 현재시각를 구하는 메소드를 이용한다
		this.mean = mean;
	}

	public double nextDouble() {
		return -mean * Math.log(1.0 - super.nextDouble());
	}

	public int nextInt() {
		return (int) Math.ceil(nextDouble());
	}// ceil은 올림하는 메소드
}
