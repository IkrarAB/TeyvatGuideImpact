package com.ikrarab.teyvatguideimpact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Menu extends AppCompatActivity {

    LinearLayout charList;
    RelativeLayout map,charTails;
    MaterialToolbar title;
    GridView gridView;
    ImageView charsIcon, charsPortrait, charsVisionIcon,charsRarity, charsNation;
    TextView charsName, charsVision, charsWeapon, charsRegion;

    private WebView webView;

    String url = "https://webstatic-sea.mihoyo.com/app/ys-map-sea/?lang=en-us#/map/2?shown_types=";
    String[] charName = {"Albedo", "Amber", "Ayaka", "Barbara", "Beidou", "Bennett", "Chongyun",
            "Diluc", "Diona", "Eula", "Fischl", "Ganyu", "Hu Tao", "Jean", "Kaeya", "Kazuha",
            "Keqing", "Klee", "Lisa", "Mona", "Ningguang", "Noelle", "Qiqi", "Razor", "Rosaria",
            "Sucrose", "Tartaglia", "Traveler Anemo", "Traveler Geo", "Venti", "Xiangling", "Xiao",
            "Xingqiu", "Xinyan", "Yanfei", "Zhongli"};

    int[] charNation = {1,1,3,1,2,1,2,1,1,1,1,2,2,1,1,3,2,1,1,1,2,1,2,1,1,1,4,9,9,1,2,2,2,2,2,2};

    String[] charWeapon = {"Sword","Bow","Sword","Catalyst","Claymore","Sword", "Claymore",
            "Claymore","Bow","Claymore","Bow","Bow","Polearm","Sword","Sword","Sword","Sword",
            "Catalyst","Catalyst","Catalyst","Catalyst","Claymore","Sword","Claymore", "Polearm",
            "Catalyst","Bow","Sword","Sword","Bow","Polearm","Polearm","Sword","Claymore","Catalyst",
            "Polearm"};

    String[] charVision = {"Geo","Pyro","Cryo","Hydro","Electro","Pyro","Cryo","Pyro","Cryo","Cryo",
            "Electro","Cryo","Pyro","Anemo","Cryo","Anemo","Electro","Pyro","Electro","Hydro","Geo",
            "Geo","Cryo","Electro","Cryo","Anemo","Hydro","Anemo","Geo","Anemo","Pyro","Anemo","Hydro",
            "Pyro","Pyro","Geo"};

    int[] charRarity = {5,4,5,4,4,4,4,5,4,5,4,5,5,5,4,5,5,5,4,5,4,4,5,4,4,4,5,5,5,5,4,5,4,4,4,5};

    int[] charVisionIcon = {R.drawable.icon_geo,R.drawable.icon_pyro,R.drawable.icon_cryo,R.drawable.icon_hydro,
            R.drawable.icon_electro,R.drawable.icon_pyro,R.drawable.icon_cryo,R.drawable.icon_pyro,R.drawable.icon_cryo,
            R.drawable.icon_cryo,R.drawable.icon_electro,R.drawable.icon_cryo,R.drawable.icon_pyro,R.drawable.icon_anemo,
            R.drawable.icon_cryo,R.drawable.icon_anemo,R.drawable.icon_electro,R.drawable.icon_pyro,R.drawable.icon_electro,
            R.drawable.icon_hydro,R.drawable.icon_geo,R.drawable.icon_geo,R.drawable.icon_cryo,R.drawable.icon_electro,
            R.drawable.icon_cryo,R.drawable.icon_anemo,R.drawable.icon_hydro,R.drawable.icon_anemo,R.drawable.icon_geo,
            R.drawable.icon_anemo,R.drawable.icon_pyro,R.drawable.icon_anemo,R.drawable.icon_hydro,R.drawable.icon_pyro,
            R.drawable.icon_pyro,R.drawable.icon_geo};

    int[] charIcon = {R.drawable.icon_albedo,R.drawable.icon_amber,R.drawable.icon_ayaka,R.drawable.icon_barbara,
            R.drawable.icon_beidou,R.drawable.icon_bennett,R.drawable.icon_chongyun,R.drawable.icon_diluc,
            R.drawable.icon_diona,R.drawable.icon_eula,R.drawable.icon_fischl,R.drawable.icon_ganyu,R.drawable.icon_hutao,
            R.drawable.icon_jean,R.drawable.icon_kaeya,R.drawable.icon_kazuha,R.drawable.icon_keqing,R.drawable.icon_klee,
            R.drawable.icon_lisa,R.drawable.icon_mona,R.drawable.icon_ningguang,R.drawable.icon_noelle,R.drawable.icon_qiqi,
            R.drawable.icon_razor,R.drawable.icon_rosaria,R.drawable.icon_sucrose,R.drawable.icon_tartaglia,R.drawable.icon_traveler_anemo,
            R.drawable.icon_traveler_geo,R.drawable.icon_venti,R.drawable.icon_xiangling,R.drawable.icon_xiao,R.drawable.icon_xingqiu,
            R.drawable.icon_xinyan,R.drawable.icon_yanfei,R.drawable.icon_zhongli};

    int[] charPortrait = {R.drawable.portrait_albedo,R.drawable.portrait_amber,R.drawable.portrait_ayaka,R.drawable.portrait_barbara,
            R.drawable.portrait_beidou,R.drawable.portrait_bennett,R.drawable.portrait_chongyun,R.drawable.portrait_diluc,
            R.drawable.portrait_diona,R.drawable.portrait_eula,R.drawable.portrait_fischl,R.drawable.portrait_ganyu,R.drawable.portrait_hutao,
            R.drawable.portrait_jean,R.drawable.portrait_kaeya,R.drawable.portrait_kazuha,R.drawable.portrait_keqing,R.drawable.portrait_klee,
            R.drawable.portrait_lisa,R.drawable.portrait_mona,R.drawable.portrait_ningguang,R.drawable.portrait_noelle,R.drawable.portrait_qiqi,
            R.drawable.portrait_razor,R.drawable.portrait_rosaria,R.drawable.portrait_sucrose,R.drawable.portrait_tartaglia,R.drawable.portrait_traveler_anemo,
            R.drawable.portrait_traveler_geo,R.drawable.portrait_venti,R.drawable.portrait_xiangling,R.drawable.portrait_xiao,
            R.drawable.portrait_xingqiu,R.drawable.portrait_xinyan,R.drawable.portrait_yanfei,R.drawable.portrait_zhongli};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
        charsVision = findViewById(R.id.charElement);
        charsWeapon = findViewById(R.id.charWeapon);
        charsNation = findViewById(R.id.charRegionIcon);
        charsRegion = findViewById(R.id.charRegion);
        charsIcon = findViewById(R.id.charIcon);
        charsRarity = findViewById(R.id.charRarity);
        charsVisionIcon = findViewById(R.id.charElementIcon);
        charsPortrait = findViewById(R.id.charPic);
        map = findViewById(R.id.map_layout);
        charTails = findViewById(R.id.chartails_layout);
        title = toolbar;

        MainAdapter adapter = new MainAdapter(Menu.this, charName, charVision, charWeapon, charIcon,
                                                charPortrait, charVisionIcon, charRarity, charNation);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                charList.setVisibility(View.GONE);
                map.setVisibility(View.GONE);
                charTails.setVisibility(View.VISIBLE);
                charsName.setText(charName[+position]);
                charsWeapon.setText(charWeapon[+position]);
                charsIcon.setImageResource(charIcon[+position]);
                charsPortrait.setImageResource(charPortrait[+position]);
                charsVision.setText(charVision[+position]);
                if (charVision[+position].equals("Geo")){
                    charsVision.setTextColor(Color.parseColor("#F5D25D"));
                    charsVisionIcon.setImageResource(R.drawable.icon_geo);
                } else if (charVision[+position].equals("Pyro")){
                    charsVision.setTextColor(Color.parseColor("#F08738"));
                    charsVisionIcon.setImageResource(R.drawable.icon_pyro);
                } else if (charVision[+position].equals("Cryo")){
                    charsVision.setTextColor(Color.parseColor("#93F3F6"));
                    charsVisionIcon.setImageResource(R.drawable.icon_cryo);
                } else if (charVision[+position].equals("Hydro")){
                    charsVision.setTextColor(Color.parseColor("#2DC7FA"));
                    charsVisionIcon.setImageResource(R.drawable.icon_hydro);
                } else if (charVision[+position].equals("Electro")){
                    charsVision.setTextColor(Color.parseColor("#CF91FA"));
                    charsVisionIcon.setImageResource(R.drawable.icon_electro);
                } else if (charVision[+position].equals("Anemo")){
                    charsVision.setTextColor(Color.parseColor("#5BD3A6"));
                    charsVisionIcon.setImageResource(R.drawable.icon_anemo);
                } else if (charVision[+position].equals("Dendro")){
                    charsVision.setTextColor(Color.parseColor("#9FCF2E"));
                    charsVisionIcon.setImageResource(R.drawable.icon_dendro);
                }

                if (charRarity[+position] == 5){
                    charsRarity.setImageResource(R.drawable.stars5);
                } else {
                    charsRarity.setImageResource(R.drawable.stars4);
                }

                if (charNation[+position] == 1){
                    charsNation.setImageResource(R.drawable.icon_mondstadt);
                    charsRegion.setText("Mondstadt");
                } else if (charNation[+position] == 2){
                    charsNation.setImageResource(R.drawable.icon_liyue);
                    charsRegion.setText("Liyue");
                } else if (charNation[+position] == 3){
                    charsNation.setImageResource(R.drawable.icon_inazuma);
                    charsRegion.setText("Inazuma");
                } else if (charNation[+position] == 4){
                    charsNation.setImageResource(R.drawable.icon_unknown);
                    charsRegion.setText("Snezhnaya");
                } else if (charNation[+position] == 9){
                    charsNation.setImageResource(R.drawable.icon_unknown);
                    charsRegion.setText("Celestia");
                }

                title.setTitle("Character Details");
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
            map.setVisibility(View.GONE);
            charList.setVisibility(View.VISIBLE);
            charTails.setVisibility(View.GONE);
            title.setTitle("Character List");
        }
    }
}