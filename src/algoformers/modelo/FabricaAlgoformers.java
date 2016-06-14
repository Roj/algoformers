package algoformers.modelo;

public class FabricaAlgoformers {
    public Algoformer crearOptimus() {	
        ModoAlgoformer humanoide = new ModoHumanoide(50,2,2);
        ModoAlgoformer alterno = new ModoTerrestre(15,4,5);
        
        Algoformer optimus = new Autobot(500,humanoide,alterno);
        
        return optimus;
    }
    public Algoformer crearBumblebee() {	
        ModoAlgoformer humanoide = new ModoHumanoide(40,1,2);
        ModoAlgoformer alterno = new ModoTerrestre(20,3,5);
        
        Algoformer bambelbi = new Autobot(350,humanoide,alterno);
        
        return bambelbi;
    }
    public Algoformer crearRatchet() {	
        ModoAlgoformer humanoide = new ModoHumanoide(5,5,1);
        ModoAlgoformer alterno = new ModoAereo(35,2,8);
        
        Algoformer ratchet = new Autobot(150,humanoide,alterno);
        
        return ratchet;
    }
    //Decepticons
    public Algoformer crearMegatron() {
        
        ModoAlgoformer humanoide = new ModoHumanoide(10,3,1);
        ModoAlgoformer alterno = new ModoAereo(55,2,8);
        
        Algoformer megatron = new Decepticon(550,humanoide,alterno);
        
        return megatron;
    }	
    
    public Algoformer crearBonecrusher() {
        
        ModoAlgoformer humanoide = new ModoHumanoide(30,3,1);
        ModoAlgoformer alterno = new ModoTerrestre(30,3,8);
        
        Algoformer boncrasher = new Decepticon(200,humanoide,alterno);
        
        return boncrasher;
    }	
    
    public Algoformer crearFrenzy() {
        
        ModoAlgoformer humanoide = new ModoHumanoide(10,5,2);
        ModoAlgoformer alterno = new ModoTerrestre(25,2,6);
        
        Algoformer frenzy = new Decepticon(400,humanoide,alterno);
        
        return frenzy;
    }	
}
