package steps;

public enum Sort {
    Дешевле("//option[contains(text(),'Дешевле')]"),
    Дороже("//option[contains(text(),'Дороже')]");


    public String value;

    public String getValue() {
        return value;
    }

    Sort(String value) {
        this.value = value;
    }
}


