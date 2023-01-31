package com.example.componentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.biz_component_a_api.IComponentA;
import com.example.biz_component_a_impl.IComponentAImpl;
import com.example.lib_component_center.ComponentCenter;
import com.sankuai.waimai.router.Router;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_toA).setOnClickListener(view -> {
//            IComponentA iComponentA = (IComponentA) ComponentCenter.getInstance().get(IComponentA.class);
//            iComponentA.jumpToComponentA(this, "type", 1);
            /**
             * 改为serviceLoader获取实例
             */
            IComponentA iComponentA = Router.getService(IComponentA.class, IComponentA.name);
            iComponentA.jumpToComponentA(this, "type", 1);
        });

        findViewById(R.id.btn_towebview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.startUri(getApplicationContext(), "https://www.baidu.com");
            }
        });
    }
}