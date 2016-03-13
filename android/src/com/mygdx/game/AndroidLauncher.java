package com.mygdx.game;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.flappyDemo;

public class AndroidLauncher extends AndroidApplication implements Callbacks { //這裡是Android的Main
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//GoToMaps();
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		flappyDemo flapbird = new flappyDemo();
		flapbird.setCallback(this);
		initialize(flapbird, config);
		//GoToMaps();
	}

	@Override
	public void StartMaps() {
		//onPause();
		Intent wheee = new Intent();
		wheee.setClass(this, MapsActivity.class);
		startActivity(wheee);
	}
}
