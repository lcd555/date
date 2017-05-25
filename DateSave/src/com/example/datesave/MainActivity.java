package com.example.datesave;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText et_info;
	private Button btn_save;
	private Button btn_read;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_save=(Button) findViewById(R.id.btn_save);
        btn_read=(Button) findViewById(R.id.btn_read);
        et_info=(EditText)findViewById(R.id.et_info);
        btn_save.setOnClickListener(this);
        btn_read.setOnClickListener(this);
    }

	@Override
	public void onClick(View a) {
		switch(a.getId()){
		case R.id.btn_read:
			dRead();
			break;
		case R.id.btn_save:
			dSave();
			break;
		
		
		}
	}

	public void dSave(){
		String saveInfo=et_info.getText().toString();
		FileOutputStream f;
		try {
			f=openFileOutput("data.txt",Context.MODE_APPEND);
			f.write(saveInfo.getBytes());
			f.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Toast.makeText(this,"保存成功",0).show();
	}
	public void dRead(){
		String content="0";
		FileInputStream f;
		try {
			f=openFileInput("data.txt");
			byte[] b=new byte[f.available()];
			f.read(b);
			content=new String (b);
			et_info.setText(content);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Toast.makeText(this, "值"+content,0).show();		
	}
    
    
}
