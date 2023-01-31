package com.example.lib_component_center;

import android.app.Application;
import android.os.Build;

import com.sankuai.waimai.router.Router;

import java.util.Comparator;
import java.util.List;

/**
 * @author kinsomy
 * @date 2023/1/9
 * @time 22:28
 */
public class ModuleLifecycleManager {

    /**
     * 初始化时按优先级降序，保证更高优先级先执行
     * @param application
     */
    public static void init(Application application) {
        List<IModuleLifecycle> list = Router.getAllServices(IModuleLifecycle.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list.sort(new Comparator<IModuleLifecycle>() {
                @Override
                public int compare(IModuleLifecycle t1, IModuleLifecycle t2) {
                    return t2.getPriority() - t1.getPriority();
                }
            });
        }
        for (IModuleLifecycle iModuleLifecycle : list) {
            iModuleLifecycle.onCreate(application);
        }
    }

    /**
     * 注销的时候按优先级升序执行，保证更高优先级后注销
     */
    public static void release() {
        List<IModuleLifecycle> list = Router.getAllServices(IModuleLifecycle.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            list.sort(new Comparator<IModuleLifecycle>() {
                @Override
                public int compare(IModuleLifecycle t1, IModuleLifecycle t2) {
                    return t1.getPriority() - t2.getPriority();
                }
            });
        }
        for (IModuleLifecycle iModuleLifecycle : list) {
            iModuleLifecycle.onTerminate();
        }
    }
}
