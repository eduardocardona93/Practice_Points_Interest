package com.example.practice_points_interest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView poiNameLabel,descriptionLabel;
    ImageButton poiminImg1,poiminImg2;
    ImageView poiImage;
    Button returnButton;
    int selectedImage,imgMinId1,imgMinId2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        poiNameLabel = findViewById(R.id.poiNameLabel);
        descriptionLabel = findViewById(R.id.descriptionLabel);
        poiminImg1 = findViewById(R.id.poiminImg1);
        poiminImg2 = findViewById(R.id.poiminImg2);
        poiImage = findViewById(R.id.poiImage);
        returnButton = findViewById(R.id.returnButton);

        poiNameLabel.setText(MainActivity.selectedPoi.getName() + "(" + MainActivity.selectedPoi.getCountry() + ")");
        descriptionLabel.setText(MainActivity.selectedPoi.getDetails());


        imgMinId1=getResources().getIdentifier(MainActivity.selectedPoi.getImage() + "1","mipmap",getPackageName());
        poiminImg1.setImageResource(imgMinId1);
        poiminImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 1;
                setImage();
            }
        });
        imgMinId2=getResources().getIdentifier(MainActivity.selectedPoi.getImage() + "2","mipmap",getPackageName());
        poiminImg2.setImageResource(imgMinId2);
        poiminImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage = 2;
                setImage();
            }
        });

        selectedImage = MainActivity.selectedImageIndex;
        setImage();
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnMain = new Intent(getBaseContext(),MainActivity.class);
                startActivity(returnMain);
            }
        });
    }

    public void setImage(){
        if (selectedImage == 1){
            poiImage.setImageResource(imgMinId1);
        }else{
            poiImage.setImageResource(imgMinId2);
        }
    }


}