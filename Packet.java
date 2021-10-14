package SN;

import java.util.Random;
import java.util.ArrayList;

public class Packet {

	private Random rand;
	private int data;
	private int id;
	
	public Packet(int id) {
		data = rand.nextInt(100);
		this.id = id;
	}
	
	public Packet getPacket() {
		return new Packet(id);
	}
	
	public int getID() {
		return this.id;
	}
	
	public String printList(ArrayList<Packet> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			sb.append(list.get(i).data);
			sb.append(" ");
		}
		return sb.toString();
	}
	
}
