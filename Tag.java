public class Tag{
	public int pointer;
	public int length;
	public String nextChar;
	public Tag(int pointer, int length, String nextChar) {
		super();
		this.pointer = pointer;
		this.length = length;
		this.nextChar = nextChar;
	}
	public Tag() {
		super();
	}
	@Override
	public String toString() {
		return "Tag [pointer=" + pointer + ", length=" + length + ", nextChar="
				+ nextChar + "]";
	}
	
	
}











//import java.util.Vector;
//
//
//public class Main2 {
//	
//	public static void main(String[] args) {
//		String originalString = "abaababaabbbbbbbbbbbba";
//		String subOriginalString;
//		String chars,charsMore;
//		String resTag;
//		Vector<String> result = new Vector<String>();
//		int resFind;
//		for (int i = 0; i < originalString.length(); i++) {
//			subOriginalString = originalString.substring(0, i);
//			chars = String.valueOf(originalString.charAt(i));
//			resFind = subOriginalString.indexOf(chars);
//			if(resFind == -1)
//			{
//				resTag = "< 0 , 0 , "+chars+" >";
//			}
//			else
//			{
//				i++;
//				charsMore = String.valueOf(originalString.charAt(i));
//				chars+=charsMore;
//				resFind = subOriginalString.indexOf(chars);
//				while(true)
//				{
//					
//				}
//			}
//			
//		}
//	}
//
//}
