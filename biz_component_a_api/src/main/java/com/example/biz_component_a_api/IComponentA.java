package com.example.biz_component_a_api;

import android.content.Context;

import com.example.lib_component_center.IComponent;

/**
 * @author kinsomy
 * @date 2023/1/4
 * @time 13:28
 */
public interface IComponentA extends IComponent {
    String name = "biz_component_a";

    void jumpToComponentA(Context context, String type, int val);
}
