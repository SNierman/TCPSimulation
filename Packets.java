package SN;

import java.util.Random;
import java.util.ArrayList;

public class Packets {

	private Random rand;
	private int number;
	
	public Packets() {
		number = rand.nextInt(100);
	}
	
	public Packets getPacket() {
		return new Packets();
	}
	
	public void createList() {
		ArrayList<Packets> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			list.add(getPacket());
		}
	}
	
	public String printList(ArrayList<Packets> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			sb.append(list.get(i).number);
			sb.append(" ");
		}
		return sb.toString();
	}
	
}
