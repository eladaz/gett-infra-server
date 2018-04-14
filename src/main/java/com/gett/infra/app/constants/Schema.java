package com.gett.infra.app.constants;

public enum Schema {

    CREATE("create"),
    VALIDATE("validate"),
    UPDATE("update"),
    CREATE_DROP("create-drop");

    private final String schemaMethod;

    Schema(String schemaMethod) {
        this.schemaMethod = schemaMethod;
    }

    public String getKey() {
        return this.schemaMethod;
    }

}
