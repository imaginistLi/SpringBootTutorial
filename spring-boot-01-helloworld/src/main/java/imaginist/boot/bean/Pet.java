package imaginist.boot.bean;

public class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
