package loginactivity.example.com.loginactivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.baidu.platform.comapi.map.B;


public class DynamicActivity extends AppCompatActivity  implements SensorEventListener {
    private long time = 0;
    private SeekBar seekBar;
    private TextView text2;
    private String data;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_layout);


        TextView text = (TextView) findViewById(R.id.text1);
        Intent intent =getIntent();
        String value = intent.getStringExtra("text");
        text.setText(value);





        Button back1 = (Button)findViewById(R.id.back);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        seekBar = (SeekBar) findViewById(R.id.seekbar1);
        seekBar.setMax(100);
        seekBar.setEnabled(false);
        text2 = (TextView) findViewById(R.id.text2);
        data = text2.getText().toString();
        String zi = data.substring(0, 2);
        int x = Integer.valueOf(zi).intValue();
        seekBar.setProgress(x);
        ToggleButton tbtn = (ToggleButton) findViewById(R.id.tb_1);
        tbtn.setText("");
        tbtn.setOnClickListener(new ToggleButton.OnClickListener()
        {


            public void onClick(View v) {
                ToggleButton tbtn = (ToggleButton) findViewById(R.id.tb_1);
                if(tbtn.isChecked())
                {
                    Toast.makeText(DynamicActivity.this,"该停车场加入收藏",Toast.LENGTH_SHORT).show();
                    tbtn.setBackgroundResource(R.drawable.xin_1);
                }
                else
                {
                    Toast.makeText(DynamicActivity.this,"该停车场已取消收藏",Toast.LENGTH_SHORT).show();
                    tbtn.setBackgroundResource(R.drawable.xin_2);
                }
            }
        });

        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//得到加速度传感器对象
        manager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);




    }

    @Override


    public void onSensorChanged(SensorEvent event){
        float[] values = event.values;
        values = event.values;
        Intent intent = new Intent(DynamicActivity.this, ShakeActivity.class);
        //取x，y，z三个方向晃动的绝对值
        int x = (int) Math.abs(values[0]);
        int y = (int) Math.abs(values[1]);
        int z = (int) Math.abs(values[2]);
        if (x > 5 && y > 5 && z > 5) {//当绝对值>5并且两次摇的时间间隔>3秒的时候，才认为是摇动了一次，可以自定义值大小
            if (System.currentTimeMillis() - time > 2000) {

                time = System.currentTimeMillis();
                startActivity(intent);

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor,int accuracy){

    }

    }
