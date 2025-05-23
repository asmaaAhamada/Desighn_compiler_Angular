package AST;

import java.util.ArrayList;
import java.util.List;

public class ParameterList {
    private final List<Object> parameters = new ArrayList<>();

    public List<Object> getParameters() {
        return parameters;
    }

    public void addParameter(Object parameter) {
        this.parameters.add(parameter);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParameterList{parameters=[");
        for (int i = 0; i < parameters.size(); i++) {
            Object param = parameters.get(i);
            sb.append(param != null ? param.toString() : "null");
            if (i < parameters.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
