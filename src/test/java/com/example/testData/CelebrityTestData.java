package com.example.testData;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import org.springframework.test.util.ReflectionTestUtils;

public class CelebrityTestData {

	public final static String celebrityName = "jk";
	public final static String celebrityEmail = "jk123@example.com";

	/**
	 * 연예인 엔티티
	 * @param celebrityId 연예인 ID
	 * @return 연예인 엔티티
	 */
	public static Celebrity getCelebrity(long celebrityId) {
		Celebrity celebrity = new Celebrity(celebrityName);
		ReflectionTestUtils.setField(celebrity, "id", celebrityId);
		return celebrity;
	}

}
