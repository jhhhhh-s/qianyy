package com.dingteam.demo.hashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MyHashMap<K, V> {

    public Entry<K, V>[] entries = new Entry[16];


    public void put(K k, V v) {
        int index = k==null?0:k.hashCode() % entries.length;
        Entry<K, V> entry = entries[index];
        if (entry == null) {
            entries[index] = new Entry<>(k, v);
        } else {
            while (entry.next!=null){
                if(entry.getK().equals(k)){
                    entry.setV(v);
                    return;
                }
            }
            entry.next = new Entry<>(k, v);
        }
    }

    public V get(K k) {

        int index = k==null? 0:k.hashCode() % entries.length;

        Entry<K, V> entry = entries[index];
        if (entry.next == null) {
            return entry.getV();
        } else {
            while (entry != null) {
                if (entry.getK().equals(k)) {
                    return entry.getV();
                }
                entry = entry.next;
            }
            return null;
        }
    }

    @Data
    class Entry<K, V> {
        K k;
        V v;
        int hash;
        Entry<K, V> next;


        Entry(K k, V v) {
            this.k = k;
            this.v = v;
            this.hash = k.hashCode();
        }

    }
}
