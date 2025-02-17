package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class DataConverter {

    public Map<String, Integer> convertTreeMapToHashMap(TreeMap<String, Integer> treeMap) {
        Map<String, Integer> hashMap = new HashMap<>();

        // Method 1: Using putAll (simplest)
        hashMap.putAll(treeMap);

        // Method 2: Iterating (more control)
        //for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
        //    hashMap.put(entry.getKey(), entry.getValue());
        //}

        return hashMap;
    }


    public TreeMap<String, Integer> createSampleTreeMap() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("apple", 1);
        treeMap.put("banana", 2);
        treeMap.put("cherry", 3);
        treeMap.put("date", 4);
        return treeMap;
    }
}