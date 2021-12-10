package JustPractice;

public class textcc {

	public static void main(String[] args) {

		String a = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nfff\n\n\n\n\n\nfffff";
		char[] contentBox = new char["\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nfff\n\n\n\n\n\n\fffff".length()];

		int idx = 0;
		String zipWord = "\n\n";

		for (int i = 0; i < a.length(); i++) {
			contentBox[idx] = a.charAt(i);
			if (contentBox[idx] == '\n' && idx >= 1) {
				int tempIdx = idx;
				int length = 1;
				boolean isRemove = true;
				for (int j = 0; j < 2; j++) {
					if (contentBox[tempIdx--] != zipWord.charAt(length--)) {
						isRemove = false;
						break;
					}
				}
				if (isRemove)
					idx -= 1;
			}
			idx++;
		}


        StringBuilder content = new StringBuilder();
        content.append(contentBox);
        content.setLength(idx);

        
        System.out.println(content);
        
	}

}
