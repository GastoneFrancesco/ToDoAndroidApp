package it.francescogastone.todoandroidapp.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private Map<String, Object> beans = new HashMap<>();

    public void putBean(String key, Object obj) {
        this.beans.put(key, obj);
    }

    public Object getBean(String key){
        return this.beans.get(key);
    }
}
