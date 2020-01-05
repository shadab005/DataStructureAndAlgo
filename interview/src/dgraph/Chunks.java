package dgraph;

public class Chunks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//limit = 30
	static int minimumChunks(String s, int limit) {
		String words[] = s.split(" ");
		int maxPossibleChunkCount = words.length; //maximum number of chunk
		int minPossibleChunkCount = 1; //minimum number of chunks
		int guessChunkCount = 0;
		while(minPossibleChunkCount < maxPossibleChunkCount) {
			guessChunkCount = (minPossibleChunkCount+maxPossibleChunkCount)/2;
			if(isPossible(words, guessChunkCount, limit)) {
				maxPossibleChunkCount = guessChunkCount;
			} else {
				minPossibleChunkCount = guessChunkCount;
			}
		}
	   return minPossibleChunkCount;
	}


	private static boolean isPossible(String[] words, int guessChunkCountTotal, int limit) {
		
		int i = 0, j = 1;
		int currentChunkCount = 1;
		int guessChunkCountTotalLength = String.valueOf(guessChunkCountTotal).length();
		int sequenceNumber = 1;
		while(j<words.length) {
			if(isMergable(words,i,j, sequenceNumber, guessChunkCountTotalLength, limit)) {
				j++;
			} else {
				i=j;
				j++;
				sequenceNumber++;
				currentChunkCount++;
			}
		}
		return currentChunkCount<=guessChunkCountTotal;
	}


	private static boolean isMergable(String[] words, int i, int j, int k, int maxChunkLength, int limit) {
		String s="";
		for(int z=i;z<=j;z++) {
			s+=words[z];
		}
		s+=String.valueOf(k).length()+"|"+maxChunkLength;
		return s.length()<=limit;
	}

}
