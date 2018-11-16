package com.example.alstn0107.mop_project_0706;


public class Information {
//   PillSearch 에 정보를 넘겨 주기 위한 클래스 입니다.
    public  String name,image,status;

    public Information(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Information(String name, String image, String status) {
        this.name = name;
        this.image = image;
        this.status = status;
    }
}
