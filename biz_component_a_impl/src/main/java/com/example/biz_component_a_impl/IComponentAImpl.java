package com.example.biz_component_a_impl;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.biz_component_a_api.IComponentA;
import com.sankuai.waimai.router.annotation.RouterService;

/**
 * @author kinsomy
 * @date 2023/1/4
 * @time 13:35
 */
@RouterService(interfaces = IComponentA.class, key = IComponentA.name, singleton = true)
public class IComponentAImpl implements IComponentA {
    @Override
    public void jumpToComponentA(@NonNull Context context, String type, int val) {
        Intent intent = new Intent(context, ComponentAActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("val", val);
        context.startActivity(intent);
    }

    @Override
    public String getName() {
        return "biz_component_a_impl";
    }
}
