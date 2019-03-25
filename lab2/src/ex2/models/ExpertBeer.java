package ex2.models;

public enum  ExpertBeer {
    LECH("Lech"),
    TATRA ("Tatra"),
    IPA (" Ipa"),
    JUICE ("Sok");

    private final String name;

    private ExpertBeer(String s) {
        name = s;
    }

}
