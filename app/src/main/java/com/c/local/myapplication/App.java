package com.c.local.myapplication;

import android.app.Application;

public class App extends Application {

	// Applicationクラス自体
	private static App mApp;

	@Override
	public void onCreate() {
		super.onCreate();
		mApp = this;
	}

	public static synchronized App getApplication() {

		return mApp;
	}
}
