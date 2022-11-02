public class Gills {
    private static final char[] alphabet = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е',
            'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М',
            'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'X', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'};

    public String encryptionAlgorythm(String str, int[][] transformationMatrix) {
        StringBuilder res = new StringBuilder();
        //str as CharArray
        char[] charStr = str.toCharArray();
        //getIndexes of char in alphabet
        int[] indexes = new int[charStr.length];
        for (int i = 0, j = 0; j < str.length() && i < alphabet.length; i++) {
            if (charStr[j] == alphabet[i]) {
                indexes[j] = i;
                j++;
                i = -1;
            }
        }

        //get encrypted indexes
        int[] newIndexes = new int[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            if (i % 2 == 0) {
                newIndexes[i] = (transformationMatrix[0][0] * indexes[i] + transformationMatrix[0][1] * indexes[i + 1]) % alphabet.length;
            } else {
                newIndexes[i] = (transformationMatrix[1][0] * indexes[i - 1] + transformationMatrix[1][1] * indexes[i]) % alphabet.length;
            }
        }
        //get final string
        for (int newIndex : newIndexes) {
            res.append(alphabet[newIndex]);
        }
        return res.toString();
    }
}