public class Main
{
    public static void main(String[] args) {
        CesarEncryption ces1 = new CesarEncryption();
        System.out.println("Афінна система підстановок:");
        System.out.println("Вихідне повідомлення - КРИПТОГРАФІЯ");
        System.out.print("Закодоване слово - ");
        System.out.println(ces1.encryptionAlgorithm("КРИПТОГРАФІЯ", 10, 2));
        System.out.println();
        CesarEncryption2 ces2 = new CesarEncryption2("ҐАТУНОК", "КРЕДИТ", 18);
        System.out.println("Система Цезаря:");
        System.out.println("Вихідне повідомлення - КРЕДИТ");
        System.out.println("Ключове слово - ҐАТУНОК");
        System.out.print("Закодоване слово - ");
        System.out.println(ces2.encryptionAlgorithm());
        System.out.println();
        Vigenere vig = new Vigenere();
        System.out.println("Шифр Віженера:");
        System.out.println("Вихідне повідомлення - Важкасправа");
        System.out.println("Ключове слово - Якір");
        System.out.print("Закодоване слово - ");
        System.out.println(vig.EncryprionAlgirithm("ВАЖКАСПРАВА", "ЯКІР"));
        System.out.println();
        Gills gil = new Gills();
        System.out.println("Шифр Гілла:");
        System.out.println("Вихідне повідомлення - СПРАВІКІНЕЦЬ");
        System.out.println("Матриця перетворення - 3 8");
        System.out.println("                       1 5");
        System.out.print("Закодоване слово - ");
        int [][] matrix = {{3,8},{1,5}};
        System.out.println(gil.encryptionAlgorythm("СПРАВІКІНЕЦЬ", matrix));
        System.out.println();
        Bigrams big = new Bigrams();
        System.out.println("Шифрування Біграмами:");
        System.out.println("Вихідне повідомлення - СПРАВІКІНЕЦЬ");
        System.out.print("Закодоване слово - ");
        System.out.println(big.encryptionAlgorithm("СПРАВІКІНЕЦЬ"));
    }
}

