/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlevendas;

import apresentacao.*;
import java.io.IOException;
import modelo.*;
import servico.*;

/**
 *
 * @author Magalhães Oliveira
 */
public class ControleVendas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        JFrameAplicacao jFrameAplicacao = new JFrameAplicacao(); // Cria o Frame principal
        jFrameAplicacao.setLocationRelativeTo(null); // Frame no centro 
        jFrameAplicacao.setVisible(true); // Mostra o Frame
    }
    
}
