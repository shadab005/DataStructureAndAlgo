package leetcode;


public class _331_VerifyPreOrderSerialization {

	public static void main(String[] args) {
		System.out.println(isValidSerialization("#"));

	}
	
	static public boolean isValidSerialization(String preorder) {
        String pre[] = preorder.split(",");
        int slot = 1;
        for(int i = 0; i<pre.length;i++){
        	slot--;
        	if(slot<0)return false;
            if(!pre[i].equals("#"))slot+=2;
        }
        return slot==0;
    }

}
