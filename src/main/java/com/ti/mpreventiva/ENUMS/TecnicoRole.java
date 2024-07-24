package com.ti.mpreventiva.ENUMS;

public enum TecnicoRole {
	
	
    USER("USER");

    private String tecnicoRole;

    TecnicoRole(String tecnicoRole) {
        this.tecnicoRole = tecnicoRole;
    }

    public String getTecnicoRole() {
        return tecnicoRole;
    }
}
