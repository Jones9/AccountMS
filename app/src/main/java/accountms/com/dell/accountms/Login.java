package accountms.com.dell.accountms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import accountms.com.dell.dao.PwdDAO;

public class Login extends AppCompatActivity {
    private TextView txtlogin;
    private Button btnlogin,btnclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        txtlogin = (TextView) findViewById(R.id.txtLogin);
        btnlogin = (Button) findViewById(R.id.btnLogin);
        btnclose = (Button) findViewById(R.id.btnClose);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                PwdDAO pwdDAO = new PwdDAO(Login.this);
                if ((pwdDAO.getCount()==0||pwdDAO.find().getPassword().isEmpty())&&txtlogin.getText().toString().isEmpty()){
                    startActivity(intent);
                }else {
                    if (pwdDAO.find().getPassword().equals(txtlogin.getText().toString())){
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this,"请输入正确密码",Toast.LENGTH_SHORT).show();
                    }
                }txtlogin.setText("");
            }
        });

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
