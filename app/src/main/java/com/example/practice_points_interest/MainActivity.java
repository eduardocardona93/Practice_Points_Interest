package com.example.practice_points_interest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner countrySpinner, placeSpinner;
    ImageButton imageButton1, imageButton2;
    public String[] countryList = {"Canada","India","Jordan"};
    public static ArrayList<Place> pois = new ArrayList<>();
    public static ArrayList<String> tempPoisNames = new ArrayList<>();

    public static ArrayList<Place> tempPois = new ArrayList<>();
    int selectedCountryIndex = 0, selectedPlaceIndex = 0;

    public static int selectedImageIndex = 1;
    public static Place selectedPoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        countrySpinner = findViewById(R.id.countrySpinner);
        placeSpinner = findViewById(R.id.placeSpinner);


        ArrayAdapter aa1=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,countryList);
        countrySpinner.setAdapter(aa1);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountryIndex = position;
                fillTemp();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedCountryIndex = 0;
                fillTemp();
            }
        });

        placeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPlaceIndex = position;
                selectedPoi = tempPois.get(selectedPlaceIndex);
                int imgId1=getResources().getIdentifier(selectedPoi.getImage() + '1',"mipmap",getPackageName());
                imageButton1.setImageResource(imgId1);
                int imgId2=getResources().getIdentifier(selectedPoi.getImage() + '2',"mipmap",getPackageName());
                imageButton2.setImageResource(imgId2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedPlaceIndex = 0;
                selectedPoi = tempPois.get(selectedPlaceIndex);
                int imgId1=getResources().getIdentifier(selectedPoi.getImage() + '1',"mipmap",getPackageName());
                imageButton1.setImageResource(imgId1);
                int imgId2=getResources().getIdentifier(selectedPoi.getImage() + '2',"mipmap",getPackageName());
                imageButton2.setImageResource(imgId2);
            }
        });

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageIndex = 1;
                Intent intent = new Intent(getBaseContext(),DetailActivity.class);
                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageIndex = 2;
                Intent intent = new Intent(getBaseContext(),DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    public void fillData(){
        pois.add(new Place( "Niagara Falls",  "niagara",  "Canada", "The Niagara River flows at approximately 35 miles/hour (56.3 kilometers/hour). There are actually two waterfalls in Niagara, the American Falls and the Canadian Horseshoe Falls. It is the combination of height and water flow that makes Niagara Falls so beautiful. ... Skylon Tower rises 775 feet above the Falls."));
        pois.add(new Place("Algonquon Park",  "algonquin","Canada",  "Algonquin Provincial Park is a provincial park located between Georgian Bay and the Ottawa River in Ontario, Canada, mostly within the Unorganized South Part of Nipissing District. ... Additions since its creation have increased the park to its current size of about 7,653 square kilometres (2,955 sq mi)."));
        pois.add(new Place("Blue Mountain",  "blue",  "Canada",  "The Blue Mountains has a host of recreational activities for all the seasons. Most notably is the winter skiing, snowboarding, snowshoeing and cross-country skiing. In the summer there is hiking, downhill/cross-country biking, an extravagant mini putt, the Ridge Runner and events such as Met Con Blue"));
        pois.add(new Place( "Thousand Islands",  "thousends", "Canada",  "The Thousand Islands (French: Mille-Îles) constitute a North American archipelago of 1,864 islands that straddles the Canada–US border in the Saint Lawrence River as it emerges from the northeast corner of Lake Ontario. They stretch for about 50 miles (80 km) downstream from Kingston, Ontario."));
        pois.add(new Place( "Rocky Mountain", "rocky",  "Canada",  "The Canadian Rockies mountain range spans the provinces of British Columbia and Alberta. With jagged, ice-capped peaks, including towering Mt. Robson, it's a region of alpine lakes, diverse wildlife and outdoor recreation sites. Yoho National Park is home to the massive Takakkaw Falls. Other national parks are Jasper, with the famously accessible Athabasca Glacier, and Banff, site of glacier-fed Lake Louise"));
        pois.add(new Place( "Taj Mahal",  "taj", "India",  "An immense mausoleum of white marble, built in Agra between 1631 and 1648 by order of the Mughal emperor Shah Jahan in memory of his favourite wife, the Taj Mahal is the jewel of Muslim art in India and one of the universally admired masterpieces of the world's heritage."));
        pois.add(new Place( "Kumbhalgarh Fort", "kumbh","India",  "Kumbhalgarh is a Mewar fortress on the westerly range of Aravalli Hills, in the Rajsamand district near Udaipur of Rajasthan state in western India. It is a World Heritage Site included in Hill Forts of Rajasthan. Built during the course of the 15th century by Rana Kumbha"));
        pois.add(new Place( "Amritsar Fort",  "amristar",  "India",  "Gobindgarh Fort is a historic military fort located in the center of the city of Amritsar in the Indian state of Punjab. The Fort was until recently occupied by the army but was opened to the public from 10 February 2017. ... The fort had 25 cannons mounted on its ramparts and it remained with the Bhangi rulers till 1805"));
        pois.add(new Place("Golden Temple", "golden","India", "The Golden Temple, also known as Harmandir Sahib, meaning abode of God or Darbār Sahib, meaning exalted court, is a gurdwara located in the city of Amritsar, Punjab, India. It is the preeminent spiritual site of Sikhism"));
        pois.add(new Place("Pangong Lake", "pangong", "India",  "Pangong Lake, situated at a height of almost 4,350m, is the world's highest saltwater lake. Its water, which seems to be dyed in blue, stand in stark contrast to the arid mountains surrounding it. Extending to almost 160km, one-third of the Pangong Lake lies in India and the other two-thirds in China"));
        pois.add(new Place("Petra",  "petra",  "Jordan",  "Famous for its rock-cut architecture and water conduit system, Petra is also called the 'Rose City' because of the colour of the stone from which it is carved. It has been a UNESCO World Heritage Site since 1985. ... Petra is a symbol of Jordan, as well as Jordan's most-visited tourist attraction"));
        pois.add(new Place("Dead Sea",  "dead", "Jordan", "Lake/Sea of Lot is a salt lake bordered by Jordan to the east and Israel and the West Bank to the west. It lies in the Jordan Rift Valley, and its main tributary is the Jordan River."));
        pois.add(new Place("Wadi Rum", "rum",  "Jordan", "Wadi Rum (Arabic: وادي رم‎ Wādī Ramm), known also as the Valley of the Moon (Arabic: وادي القمر‎ Wādī al-Qamar), is a valley cut into the sandstone and granite rock in southern Jordan 60 km (37 mi) to the east of Aqaba; it is the largest wadi in Jordan."));
        pois.add(new Place("Aqaba Gulf",  "aqaba", "Jordan", "Aqaba (English: /ˈækəbə/,[2] also US: /ˈɑːk-/;[3] Arabic: العقبة‎, romanized: al-ʿAqaba, al-ʿAgaba, pronounced [æl ˈʕæqaba, alˈʕagaba]) is the only coastal city in Jordan and the largest and most populous city on the Gulf of Aqaba.[4] Situated in southernmost Jordan, Aqaba is the administrative centre of the Aqaba Governorate.[5] The city had a population of 148,398 in 2015 and a land area of 375 square kilometres (144.8 sq mi)"));
    }

    public void fillTemp(){
        tempPois.clear();
        tempPoisNames.clear();
        for (Place pl : pois) {
            if(pl.getCountry().equalsIgnoreCase(countryList[selectedCountryIndex])){
                tempPois.add(pl);
                tempPoisNames.add(pl.getName());
            }
        }
        ArrayAdapter aa2=new ArrayAdapter(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, tempPoisNames);
        placeSpinner.setAdapter(aa2);
    }

}