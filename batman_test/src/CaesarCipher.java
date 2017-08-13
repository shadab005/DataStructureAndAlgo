//A Java Program to illustrate Caesar Cipher Technique
class CaesarCipher
{
    // Encrypts text using a shift od s
    public static String fun(String text, int s)
    {
    	
        StringBuffer result= new StringBuffer();
 
        for (int i=0; i<text.length(); i++)
        {
        	char ch = (char)(((int)text.charAt(i) +
                    s - 65) % 255);
        	result.append(ch);
            /*if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 65) % 255 + 65);
                result.append(ch); 
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 97) % 26 + 97);
                result.append(ch);
            }*/
        }
        return result.reverse().toString();
    }
    
    public static String encrypt(String text){
    	return fun(text,4);
    }
    
   public static String decrypt(String text){
	   return new StringBuffer(fun(new StringBuffer(text).reverse().toString(),-4)).reverse().toString();
   }
    
 
    // Driver code
    public static void main(String[] args)
    {
        String text = "M052-17";//"ATTACKATONCE";
        String encoded = encrypt(text);
        System.out.println(encoded);
        String decoded = decrypt(encoded);
        System.out.println(decoded);
    }
    
    
}