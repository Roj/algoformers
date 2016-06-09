package algoformers;

public abstract class Aire extends Superficie { 
    public int hash(){
        return 0;
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Aire);
    }
}
