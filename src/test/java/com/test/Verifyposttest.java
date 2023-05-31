package com.test;

import org.testng.annotations.Test;

import com.api.script.Generic;

public class Verifyposttest {
	
	@Test
	public void validation_post_Method()
	{
		Generic refa = new Generic();
		refa.post();
	}

}
