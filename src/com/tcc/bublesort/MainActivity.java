/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.tcc.bublesort;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import org.apache.cordova.*;
import org.apache.cordova.engine.SystemWebView;
import org.apache.cordova.engine.SystemWebViewClient;
import org.apache.cordova.engine.SystemWebViewEngine;

public class MainActivity extends CordovaActivity
{
    long start = System.currentTimeMillis();
    private Toast toast;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
        final WebView webView = (WebView) this.appView.getView();
        webView.setWebViewClient(new SystemWebViewClient((SystemWebViewEngine) this.appView.getEngine()){
            public void onPageFinished(WebView view, String url) {
                webView.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);
                long time = System.currentTimeMillis() - start;
                showToast(time);
                //Toast.makeText(getBaseContext(),"Time: "+time/1000.0, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showToast(long time) {
        int duration = 40000;
        toast = Toast.makeText(this,""+time/1000.0, Toast.LENGTH_LONG);
        CountDownTimer countDownTimer;
        countDownTimer = new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                toast.show();
            }

            @Override
            public void onFinish() {
                toast.cancel();
            }
        };
        toast.show();
        countDownTimer.start();

    }
}
