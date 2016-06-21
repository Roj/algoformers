package algoformers.modelo.algoformer;

import algoformers.vista.VistaAlgoformer;

public class FabricaAlgoformers {
    public Algoformer crearOptimus() {	
        ModoAlgoformer humanoide = new ModoHumanoide(50,2,2);
        ModoAlgoformer alterno = new ModoTerrestre(15,4,5);
        
        VistaAlgoformer vistaOptimus = new VistaAlgoformer("Optimus","Optimus");
        Algoformer optimus = new Autobot(500,humanoide,alterno,vistaOptimus);
        
        return optimus;
    }
    public Algoformer crearBumblebee() {	
        ModoAlgoformer humanoide = new ModoHumanoide(40,1,2);
        ModoAlgoformer alterno = new ModoTerrestre(20,3,5);
        
        VistaAlgoformer vistaBumblebee = new VistaAlgoformer("Bumblebee","Bumblebee");
        Algoformer bambelbi = new Autobot(350,humanoide,alterno,vistaBumblebee);
        
        return bambelbi;
    }
    public Algoformer crearRatchet() {	
        ModoAlgoformer humanoide = new ModoHumanoide(5,5,1);
        ModoAlgoformer alterno = new ModoAereo(35,2,8);
        
        VistaAlgoformer vistaRatchet = new VistaAlgoformer("Ratchet","Ratchet");
        Algoformer ratchet = new Autobot(150,humanoide,alterno,vistaRatchet);
        
        return ratchet;
    }
    //Decepticons
    public Algoformer crearMegatron() {
        
        ModoAlgoformer humanoide = new ModoHumanoide(10,3,1);
        ModoAlgoformer alterno = new ModoAereo(55,2,8);
        
        VistaAlgoformer vistaMegatron = new VistaAlgoformer("Megatron","Megatron");
        Algoformer megatron = new Decepticon(550,humanoide,alterno,vistaMegatron);
        
        return megatron;
    }	
    
    public Algoformer crearBonecrusher() {
        
        ModoAlgoformer humanoide = new ModoHumanoide(30,3,1);
        ModoAlgoformer alterno = new ModoTerrestre(30,3,8);
        
        VistaAlgoformer vistaBonecrusher = new VistaAlgoformer("Bonecrusher","Bonecrusher");
        Algoformer boncrasher = new Decepticon(200,humanoide,alterno,vistaBonecrusher);
        
        return boncrasher;
    }	
    
    public Algoformer crearFrenzy() {
        
        ModoAlgoformer humanoide = new ModoHumanoide(10,5,2);
        ModoAlgoformer alterno = new ModoTerrestre(25,2,6);
        
        VistaAlgoformer vistaFrenzy = new VistaAlgoformer("Frenzy","Frenzy");
        Algoformer frenzy = new Decepticon(400,humanoide,alterno,vistaFrenzy);
        
        return frenzy;
    }	
}
