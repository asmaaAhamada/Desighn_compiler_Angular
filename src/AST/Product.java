package AST;

public class Product {
    private String key1;
    private String numberValue;
    private String key2;
    private String stringValue1;
    private String key3;
    private String stringValue2;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(String numberValue) {
        this.numberValue = numberValue;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getStringValue1() {
        return stringValue1;
    }

    public void setStringValue1(String stringValue1) {
        this.stringValue1 = stringValue1;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getStringValue2() {
        return stringValue2;
    }

    public void setStringValue2(String stringValue2) {
        this.stringValue2 = stringValue2;
    }

    @Override
    public String toString() {
        return toString("");
    }
    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("Product:\n");
        sb.append(indent).append("  key1: ").append(key1).append("\n");
        sb.append(indent).append("  numberValue: ").append(numberValue).append("\n");
        sb.append(indent).append("  key2: ").append(key2).append("\n");
        sb.append(indent).append("  stringValue1: ").append(stringValue1).append("\n");
        sb.append(indent).append("  key3: ").append(key3).append("\n");
        sb.append(indent).append("  stringValue2: ").append(stringValue2).append("\n");
        return sb.toString();
    }

}
