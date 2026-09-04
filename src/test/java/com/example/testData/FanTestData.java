package com.example.testData;

import com.example.biasTalk.domain.fan.model.Fan;
import org.springframework.test.util.ReflectionTestUtils;

public class FanTestData {

	public final static String fanName = "army";
	public final static String fanEmail = "army123@example.com";

	/**
	 * 팬 엔티티
	 * @param fanId 팬 ID
	 * @return 팬 엔티티
	 */
	public static Fan getFan(long fanId) {
		Fan fan = new Fan(fanName, fanEmail);

		ReflectionTestUtils.setField(fan, "id", fanId);
		return fan;
	}

}
