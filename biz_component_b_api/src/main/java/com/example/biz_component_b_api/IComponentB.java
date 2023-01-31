package com.example.biz_component_b_api;

import android.content.Context;

import com.example.lib_common.User;
import com.example.lib_component_center.IComponent;

/**
 * @author kinsomy
 * @date 2023/1/4
 * @time 13:36
 */
public interface IComponentB extends IComponent {
    String name = "biz_component_b";

    void jumpToComponentBActivity(Context context, User user);

    void jumpToComponentBActivityWithId(Context context, String userId);
}
