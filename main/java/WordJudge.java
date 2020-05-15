public class WordJudge {

	public static boolean detectCapitalUse(String word) {
		if(word.length()==1) return true;
		char first=word.charAt(0);
		char second=word.charAt(1);
		char temp;
		if(first<='z' && first>='a'){
			for (int i = 1; i < word.length(); i++) {
				temp=word.charAt(i);
				if(!(temp<='z' && temp>='a'))
					return false;
			}
		}else {
			if(second<='z' && second>='a'){
				for (int i = 2; i < word.length(); i++) {
					temp=word.charAt(i);
					if(!(temp<='z' && temp>='a'))
						return false;
				}
			}else {
				for (int i = 2; i < word.length(); i++) {
					temp=word.charAt(i);
					if(temp<='z' && temp>='a')
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String word="usa";
		System.out.println(detectCapitalUse(word));
	}
}
