package com.phodal.android.athome;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SettingActivity extends ActionBarActivity {

    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor editor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sharedPreferences = this.getSharedPreferences("athome",MODE_WORLD_READABLE);
        editor = sharedPreferences.edit();

        final EditText edtName = (EditText) this.findViewById(R.id.edtTelephone);

        Button btnWrite = (Button) this.findViewById(R.id.btnWrite);
        Button btnRead = (Button) this.findViewById(R.id.btnRead);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telephone = sharedPreferences.getString("telephone", null);
                Toast.makeText(getApplicationContext(),"号码是:"+telephone,
                        Toast.LENGTH_LONG).show();
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telephone = edtName.getText().toString();
                editor.putString("telephone", telephone);
                Toast.makeText(getApplicationContext(), "所保存的报警电话号码是"+telephone,
                        Toast.LENGTH_LONG).show();
                editor.commit();
            }
        });

    }

}
