package cn.wjdiankong.patch;

public class PatchedClassInfo {
	
	private String fixClassName;//需要修复类名称
	private String patchClassName;//需要修复Patch类名称
	
	public PatchedClassInfo(String fixClassName, String patchClassName){
		this.fixClassName = fixClassName;
		this.patchClassName = patchClassName;
	}
	
	public String getFixClassName(){
		return fixClassName;
	}
	
	public String getPatchClassName(){
		return patchClassName;
	}

}
