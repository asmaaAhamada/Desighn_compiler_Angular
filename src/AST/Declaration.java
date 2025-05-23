package AST;

public class Declaration {
    private ServiceDeclaration serviceDeclaration;
    private ComponentDeclaration componentDeclaration;
    public ServiceDeclaration getServiceDeclaration() {
        return serviceDeclaration;
    }
    public ComponentDeclaration getComponentDeclaration() {
        return componentDeclaration;
    }
    public void setServiceDeclaration(ServiceDeclaration serviceDeclaration) {
        this.serviceDeclaration = serviceDeclaration;
    }
    public void setComponentDeclaration(ComponentDeclaration componentDeclaration) {
        this.componentDeclaration = componentDeclaration;
    }
    @Override
    public String toString() {
        return toString("    ");
    }

    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        if (serviceDeclaration != null) {
            sb.append(indent).append("ServiceDeclaration:\n");
            sb.append(serviceDeclaration);
        }
        if (componentDeclaration != null) {
            sb.append(indent).append("ComponentDeclaration:\n");
            sb.append(componentDeclaration.toString(indent + "    "));
        }
        return sb.toString();
    }
}
