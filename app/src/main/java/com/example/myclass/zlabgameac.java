package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class zlabgameac extends AppCompatActivity {

    private String st,st0,st1,st2,st3,st4,st5,st6,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,stana;
    TextView tvaa,tvab,tvac,tvad,tvae;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabgameac);

        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        st = getIntent().getExtras().getString("value");

        st1= getIntent().getExtras().getString("gid");

        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");

        st5 = getIntent().getExtras().getString("CID");
        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        sta = getIntent().getExtras().getString("aid");
        stb = getIntent().getExtras().getString("bid");
        stz = getIntent().getExtras().getString("zid");
        stqa = getIntent().getExtras().getString("zqa");
        stqb = getIntent().getExtras().getString("zqb");
        stqc = getIntent().getExtras().getString("zqc");
        stqd = getIntent().getExtras().getString("zqd");
        stqe = getIntent().getExtras().getString("zqe");
        staa = getIntent().getExtras().getString("zaa");
        stab = getIntent().getExtras().getString("zab");
        stac = getIntent().getExtras().getString("zac");
        stad = getIntent().getExtras().getString("zad");
        stae = getIntent().getExtras().getString("zae");

        tvaa =findViewById(R.id.tvaaa);
    }
    public void zbackza(View view){
        Intent intent = new Intent(this,gamezc.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value", st);
        intent.putExtra("gid", st1);
        intent.putExtra("SIDNAME", st2);
        intent.putExtra("SID", st3);
        intent.putExtra("SIDPDF", st0);
        intent.putExtra("CID",st5);
        intent.putExtra("CIDNAME",st4);
        intent.putExtra("CPDF", st6);
        intent.putExtra("aid", sta);
        intent.putExtra("bid", stb);
        intent.putExtra("zid", stz);
        intent.putExtra("zqa", stqa);
        intent.putExtra("zqb", stqb);
        intent.putExtra("zqc", stqc);
        intent.putExtra("zqd", stqd);
        intent.putExtra("zqe", stqe);
        intent.putExtra("zaa", staa);
        intent.putExtra("zab", stab);
        intent.putExtra("zac", stac);
        intent.putExtra("zad", stad);
        intent.putExtra("zae", stae);
        startActivity(intent);
        finish();
    }




    protected void onResume(){
        super.onResume();
        loadSession1();

        Handler handler = new Handler ();
        handler.postDelayed (new Runnable ( ) {
            @Override
            public void run() {

                stana = tvaa.getText().toString();


                webView = (WebView) findViewById(R.id.webview);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.setWebChromeClient(new WebChromeClient());
                webView.loadUrl(stana);


            }
        },3000);





    }
    public void loadSession1(){

        JsonObjectRequest jsonObjectRequest4 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/answer.php?cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvaa.setText(response.getString("aac"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });
        VolleySingleton.getInstance(zlabgameac.this).addToRequestQueue(jsonObjectRequest4);
    }
}