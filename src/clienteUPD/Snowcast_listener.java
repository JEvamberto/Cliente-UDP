/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteUPD;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author jose
 */
public class Snowcast_listener{

    //Comando Hello
    byte commandType = 0;
    short updPort;
    //SetStation
    byte commandType1 = 1;
    short stationNumber;
    

    //receptor
    public static void main(String[] args) throws JavaLayerException {
        String portaUDP=null;
        if (args.length==0) {
            System.out.println("Digite um parametro válido : <nomeDoArquivo> <portaUDP>");
        }else{
            
            portaUDP=args[0];
        
        }
        
        
        try {
            

            int pacote = 50000;
           
            DatagramSocket receber = new DatagramSocket(Integer.parseInt(portaUDP));
            
            
            byte[] myBuffer = new byte[pacote];

            DatagramPacket pkgRecebe = new DatagramPacket(myBuffer, myBuffer.length);
          
            
           
            
            //new Player();
                while(true){
                    receber.receive(pkgRecebe);
                byte audio[] = pkgRecebe.getData();
                  //  System.out.write(audio);
                    Player toca= new Player ( new ByteArrayInputStream(audio));
                    toca.play();
                   
                }
            
            
            
            
         
        } catch (SocketException ex) {
            Logger.getLogger(Snowcast_listener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Snowcast_listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
