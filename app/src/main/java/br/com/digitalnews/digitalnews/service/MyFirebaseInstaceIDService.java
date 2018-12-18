package br.com.digitalnews.digitalnews.service;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

class MyFirebaseInstanceIDService extends MyFirebaseMessagingService {

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.wtf("NEW_TOKEN",s);
    }

}