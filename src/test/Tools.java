package test;

public abstract class Tools {
    public String name="C";

    public Tools() {
        System.out.println("父类也创建出来了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
