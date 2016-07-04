package exercise3;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private int capacity;

    public MyHashMap(int capacity) {
        this.capacity = capacity;

        // Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>();
        for(Integer i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<MyEntry>());
        }
    }

    public String get(String key) {

        for(LinkedList<MyEntry> s : buckets) {
            if (s != null) {
                if (s.getFirst().getKey().equals(key)) {
                    return s.toString();
                }
            }
        }

        return null;
    }

    public void put(String key, String value) {

        int index = 0;

        if (key != null)
            index = Math.abs (key.hashCode()) % this.capacity;

        for (MyEntry entry : buckets.get(index)) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        buckets.get(index).add(new MyEntry(key, value));
    }

    public Set<String> keySet() {

        Set <String> mySet = new HashSet<String>();

        for(LinkedList<MyEntry> it : buckets){
            for(MyEntry entry : it){
                mySet.add(entry.getKey());
            }
        }
        return mySet;
    }

    public Collection<String> values() {

        Collection <String> myCollection = new HashSet<String>();

        for(LinkedList<MyEntry> it : buckets){
            for(MyEntry entry : it){
                myCollection.add(entry.getValue());
            }
        }

        return myCollection;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        return null;
    }

    public boolean containsKey(String key) {

        for (LinkedList<MyEntry> entries : buckets) {
            for (MyEntry entry : entries) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(String value) {

        for (LinkedList<MyEntry> entries : buckets) {
            for (MyEntry entry : entries) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {

        int size = 0;

        for (LinkedList<MyEntry> entries : buckets) {
            size += entries.size();
        }
        return size;
    }

    public void clear() {

        for (LinkedList<MyEntry> entries : buckets) {
            entries.clear();
        }
    }

    public Set<MyEntry> entrySet() {

        Set<MyEntry> entrySet = new HashSet<MyEntry>();

        for (LinkedList<MyEntry> entries : buckets) {
            entrySet.addAll(entries);
        }
        return entrySet;
    }

    public boolean isEmpty() {

        for (LinkedList<MyEntry> entries : buckets) {
            if (entries.size() > 0)
                return false;
        }
        return true;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
