package com.laigukf.client;

import android.app.Application;
import android.widget.Toast;

import com.laigukf.core.LGManager;
import com.laigukf.core.callback.OnInitCallback;
import com.laigukf.sdk.util.LGConfig;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initMeiqiaSDK();
    }

    private void initMeiqiaSDK() {
        LGManager.setDebugMode(true);

        // 替换成自己的key
        String appKey = "725d0a9d3d1e2f82eaa16d6d1e146bfa";
        LGConfig.init(this, appKey, new OnInitCallback() {
            @Override
            public void onSuccess(String clientId) {
                Toast.makeText(App.this, "init success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int code, String message) {
                Toast.makeText(App.this, "int failure message = " + message, Toast.LENGTH_SHORT).show();
            }
        });

        // 可选
        customMeiqiaSDK();
    }

    private void customMeiqiaSDK() {
        // 配置自定义信息
        LGConfig.ui.titleGravity = LGConfig.ui.MQTitleGravity.LEFT;
        LGConfig.ui.backArrowIconResId = R.drawable.ic_arrow_back_white_24dp;
//        MQConfig.ui.titleBackgroundResId = R.color.test_red;
//        MQConfig.ui.titleTextColorResId = R.color.test_blue;
//        MQConfig.ui.leftChatBubbleColorResId = R.color.test_green;
//        MQConfig.ui.leftChatTextColorResId = R.color.test_red;
//        MQConfig.ui.rightChatBubbleColorResId = R.color.test_red;
//        MQConfig.ui.rightChatTextColorResId = R.color.test_green;
//        MQConfig.ui.robotEvaluateTextColorResId = R.color.test_red;
//        MQConfig.ui.robotMenuItemTextColorResId = R.color.test_blue;
//        MQConfig.ui.robotMenuTipTextColorResId = R.color.test_blue;
    }

}
