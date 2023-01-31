package com.example.lib_component_center.handler;

import android.content.Context;

import com.sankuai.waimai.router.core.RootUriHandler;

/**
 * 自定义路由handler
 *
 * @author kinsomy
 * @date 2023/1/10
 * @time 23:09
 */
public class CustomRootUriHandler extends RootUriHandler {
    public CustomRootUriHandler(Context context) {
        super(context);
        addChildHandler(new HttpUriHandler());
    }
}
