package com.example.retrofitinjavaandkotlin.JavaPart;

import android.widget.ImageView;

import java.io.FileReader;

public class Hero {

    private String name;
    private String realname;
    private String team;
    private String firstappearence;
    private String createdby;
    private String publisher;
    private String imageurl;
    private String bio;

    public Hero(String name,String realName,String team, String firstappearence, String createdBy,String publisher, String imageurl, String bio){
        this.name=name;
        this.realname=realName;
        this.team=team;
        this.firstappearence=firstappearence;
        this.createdby=createdBy;
        this.publisher=publisher;
        this.imageurl=imageurl;
        this.bio=bio;
    }

    public String getBio() { return bio; }


    public String getImageUrl() { return imageurl; }

    public String getPublisher() { return publisher; }

    public String getCreatedBy() { return createdby; }

    public String getFirstAppearence() { return firstappearence; }

    public String getTeam() { return team; }

    public String getRealName() { return realname; }

    public String getName() { return name; }
}
