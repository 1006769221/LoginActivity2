package loginactivity.example.com.loginactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        Button button = (Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.user);
                final String user = editText.getText().toString();
                EditText editText1 = (EditText)findViewById(R.id .password);
                final String password = editText1.getText().toString();
                if (user.equals("admin")&& password.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this,ChooseParkActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"用户名或密码输入有误！", LENGTH_SHORT).show();
                }
            }
        });

        TextView forgetpwd = (TextView)findViewById(R.id.forgetpwd);
        forgetpwd.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.dialog));
                new AlertDialog.Builder(LoginActivity.this).setTitle("忘记密码").setView(layout)
                        .setPositiveButton("确定", null)
                        .setNegativeButton("取消", null).show();



                }

        });
    }
}
