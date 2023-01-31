package com.example.biz_component_a_impl;

import android.app.Application;
import android.util.Log;

import com.example.lib_component_center.IModuleLifecycle;
import com.sankuai.waimai.router.annotation.RouterService;

/**
 * @author kinsomy
 * @date 2023/1/9
 * @time 21:25
 */

@RouterService(interfaces = IModuleLifecycle.class, key = "IComponentALifecycle")
public class IComponentALifecycle implements IModuleLifecycle {

    @Override
    public void onCreate(Application application) {
        Log.d("lifecycle","IComponentALifecycle: onCreate");
    }

    @Override
    public void onTerminate() {
        Log.d("lifecycle","IComponentALifecycle: onTerminate");
    }

    @Override
    public int getPriority() {
        return IModuleLifecycle.MIN_PRIORITY;
    }
}
