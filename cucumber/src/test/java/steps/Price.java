package steps;

public enum Price {
    Дешевле("//option[contains(text(),'Дешевле')]"),
    Дороже("//option[contains(text(),'Дороже')]");


    public String value;

    public String getValue() {
        return value;
    }

    Price(String value) {
        this.value = value;
    }
}
