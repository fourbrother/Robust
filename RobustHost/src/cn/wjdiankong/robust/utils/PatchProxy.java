package cn.wjdiankong.robust.utils;

import android.text.TextUtils;
import cn.wjdiankong.patch.ChangeQuickRedirect;

public class PatchProxy {
	
    public static boolean isSupport(Object[] argsObj, Object thisObj, ChangeQuickRedirect changeQuickRedirect, boolean isStatic) {
        if (changeQuickRedirect == null) {
            return false;
        }
        //获取当前方法信息，其实就是借助了方法栈信息
        String classMethod = getClassMethod(isStatic);
        if (TextUtils.isEmpty(classMethod)) {
            return false;
        }
        return changeQuickRedirect.isSupport(classMethod, getObjects(argsObj, thisObj, isStatic));
    }

    public static Object accessDispatch(Object[] argsObj, Object thisObj, ChangeQuickRedirect changeQuickRedirect, boolean isStatic) {
        if (changeQuickRedirect == null) {
            return null;
        }
        String classMethod = getClassMethod(isStatic);
        if (TextUtils.isEmpty(classMethod)) {
            return null;
        }
        return changeQuickRedirect.accessDispatch(classMethod, getObjects(argsObj, thisObj, isStatic));
    }

    public static void accessDispatchVoid(Object[] argsObj, Object thisObj, ChangeQuickRedirect changeQuickRedirect, boolean isStatic) {
        if (changeQuickRedirect != null) {
            String classMethod = getClassMethod(isStatic);
            if (!TextUtils.isEmpty(classMethod)) {
                changeQuickRedirect.accessDispatch(classMethod, getObjects(argsObj, thisObj, isStatic));
            }
        }
    }

    private static Object[] getObjects(Object[] argsObj, Object thisObj, boolean isStatic) {
        if (argsObj == null) {
            return null;
        }
        Object[] newArgsObj;
        int length = argsObj.length;
        if (isStatic) {
        	newArgsObj = new Object[length];
        } else {
        	newArgsObj = new Object[length + 1];
        }
        int i = 0;
        while (i < length) {
        	newArgsObj[i] = argsObj[i];
            i++;
        }
        if (isStatic) {
            return newArgsObj;
        }
        newArgsObj[i] = thisObj;
        return newArgsObj;
    }

    private static String getClassMethod(boolean isStatic) {
        String str = "";
        try {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
            str = stackTraceElement.getClassName() + ":" + stackTraceElement.getMethodName() + ":" + isStatic;
        } catch (Throwable th) {
        }
        return str;
    }
}

