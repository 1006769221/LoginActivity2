package loginactivity.example.com.loginactivity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.DynamicDrawableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.platform.comapi.map.B;


public class ChooseParkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosepark_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }



        Button button1 = (Button)findViewById(R.id.gocitypark);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("text","城市广场停车场");
                intent.setClass(ChooseParkActivity.this,DynamicActivity.class);
                startActivity(intent);

            }
        });
        Button button2 = (Button)findViewById(R.id.goshop);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("text","百货大厦停车场");
                intent.setClass(ChooseParkActivity.this,DynamicActivity.class);
                startActivity(intent);

            }
        });
        Button button3 = (Button)findViewById(R.id.gokfc);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("text","百城柯德基停车场");
                intent.setClass(ChooseParkActivity.this,DynamicActivity.class);
                startActivity(intent);
            }
        });
        Button button4 = (Button)findViewById(R.id.goxinyu);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("text","新宇大厦停车场");
                intent.setClass(ChooseParkActivity.this,DynamicActivity.class);
                startActivity(intent);
            }
        });
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
