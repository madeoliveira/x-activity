package com.github.madeoliveira.x_activity.entities.enums;

public enum PlannerStatus {
	Disponivel(1),
	Concluir(2),
	Historico(3);
	
	private int code;
	
	private PlannerStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	
	public static PlannerStatus valueOf(int code) {
		for(PlannerStatus value : PlannerStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo do Status errado!");
	}

}
