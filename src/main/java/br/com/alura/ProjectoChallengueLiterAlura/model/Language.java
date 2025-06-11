package br.com.alura.ProjectoChallengueLiterAlura.model;

public enum Language {

    EN("en"),
    ES("es" ),
    FR("fr"),
    DE("de"),
    PT("pt"),
    ZH("zh");

    private String languagesCode;


    Language(String languagesCode) {
        this.languagesCode = languagesCode;

    }



    public static Language fromString(String code) {
        for (Language language : Language.values()) {
            if (language.languagesCode.equalsIgnoreCase(code)) {
                return language;
            }
        }
        throw new IllegalArgumentException("Nenhum language encontrada para a string fornecida: " + code);
    }


}
