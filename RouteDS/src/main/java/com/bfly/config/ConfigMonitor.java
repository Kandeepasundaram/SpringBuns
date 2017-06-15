package com.bfly.config;

import java.util.ArrayList;
import java.util.List;

public enum ConfigMonitor {
instance;
	
	List<String> configSteps = new ArrayList<>();
	
	public void auditStep(String stepComment) {
		this.configSteps.add(stepComment);
		if (7 == this.configSteps.size()) {
			logSteps();
		}
	}
	
	private void logSteps() {
		for (String step : configSteps) {
			System.out.println(step);
		}

	}
			
}
