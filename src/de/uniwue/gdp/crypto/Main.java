package de.uniwue.gdp.crypto;


import de.uniwue.gdp.crypto.basic.NeighborEncryptor;
import de.uniwue.gdp.crypto.basic.RevertEncryptor;
import de.uniwue.gdp.crypto.basic.ShiftEncryptor;



public class Main {
    public static void main(String[] args) {
        String test = "HAUS";
        System.out.println("Testsatz: " + test);


        NeighborEncryptor ne = new NeighborEncryptor();
        System.out.println("Neighbor: " + ne.encode("DER AZ ALKMAAR IST EINE BEKANNTE NIEDERLAENDISCHE FUSSBALLMANNSCHAF"));
        System.out.println(ne.decode("HVR ZZ LVWMARR ALT MVRE FOKNAGXE VMHHVCLERQLAUJLE ZMKTBLWXMNAFUJHFF"));
        //Encryptor ce = KeyTranslator.fromKey("RVT-NEI");
        //System.out.println("Complex: " + ce.encode(test));

    }
}