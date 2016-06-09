package algoformers;

public abstract class Tierra extends Superficie { 
    @Override
    public int hash(){
        return 1;
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Tierra);
    }
    
}