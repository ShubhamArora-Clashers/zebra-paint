/*
 * Copyright (C) 2010 Peter Dornbach.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dornbachs.zebra;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class ZebraActivity extends Activity {
	public static final String INTENT_START_NEW = 
		"com.dornbachs.zebra.paint.START_NEW";
	public static final String INTENT_PICK_COLOR = 
		"com.dornbachs.zebra.paint.PICK_COLOR";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	WindowManager w = getWindowManager();
        Display d = w.getDefaultDisplay();
        _displayWidth = d.getWidth();
        _displayHeight = d.getHeight();     	
    }

	public static int getDisplayWitdh() {
		return _displayWidth;
	}

	public static int getDisplayHeight() {
		return _displayHeight;
	}

	protected void findAllColorButtons(List<ColorButton> result) {
		findAllColorButtons((ViewGroup)getWindow().getDecorView(), result);
	}
	
    protected void findAllColorButtons(ViewGroup g, List<ColorButton> result) {
    	for (int i = 0; i < g.getChildCount(); i++) {
    		View v = g.getChildAt(i);
    		if (v instanceof ViewGroup) {
    			findAllColorButtons((ViewGroup)v, result);
    		}
    		if (v instanceof ColorButton) {
    			result.add((ColorButton)v);
    		}
    	}
    }
    
	protected static int _displayWidth;
	protected static int _displayHeight;
}