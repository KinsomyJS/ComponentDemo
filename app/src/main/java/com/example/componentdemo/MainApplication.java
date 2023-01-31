package com.example.componentdemo;

import android.app.Application;

import com.example.lib_component_center.handler.CustomRootUriHandler;
import com.example.lib_component_center.handler.HttpUriHandler;
import com.example.lib_component_center.ModuleLifecycleManager;
import com.sankuai.waimai.router.Router;

/**
 * @author kinsomy
 * @date 2023/1/4
 * @time 14:42
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * 组件化另一种实现，路由形式
         * 这里只用来演示拦截http路由跳转webview
         */
        Router.init(new CustomRootUriHandler(this));

        Router.lazyInit();

        /**
         *  使用serviceLoader自动注册，不再需要手动注册
         */
//        ComponentCenter.getInstance().register(IComponentA.class, new IComponentAImpl());
//        ComponentCenter.getInstance().register(IComponentB.class, new IComponentBImpl());

        /**
         * 一次性加载组件初始化，根据实际场景按需加载更好
         * 如果有耗时操作，放到后台执行
         */
        ModuleLifecycleManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        /**
         * 释放组件
         */
        ModuleLifecycleManager.release();
    }
}
