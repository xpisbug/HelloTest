package com.dd.test.test1;

public class Main {
	public static void main(String[] args) {
		String s = "中国π杜程";
		String ss = gbEncoding(s);
		System.out.println(ss);

		System.out.println(unicode2String("\\\\u03c0"));
		System.out.println(unicode2String("\\\\u05D0"));
		System.out.println(unicode2String("\\\\u125D"));
		System.out.println(unicode2String("\\\\u125D0"));
		System.out.println(unicode2String("\\\\u165D0"));
		System.out.println(unicode2String("\\\\u175D0"));
		char ch = 'A';
		System.out.println(ch +=1);
		//testUnStr();
		for(int i = 0; i< 999999; i++){
			//System.out.print(test0("\\u"+i));
			if(i % 10 == 0){
				System.out.println();
			}
		}
	}
	private static void testUnStr(){
		char ch1 = 'A';
		char ch2 = 'A';
		char ch3 = 'A';
		char ch4 = 'A';
		for(int i = 0; i< 15; i++){
			for(int j = 0; j< 15; j++){
				for(int k = 0; k< 15; k++){
					for(int l = 0; l< 15; l++){
						String str = "\\u";
						if(i > 9){
							str += (char)(ch1 + i - 10);
							//ch1 += 1;
						}else{
							str += i;
						}
						if(j > 9){
							str += (char)(ch2 + j -10);
							//ch2 += 1;
						}else{
							str += j;
						}
						if(k > 9){
							str += (char)(ch3 + k -10);
							//ch3 += 1;
						}else{
							str += k;
						}
						if(l > 9){
							str += (char)(ch4 + l-10);
							//ch4 += 1;
							//System.out.println("====="+str+"-----");
						}else{
							str += l;
						}
						System.out.print(test0(str)+"--"+str);
						if(l == 14){
							System.out.println("");
						}
					}
				}
			}
		}
	}
	private static String test0(final String str){
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while(start > -1){
			end = str.indexOf("\\u",start+2);
			String charStr = "";
			if(end == -1){
				charStr = str.substring(start+2,str.length());
			}else{
				charStr = str.substring(start+2,end);
			}
			char letter = (char)Integer.parseInt(charStr,16);
			buffer.append(new Character(letter).toString());
			start = end;
		}
		//System.out.println(buffer.toString());
		return buffer.toString();
	}

	public static String gbEncoding(final String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
			String hexB = Integer.toHexString(utfBytes[byteIndex]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}else if(hexB.length() ==3){
				hexB = "0" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		System.out.println("unicodeBytes is: " + unicodeBytes);
		return unicodeBytes;
	}

	public static String unicode2String(String unicode) {
		StringBuffer string = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) {
			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i], 16);
			// 追加成string
			string.append((char) data);
		}

		return string.toString();
	}
}
