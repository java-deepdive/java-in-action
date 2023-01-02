package kr.seok.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ImmutableObjectTest {
	
	@Test
	void testCase1() throws JsonProcessingException {
		ImmutableObject immutableObject = new ImmutableObject("title", "content");
		
		ObjectMapper mapper = new ObjectMapper();
		String valueAsString = mapper.writeValueAsString(immutableObject);
		
		assertThat(valueAsString).isEqualTo("{\"title\":\"title\",\"content\":\"content\"}");
		
		ImmutableObject expected = mapper.readValue(valueAsString, ImmutableObject.class);
		
		assertThat(immutableObject).isEqualTo(expected);
	}
}