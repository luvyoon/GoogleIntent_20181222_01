package kr.tjeit.googleintent_20181222_01;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends BaseActivity{


    EditText phoneNumEdt;
    Button dialBtn;
    Button callBtn;
    Button contentEdt;
    Button smsEdt;
    Button kakakoMarketLinkBtn;
    Button naverWeblinkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();



    }

    @Override
    public void setupEvents() {

        naverWeblinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String naverUrl= "http://www.naver.com";
                Uri uri = Uri.parse(naverUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);


            }
        });

        kakakoMarketLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kakaoLinkUrl = "com.kakao.talk&hl=ko";
                Uri uri = Uri.parse(String.format("market: //details?id=%s",kakaoLinkUrl));
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });

        smsEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputNumber = phoneNumEdt.getText().toString();
                String inputContent = contentEdt.getText().toString();

                Uri uri = Uri.parse(String.format("smsto:%s",inputNumber));
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra("sms_body",inputContent);
                startActivity(intent);


            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPhoneNum = phoneNumEdt.getText().toString();
                Uri uri =Uri.parse(String.format("tel:%s",inputPhoneNum));
                Intent intent= new Intent(Intent.ACTION_CALL,uri);
                startActivity(intent);

            }
        });

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 폰번 에딧 텍스트의 입력값을받고
                String inputPhoneNum = phoneNumEdt.getText().toString();

//                   그 입력값을 전화를 거는 데 사용

                Uri uri = Uri.parse(String.format("tel: %s",inputPhoneNum));
                Intent intent= new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);


            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        phoneNumEdt = findViewById(R.id.phoneNumEdt);
        dialBtn = findViewById(R.id.dialBtn);
        callBtn =findViewById(R.id.callBtn);
        contentEdt =findViewById(R.id.contentEdt);
        smsEdt = findViewById(R.id.smsBtn);
        kakakoMarketLinkBtn = findViewById(R.id.kakakoMarketLinkBtn);
        naverWeblinkBtn = findViewById(R.id.naverWeblinkBtn);

    }
}
