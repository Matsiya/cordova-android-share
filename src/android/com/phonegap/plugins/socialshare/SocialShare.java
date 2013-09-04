package com.phonegap.plugins.socialshare;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

public class SocialShare extends CordovaPlugin {

    public final String ACTION_SHARE = "share";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        boolean result = false;
        if(action.equals(ACTION_SHARE)) {
            JSONObject obj = args.optJSONObject(0);
            if (obj != null) {
                doSendIntent( obj.optString("subject"), obj.optString("text") );
            }
        }

        return result;
    }

    private void doSendIntent(String subject, String text) {
        Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        if( subject.length() > 0 )
            sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);

        if( text.length() > 0 )
            sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        this.cordova.startActivityForResult(this, sendIntent, 0);
    }
}