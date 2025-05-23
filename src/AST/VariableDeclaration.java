package AST;

public class VariableDeclaration {
    private String name;
    private String modifier;
    private String value;
    private boolean isThisReference;

    private Type type;
    private ArrayLiteral arrayLiteral;
    private TupleLiteral tupleLiteral;
    private EnumValue enumValue;
    private TypeAssertion typeAssertion;
    private Decorator decorator;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getModifier() { return modifier; }
    public void setModifier(String modifier) { this.modifier = modifier; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public boolean isThisReference() { return isThisReference; }
    public void setThisReference(boolean thisReference) { isThisReference = thisReference; }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    public ArrayLiteral getArrayLiteral() { return arrayLiteral; }
    public void setArrayLiteral(ArrayLiteral arrayLiteral) { this.arrayLiteral = arrayLiteral; }

    public TupleLiteral getTupleLiteral() { return tupleLiteral; }
    public void setTupleLiteral(TupleLiteral tupleLiteral) { this.tupleLiteral = tupleLiteral; }

    public EnumValue getEnumValue() { return enumValue; }
    public void setEnumValue(EnumValue enumValue) { this.enumValue = enumValue; }

    public TypeAssertion getTypeAssertion() { return typeAssertion; }
    public void setTypeAssertion(TypeAssertion typeAssertion) { this.typeAssertion = typeAssertion; }

    public Decorator getDecorator() { return decorator; }
    public void setDecorator(Decorator decorator) { this.decorator = decorator; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (name != null) {
            sb.append("name='").append(name).append('\'');
        }
        if (modifier != null) {
            sb.append(", modifier='").append(modifier).append('\'');
        }
        if (value != null) {
            sb.append(", value='").append(value).append('\'');
        }
        if (isThisReference) {
            sb.append(", isThisReference=").append(isThisReference);
        }
        if (type != null) {
            sb.append(", type=").append(type);
        }
        if (arrayLiteral != null) {
            sb.append(", arrayLiteral=").append(arrayLiteral);
        }
        if (tupleLiteral != null) {
            sb.append(", tupleLiteral=").append(tupleLiteral);
        }
        if (enumValue != null) {
            sb.append(", enumValue=").append(enumValue);
        }
        if (typeAssertion != null) {
            sb.append(", typeAssertion=").append(typeAssertion);
        }
        if (decorator != null) {
            sb.append(", decorator=").append(decorator);
        }
        sb.append('}');
        return sb.toString();
    }


}
