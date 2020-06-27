package com.example.rookieofart;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GallWeb_2 extends AppCompatActivity {
    private WebView mWebView2; // 웹뷰 선언
    private WebSettings mWebSettings2; //웹뷰세팅
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gall_web2);

        // 웹뷰 시작
        mWebView2 = (WebView) findViewById(R.id.webView2);

        mWebView2.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        mWebSettings2 = mWebView2.getSettings(); //세부 세팅 등록
        mWebSettings2.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        mWebSettings2.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
        mWebSettings2.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        mWebSettings2.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        mWebSettings2.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        mWebSettings2.setSupportZoom(false); // 화면 줌 허용 여부
        mWebSettings2.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        mWebSettings2.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
        mWebSettings2.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        mWebSettings2.setDomStorageEnabled(true); // 로컬저장소 허용 여부

        mWebView2.loadUrl("https://www.opengallery.co.kr/exhibition/"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
//        https://www.artsum.co.kr/contest_detail.php?num=1699
//        https://www.opengallery.co.kr/exhibition/
    }
}
