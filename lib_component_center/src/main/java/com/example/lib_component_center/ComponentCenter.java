package com.example.lib_component_center;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kinsomy
 * @date 2023/1/4
 * @time 13:55
 */
public class ComponentCenter {
    private ConcurrentHashMap<Class, IComponent> componentMap = null;

    private volatile static ComponentCenter instance;

    private ComponentCenter() {
        componentMap = new ConcurrentHashMap<>();
    }

    public static ComponentCenter getInstance() {
        if (instance == null) {
            synchronized (ComponentCenter.class) {
                if (instance == null) {
                    instance = new ComponentCenter();
                }
            }
        }
        return instance;
    }

    public void register(Class clz, IComponent iComponent) {
        if (iComponent == null || componentMap.contains(clz)) {
            return;
        }
        componentMap.put(clz, iComponent);
    }

    public void unregister(Class clz) {
        componentMap.remove(clz);
    }

    public IComponent get(Class clz) {
        return componentMap.get(clz);
    }
}
