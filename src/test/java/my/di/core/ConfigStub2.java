package my.di.core;

import my.di.core.annotation.Bean;

public class ConfigStub2 {
	
	@Bean
	public Hoge2 hoge2(Hoge1 hoge1) {
		return new Hoge2(hoge1);
	}
	
	@Bean
	public Hoge1 hoge1(Hoge2 hoge2) {
		Hoge1 hoge1 = new Hoge1();
		return hoge1;
	}
	
	

}
