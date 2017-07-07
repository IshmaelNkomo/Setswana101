package com.example.admin.setswana101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ImageButton imgBColors,imgBFood,imgBFamily,btnGreetings,btnNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
public void color(View view){

    imgBColors = (ImageButton)findViewById(R.id.imgBColors);
    Intent col = new Intent(MainActivity.this,Colors.class);
    startActivity(col);
}
public void food(View view){

    imgBFood = (ImageButton)findViewById(R.id.btnFood);
    Intent foo = new Intent(MainActivity.this,Food.class);
    startActivity(foo);
}
public void family(View v){

    imgBFamily = (ImageButton)findViewById(R.id.btnFamily);
    Intent fam = new Intent(MainActivity.this,Family.class);
    startActivity(fam);
}
public void number(View v){

    btnNumbers = (ImageButton)findViewById(R.id.btnNumbers);
    Intent num = new Intent(MainActivity.this,Numbers.class);
    startActivity(num);
}
public void greet(View d){

    btnGreetings = (ImageButton)findViewById(R.id.btnGreetings);
    Intent greet = new Intent(MainActivity.this,Greetings.class);
    startActivity(greet);
}

}
