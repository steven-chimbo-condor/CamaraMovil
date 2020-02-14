package com.example.camara1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;

public class Main2Activity extends AppCompatActivity {
    private ListView lista;
    private ImageView image;
    private String[] archivo;
    private ArrayAdapter<String> adaptador1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        File dir=getExternalFilesDir(null);
        archivo=dir.list();
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,archivo);
        lista=(ListView)findViewById(R.id.listView1);
        lista.setAdapter(adaptador1);

        image=(ImageView)findViewById(R.id.imageView1);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Bitmap bitmap1 = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+archivo[arg2]);
                image.setImageBitmap(bitmap1);
            }
            });
    }
}
