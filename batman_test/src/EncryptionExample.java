import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptionExample
{
    /* encrypt and decrypt a text using a simple algorithm of offsetting the letters */
    
    static char[] chars = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z', '0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'A', 'B', 'C', 'D',
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z','-'
    };
    
    public static void main(String[] args) 
    {
        //String text = "h012-17";
        int offset = 5;
        
/*        String enc = encrypt(text, offset);
        System.out.println("Encrypted text: " + enc);
        
        String dec = decrypt(enc, offset);
        System.out.println("Decrypted text: " + dec);*/
        
        BufferedReader br = null;
        FileReader fr = null;
        
    	BufferedWriter bw = null;
		FileWriter fw = null;
        
        try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader("roll.txt");
			br = new BufferedReader(fr);
			
			fw = new FileWriter("newroll.txt");
			bw = new BufferedWriter(fw);

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				bw.write(encrypt(sCurrentLine, offset)+"\n");
//				System.out.println(sCurrentLine);
			}
        }catch (IOException e) {

			e.printStackTrace();

		}finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
        System.out.println("Done");
        
    }
    

    // Caesar cipher
    static String encrypt(String text, int offset)
    {
        char[] plain = text.toCharArray();

        for (int i = 0; i < plain.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (j <= chars.length - offset) {
                    if (plain[i] == chars[j]) {
                        plain[i] = chars[j + offset];
                        break;
                    }
                } 
                else if (plain[i] == chars[j]) {
                    plain[i] = chars[j - (chars.length - offset + 1)];
                }
            }
        }
        return new StringBuilder(String.valueOf(plain)).reverse().toString();
    }

    static String decrypt(String cip, int offset)
    {
    	cip = new StringBuilder(cip).reverse().toString();
        char[] cipher = cip.toCharArray();
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (j >= offset && cipher[i] == chars[j]) {
                    cipher[i] = chars[j - offset];
                    break;
                }
                if (cipher[i] == chars[j] && j < offset) {
                    cipher[i] = chars[(chars.length - offset +1) + j];
                    break;
                }
            }
        }
        return String.valueOf(cipher);
    }
}
