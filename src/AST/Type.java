package AST;
import java.util.List;

public class Type {
    private String name;
    private Type innerType;
    private List<Type> tupleTypes;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Type getInnerType() {
        return innerType;
    }
    public void setInnerType(Type innerType) {
        this.innerType = innerType;
    }

    public List<Type> getTupleTypes() {
        return tupleTypes;
    }
    public void setTupleTypes(List<Type> tupleTypes) {
        this.tupleTypes = tupleTypes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type{name='").append(name).append('\'');

        if (innerType != null) {
            sb.append(", innerType=").append(innerType.toString());
        }

        if (tupleTypes != null && !tupleTypes.isEmpty()) {
            sb.append(", tupleTypes=[");
            for (int i = 0; i < tupleTypes.size(); i++) {
                sb.append(tupleTypes.get(i).toString());
                if (i < tupleTypes.size() - 1) sb.append(", ");
            }
            sb.append("]");
        }
        sb.append('}');
        return sb.toString();
    }

}
