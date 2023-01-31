package com.example.lib_component_center;

import android.app.Application;

/**
 * proxyLifecycle基类
 *
 * @author kinsomy
 * @date 2023/1/9
 * @time 22:16
 */
public interface IModuleLifecycle {
    int MAX_PRIORITY = 10;
    int MIN_PRIORITY = 1;
    int DEFAULT_PRIORITY = 6;

    /**
     * 壳工程application onCreate时触发
     *
     * @param application
     */
    void onCreate(Application application);

    /**
     * 壳工程application onTerminate时触发
     */
    void onTerminate();

    int getPriority();
}
