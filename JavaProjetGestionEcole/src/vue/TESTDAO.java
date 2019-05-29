/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import DAO.DAO;
import DAO_Factory.DAO_Factory;
import modele.*;

/**
 *
 * @author Marine <ECE>
 */
public class TESTDAO {
        public static void main(String[] args){

            DAO<Ecole> niv = DAO_Factory.getEcoleDAO();
            Ecole niv1= new Ecole(2,"EPF");
            
            boolean result=niv.create(niv1);
            
            if(result==false)
                {System.out.println("NOPE");}
            if(result==true)
                {System.out.println("Yep");}
            
            Ecole niv2 = niv.find(4);
            
            System.out.println(niv2.getNom());
        }
}
