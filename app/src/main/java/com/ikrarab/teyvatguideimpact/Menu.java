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
    TextView charsName, charsVision, charsWeapon, charsRegion, charsDesc, charsAff, charsCons, charsBirth;

    private WebView webView;

    String url = "https://webstatic-sea.mihoyo.com/app/ys-map-sea/?lang=en-us#/map/2?shown_types=";
    String[] charName = {"Albedo", "Amber", "Ayaka", "Barbara", "Beidou", "Bennett", "Chongyun",
            "Diluc", "Diona", "Eula", "Fischl", "Ganyu", "Hu Tao", "Jean", "Kaeya", "Kazuha",
            "Keqing", "Klee", "Lisa", "Mona", "Ningguang", "Noelle", "Qiqi", "Razor", "Rosaria",
            "Sucrose", "Tartaglia", "Traveler Anemo", "Traveler Geo", "Venti", "Xiangling", "Xiao",
            "Xingqiu", "Xinyan", "Yanfei", "Zhongli"};

    String[] charCons = {"Princeps Cretaceus", "Lepus", "Grus Nivis", "Crater", "Victor Mare", "Rota Calamitas",
            "Nubis Caesor", "Noctua", "Feles", "Aphros Delos", "Corvus", "Sinae Unicornis", "Papilio Charontis",
            "Leo Minor", "Pavo Ocellus", "Acer Palmatum", "Trulla Cementarii", "Trifolium", "Tempus Fugit",
            "Astrolabos", "Opus Aequilibrium", "Parma Cordis", "Pristina Nola", "Lupus Minor", "Spinea Corona",
            "Ampulla", "Monoceros Caeli", "Viatrix", "Viatrix", "Carmen Dei", "Trulla", "Alatus Nemeseos",
            "Fabulae Textile", "Fila Ignium", "Bestia Iustitia", "Lapis Dei"};

    String[] charAff = {"Knights of Favonius","Knights of Favonius","Yashiro Commission", "Church of Favonius",
                        "The Crux", "Adventurers' Guild", "Liyue Harbor", "Dawn Winery", "The Cat's Tail",
                        "Knights of Favonius","Adventurers' Guild","Yuehai Pavilion", "Wangsheng Funeral Parlor",
                        "Knights of Favonius", "Knights of Favonius", "The Crux", "Liyue Qixing", "Knights of Favonius",
                        "Knights of Favonius", "Mondstadt", "Liyue Qixing", "Knights of Favonius", "Bubu Pharmacy",
                        "Wolvendom", "Church of Favonius", "Knights of Favonius", "Fatui", "None", "None",
                        "Mondstadt", "Wanmin Restaurant", "Liyue Adeptus", "Feiyun Commerce Guild", "Liyue Harbor",
                        "Liyue Harbor Adepti", "Liyue Harbor"};

    String[] charDesc = {"A genius known as the Kreideprinz, he is the Chief Alchemist and Captain of the Investigation Team of the Knights of Favonius.",
                        "Always energetic and full of life, Amber's the best - albeit only - Outrider of the Knights of Favonius.",
                        "Daughter of the Yashiro Commission's Kamisato Clan. Dignified and elegant, as well as wise and strong.",
                        "Every denizen of Mondstadt adores Barbara. However, she learned the word \"idol\" from a magazine.",
                        "Captain of her crew, The Crux. She's quite an unbound and forthright woman.",
                        "A righteous and good-natured adventurer from Mondstadt who's unfortunately extremely unlucky.",
                        "A young exorcist from a family of exorcists. He does everything he can to suppress his abundance of yang energy.",
                        "The tycoon of a winery empire in Mondstadt, unmatched in every possible way.",
                        "A young lady who has inherited trace amounts of non-human blood. She is the incredibly popular bartender of the Cat's Tail tavern.",
                        "The Spindrift Knight, a scion of the old aristocracy, and the Captain of the Knights of Favonius Reconnaissance Company. The reason for which a descendant of the ancient nobles might join the Knights remains a great mystery in Mondstadt to this very day.",
                        "A mysterious girl who calls herself \"Prinzessin der Verurteilung\" and travels with a night raven named Oz.",
                        "The secretary at Yuehai Pavilion. The blood of the qilin, an illuminated beast, flows within her veins.",
                        "The 77th Director of the Wangsheng Funeral Parlor. She took over the business at a rather young age.",
                        "The righteous and rigorous Dandelion Knight, and Acting Grand Master of Mondstadt's Knights of Favonius",
                        "A thinker in the Knights of Favonius with a somewhat exotic appearance.",
                        "If one's heart is empty, all under heaven is empty. But if one's heart is pure, all under heaven is pure.",
                        "The Yuheng of the Liyue Qixing. Has much to say about Rex Lapis' unilateral approach to policymaking in Liyue - but in truth, gods admire skeptics such as her quite a lot.",
                        "An explosives expert and a regular at the Knights of Favonius' confinement room. Also known as Fleeing Sunlight.",
                        "The languid but knowledgeable Librarian of the Knights of Favonius who was deemed by Sumeru Academia to be their most distinguished graduate in the past two centuries.",
                        "A mysterious young astrologer who proclaims herself to be \"Astrologist Mona Megistus,\" and who possesses abilities to match the title. Erudite, but prideful.",
                        "The Tianquan of Liyue Qixing. Her wealth is unsurpassed in all of Teyvat.",
                        "A maid who faithfully serves the Knights of Favonius that dreams of joining their ranks someday.",
                        "An apprentice and herb gatherer at Bubu Pharmacy. An undead with a bone-white complexion, she seldom has much in the way of words or emotion.",
                        "A boy who lives among the wolves in Wolvendom of Mondstadt, away from human civilization. As agile as lightning.",
                        "A sister of the church, though you wouldn't know it if it weren't for her attire. Known for her sharp, cold words and manner, she often works alone.",
                        "An alchemist filled with curiosity about all things. She researches bio-alchemy.",
                        "No. 11 of The Harbingers, also known as \"Childe\". His name is highly feared on the battlefield.",
                        "A traveler from another world who had their only kin taken away, forcing them to embark on a journey to find The Seven.",
                        "A traveler from another world who had their only kin taken away, forcing them to embark on a journey to find The Seven.",
                        "One of the many bards of Mondstadt, who freely wanders the city's streets and alleys.",
                        "A renowned chef from Liyue. She's extremely passionate about cooking and excels at making her signature hot and spicy dishes.",
                        "A yaksha adeptus that defends Liyue. Also heralded as the \"Conqueror of Demons\" and \"Vigilant Yaksha\".",
                        "A young man carrying a longsword who is frequently seen at book booths. He has a chivalrous heart and yearns for justice and fairness for all.",
                        "Liyue's sole rock 'n' roll musician. She rebels against ossified prejudices using her music and passionate singing.",
                        "A well-known legal adviser active in Liyue Harbor. A brilliant young lady in whose veins runs the blood of an illuminated beast.",
                        "A mysterious expert contracted by the Wangsheng Funeral Parlor. Extremely knowledgeable in all things."};

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
        charsDesc = findViewById(R.id.charDesc);
        charsCons = findViewById(R.id.charCons);
        charsAff = findViewById(R.id.charAff);
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

        MainAdapter adapter = new MainAdapter(Menu.this, charName, charVision, charWeapon, charDesc,
                                                charAff,charCons,charIcon, charPortrait, charVisionIcon, charRarity,
                                                charNation);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                charList.setVisibility(View.GONE);
                map.setVisibility(View.GONE);
                charTails.setVisibility(View.VISIBLE);
                charsName.setText(charName[+position]);
                charsWeapon.setText(charWeapon[+position]);
                charsDesc.setText(charDesc[+position]);
                charsCons.setText(charCons[+position]);
                charsAff.setText(charAff[+position]);
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