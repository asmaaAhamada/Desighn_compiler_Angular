package AST;

import java.util.ArrayList;
import java.util.List;

public class Any_type {
    private List<Product> productArrayList = new ArrayList<>();
    private String rawValue;

    public List<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(List<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public String getRawValue() {
        return rawValue;
    }

    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(sb, "");
        return sb.toString();
    }

    private void toStringHelper(StringBuilder sb, String indent) {
        sb.append(indent).append("Any_type:\n");
        sb.append(indent).append("  rawValue: ").append(rawValue).append("\n");
        sb.append(indent).append("  productArrayList:\n");
        for (Product product : productArrayList) {
            if (product != null) {
                sb.append(product.toString(indent + "    "));
            } else {
                sb.append(indent).append("    null\n");
            }
        }
    }
}
