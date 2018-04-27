import java.util.Random;

public class Simulation {
	public static void main(String[] args) {
		int sell, buy, gain = 0;// 변수 초기화
		int operatingTime = 100;// 운영시간 100초를 나타나기위해 선언함
		Queue bought = new Queue();
		Queue sold = new Queue();// bought sold 큐 두개를 만듬
		for (int i = 1; i <= operatingTime; i++) {// 1초부터 100초까지 실행한다.
			ExponentialRandom randombuy = new ExponentialRandom(5);
			ExponentialRandom randomsell = new ExponentialRandom(10);// 지수함수에 의거해서 난수 2개를 만든다.

			System.out.printf("Time : %d(s)\n", i);
			if (i % randombuy.nextInt() == 0) {// 난수로 나누었을때 나머지가 0인지 판단한다.
				bought.add(new Random().nextInt(1500) + 1,new Random().nextInt(20) + 1);// 0이라면 bought에 새롭게 추가한다.
				System.out.print("Bought(구매 정보 저장)  | ");
				bought.print();//추가 된걸 나타내준다.
			}

			if (i % randomsell.nextInt() == 0) {// 난수로 나누었을때 나머지가 0인지 판단한다.
				sold.add(new Random().nextInt(1500) + 1,new Random().nextInt(20) + 1);// 0이라면 sold에 새롭게 추가한다.
				System.out.print("Sold(판매 정보 저장)    | ");
				sold.print();//추가 된걸 나타내준다.

				while (sold.head != null) {//sold가 들어왔을땐 sold가 null이 될때까지 수행해야한다.
					if (bought.head == null)//하지만 만약 bought가 null이라면 더이상 판매를 못하니 while문을 나와야한다.
						break;
					sell = sold.first().amount;
					buy = bought.first().amount;
					if (sell > buy) {
						gain += buy * (sold.head.price - bought.head.price);
						bought.remove();
						sold.head.amount = sell - buy;//판매할께 더많으면 bought를 비우고 차이만큼 남은걸 sold에 넣어준다.
					} else if (buy > sell) {
						gain += sell * (sold.head.price - bought.head.price);
						sold.remove();
						bought.head.amount = buy - sell;//판매할게 더적으면 sold를 비우고 차이만큼 bought에 넣는다
					} else if (buy == sell) {
						gain += buy * (sold.head.price - bought.head.price);
						sold.remove();
						bought.remove();//만약 두개 의 비용이같다면 둘다 삭제하면된다.
					}
				}
				System.out.print("Bought(판매 요청 이후)  | ");
				bought.print();
				System.out.print("Sold(판매 요청 이후)    | ");
				sold.print();
				System.out.print("Gains : " + gain + "원\n");
			}

		}
	}
}
