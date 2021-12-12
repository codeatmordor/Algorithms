package org.gks.designpatterns.callback;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalConfig {

    private final ConcurrentHashMap<String, String> config = new ConcurrentHashMap<>();
    private static GlobalConfig INSTANCE ;

    private GlobalConfig(){

    }

    public static GlobalConfig getInstance() {
        if(INSTANCE == null) {
            synchronized (GlobalConfig.class){
                if(INSTANCE == null){
                    INSTANCE = new GlobalConfig();
                }
            }
        }
        return  INSTANCE;
    }

    public Map<String, String> getConfig(){
        return new ConcurrentHashMap<>(config);
    }

    public void setConfig(String key, String value ){
        config.put(key, value);
    }
}
