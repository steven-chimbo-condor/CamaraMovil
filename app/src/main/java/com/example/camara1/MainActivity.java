package com.example.camara1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private ImageView image1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1=(ImageView)findViewById(R.id.imageView);
        text= (EditText)findViewById(R.id.editText);
    }
    public void TomarFoto(View v){
        Intent intento1= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File foto = new File(getExternalFilesDir(null),text.getText().toString());
        intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
        startActivity(intento1);
    }
    public void RecuperFoto(View v){
        Bitmap bitmap1 = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+text.getText().toString());
        image1.setImageBitmap(bitmap1);


    }
    public  void Ver(View v){
        Intent intento1=new Intent(this,Main2Activity.class);
        startActivity(intento1);

    }
}
