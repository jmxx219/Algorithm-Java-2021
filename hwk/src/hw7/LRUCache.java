package hw7;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// A: LRU Cache

public class LRUCache {
	public static void put(int C, LinkedHashMap<Integer, Integer> map, int key, int value) { 
		if(map.containsKey(key)) {
			map.remove(key);
			map.put(key, value); 
		}
		else if(map.size() < C) {
			map.put(key, value); 
		}
		else { // ��ü
			map.remove(map.keySet().iterator().next());// ���� ������ ������ key�� �ش��ϴ� ������ ����
			map.put(key, value); // ���ο� �����ͷ� ��ü
		}
	}
	public static void get(LinkedHashMap<Integer, Integer> map, int key) {
		if(map.containsKey(key)) {
			int value = map.get(key);
			map.remove(key);
			map.put(key, value);
		}
		System.out.print(map.getOrDefault(key, -1)+" "); // ���� ������ -1
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int key;
		int value;
		for(int i=0; i<T; i++) {
			LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
			int C = in.nextInt(); // ĳ�� ���� ��
			int N = in.nextInt(); // ��� ��
			for(int j=0; j<N; j++) {
				int num = in.nextInt();
				if(num == 0) { // put
					key = in.nextInt(); // ĳ�ÿ� �����ϴ� Ű
					value = in.nextInt(); // ĳ�ÿ� �����ϴ� ��
					put(C, map, key, value);
				}
				else if(num == 1) { // get
					key = in.nextInt(); // ĳ�ÿ��� �а��� �ϴ� Ű
					get(map, key);
				}
			}
		}
	}

}

class LRUCache2 {
	private Map<Integer, node> nodeMap;
	private int capacity;
	private node head;
	private node tail;

	private class node {
		private int key;
		private int value;
		private node prev;
		private node next;

		public node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}

	public LRUCache2(int capacity) {
		this.nodeMap = new HashMap<>();
		this.capacity = capacity;
		head = new node(0, 0);
		tail = new node(0, 0);
		head.next = tail;
		tail.prev = head;

	}

	private void remove(node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;

		nodeMap.remove(node.key);
	}

	private void insertToHead(node node) {
		this.head.next.prev = node;
		node.next = this.head.next;
		node.prev = this.head;
		this.head.next = node;

		nodeMap.put(node.key, node);
	}

	public int get(int key) {
		if(!nodeMap.containsKey(key)) return -1;
		node getNode = nodeMap.get(key);
		remove(getNode);
		insertToHead(getNode);
		return getNode.value;

	}

	public void put(int key, int value) {
		node newNode = new node(key, value);
		if (nodeMap.containsKey(key)) {
			node oldNode = nodeMap.get(key);
			remove(oldNode);
		} 
		else {
			if (nodeMap.size() >= this.capacity) {
				node delNode = tail.prev;
				remove(delNode);
			}
		}
		insertToHead(newNode);
	}

}

class LRUCache3 {
    private final Map<Integer, Integer> map;
    private final int capacity;

    public LRUCache3(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);

        if (map.size() > capacity) {
            int leastUsedKey = map.keySet().iterator().next();
            map.remove(leastUsedKey);
        }
    }
}
