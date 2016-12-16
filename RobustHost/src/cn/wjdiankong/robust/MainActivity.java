package cn.wjdiankong.robust;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import cn.wjdiankong.patch.ChangeQuickRedirect;
import cn.wjdiankong.robust.utils.PatchProxy;

public class MainActivity extends Activity {
	
	public static ChangeQuickRedirect changeQuickRedirect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		if (changeQuickRedirect != null) {
            if (PatchProxy.isSupport(new Object[]{savedInstanceState}, this, changeQuickRedirect, false)) {
                PatchProxy.accessDispatch(new Object[]{savedInstanceState}, this, changeQuickRedirect, false);
                return;
            }
        }
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MoneyBean bean = new MoneyBean();
		TextView moneyTxt = (TextView)findViewById(R.id.money);
		moneyTxt.setText(bean.getMoneyValue()+"");
		TextView descTxt = (TextView)findViewById(R.id.desc);
		descTxt.setText(MoneyBean.desc().toString());
		
	}

}

