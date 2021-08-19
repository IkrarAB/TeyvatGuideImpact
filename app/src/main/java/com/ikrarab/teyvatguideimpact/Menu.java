package com.ikrarab.teyvatguideimpact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.ikrarab.teyvatguideimpact.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Menu extends AppCompatActivity {

    LinearLayout charList;
    RelativeLayout map,charTails;
    MaterialToolbar title;
    GridView gridView;
    TextView charsName,charsElement;
    private WebView webView;
    private final String TAG = "Menu";

    String url = "https://webstatic-sea.mihoyo.com/app/ys-map-sea/?lang=en-us#/map/2?shown_types=";
    String[] charName = {"albedo", "amber", "ayaka", "barbara", "beidou", "bennett", "chongyun",
            "diluc", "diona", "eula", "fischl", "ganyu", "hu-tao", "jean", "kaeya", "kazuha",
            "keqing", "klee", "lisa", "mona", "ningguang", "noelle", "qiqi", "razor", "rosaria",
            "sucrose", "tartaglia", "traveler-anemo", "traveler-geo", "venti", "xiangling", "xiao",
            "xingqiu", "xinyan", "yanfei", "zhongli"};
    int[] charIcon = {R.drawable.icon_albedo,R.drawable.icon_amber,R.drawable.icon_ayaka,R.drawable.icon_barbara,
            R.drawable.icon_beidou,R.drawable.icon_bennett,R.drawable.icon_chongyun,R.drawable.icon_diluc,
            R.drawable.icon_diona,R.drawable.icon_eula,R.drawable.icon_fischl,R.drawable.icon_ganyu,R.drawable.icon_hutao,
            R.drawable.icon_jean,R.drawable.icon_kaeya,R.drawable.icon_kazuha,R.drawable.icon_keqing,R.drawable.icon_klee,
            R.drawable.icon_lisa,R.drawable.icon_mona,R.drawable.icon_ningguang,R.drawable.icon_noelle,R.drawable.icon_qiqi,
            R.drawable.icon_razor,R.drawable.icon_rosaria,R.drawable.icon_sucrose,R.drawable.icon_tartaglia,R.drawable.icon_traveler_anemo,
            R.drawable.icon_traveler_geo,R.drawable.icon_venti,R.drawable.icon_xiangling,R.drawable.icon_xiao,R.drawable.icon_xingqiu,
            R.drawable.icon_xinyan,R.drawable.icon_yanfei,R.drawable.icon_zhongli};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getDataFromApi();

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUserAgentString("Android");

        MaterialToolbar toolbar = findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.getMenu().getItem(0).setChecked(true);

        gridView = findViewById(R.id.charGrid);
        charList = findViewById(R.id.charlist_layout);
        charsName = findViewById(R.id.charName);
        map = findViewById(R.id.map_layout);
        charTails = findViewById(R.id.chartails_layout);
        title = toolbar;

        MainAdapter adapter = new MainAdapter(Menu.this,charName,charIcon);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                charList.setVisibility(View.GONE);
                map.setVisibility(View.GONE);
                charTails.setVisibility(View.VISIBLE);
                charsName.setText(charName[+position]);
                title.setTitle("Character List");
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id){
                    case R.id.nav_charlist:
                        charList.setVisibility(View.VISIBLE);
                        map.setVisibility(View.GONE);
                        charTails.setVisibility(View.GONE);
                        title.setTitle("Character List");
                        break;

                    case R.id.nav_map:
                        map.setVisibility(View.VISIBLE);
                        charList.setVisibility(View.GONE);
                        charTails.setVisibility(View.GONE);
                        title.setTitle("Map");
                        break;

                    default:
                        return true;
                }
                return true;
            }

        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private void getDataFromApi(){
        ApiService.endPoint().getCharListData()
                .enqueue(new Callback<CharListModel>() {
                    @Override
                    public void onResponse(Call<CharListModel> call, Response<CharListModel> response) {
                        if (response.isSuccessful()){
                            List<CharListModel.Types> results = response.body().getTypes();
                            Log.d(TAG, results.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<CharListModel> call, Throwable t) {
                        Log.d(TAG, t.toString());
                    }
                });
    }

}