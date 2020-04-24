package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class OpenHashMap {
	public List<List<Entry>> map;
	public int size, capc;
	public float factor;
	
	public class Entry {
		public int key;
		public String value;
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
		public int getKey() {
			return key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(reader.readLine());
			OpenHashMap openHashMap = new OpenHashMap(n);
			for (int i = 0; i < n; i++) {
				String[] put_query = reader.readLine().split(" ");
				openHashMap.put(Integer.parseInt(put_query[0]), put_query[1]);
			}
			int q = Integer.parseInt(reader.readLine());
			for (int i = 0; i < q; i++) {
				System.out.println(openHashMap.get(Integer.parseInt(reader.readLine())));
			}
		} catch (IOException e) {
			
		}
	}
	
	public OpenHashMap() {
		this(16, 0.75f);
	}
	
	public OpenHashMap(int initialCapacity) {
		this(initialCapacity, 0.75f);
	}
	
	public OpenHashMap(int initialCapacity, float loadFactor) {
		init(Math.max(initialCapacity, 1));
		factor = loadFactor;
	}
	
	public void init(int capacity) {
		map = new ArrayList<List<Entry>>(capacity);
		size = 0;
		capc = capacity;
		for (int i = 0; i < capacity; i++) {
			map.add(new LinkedList<Entry>());
		}
	}
	
	public void put(int key, String value) {
		List<Entry> slot = map.get(getSlot(key));
		int index = getEntry(slot, key);
		if (index != -1) {
			slot.get(index).setValue(value);
			return;
		}
		
		if (size > factor * capc) {
			List<List<Entry>> oldMap = map;
			init(2 * capc);
			for (List<Entry> oldSlot : oldMap) {
				for (Entry entry : oldSlot) {
					map.get(getSlot(entry.getKey())).add(entry);
				}
			}
			slot = map.get(getSlot(key));
		}
		slot.add(new Entry(key, value));
	}
	
	public String get(int key) {
		List<Entry> slot = map.get(getSlot(key));
		int index = getEntry(slot, key);
		return index == -1 ? "" : slot.get(index).getValue();
	}
	
	public int getEntry(List<Entry> slot, int key) {
		ListIterator<Entry> it = slot.listIterator();
		while (it.hasNext()) {
			int index = it.nextIndex();
			if (it.next().getKey() == key) {
				return index;
			}
		}
		return -1;
	}
	
	public int getSlot(int key) {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result % capc;
	}
}
