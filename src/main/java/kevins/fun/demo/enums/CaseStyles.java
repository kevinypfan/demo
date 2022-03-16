package kevins.fun.demo.enums;

public enum CaseStyles {
    CAMEL("CAMEL", "駝峰式"),
    SNAKE("SNAKE", "底線式"),
    KEBAB("KEBAB", "連接式");

    private final String value;
    private final String info;

    CaseStyles(String value, String info) {
        this.value = value;
        this.info = info;
    }

    public String getValue() {
        return value;
    }

    public String getInfo() {
        return info;
    }
}
