import java.util.Vector;

public clastrResult Main {
	//static String originalString = "abaababaabbbbbbbbbbbba";	
	public static Vector<Tag> ComprestrResultionLZ77(String originalString)
	{
		
		Vector<Tag> result = new Vector<Tag>();
		Vector<Integer> outputs = new Vector<Integer>();
		String strResult="";
		String tempChar="";
		Tag tag;
		Tag newTag;
		int size =  originalString.length();
		for (int i = 0; i < size; i++)
		{ 
	        tempChar = String.valueOf(originalString.charAt(i));
			strResult = tempChar;
			int output = stringIsfoundAt(originalString,strResult,i-1);
			outputs.add(output);
			if(output== -1)
			{
				 tag  = new Tag(0,0,strResult);
			
				result.add(tag);
			}

			else
			{		
				
				if(i+1 == size)
				{
					 newTag = new Tag(output,1,"null");
					result.add(newTag);
					strResult = "";
					tempChar = "";
					newTag = null;
					break;
				}
				
				
				i++;
				if(i<=size-1){
					tempChar = String.valueOf(originalString.charAt(i));
					strResult+=tempChar;
					output = stringIsfoundAt(originalString,strResult,i-strResult.length());
					outputs.add(output);
					while(i<= size-2 &&output!=-1)
					{
						if(i+1 == size)
						{
							 newTag = new Tag(output,1,"null");
						   // newTag  ="< "+ String.valueOf(output) +" , " +String.valueOf(1)+" , null >";
							result.add(newTag);
							strResult = "";
							tempChar = "";
							newTag = null;
							break;
						}
						
						i++;
						tempChar = String.valueOf(originalString.charAt(i));
						strResult+=tempChar;
						output = stringIsfoundAt(originalString,strResult,i-strResult.length());
						outputs.add(output);
						if(i==size-1 )break;
					}
					 newTag = new Tag(outputs.get(i-1),strResult.length()-1,String.valueOf(strResult.charAt(strResult.length()-1)));
					 //newTag  ="< "+ String.valueOf(outputs.get(i-1)) +" , " +String.valueOf(strResult.length()-1)+
					//			" , "+String.valueOf(strResult.charAt(strResult.length()-1))+" >";
					result.add(newTag);
					strResult = "";
					tempChar = "";
					newTag = null;
					if(i==size-1 )break;
					
					}
				else break;
			}
		}
		return result;
	}
	public static int stringIsfoundAt(String originalString,String x , int limit)
	{
		x = new StringBuilder(x).reverse().toString();
		String subOriginal = originalString.substring(0,limit+1);
		int size = originalString.length();
		String xx = new StringBuilder(subOriginal).reverse().toString();
		int out =xx.indexOf(x); 
		if(limit<= size-2 && out != -1)
		{
			int actual =out + x.length();
			return actual;
		}
		return -1;	
	}
	
	
	public static String DecomprestrResultLZ77(Vector<Tag> result)
	{
		 int len = 0;
		String originalText = "";
		Tag t;
		for (int i = 0; i < result.size(); i++) 
		{
			t = result.elementAt(i);
			if(t.pointer == 0)
			{
				if(t.nextChar.equals("null"))continue;
				originalText+=t.nextChar;
				len=originalText.length();
			}
			else
			{
				String x = originalText.substring(len-t.pointer, (len-t.pointer)+t.length);
				originalText+=x;
    			if(t.nextChar.equals("null"))continue;
    			originalText+=t.nextChar;
    			len=originalText.length();
			}
		}
		return originalText;
	}
	
	
	
	public static void main(String[] args) {
		
		Vector<Tag> result = new Vector<Tag>();
		result = ComprestrResultionLZ77("HelloWorld");
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
		boolean check = DecomprestrResultLZ77(result).equals("HelloWorld");
		if(check) System.out.println("Equals");
		else System.out.println("Not Equal");
	}
}
