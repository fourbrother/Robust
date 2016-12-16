package cn.wjdiankong.patchimpl;

import android.text.TextUtils;
import cn.wjdiankong.patch.ChangeQuickRedirect;

public class MoneyBeanStatePatch implements ChangeQuickRedirect {
    @Override
    public Object accessDispatch(String methodSignature, Object[] paramArrayOfObject) {
    	//这里通过判断方法签名进行方法的替换
    	//methodSignature格式为：classname:methodname:isstatic
        String[] signature = methodSignature.split(":");
        
        //以下句式需要进行修复方法的具体修复代码
        if(TextUtils.equals(signature[1], "getMoneyValue")) {
            return 10000;
        }
        if(TextUtils.equals(signature[1], "desc")){
        	return "Patch Desc";
        }
        return null;
    }

    @Override
    public boolean isSupport(String methodSignature, Object[] paramArrayOfObject) {
    	//这里需要先校验方法的正确性
    	//methodSignature格式为：classname:methodname:isstatic
        String[] signature = methodSignature.split(":");
        
        //以下就是需要进行修复的方法名称
        if(TextUtils.equals(signature[1], "getMoneyValue")) {
            return true;
        }
        if(TextUtils.equals(signature[1], "desc")){
        	return true;
        }
        return false;
    }
}
