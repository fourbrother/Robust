package cn.wjdiankong.robust.utils;

import android.util.Log;

public class Logger {
	
	private final static boolean isDebug = true;
	
	public static void debug(String tag, String msg){
		if(isDebug){
			Log.i(tag, msg+"");
		}
	}
	
	public static void debug(String msg){
		if(isDebug){
			Log.i("jw", msg+"");
		}
	}

}
