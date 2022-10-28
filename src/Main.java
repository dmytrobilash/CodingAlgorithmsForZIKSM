public class Main
{
    public static void main(String[] args) {
        //CesarEncryption object = new CesarEncryption();
        //CesarEncryption2 object = new CesarEncryption2("ҐАТУНОК", "КРЕДИТ", 18);
        //String res = object.encryptionAlgorithm();
        //String res = object.encryptionAlgorithm("КРИПТОГРАФІЯ", 10, 2);
        //Bigrams object = new Bigrams();
        Gills object = new Gills();
        int [][] transformationMatrix= {{5, 1}, {8, 3}};
        String res = object.encryptionAlgorythm("ЗАБРАВПРИЗ", transformationMatrix);
        System.out.println(res);
    }
}

