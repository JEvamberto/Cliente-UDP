/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteUPD;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        try {
            

            int pacote = 50000;
           
            DatagramSocket receber = new DatagramSocket(12344);
            
            
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
