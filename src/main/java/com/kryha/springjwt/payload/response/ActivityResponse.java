package com.kryha.springjwt.payload.response;

public class ActivityResponse {

    private String nameAct;

    private String nameCateg;

    private Boolean userHas = false;

    public ActivityResponse() {
    }

    public ActivityResponse(String nameAct, String nameCateg) {
        this.nameAct = nameAct;
        this.nameCateg = nameCateg;
    }

    public Boolean getUserHas() {
        return userHas;
    }

    public void setUserHas(Boolean userHas) {
        this.userHas = userHas;
    }

    public String getNameAct() {
        return nameAct;
    }

    public void setNameAct(String nameAct) {
        this.nameAct = nameAct;
    }

    public String getNameCateg() {
        return nameCateg;
    }

    public void setNameCateg(String nameCateg) {
        this.nameCateg = nameCateg;
    }
}
