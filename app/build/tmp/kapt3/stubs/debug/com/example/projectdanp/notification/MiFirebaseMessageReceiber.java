package com.example.projectdanp.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/example/projectdanp/notification/MiFirebaseMessageReceiber;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "generateNotification", "", "title", "", "message", "getRemoteView", "Landroid/widget/RemoteViews;", "onMessageReceived", "Lcom/google/firebase/messaging/RemoteMessage;", "app_debug"})
public final class MiFirebaseMessageReceiber extends com.google.firebase.messaging.FirebaseMessagingService {
    
    public MiFirebaseMessageReceiber() {
        super();
    }
    
    @java.lang.Override()
    public void onMessageReceived(@org.jetbrains.annotations.NotNull()
    com.google.firebase.messaging.RemoteMessage message) {
    }
    
    public final void generateNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"RemoteViewLayout"})
    public final android.widget.RemoteViews getRemoteView(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return null;
    }
}