package AST;

public class ServiceDeclaration {
    private String providedIn;

    public String getProvidedIn() {
        return providedIn;
    }
    public void setProvidedIn(String providedIn) {
        this.providedIn = providedIn;
    }
    @Override
    public String toString() {
        return "{" +
                "providedIn='" + providedIn + '\'' +
                '}';
    }
}
