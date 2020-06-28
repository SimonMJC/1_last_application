package com.example.rookieofart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class BioProfile extends AppCompatActivity {
    //사용자 프로필 사진 등록
    //사용자 bio 작성란

    private static final int REQUEST_CODE = 0;
    private static String TAG = "Setting";
    private ImageView imageView;
    private Button load, save, delete;
    private EditText bio;

    //메모를 저장할 파일명 (파일 하나만 지원)
    private String fileName = "MyMemo.txt";
    //백버튼 누른 시간 저장
    private long backPressTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bio_profile);

        load = (Button)findViewById(R.id.load);
        save = (Button)findViewById(R.id.save);
        delete = (Button)findViewById(R.id.delete);
        bio = (EditText)findViewById(R.id.edit);

        load.setOnClickListener(load_listener);
        save.setOnClickListener(save_listener);
        delete.setOnClickListener(delete_listener);

        imageView = findViewById(R.id.profile_2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    View.OnClickListener load_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FileInputStream inputStream = null;
            try {
                inputStream = openFileInput(fileName);
                //바이트 단위로 스트림 데이터를 읽음
                byte[] data = new byte[inputStream.available()];
                while(inputStream.read(data) != -1) {}
                //현재 에디트 박스에 읽은 바이트 데이터를 세팅
                bio.setText(new String(data));
                //화면 아래 간단한 알림 메시지 출력
                Toast.makeText(getApplicationContext(), "로드 성공", Toast.LENGTH_LONG).show();
            }catch (Exception e)
            { e.printStackTrace(); }
            finally {
                try {//파일 읽기 성공 여부 상관없이 반드시 스트림 닫기
                    if(inputStream != null)
                        inputStream.close();
                }catch (Exception e)
                { e.printStackTrace(); }
            }
        }
    };
    View.OnClickListener save_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //파일 저장 시 이용할 파일 출력 스트림
            FileOutputStream outputStream = null;
            try
            { outputStream = openFileOutput(fileName, MODE_PRIVATE);
                //에디트 박스에 저장된 스트링 데이터를 스트림에 기록함
                outputStream.write(bio.getText().toString().getBytes());
                outputStream.close();
                Toast.makeText(getApplicationContext(), "저장 성공", Toast.LENGTH_LONG).show(); }
            catch(Exception e)
            { e.printStackTrace(); }
        }
    };
    View.OnClickListener delete_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //해당 파일을 디스크 상에서 삭제, true 리턴 시 삭제 성공
            boolean Del = deleteFile(fileName);
            if(Del)
                Toast.makeText(getApplicationContext(), "메모 삭제 완료", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "메모 삭제 실패", Toast.LENGTH_LONG).show();
        }
    };
    //갤러리 불러오기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    imageView.setImageBitmap(img);
                } catch (Exception e) {

                }
            } else if (resultCode == RESULT_CANCELED) {//갤러리 사진 취소 시 토스트
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }

}
