package com.example.biz_component_a_impl;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.biz_component_a_api.IComponentA;
import com.example.biz_component_b_api.IComponentB;
import com.example.lib_component_center.ComponentCenter;
import com.sankuai.waimai.router.Router;

/**
 * @author kinsomy
 * @date 2023/1/4
 * @time 13:34
 */
public class ComponentAActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_a);
        findViewById(R.id.btn_to_componentb).setOnClickListener(view -> {
//            IComponentB iComponentB = (IComponentB) ComponentCenter.getInstance().get(IComponentB.class);
//            iComponentB.jumpToComponentBActivityWithId(this, "id_111");

            /**
             * 改为serviceLoader获取实例
             */
            IComponentB iComponentB = Router.getService(IComponentB.class, IComponentB.name);
            iComponentB.jumpToComponentBActivityWithId(this, "id_111");
        });
    }
}
