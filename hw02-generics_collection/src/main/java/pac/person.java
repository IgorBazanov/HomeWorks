package pac;

public class person implements Comparable<person>{
    private String name;
    private int IQ;

    public person(String name,int IQ){
        this.name=name;
        this.IQ=IQ;
    }

    @Override
    public String toString() {
        return name + ", "+IQ;
    }

    @Override
    public int compareTo (person o){
        return this.IQ-o.IQ;
    }

    public String getName() {
        return name;
    }

}
