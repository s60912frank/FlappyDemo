package com.mygdx.game;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.flappyDemo;

public class AndroidLauncher extends AndroidApplication { //這裡是Android的Main
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//GoToMaps();
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new flappyDemo(), config);
		GoToMaps();
	}

	public void GoToMaps(){ //切換到地圖
		//onPause();
		Intent wheee = new Intent();
		wheee.setClass(this, MapsActivity.class);
		startActivity(wheee);
	}
}
