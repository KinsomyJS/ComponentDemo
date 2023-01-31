package com.example.biz_component_b_impl;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.biz_component_b_api.IComponentB;
import com.example.lib_common.User;
import com.sankuai.waimai.router.annotation.RouterService;

/**
 * @author kinsomy
 * @date 2023/1/4
 * @time 14:33
 */

@RouterService(interfaces = IComponentB.class, key = IComponentB.name, singleton = true)
public class IComponentBImpl implements IComponentB {

    @Override
    public String getName() {
        return "biz_component_b_impl";
    }

    @Override
    public void jumpToComponentBActivity(@NonNull Context context, User user) {

    }

    @Override
    public void jumpToComponentBActivityWithId(@NonNull Context context, String userId) {
        Intent intent = new Intent(context, ComponentBActivity.class);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }
}
