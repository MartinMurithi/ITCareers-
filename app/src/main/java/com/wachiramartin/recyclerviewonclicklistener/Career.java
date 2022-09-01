package com.wachiramartin.recyclerviewonclicklistener;

public class Career {
    private String careerName;
    private String aboutCareer;
    private int careerImages;

    public Career(String careerName, String aboutCareer, int careerImages) {
        this.careerName = careerName;
        this.aboutCareer = aboutCareer;
        this.careerImages = careerImages;
    }

    @Override
    public String toString() {
        return "Career{" +
                "careerName='" + careerName + '\'' +
                ", aboutCareer='" + aboutCareer + '\'' +
                ", careerImages=" + careerImages +
                '}';
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public String getAboutCareer() {
        return aboutCareer;
    }

    public void setAboutCareer(String aboutCareer) {
        this.aboutCareer = aboutCareer;
    }

    public int getCareerImages() {
        return careerImages;
    }

    public void setCareerImages(int careerImages) {
        this.careerImages = careerImages;
    }

}
