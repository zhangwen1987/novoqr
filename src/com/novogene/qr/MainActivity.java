package com.novogene.qr;

import com.novogene.qr.CameraTestActivity;
import com.novogene.qr.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener  {
	private EditText et_edit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		// 文本输入框
		et_edit = (EditText) findViewById(R.id.editText1);
		// 扫描按钮
		findViewById(R.id.button1).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {

		Intent intent = new Intent();
		intent.setClass(this, CameraTestActivity.class);
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		//返回的条形码数据
		String code = data.getStringExtra("Code");
		//输入文本输入框中
		et_edit.setText(code);
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
