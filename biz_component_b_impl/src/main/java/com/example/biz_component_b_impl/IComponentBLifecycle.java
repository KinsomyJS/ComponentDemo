package com.example.biz_component_b_impl;

import android.app.Application;
import android.util.Log;

import com.example.lib_component_center.IModuleLifecycle;
import com.sankuai.waimai.router.annotation.RouterService;

/**
 * @author kinsomy
 * @date 2023/1/9
 * @time 20:25
 */

@RouterService(interfaces = IModuleLifecycle.class, key = "IComponentBLifecycle")
public class IComponentBLifecycle implements IModuleLifecycle {

    @Override
    public void onCreate(Application application) {
        Log.d("lifecycle", "IComponentBLifecycle: onCreate");
    }

    @Override
    public void onTerminate() {
        Log.d("lifecycle", "IComponentBLifecycle: onTerminate");
    }

    @Override
    public int getPriority() {
        return IModuleLifecycle.DEFAULT_PRIORITY;
    }
}
