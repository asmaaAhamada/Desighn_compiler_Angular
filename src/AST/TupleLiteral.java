package AST;

import java.util.ArrayList;
import java.util.List;

public class TupleLiteral {
    private List<String> values = new ArrayList<>();

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    @Override
    public String toString() {
        return "TupleLiteral{" +
                "values=" + values +
                '}';
    }
}
