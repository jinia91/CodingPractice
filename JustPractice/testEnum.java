package JustPractice;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum ProviderType {

    FACEBOOK("facebook"),
    GOOGLE("google"),
    KAKAO("kakao"),
    NAVER("naver");

    private final String value;

	private ProviderType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
    
    
}


public class testEnum {

		
	public static void main(String[] args) {

		
	Map<String, ProviderType> stringToEnum = 
            Stream.of(ProviderType.values())
            .collect(Collectors.toMap(o -> o.getValue(),e->e));
		
	
	System.out.println(stringToEnum.get("facebook"));
	
	System.out.println(Arrays.toString(ProviderType.values()));
	
	}

}
