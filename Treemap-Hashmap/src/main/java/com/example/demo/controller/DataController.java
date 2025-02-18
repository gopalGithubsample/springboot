package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DataConverter;

import java.util.Map;
import java.util.TreeMap;

@RestController
public class DataController {

    @Autowired
    private DataConverter dataConverter;

    @GetMapping("/convert")
    public Map<String, Integer> convertData() {
        TreeMap<String, Integer> treeMap = dataConverter.createSampleTreeMap();
        return dataConverter.convertTreeMapToHashMap(treeMap);
    }

    @GetMapping("/getTreeMap")
    public TreeMap<String, Integer> getTreeMap() {
        return dataConverter.createSampleTreeMap();
    }
}