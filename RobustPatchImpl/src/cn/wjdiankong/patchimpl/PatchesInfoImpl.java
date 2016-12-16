package cn.wjdiankong.patchimpl;

import java.util.ArrayList;
import java.util.List;

import cn.wjdiankong.patch.PatchedClassInfo;
import cn.wjdiankong.patch.PatchesInfo;

public class PatchesInfoImpl implements PatchesInfo {
    public List<PatchedClassInfo> getPatchedClassesInfo() {
        List<PatchedClassInfo> patchedClassesInfos = new ArrayList<PatchedClassInfo>();
        PatchedClassInfo patchedClass = new PatchedClassInfo(
        		"cn.wjdiankong.robust.MoneyBean", 
        		MoneyBeanStatePatch.class.getCanonicalName());
        patchedClassesInfos.add(patchedClass);
        return patchedClassesInfos;
    }
}
